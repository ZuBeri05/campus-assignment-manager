package com.zuberi.cam.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssignmentCreateRequest {
    private Long courseId;
    private String title;
    private String description;
    private LocalDateTime dueAt;

    // rules
    private String allowedTypes;
    private Long maxSizeBytes;
    private String requiredFiles;
}
