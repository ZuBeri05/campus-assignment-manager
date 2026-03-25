import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import AdminSettings from '../views/AdminSettings.vue'

import AssignmentCreate from '../views/AssignmentCreate.vue'
import SubmissionCreate from '../views/SubmissionCreate.vue'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  { path: '/admin/settings', component: AdminSettings },
  { path: '/assignments/new', component: AssignmentCreate },
  { path: '/submissions/new', component: SubmissionCreate }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
