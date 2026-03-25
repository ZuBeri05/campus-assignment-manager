package com.zuberi.cam.controller;

import com.zuberi.cam.entity.Notification;
import com.zuberi.cam.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationRepository notificationRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT','TEACHER','ADMIN')")
    public List<Notification> list(@RequestParam Long userId) {
        return notificationRepository.findAll().stream()
                .filter(n -> n.getUser().getId().equals(userId))
                .toList();
    }
}
