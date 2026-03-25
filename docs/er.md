# 数据库设计（ER 概览）

## 核心表
- users
- roles
- user_roles
- courses
- course_members
- assignments
- assignment_rules
- submissions
- submission_files
- similarity_reports
- grades
- notifications
- system_settings

## 主要关系
- users <-> roles：多对多（user_roles）
- courses <-> users：多对多（course_members）
- assignments -> courses：多对一
- submissions -> assignments：多对一
- submissions -> users（学生）：多对一
- grades -> submissions：一对一/一对多
- similarity_reports -> assignments：一对多
- system_settings：键值配置（SMTP）

