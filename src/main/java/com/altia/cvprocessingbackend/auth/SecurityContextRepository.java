package com.altia.cvprocessingbackend.auth;

import com.altia.cvprocessingbackend.runner.Runner;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private AuthenticationManager authenticationManager;

    @Override
    public Mono<Void> save(ServerWebExchange swe, SecurityContext sc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    public Mono<SecurityContext> load(ServerWebExchange swe) {
        logger.info("SecurityContextRepository --> load() ");
        return Mono.justOrEmpty(swe.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                .flatMap(authHeader -> {
                    String authToken = authHeader;
                    Authentication auth = new UsernamePasswordAuthenticationToken(authToken, authToken);
                    return this.authenticationManager.authenticate(auth).map(SecurityContextImpl::new);
                });
    }
}