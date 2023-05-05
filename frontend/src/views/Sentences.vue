<template>
  <div class="sentences">
    <Transition>
      <el-card class="box-card">
        <template v-for="(line, index) in sentence?.lines" :key="index">
          <div class="one-line-sentence">
            <Transition>
              <p v-if="showLine[index]">
                {{ line }}
              </p>
            </Transition>
          </div>
        </template>
        <Transition>
          <div class="by-who">
            <p v-if="showByWho">
              {{sentence.by}}
            </p>
          </div>
        </Transition>
      </el-card>
    </Transition>
    <div class="button-group">
      <el-button type="primary" @click="nextSentence">next</el-button>
    </div>
  </div>

</template>

<script lang="ts">
import {defineComponent} from 'vue'
import {sleep} from "@/util/sleep";
import {nextTick} from "vue";
import {randomOne} from "@/util/random";

interface sentence {
    lines: Array<string>;
    showLine: Array<boolean>;
    by?: string
}

export default defineComponent({
    name: "Sentences",
    data() {
        return {
            content: 'to love oneself is the beginning of a lifelong romance',
            by: 'Oscar Wilde',
            showSentence: true,
            sentences: [
                {
                    lines: [
                        "I love you once,",
                        "I love you twice,",
                        "I love you more than beans and rice.",
                    ],
                    by: 'Desperate Housewives'
                },
                {
                    lines: [
                        "To love oneself is the beginning of a lifelong romance.",
                    ],
                    by: 'Oscar Wilde'
                },
                {
                    lines: [
                        "If you want to know something about yourself,",
                        "sit on your bed one night and say,",
                        "What's one thing you are doing wrong,",
                        "that you know you are doing wrong,",
                        "that you could fix,",
                        "that you would fix?",
                        "If you meditate on that,",
                        "you'll get an answer.",
                    ],
                    by: 'Jordan Peterson'
                },

            ] as Array<sentence>,
            sentence: null as sentence | null,
            showLine: [] as Array<boolean>,
            showByWho: false
        }
    },
    methods: {
        async nextSentence() {
            this.showLine = []
            this.showByWho = false
            this.sentence = randomOne(this.sentences)
            if (this.sentence) {
                for (let i = 0; i < this.sentence.lines.length; i++) {
                    await sleep(1000)
                    this.showLine.push(true)
                }
            }
        }
    },
    async created() {
        this.nextSentence()
    },
    watch: {
        showLine: {
            async handler(newVal, oldVal) {
                if (newVal.length === this.sentence?.lines.length) {
                    await sleep(1000)
                    this.showByWho = true
                }
            },
            deep: true
        },
    }
})
</script>


<style scoped>
.v-enter-active,
.v-leave-active {
    transition: opacity 1s ease;
}

.v-enter-from,
.v-leave-to {
    opacity: 0;
}

.sentence {
    position: relative;
}


.one-line-sentence {
    font-size: 20px;
    line-height: 50px;
}

.by-who {
    display: flex;
    justify-content: end;
}

.button-group {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}

</style>