package com.altia.cvprocessingbackend.auth;

import com.altia.cvprocessingbackend.runner.Runner;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    //public Mono<Boolean> authenticateAgainst(String authToken) {
    public boolean authenticateAgainst(String authToken) {

        /*AtomicBoolean statusOK = new AtomicBoolean();
        statusOK.set(false);
        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Redmine-API-Key", authToken)
                .build();
        return webClient.get()
                .uri("https://dedalo.altia.es/dedalo/my/account.json")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(10))  // timeout 10s
                .map( respuesta -> {
                    logger.info("response is "+ respuesta);
                    return true;
                })
                .subscribeOn(Schedulers.boundedElastic());*/
        boolean status = false;
        try {
            StringBuilder resultado = new StringBuilder();
            URL url = new URL("https://dedalo.altia.es/dedalo/my/account.json");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("X-Redmine-API-Key", authToken);
            conexion.setInstanceFollowRedirects(false);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();
            int statusCode = conexion.getResponseCode();
            logger.info("statusCode: "+statusCode);

            if(statusCode==200){
                status=true;
                logger.info("status: " +status);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        logger.info("AuthenticationManager()");

        String authToken = authentication.getCredentials().toString();
        //logger.info("authToken es: "+ authToken);

        /*authenticateAgainst(authToken).map( value -> {
            logger.info("Valor ", value);
            return null;
        }).subscribeOn(Schedulers.boundedElastic());
*/
        return Mono.just(authenticateAgainst(authToken))
                .filter(valid -> valid)
                .switchIfEmpty(Mono.empty())
                .map(valid -> {
                    return new UsernamePasswordAuthenticationToken(
                            "user",
                            authToken,
                            new ArrayList<>()//roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                    );
                });
    }
}
