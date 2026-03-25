package com.zuberi.cam.service;

import com.zuberi.cam.entity.AssignmentRule;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RuleCheckService {
    public boolean validate(AssignmentRule rule, String filename, Long sizeBytes) {
        if (rule == null) return true;
        if (rule.getMaxSizeBytes() != null && sizeBytes != null && sizeBytes > rule.getMaxSizeBytes()) {
            return false;
        }
        if (rule.getAllowedTypes() != null && filename != null) {
            List<String> types = Arrays.stream(rule.getAllowedTypes().split(","))
                    .map(String::trim).toList();
            String ext = filename.contains(".") ? filename.substring(filename.lastIndexOf('.') + 1) : "";
            if (!types.isEmpty() && !types.contains(ext)) {
                return false;
            }
        }
        // requiredFiles could be checked in multipart submission
        return true;
    }
}
