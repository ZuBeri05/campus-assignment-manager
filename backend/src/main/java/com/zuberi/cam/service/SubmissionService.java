package com.zuberi.cam.service;

import com.zuberi.cam.dto.SubmitRequest;
import com.zuberi.cam.entity.*;
import com.zuberi.cam.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final SubmissionFileRepository fileRepository;
    private final AssignmentRepository assignmentRepository;
    private final AssignmentRuleRepository ruleRepository;
    private final UserRepository userRepository;
    private final RuleCheckService ruleCheckService;

    public Submission submit(String email, SubmitRequest req) {
        Assignment assignment = assignmentRepository.findById(req.getAssignmentId()).orElseThrow();
        AssignmentRule rule = ruleRepository.findAll().stream()
                .filter(r -> r.getAssignment().getId().equals(assignment.getId()))
                .findFirst().orElse(null);

        boolean ok = ruleCheckService.validate(rule, req.getFilename(), req.getSizeBytes());
        if (!ok) throw new RuntimeException("Rule check failed");

        User student = userRepository.findByEmail(email).orElseThrow();
        Submission sub = new Submission();
        sub.setAssignment(assignment);
        sub.setStudent(student);
        sub.setNote(req.getNote());
        sub.setStatus("SUBMITTED");
        submissionRepository.save(sub);

        SubmissionFile file = new SubmissionFile();
        file.setSubmission(sub);
        file.setFilename(req.getFilename());
        file.setSizeBytes(req.getSizeBytes());
        file.setStoragePath("/tmp/" + req.getFilename());
        fileRepository.save(file);

        return sub;
    }
}
