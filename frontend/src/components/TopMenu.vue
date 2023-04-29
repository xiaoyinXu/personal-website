<script setup lang="ts">
import {onMounted, ref} from 'vue'
import { useDark, useToggle } from '@vueuse/core'
import { useRouter, useRoute } from 'vue-router'


import {Moon, Sunny} from "@element-plus/icons-vue";
const route = useRoute()


onMounted(() => {
    console.log(route.path)

})

const isDark = useDark()
const isDarkStatus = ref(true)
const toggleDark = useToggle(isDark)

const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
</script>

<template>
  <el-menu
          :default-active="$route.path"
          class="el-menu-demo"
          mode="horizontal"
          :ellipsis="false"
          @select="handleSelect"
  >
    <el-menu-item index="..">LOGO</el-menu-item>
    <div class="flex-grow"/>
    <el-menu-item index="/" class="icon-menu-item">
        <el-link href="/">
          <el-tooltip
                  class="box-item"
                  effect="dark"
                  content="Home"
                  placement="bottom"
          >
          <el-icon size="large"><HomeFilled /></el-icon>
          </el-tooltip>
        </el-link>
    </el-menu-item>

    <el-menu-item index="/about" class="icon-menu-item">
      <el-link href="/about">
        About
      </el-link>
    </el-menu-item>

<!--    <el-sub-menu index="2">-->
<!--      <template #title>Workspace</template>-->
<!--      <el-menu-item index="2-1">item one</el-menu-item>-->
<!--      <el-menu-item index="2-2">item two</el-menu-item>-->
<!--      <el-menu-item index="2-3">item three</el-menu-item>-->
<!--      <el-sub-menu index="2-4">-->
<!--        <template #title>item four</template>-->
<!--        <el-menu-item index="2-4-1">item one</el-menu-item>-->
<!--        <el-menu-item index="2-4-2">item two</el-menu-item>-->
<!--        <el-menu-item index="2-4-3">item three</el-menu-item>-->
<!--      </el-sub-menu>-->
<!--    </el-sub-menu>-->
    <el-menu-item index="5">
      <el-menu-item index="top-right">
        <nav>
          <el-switch v-model="isDarkStatus" class="mt-2" @click="toggleDark()" inline-prompt :active-icon="Moon"
                     :inactive-icon="Sunny" />
        </nav>
      </el-menu-item>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>
.flex-grow {
    flex-grow: 1;
}

.icon-menu-item {
    height: var(--el-header-height);
    align-items: center;
}
</style>