package com.zuberi.cam.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleUpdateRequest {
    private Long userId;
    private List<String> roles;
}
