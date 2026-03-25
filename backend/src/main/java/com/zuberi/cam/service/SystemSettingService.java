package com.zuberi.cam.service;

import com.zuberi.cam.entity.SystemSetting;
import com.zuberi.cam.repository.SystemSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemSettingService {
    private final SystemSettingRepository repo;

    public Optional<String> get(String key) {
        return repo.findByConfigKey(key).map(SystemSetting::getConfigValue);
    }

    public void set(String key, String value) {
        SystemSetting setting = repo.findByConfigKey(key).orElseGet(SystemSetting::new);
        setting.setConfigKey(key);
        setting.setConfigValue(value);
        repo.save(setting);
    }
}
