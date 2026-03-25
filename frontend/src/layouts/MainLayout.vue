<template>
  <el-container style="min-height: 100vh;">
    <el-aside width="220px">
      <el-menu :default-active="active" router>
        <el-menu-item index="/assignments/new">发布作业</el-menu-item>
        <el-menu-item index="/submissions/new">提交作业</el-menu-item>
        <el-menu-item index="/similarity">相似度检测</el-menu-item>
        <el-menu-item index="/grades">评分</el-menu-item>
        <el-menu-item index="/notifications">通知</el-menu-item>
        <el-menu-item index="/admin/settings">系统设置</el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>Campus Assignment Manager</el-header>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useRoute } from 'vue-router'
const route = useRoute()
const active = route.path
</script>
