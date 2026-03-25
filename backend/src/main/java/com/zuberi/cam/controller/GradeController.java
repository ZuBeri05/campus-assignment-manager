package com.zuberi.cam.controller;

import com.zuberi.cam.entity.Grade;
import com.zuberi.cam.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    public Grade grade(@RequestParam Long submissionId,
                       @RequestParam Double score,
                       @RequestParam(required = false) String comment) {
        return gradeService.grade(submissionId, score, comment);
    }
}
