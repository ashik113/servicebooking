package com.ashik.servicebooking.controller;

import com.ashik.servicebooking.dto.LoginRequest;
import com.ashik.servicebooking.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if ("ashik".equals(loginRequest.getUserName()) &&
                "1234".equals(loginRequest.getPassword())) {

            return JwtUtil.generateToken(loginRequest.getUserName());
        }

        return "Invalid Credentials";
    }

    @GetMapping("/api/test")
    public String test() {
        return "Protected API working!";
    }


}
