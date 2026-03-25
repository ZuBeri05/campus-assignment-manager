INSERT INTO roles (id, name, created_at, updated_at) VALUES
 (1, 'STUDENT', NOW(), NOW()),
 (2, 'TEACHER', NOW(), NOW()),
 (3, 'TA', NOW(), NOW()),
 (4, 'ADMIN', NOW(), NOW())
ON DUPLICATE KEY UPDATE name=VALUES(name), updated_at=NOW();
