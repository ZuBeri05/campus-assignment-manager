<template>
  <div style="max-width: 720px; margin: 40px auto;">
    <h2>提交作业</h2>
    <el-form>
      <el-form-item label="作业ID">
        <el-input v-model="assignmentId" />
      </el-form-item>
      <el-form-item label="选择文件">
        <input type="file" @change="onFile" />
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="note" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import http from '../api/http'

const assignmentId = ref('')
const note = ref('')
const fileRef = ref(null)

const onFile = (e) => {
  fileRef.value = e.target.files[0]
}

const submit = async () => {
  const form = new FormData()
  form.append('assignmentId', assignmentId.value)
  form.append('note', note.value)
  form.append('file', fileRef.value)

  await http.post('/upload/submission', form, {
    headers: { 'X-User-Email': 'student@example.com', 'Content-Type': 'multipart/form-data' }
  })
}
</script>
