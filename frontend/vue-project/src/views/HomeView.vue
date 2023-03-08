<template>
  <div class="home">
    {{homeContent}}
    <!-- <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import axios from "axios";

export default {
  name: "HomeView",
  components: {
    HelloWorld
  },
  data() {
    return {
      homeContent: ""
    };
  },
  created() {
    axios
      .get("/backend/home/content")
      .then(response => {
        this.homeContent = response.data;
      })
      .catch(error => {
        this.homeContent = "Home";
      });
  }
};
</script>
