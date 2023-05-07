<script setup lang="ts">
import {onMounted, ref} from 'vue'
import {useDark, useToggle} from '@vueuse/core'
import {useRouter, useRoute} from 'vue-router'


import {Moon, Sunny} from "@element-plus/icons-vue";

const route = useRoute()


onMounted(() => {
    console.log(route.path)

})

function openGithubPage() {
    window.open("https://github.com/xiaoyinXu")
}

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
          :router="true"
  >
    <h1 index="..">Cookieee's Evolving Website</h1>
    <div class="flex-grow"/>
    <el-menu-item index="/" class="icon-menu-item">
      <el-link href="/">
        <el-tooltip
                class="box-item"
                effect="dark"
                content="Home"
                placement="bottom"
        >
          <el-icon size="large">
            <HomeFilled/>
          </el-icon>
        </el-tooltip>
      </el-link>
    </el-menu-item>

    <el-menu-item index="/about" class="icon-menu-item">
      <el-link href="/about" @click="openGithubPage">
        <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" viewBox="0 0 24 24" class="vt-social-link-icon"><path d="M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12"></path></svg>
        <!--        About-->
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
    <el-menu-item>
        <nav>
          <el-switch v-model="isDarkStatus" class="mt-2" @click="toggleDark()" inline-prompt :active-icon="Moon"
                     :inactive-icon="Sunny"/>
        </nav>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>
.el-menu {
    padding: 0 50px;
}


.flex-grow {
    flex-grow: 1;
}

.icon-menu-item {
    height: var(--el-header-height);
    align-items: center;
}

.vt-social-link-icon {
    width: 20px;
    height: 20px;
}

.vt-social-link-icon path{
    fill: var(--el-menu-text-color);
}
</style>