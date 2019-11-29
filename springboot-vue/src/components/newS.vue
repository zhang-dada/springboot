<template>
  <div id="add">
    <div v-for="(d,index) in counter" :key="index">
        <input type="text" placeholder="请输入内容"/>
    </div>
    <el-button type="primary" @click="add">主要按钮</el-button>
  </div>
</template>

<script>
    export default {
        el:'#app',
        name: "newS",
        data(){
            return{
                counter:[]
            }
        },
        methods:{
            add(){
                this.counter.push({});
            }
        }
    }
</script>

<style scoped>

</style>
