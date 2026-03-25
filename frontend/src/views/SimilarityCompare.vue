<template>
  <div style="max-width: 720px; margin: 40px auto;">
    <h2>相似度检测</h2>
    <el-form>
      <el-form-item label="Submission A ID">
        <el-input v-model="form.a" />
      </el-form-item>
      <el-form-item label="Submission B ID">
        <el-input v-model="form.b" />
      </el-form-item>
      <el-form-item label="Text A">
        <el-input type="textarea" v-model="form.textA" />
      </el-form-item>
      <el-form-item label="Text B">
        <el-input type="textarea" v-model="form.textB" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="compare">计算</el-button>
      </el-form-item>
    </el-form>
    <div v-if="score !== null">相似度：{{ score }}</div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import http from '../api/http'

const form = reactive({ a: '', b: '', textA: '', textB: '' })
const score = ref(null)

const compare = async () => {
  const res = await http.post('/similarity/compare', null, {
    params: { a: form.a, b: form.b, textA: form.textA, textB: form.textB }
  })
  score.value = res.data.score
}
</script>
