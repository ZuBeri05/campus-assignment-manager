<template>
  <el-container style="min-height: 100vh;">
    <el-aside width="220px">
      <el-menu :default-active="active" router>
        <el-menu-item index="/student/submissions/new">提交作业</el-menu-item>
        <el-menu-item index="/student/notifications">通知</el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>Student Console</el-header>
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
