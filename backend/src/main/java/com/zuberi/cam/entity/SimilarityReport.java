package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "similarity_reports")
@Getter
@Setter
public class SimilarityReport extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "submission_a_id")
    private Submission submissionA;

    @ManyToOne(optional = false)
    @JoinColumn(name = "submission_b_id")
    private Submission submissionB;

    private Double score; // 0-1
}
