# Campus Assignment Manager

A full-stack campus assignment management system for Software Engineering coursework.

- 中文说明：**[README.zh-CN.md](README.zh-CN.md)**

## ✨ Features (MVP)
- Email OTP login (SMTP configurable in admin panel)
- Course & assignment management
- Submission with rule validation (file type/size)
- Similarity detection (basic Jaccard)
- Grading & feedback
- Notifications
- Admin system settings

## 🧱 Tech Stack
- Backend: Java 17, Spring Boot 3, MySQL 8
- Frontend: Vue 3, Vite, Element Plus

## 🗂️ Project Structure
```
backend/   # Spring Boot app
frontend/  # Vue3 app
docs/      # Requirements, ER, API, Postman
```

## 🚀 Quick Start
### Backend
```bash
cd backend
# edit src/main/resources/application.yml for DB
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```

## 🔐 Auth & SMTP
- Email login uses OTP codes.
- SMTP settings are stored in DB and configured via admin page:
  - `/admin/settings`

## 📄 Docs
- Requirements: `docs/requirements.md`
- ER design: `docs/er.md`
- API docs: `docs/api.md`
- Postman: `docs/postman_collection.json`

## 📌 Roadmap
- Fine-grained RBAC permissions
- Real file storage (S3/OSS)
- Improved plagiarism detection
- Better UI/UX
