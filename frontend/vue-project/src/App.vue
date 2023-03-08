<template>
<div>
    <top-menu/>
    <div class="h-6" />
    <router-view/>
</div>
</template>

<script>
import TopMenu from "./components/TopMenu.vue";

export default {
  name: "App",
  components: {
    TopMenu
  },
  data() {},
  created() {}
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
