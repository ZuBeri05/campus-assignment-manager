package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assignment_rules")
@Getter
@Setter
public class AssignmentRule extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    private String allowedTypes; // e.g. pdf,zip,docx
    private Long maxSizeBytes;   // max file size
    private String requiredFiles; // comma-separated
}
