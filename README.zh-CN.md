# 校园课程作业管理系统（Campus Assignment Manager）

面向软件工程课程的全流程作业管理系统（MVP）。

## ✨ 功能（MVP）
- 邮箱验证码登录（SMTP 由管理员后台配置）
- 课程与作业管理
- 作业提交 + 规则校验（文件类型/大小）
- 相似度检测（基础版 Jaccard）
- 评分与评语
- 站内通知
- 管理员系统设置

## 🧱 技术栈
- 后端：Java 17 / Spring Boot 3 / MySQL 8
- 前端：Vue 3 / Vite / Element Plus

## 🗂️ 项目结构
```
backend/   # Spring Boot
frontend/  # Vue3
docs/      # 需求、ER、API、Postman
```

## 🚀 快速启动
### 后端
```bash
cd backend
# 修改 src/main/resources/application.yml 的数据库配置
mvn spring-boot:run
```

### 前端
```bash
cd frontend
npm install
npm run dev
```

## 🔐 登录与 SMTP
- 登录使用邮箱验证码
- SMTP 配置在后台页面：`/admin/settings`
- **开发模式（无需 SMTP）**
  ```bash
  CAM_DEV_MODE=true mvn spring-boot:run
  ```
  验证码会打印在后端日志中。

## 📄 文档
- 需求说明：`docs/requirements.md`
- 数据库设计：`docs/er.md`
- API 文档：`docs/api.md`
- Postman 集合：`docs/postman_collection.json`

## 🧭 架构（概览）
```
[Vue 前端] -> [Spring Boot API] -> [MySQL]
                      |
                      -> [SMTP 邮件服务]
```

## 📷 截图
- （请在此补充截图）

## 🧪 本地部署
### 1）数据库
```sql
CREATE DATABASE cam DEFAULT CHARACTER SET utf8mb4;
```
修改 `backend/src/main/resources/application.yml` 的数据库配置。

### 2）后端
```bash
cd backend
mvn spring-boot:run
```

### 3）前端
```bash
cd frontend
npm install
npm run dev
```

## 📌 路线图
- 细粒度权限（RBAC）
- 真实对象存储
- 更强的相似度检测
- UI/UX 优化
