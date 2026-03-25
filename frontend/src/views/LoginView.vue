<template>
  <div style="max-width: 360px; margin: 60px auto;">
    <h2>邮箱验证码登录</h2>
    <el-form>
      <el-form-item label="邮箱">
        <el-input v-model="email" placeholder="you@example.com" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="sendCode">发送验证码</el-button>
      </el-form-item>
      <el-form-item label="验证码">
        <el-input v-model="code" />
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import http from '../api/http'
import { setToken, getRoles } from '../utils/auth'
import { useRouter } from 'vue-router'

const router = useRouter()
const email = ref('')
const code = ref('')

const sendCode = async () => {
  await http.post('/auth/send-code', { email: email.value })
}

const login = async () => {
  const res = await http.post('/auth/login', { email: email.value, code: code.value })
  setToken(res.data.token)
  const roles = getRoles()
  if (roles.includes('TEACHER') || roles.includes('ADMIN')) {
    router.push('/teacher/assignments/new')
  } else {
    router.push('/student/submissions/new')
  }
}
</script>
