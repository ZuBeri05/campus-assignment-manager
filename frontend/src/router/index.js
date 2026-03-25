import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import AdminSettings from '../views/AdminSettings.vue'

import AssignmentCreate from '../views/AssignmentCreate.vue'
import SubmissionCreate from '../views/SubmissionCreate.vue'
import SimilarityCompare from '../views/SimilarityCompare.vue'
import GradeView from '../views/GradeView.vue'
import NotificationView from '../views/NotificationView.vue'

import TeacherLayout from '../layouts/TeacherLayout.vue'
import StudentLayout from '../layouts/StudentLayout.vue'

import { isLoggedIn, hasRole } from '../utils/auth'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  {
    path: '/teacher',
    component: TeacherLayout,
    meta: { requiresAuth: true, roles: ['TEACHER', 'ADMIN'] },
    children: [
      { path: '/teacher/assignments/new', component: AssignmentCreate },
      { path: '/teacher/similarity', component: SimilarityCompare },
      { path: '/teacher/grades', component: GradeView },
      { path: '/teacher/notifications', component: NotificationView }
    ]
  },
  {
    path: '/student',
    component: StudentLayout,
    meta: { requiresAuth: true, roles: ['STUDENT'] },
    children: [
      { path: '/student/submissions/new', component: SubmissionCreate },
      { path: '/student/notifications', component: NotificationView }
    ]
  },
  {
    path: '/admin',
    component: TeacherLayout,
    meta: { requiresAuth: true, roles: ['ADMIN'] },
    children: [
      { path: '/admin/settings', component: AdminSettings }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (!to.meta?.requiresAuth) return next()
  if (!isLoggedIn()) return next('/login')

  const roles = to.meta?.roles || []
  if (roles.length === 0) return next()
  const allowed = roles.some(r => hasRole(r))
  if (!allowed) return next('/login')
  next()
})

export default router
