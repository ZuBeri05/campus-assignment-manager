package com.zuberi.cam.service;

import com.zuberi.cam.dto.AssignmentCreateRequest;
import com.zuberi.cam.entity.Assignment;
import com.zuberi.cam.entity.AssignmentRule;
import com.zuberi.cam.entity.Course;
import com.zuberi.cam.repository.AssignmentRepository;
import com.zuberi.cam.repository.AssignmentRuleRepository;
import com.zuberi.cam.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final AssignmentRuleRepository ruleRepository;
    private final CourseRepository courseRepository;

    public Assignment create(AssignmentCreateRequest req) {
        Course course = courseRepository.findById(req.getCourseId()).orElseThrow();

        Assignment a = new Assignment();
        a.setCourse(course);
        a.setTitle(req.getTitle());
        a.setDescription(req.getDescription());
        a.setDueAt(req.getDueAt());
        assignmentRepository.save(a);

        AssignmentRule rule = new AssignmentRule();
        rule.setAssignment(a);
        rule.setAllowedTypes(req.getAllowedTypes());
        rule.setMaxSizeBytes(req.getMaxSizeBytes());
        rule.setRequiredFiles(req.getRequiredFiles());
        ruleRepository.save(rule);

        return a;
    }
}
