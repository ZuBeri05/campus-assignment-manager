package com.zuberi.cam.controller;

import com.zuberi.cam.entity.SimilarityReport;
import com.zuberi.cam.entity.Submission;
import com.zuberi.cam.repository.SimilarityReportRepository;
import com.zuberi.cam.repository.SubmissionRepository;
import com.zuberi.cam.service.SimilarityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/similarity")
@RequiredArgsConstructor
public class SimilarityController {
    private final SimilarityService similarityService;
    private final SubmissionRepository submissionRepository;
    private final SimilarityReportRepository reportRepository;

    @PostMapping("/compare")
    public SimilarityReport compare(@RequestParam Long a, @RequestParam Long b,
                                    @RequestParam String textA, @RequestParam String textB) {
        double score = similarityService.similarity(textA, textB);
        Submission sa = submissionRepository.findById(a).orElseThrow();
        Submission sb = submissionRepository.findById(b).orElseThrow();
        SimilarityReport report = new SimilarityReport();
        report.setAssignment(sa.getAssignment());
        report.setSubmissionA(sa);
        report.setSubmissionB(sb);
        report.setScore(score);
        return reportRepository.save(report);
    }

    @GetMapping("/reports/{assignmentId}")
    public List<SimilarityReport> list(@PathVariable Long assignmentId) {
        return reportRepository.findAll().stream()
                .filter(r -> r.getAssignment().getId().equals(assignmentId))
                .toList();
    }
}
