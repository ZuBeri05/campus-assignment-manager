package com.zuberi.cam.controller;

import com.zuberi.cam.dto.AssignmentCreateRequest;
import com.zuberi.cam.entity.Assignment;
import com.zuberi.cam.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping
    public Assignment create(@RequestBody AssignmentCreateRequest req) {
        return assignmentService.create(req);
    }
}
