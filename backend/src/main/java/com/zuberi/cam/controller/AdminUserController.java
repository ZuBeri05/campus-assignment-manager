package com.zuberi.cam.controller;

import com.zuberi.cam.dto.RoleUpdateRequest;
import com.zuberi.cam.entity.Role;
import com.zuberi.cam.entity.User;
import com.zuberi.cam.repository.RoleRepository;
import com.zuberi.cam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/roles")
    public User updateRoles(@RequestBody RoleUpdateRequest req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow();
        Set<Role> roles = req.getRoles().stream()
                .map(name -> roleRepository.findByName(name).orElseGet(() -> {
                    Role r = new Role();
                    r.setName(name);
                    return roleRepository.save(r);
                }))
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
