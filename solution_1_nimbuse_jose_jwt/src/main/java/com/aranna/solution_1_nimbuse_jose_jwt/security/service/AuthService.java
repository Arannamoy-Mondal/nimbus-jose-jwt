package com.aranna.solution_1_nimbuse_jose_jwt.security.service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.aranna.solution_1_nimbuse_jose_jwt.repo.UserRepo;

@Service
public class AuthService {
    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private UserRepo userRepo;
    public String createToken(Authentication authentication){
        var claims=JwtClaimsSet.builder()
        .issuedAt(Instant.now())
        .expiresAt(Instant.now().plusSeconds(3600*12))
        .claim("scope", createScope(authentication))
        .build();
        JwtEncoderParameters jwtEncoderParameters=JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }

    public String createScope(Authentication authentication){
        return authentication.getAuthorities().stream()
        .map(a->a.getAuthority())
        .collect(Collectors.joining(" "));
    }
}
