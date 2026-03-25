<template>
  <div style="max-width: 900px; margin: 30px auto;">
    <h2>用户管理</h2>
    <el-table :data="users" style="width: 100%">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="email" label="邮箱" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column label="角色">
        <template #default="scope">
          <el-select v-model="scope.row.roleNames" multiple placeholder="选择角色">
            <el-option label="STUDENT" value="STUDENT" />
            <el-option label="TEACHER" value="TEACHER" />
            <el-option label="ADMIN" value="ADMIN" />
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120">
        <template #default="scope">
          <el-button type="primary" @click="save(scope.row)">保存</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import http from '../api/http'

const users = ref([])

const load = async () => {
  const res = await http.get('/admin/users')
  users.value = res.data.map(u => ({
    ...u,
    roleNames: (u.roles || []).map(r => r.name)
  }))
}

const save = async (row) => {
  await http.post('/admin/users/roles', { userId: row.id, roles: row.roleNames })
}

onMounted(load)
</script>
