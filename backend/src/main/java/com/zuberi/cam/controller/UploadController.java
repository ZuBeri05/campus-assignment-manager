package com.zuberi.cam.controller;

import com.zuberi.cam.dto.SubmitRequest;
import com.zuberi.cam.entity.Submission;
import com.zuberi.cam.service.FileStorageService;
import com.zuberi.cam.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {
    private final FileStorageService fileStorageService;
    private final SubmissionService submissionService;

    @PostMapping("/submission")
    public Submission upload(@RequestHeader("X-User-Email") String email,
                             @RequestParam Long assignmentId,
                             @RequestParam(required = false) String note,
                             @RequestPart("file") MultipartFile file) throws Exception {
        String path = fileStorageService.save(file);

        SubmitRequest req = new SubmitRequest();
        req.setAssignmentId(assignmentId);
        req.setNote(note);
        req.setFilename(file.getOriginalFilename());
        req.setSizeBytes(file.getSize());

        req.setStoragePath(path);
        Submission sub = submissionService.submit(email, req);
        return sub;
    }
}
