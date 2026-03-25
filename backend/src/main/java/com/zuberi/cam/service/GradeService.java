package com.zuberi.cam.service;

import com.zuberi.cam.entity.Grade;
import com.zuberi.cam.entity.Notification;
import com.zuberi.cam.entity.Submission;
import com.zuberi.cam.repository.GradeRepository;
import com.zuberi.cam.repository.NotificationRepository;
import com.zuberi.cam.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final SubmissionRepository submissionRepository;
    private final NotificationRepository notificationRepository;

    public Grade grade(Long submissionId, Double score, String comment) {
        Submission submission = submissionRepository.findById(submissionId).orElseThrow();
        Grade grade = new Grade();
        grade.setSubmission(submission);
        grade.setScore(score);
        grade.setComment(comment);
        Grade saved = gradeRepository.save(grade);

        Notification n = new Notification();
        n.setUser(submission.getStudent());
        n.setTitle("作业已评分");
        n.setContent("你的作业已评分，得分：" + score);
        notificationRepository.save(n);

        return saved;
    }
}
