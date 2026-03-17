package com.aranna.solution_1_nimbuse_jose_jwt.security.config;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nimbusds.jose.jwk.RSAKey;

@Configuration
public class CustomRSAKey {
    // step-2: create rsakey
    @Bean
    RSAKey rsaKey(KeyPair keyPair) {
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic()).privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString().toString())
                .build();
    }
}
