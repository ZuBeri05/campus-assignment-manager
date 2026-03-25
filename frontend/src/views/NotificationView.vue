<template>
  <div style="max-width: 640px; margin: 40px auto;">
    <h2>通知</h2>
    <el-form>
      <el-form-item label="用户ID">
        <el-input v-model="userId" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="load">加载通知</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="list" style="width:100%; margin-top: 20px;">
      <el-table-column prop="title" label="标题" />
      <el-table-column prop="content" label="内容" />
      <el-table-column prop="readFlag" label="已读" />
    </el-table>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import http from '../api/http'

const userId = ref('')
const list = ref([])

const load = async () => {
  const res = await http.get('/notifications', { params: { userId: userId.value } })
  list.value = res.data
}
</script>
