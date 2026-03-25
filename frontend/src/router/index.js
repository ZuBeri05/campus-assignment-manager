import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import AdminSettings from '../views/AdminSettings.vue'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  { path: '/admin/settings', component: AdminSettings }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
