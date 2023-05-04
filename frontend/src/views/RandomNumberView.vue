<template>
  <div class="random-number">
    <div class="random-number-wrapper">
      <div class="row">
        <label>from:</label>
        <input v-model="min" type="number"/>
      </div>
      <div class="row">
        <label>to:</label>
        <input v-model="max" type="number"/>
      </div>
      <div class="row">
        <div class="label">
          <button @click="generate">
            generate
          </button>
        </div>
        <input v-model="result" disabled/>

      </div>

    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue'

export default defineComponent({
    name: "RandomNumberView.vue",
    data() {
        return {
            min: 0,
            max: 10,
            result: null as null | number
        }
    },
    methods: {
        randomNumber(min: number, max: number): number {
            return Math.floor(Math.random() * (max - min + 1) + min)
        },
        generate() {
            // The maximum is inclusive and the minimum is inclusive
            this.result = this.randomNumber(this.min, this.max)
        }
    }
})
</script>


<style scoped>
.random-number {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 800px;
}

.random-number-wrapper {
    height: 400px;
}

.row label, .row .label {
    display: inline-block;
    width: 200px;
    text-align: right;
    margin-right: 10px;
}


.row {
    display: flex;
    margin-bottom: 5px;
    height: 50px;
    line-height: 50px;
}



.row button {
    background-color: pink;
    color: purple;
}

</style>