package com.zuberi.cam.service;

import com.zuberi.cam.entity.EmailCode;
import com.zuberi.cam.entity.Role;
import com.zuberi.cam.entity.User;
import com.zuberi.cam.repository.EmailCodeRepository;
import com.zuberi.cam.repository.RoleRepository;
import com.zuberi.cam.repository.UserRepository;
import com.zuberi.cam.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final EmailCodeRepository emailCodeRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MailService mailService;

    public void sendCode(String email) {
        String code = String.format("%06d", new Random().nextInt(999999));
        EmailCode emailCode = new EmailCode();
        emailCode.setEmail(email);
        emailCode.setCode(code);
        emailCode.setExpiresAt(LocalDateTime.now().plusMinutes(10));
        emailCodeRepository.save(emailCode);

        String devMode = System.getenv().getOrDefault("CAM_DEV_MODE", "false");
        if (Boolean.parseBoolean(devMode)) {
            System.out.println("[DEV OTP] " + email + " -> " + code);
        } else {
            mailService.send(email, "Your login code", "Your code: " + code);
        }
    }

    public String login(String email, String code) {
        EmailCode ec = emailCodeRepository
                .findTopByEmailAndUsedFalseAndExpiresAtAfterOrderByCreatedAtDesc(email, LocalDateTime.now())
                .orElseThrow(() -> new RuntimeException("Invalid code"));

        if (!ec.getCode().equals(code)) {
            throw new RuntimeException("Invalid code");
        }
        ec.setUsed(true);
        emailCodeRepository.save(ec);

        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User u = new User();
            u.setEmail(email);
            u.setName(email.split("@")[0]);
            Role student = roleRepository.findByName("STUDENT").orElseGet(() -> {
                Role r = new Role();
                r.setName("STUDENT");
                return roleRepository.save(r);
            });
            u.getRoles().add(student);
            return userRepository.save(u);
        });

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles().stream().map(Role::getName).toList());
        return JwtUtil.generateToken(user.getEmail(), claims);
    }
}
