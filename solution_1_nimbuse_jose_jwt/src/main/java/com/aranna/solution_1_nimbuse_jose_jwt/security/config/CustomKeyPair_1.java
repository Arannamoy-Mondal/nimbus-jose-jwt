package com.aranna.solution_1_nimbuse_jose_jwt.security.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomKeyPair_1 {
    public static final Logger log = LoggerFactory.getLogger(BasicAuthConfiguration.class);

    // step-1: keypair generator
    @Bean
    KeyPair keyPair() throws Exception {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
            throw new Exception("Fault in keypair generator." + " " + getClass().descriptorString());
        }

    }
}
