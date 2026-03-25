# API 文档（MVP）

## Auth
### 发送验证码
POST `/api/auth/send-code`
```json
{ "email": "user@example.com" }
```

### 登录
POST `/api/auth/login`
```json
{ "email": "user@example.com", "code": "123456" }
```

---
## Admin
### 获取 SMTP 设置
GET `/api/admin/settings/smtp`

### 保存 SMTP 设置
POST `/api/admin/settings/smtp`
```json
{
  "host": "smtp.example.com",
  "port": "587",
  "username": "xxx",
  "password": "xxx",
  "ssl": "false",
  "tls": "true",
  "enabled": "true"
}
```

---
## Assignments
### 发布作业
POST `/api/assignments`
```json
{
  "courseId": 1,
  "title": "HW1",
  "description": "desc",
  "dueAt": "2026-03-30T23:59:59",
  "allowedTypes": "pdf,zip",
  "maxSizeBytes": 10485760,
  "requiredFiles": "README.md"
}
```

---
## Submissions
### 提交（JSON 简化）
POST `/api/submissions`
Header: `X-User-Email`
```json
{
  "assignmentId": 1,
  "note": "my submission",
  "filename": "hw1.zip",
  "sizeBytes": 12345
}
```

### 提交（multipart）
POST `/api/upload/submission`
Header: `X-User-Email`
Form-data:
- assignmentId
- note
- file

---
## Similarity
### 对比
POST `/api/similarity/compare`
Params: `a`, `b`, `textA`, `textB`

### 报告列表
GET `/api/similarity/reports/{assignmentId}`

---
## Grades
### 评分
POST `/api/grades`
Params: `submissionId`, `score`, `comment`

---
## Notifications
### 列表
GET `/api/notifications?userId=1`

