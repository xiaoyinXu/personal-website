<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import {onMounted} from "vue";
import TopMenu from "@/components/TopMenu.vue";
import HelloWorld from './components/HelloWorld.vue'
import axios from "axios"


onMounted(() => {
    console.log("hello world")
})
</script>

<template>
    <el-container>
        <el-header class="my-header">
            <TopMenu />
        </el-header>
        <el-main class="my-main">
            <RouterView/>
        </el-main>

    </el-container>

</template>

<style scoped>
.my-main {
    width: 80vw;
    margin: 0 auto;
}

</style>
