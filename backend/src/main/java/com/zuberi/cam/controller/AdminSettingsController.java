package com.zuberi.cam.controller;

import com.zuberi.cam.service.SystemSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/settings")
@RequiredArgsConstructor
public class AdminSettingsController {
    private final SystemSettingService settings;

    @PostMapping("/smtp")
    public void saveSmtp(@RequestBody Map<String, String> body) {
        settings.set("smtp.host", body.getOrDefault("host", ""));
        settings.set("smtp.port", body.getOrDefault("port", "587"));
        settings.set("smtp.username", body.getOrDefault("username", ""));
        settings.set("smtp.password", body.getOrDefault("password", ""));
        settings.set("smtp.ssl", body.getOrDefault("ssl", "false"));
        settings.set("smtp.tls", body.getOrDefault("tls", "true"));
        settings.set("smtp.enabled", body.getOrDefault("enabled", "false"));
    }

    @GetMapping("/smtp")
    public Map<String, String> getSmtp() {
        return Map.of(
                "host", settings.get("smtp.host").orElse(""),
                "port", settings.get("smtp.port").orElse(""),
                "username", settings.get("smtp.username").orElse(""),
                "password", "", // do not return password
                "ssl", settings.get("smtp.ssl").orElse("false"),
                "tls", settings.get("smtp.tls").orElse("true"),
                "enabled", settings.get("smtp.enabled").orElse("false")
        );
    }
}
