<template>
  <div style="max-width: 640px; margin: 40px auto;">
    <h2>系统设置 - SMTP</h2>
    <el-form>
      <el-form-item label="SMTP 主机">
        <el-input v-model="form.host" />
      </el-form-item>
      <el-form-item label="端口">
        <el-input v-model="form.port" />
      </el-form-item>
      <el-form-item label="账号">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="授权码">
        <el-input v-model="form.password" type="password" />
      </el-form-item>
      <el-form-item label="启用">
        <el-switch v-model="form.enabled" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive, onMounted } from 'vue'
import http from '../api/http'

const form = reactive({
  host: '',
  port: '587',
  username: '',
  password: '',
  enabled: false,
  ssl: false,
  tls: true
})

onMounted(async () => {
  const res = await http.get('/admin/settings/smtp')
  Object.assign(form, res.data)
})

const save = async () => {
  await http.post('/admin/settings/smtp', form)
}
</script>
