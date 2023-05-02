<template>
  <div class="login-view">
    <el-form class="my-form" :model="form" :label-width="labelWidth">
        <h2 class="welcome-title">
          Welcome
        </h2>
      <el-form-item label="username">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="password">
        <el-input type="password" v-model="form.password" />
      </el-form-item>
      <div class="button-group">
        <el-button>
          back
        </el-button>
        <el-button type="primary" @click="submit">
          login
        </el-button>

      </div>
    </el-form>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue'
import axios from "axios";

export default defineComponent({
    name: "LoginView",
    data() {
        return {
            form: {
                username: '',
                password: ''
            },
            labelWidth: 120
        }
    },
    computed: {
        labelWidthPx() {
            return this.labelWidth + 'px'
        }
    },
    methods: {
        submit() {
            axios.post("/backend/home/login", this.form, {
                validateStatus(status) {
                    return status >= 201 && status <= 299 || status == 401
                },
                withCredentials: true
            })
                .then(res => {
                    if (res.status === 401) {
                        // this.$router.push({name: 'home'})
                        window.location.href = res.headers.location
                    }
                })
                .catch(err => {
                    console.log(err)
                })

        }
    }
})
</script>


<style scoped>
.login-view {
    width: 100vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    left: 0;
    top: 0;
    z-index: -1;
}

.my-form {
    width: 400px;
}

.welcome-title {
    text-align: center;
    margin-left: v-bind(labelWidthPx);
}


.button-group {
    display: flex;
    justify-content: end;
}

</style>