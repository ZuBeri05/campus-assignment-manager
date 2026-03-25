package com.zuberi.cam.controller;

import com.zuberi.cam.dto.SubmitRequest;
import com.zuberi.cam.entity.Submission;
import com.zuberi.cam.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService submissionService;

    @PostMapping
    @PreAuthorize("hasAnyRole('STUDENT')")
    public Submission submit(@RequestHeader("X-User-Email") String email, @RequestBody SubmitRequest req) {
        return submissionService.submit(email, req);
    }
}
