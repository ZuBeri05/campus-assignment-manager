<template>
  <div style="max-width: 640px; margin: 40px auto;">
    <h2>评分</h2>
    <el-form>
      <el-form-item label="Submission ID">
        <el-input v-model="form.submissionId" />
      </el-form-item>
      <el-form-item label="分数">
        <el-input v-model="form.score" />
      </el-form-item>
      <el-form-item label="评语">
        <el-input type="textarea" v-model="form.comment" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">提交评分</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { reactive } from 'vue'
import http from '../api/http'

const form = reactive({
  submissionId: '',
  score: '',
  comment: ''
})

const submit = async () => {
  await http.post('/grades', null, { params: form })
}
</script>
