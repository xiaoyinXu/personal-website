<template>
<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
    <div class="flex-grow" />
    <el-menu-item index="1">
        <nav>
            <router-link to="/about">About</router-link>
        </nav>
    </el-menu-item>
    <el-menu-item index="1">
        <nav>
            <router-link to="/contact">Contact</router-link>
        </nav>
    </el-menu-item>
    <!-- <el-sub-menu index="2">
        <template #title>Workspace</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-menu-item index="2-2">item two</el-menu-item>
        <el-menu-item index="2-3">item three</el-menu-item>
        <el-sub-menu index="2-4">
            <template #title>item four</template>
            <el-menu-item index="2-4-1">item one</el-menu-item>
            <el-menu-item index="2-4-2">item two</el-menu-item>
            <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
    </el-sub-menu> -->
    <el-menu-item index="3" disabled>Unknown</el-menu-item>
</el-menu>
</template>

<script>
export default {
  name: "TopMenu"
};
</script>

<style>
.flex-grow {
  flex-grow: 1;
}
</style>
