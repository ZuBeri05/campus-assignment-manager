package com.zuberi.cam.config;

import com.zuberi.cam.entity.Role;
import com.zuberi.cam.entity.User;
import com.zuberi.cam.repository.RoleRepository;
import com.zuberi.cam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        Role adminRole = roleRepository.findByName("ADMIN").orElse(null);
        if (adminRole == null) return;

        String adminEmail = "admin@local";
        boolean exists = userRepository.findByEmail(adminEmail).isPresent();
        if (!exists) {
            User u = new User();
            u.setEmail(adminEmail);
            u.setName("Admin");
            u.getRoles().add(adminRole);
            userRepository.save(u);
        }
    }
}
