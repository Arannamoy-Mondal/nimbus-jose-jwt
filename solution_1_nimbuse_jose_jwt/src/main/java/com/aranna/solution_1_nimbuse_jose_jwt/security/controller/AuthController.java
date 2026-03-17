package com.aranna.solution_1_nimbuse_jose_jwt.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aranna.solution_1_nimbuse_jose_jwt.model.User;
import com.aranna.solution_1_nimbuse_jose_jwt.repo.UserRepo;
import com.aranna.solution_1_nimbuse_jose_jwt.security.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        try {
            System.out.println(user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userRepo.findAll());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            Authentication authentication=authenticationManager.authenticate(authenticationToken);
            return ResponseEntity.status(HttpStatus.OK).body(userService.createToken(authentication));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userRepo.findAll());
        }
    }
    

}
