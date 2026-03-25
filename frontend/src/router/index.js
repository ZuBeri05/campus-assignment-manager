import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import AdminSettings from '../views/AdminSettings.vue'

import AssignmentCreate from '../views/AssignmentCreate.vue'
import SubmissionCreate from '../views/SubmissionCreate.vue'
import SimilarityCompare from '../views/SimilarityCompare.vue'
import GradeView from '../views/GradeView.vue'
import NotificationView from '../views/NotificationView.vue'

import MainLayout from '../layouts/MainLayout.vue'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  {
    path: '/',
    component: MainLayout,
    children: [
      { path: '/admin/settings', component: AdminSettings },
      { path: '/assignments/new', component: AssignmentCreate },
      { path: '/submissions/new', component: SubmissionCreate },
      { path: '/similarity', component: SimilarityCompare },
      { path: '/grades', component: GradeView },
      { path: '/notifications', component: NotificationView }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
