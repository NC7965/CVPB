package com.altia.cvprocessingbackend.auth;

import com.altia.cvprocessingbackend.runner.Runner;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.ArrayList;


@Component
@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        logger.info("AuthenticationManager()");
        String authToken = authentication.getCredentials().toString();

        WebClient client = WebClient.builder()
                .baseUrl("https://pre-dedalo.altia.es")
                .build();

        Mono <String> response = client.get()
                .uri("/dedalonext/my/account.json")
                .header("X-Redmine-API-Key", authToken)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is3xxRedirection, clientResponse -> {
                    logger.error("Error endpoint with status code {}",  clientResponse.statusCode());
                    throw new BadCredentialsException("User token not valid "+ authToken);
                })
                .onStatus(HttpStatus::isError, clientResponse -> {
                    logger.error("Error endpoint with status code {}",  clientResponse.statusCode());
                    throw new AuthenticationServiceException("Unsuported Exception "+ authToken);
                })
                .bodyToMono(String.class ).log()
                .publishOn(Schedulers.boundedElastic())
                .timeout(Duration.ofSeconds(100));

        return response.map(valid -> {
            return new UsernamePasswordAuthenticationToken(
                            "user",
                            authToken,
                            new ArrayList<>()
            );
        });
    }
}