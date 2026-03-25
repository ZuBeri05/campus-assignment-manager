<template>
  <div style="max-width: 720px; margin: 40px auto;">
    <h2>提交作业</h2>
    <el-form>
      <el-form-item label="作业ID">
        <el-input v-model="form.assignmentId" />
      </el-form-item>
      <el-form-item label="文件名">
        <el-input v-model="form.filename" />
      </el-form-item>
      <el-form-item label="文件大小(字节)">
        <el-input v-model="form.sizeBytes" />
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="form.note" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive } from 'vue'
import http from '../api/http'

const form = reactive({
  assignmentId: '',
  filename: '',
  sizeBytes: '',
  note: ''
})

const submit = async () => {
  await http.post('/submissions', form, {
    headers: { 'X-User-Email': 'student@example.com' }
  })
}
</script>
