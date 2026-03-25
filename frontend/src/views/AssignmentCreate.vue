<template>
  <div style="max-width: 720px; margin: 40px auto;">
    <h2>发布作业</h2>
    <el-form>
      <el-form-item label="课程ID">
        <el-input v-model="form.courseId" />
      </el-form-item>
      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="描述">
        <el-input type="textarea" v-model="form.description" />
      </el-form-item>
      <el-form-item label="截止时间">
        <el-input v-model="form.dueAt" placeholder="2026-03-25T23:59:59" />
      </el-form-item>
      <el-form-item label="允许类型">
        <el-input v-model="form.allowedTypes" placeholder="pdf,zip,docx" />
      </el-form-item>
      <el-form-item label="最大大小(字节)">
        <el-input v-model="form.maxSizeBytes" />
      </el-form-item>
      <el-form-item label="必备文件">
        <el-input v-model="form.requiredFiles" placeholder="README.md,main.py" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">发布</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive } from 'vue'
import http from '../api/http'

const form = reactive({
  courseId: '',
  title: '',
  description: '',
  dueAt: '',
  allowedTypes: '',
  maxSizeBytes: '',
  requiredFiles: ''
})

const submit = async () => {
  await http.post('/assignments', form)
}
</script>
