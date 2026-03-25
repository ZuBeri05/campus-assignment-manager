package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String code; // optional course code

    private String term; // e.g. 2026 Spring
}
