package com.aranna.solution_1_nimbuse_jose_jwt.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<?> getHello(){
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }
}
