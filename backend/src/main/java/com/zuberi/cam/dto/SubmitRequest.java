package com.zuberi.cam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitRequest {
    private Long assignmentId;
    private String note;
    // simplified: file info (in real scenario use multipart upload)
    private String filename;
    private Long sizeBytes;
    private String storagePath;
}
