package com.zuberi.cam.repository;

import com.zuberi.cam.entity.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemSettingRepository extends JpaRepository<SystemSetting, Long> {
    Optional<SystemSetting> findByConfigKey(String configKey);
}
