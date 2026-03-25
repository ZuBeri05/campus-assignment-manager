package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grades")
@Getter
@Setter
public class Grade extends BaseEntity {
    @OneToOne(optional = false)
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private Double score;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
