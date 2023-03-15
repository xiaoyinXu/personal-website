<template>
<div class="top-menu">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <!-- <div class="flex-grow" /> -->
        <el-menu-item index="0">
            <nav>
                <router-link to="/">
                <el-icon size="25px">
                    <House />
                </el-icon>
                </router-link>
            </nav>
        </el-menu-item>
        <el-menu-item index="1">
            <nav>
                <router-link to="/about">About</router-link>
            </nav>
        </el-menu-item>
        <el-menu-item index="2">
            <nav>
                <router-link to="/contact">Contact</router-link>
            </nav>
        </el-menu-item>
        <el-sub-menu index="3">
            <template #title>
                <el-icon size="25px">
                    <Menu />
                </el-icon>
            </template>
            <el-menu-item index="3-1">
                <nav>
                    <router-link to="/">Home</router-link>
                </nav>
            </el-menu-item>
            <el-menu-item index="3-2">item two</el-menu-item>
            <el-menu-item index="3-3">item three</el-menu-item>
            <el-sub-menu index="3-4">
                <template #title>item four</template>
                <el-menu-item index="3-4-1">item one</el-menu-item>
                <el-menu-item index="3-4-2">item two</el-menu-item>
                <el-menu-item index="3-4-3">item three</el-menu-item>
            </el-sub-menu>
        </el-sub-menu>
    </el-menu>
</div>
</template>

<script>
export default {
  name: "TopMenu"
};
</script>

<style>
.el-menu-demo {
  display: flex;
  justify-content: flex-end;
}

/* .flex-grow {
  flex-grow: 1;
} */
</style>
