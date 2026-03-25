package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "submission_files")
@Getter
@Setter
public class SubmissionFile extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private String filename;
    private String storagePath;
    private Long sizeBytes;
}
