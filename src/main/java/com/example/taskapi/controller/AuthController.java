package com.example.taskapi.controller;

import com.example.taskapi.model.LoginRequest;
import com.example.taskapi.model.LoginResponse;
import com.example.taskapi.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        if (
                request.getUsername().equals("admin")
                        &&
                        request.getPassword().equals("password")
        ) {

            String token =
                    jwtService.generateToken(
                            request.getUsername()
                    );

            return ResponseEntity.ok(
                    new LoginResponse(token)
            );
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }
}