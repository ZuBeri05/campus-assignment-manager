package com.zuberi.cam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {
    private final String baseDir = "/root/.openclaw/workspace/campus-assignment-manager/storage";

    public String save(MultipartFile file) throws IOException {
        File dir = new File(baseDir);
        if (!dir.exists()) dir.mkdirs();
        String path = baseDir + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File dest = new File(path);
        file.transferTo(dest);
        return path;
    }
}
