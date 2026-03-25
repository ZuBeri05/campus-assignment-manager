package com.zuberi.cam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "system_settings")
@Getter
@Setter
public class SystemSetting extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String configKey;

    @Column(columnDefinition = "TEXT")
    private String configValue;
}
