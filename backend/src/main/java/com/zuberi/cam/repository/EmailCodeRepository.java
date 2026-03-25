package com.zuberi.cam.repository;

import com.zuberi.cam.entity.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailCodeRepository extends JpaRepository<EmailCode, Long> {
    Optional<EmailCode> findTopByEmailAndUsedFalseAndExpiresAtAfterOrderByCreatedAtDesc(String email, LocalDateTime now);
}
