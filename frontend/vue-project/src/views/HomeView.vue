<template>
  <div class="home-parent">
    <div class="home">
    {{homeContent}}
    <!-- <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
     <div v-for="article in articles" :key="article.id">
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>{{article.title}}</span>
      </div>
    </template>
    <p>{{article.content}}</p>
  </el-card>
  </div>
    </div>
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
      homeContent: "",
      articles: [
        {
          id: 1,
          title: "title1",
          content: "content1"
        },
        {
          id: 2,
          title: "title2",
          content: "content2"
        },
        {
          id: 3,
          title: "title3",
          content: "content3"
        }
      ]
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

<style>
.home-parent {
  background-color: rgb(241, 242, 242);
  width: 100%;
}

.home {
  background-color: rgb(241, 242, 242);
  width: 1000px;
  margin: 0 auto;
}

.box-card {
  text-align: left;
}
</style>

