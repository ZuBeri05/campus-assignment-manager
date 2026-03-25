package com.zuberi.cam.controller;

import com.zuberi.cam.dto.AuthResponse;
import com.zuberi.cam.dto.LoginRequest;
import com.zuberi.cam.dto.SendCodeRequest;
import com.zuberi.cam.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/send-code")
    public void sendCode(@Valid @RequestBody SendCodeRequest request) {
        authService.sendCode(request.getEmail());
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getCode());
        return new AuthResponse(token);
    }
}
