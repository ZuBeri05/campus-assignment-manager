package com.zuberi.cam.controller;

import com.zuberi.cam.dto.AssignmentCreateRequest;
import com.zuberi.cam.entity.Assignment;
import com.zuberi.cam.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    public Assignment create(@RequestBody AssignmentCreateRequest req) {
        return assignmentService.create(req);
    }
}
