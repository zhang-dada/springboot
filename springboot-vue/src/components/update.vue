<template>
  <el-main>
    <el-form :inline="true" :model="saveForm" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="saveForm.id" placeholder="请输入名称" type="hidden"></el-input>
      </el-form-item>
      <el-form-item label="名称">
        <el-input v-model="saveForm.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="采购日期">
        <el-date-picker
          v-model="saveForm.createTime"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="数量">
        <el-input v-model="saveForm.num" placeholder="请输入数量"></el-input>
      </el-form-item><br>
      <el-form-item label="供应商">
      <el-input v-model="saveForm.supplier" placeholder="请输入供应商"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="saveForm.description" placeholder="请输入描述"></el-input>
      </el-form-item>
      <el-form-item label="单价">
        <el-input v-model="saveForm.price" placeholder="请输入单价" oninput="value=value.replace=(/[^\d]/g, '')"></el-input>
      </el-form-item>
      <el-form-item label="采购人">
        <el-input v-model="saveForm.username" placeholder="请输入采购人"></el-input>
      </el-form-item>
      <el-select v-model="saveForm.typeid" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.tid"
          :label="item.tname"
          :value="item.tid">
        </el-option>
      </el-select>
      <br>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </el-main>
</template>

<script>
    const axios=require("axios");
    const basePath="http://127.0.0.1";
    export default {
        name: "update",
        data(){
            return{
                saveForm:{},
                options:{},
            }
        },
        methods:{
            getlist(){
                const self=this;
                axios({
                    url:basePath+"/Office/types",
                    methods: "get",
                }).then(res=>{
                    console.log(res);
                    self.options=res.data;
                })
            },
            gethui(){
                const self=this;
                var id=this.$route.params;
               axios({
                    url:basePath+"/Office/selectByid",
                   methods:"get",
                   params: {id:id.id}
                }).then(res=>{
                  self.saveForm=res.data;

                })
            },
            onSubmit(){
                const self=this;
                console.log(self.saveForm)
               axios({
                    url:basePath+"/Office/update",
                   methods:"post",
                   params:this.saveForm
                }).then(res=>{
                    if (res){
                        alert("修改成功！");
                        this.$router.push("/");
                    }else{
                        alert("修改失败！");
                    }
                })
            }
        },
        created() {
            this.getlist();
            this.gethui();
        }
    }
</script>

<style scoped>

</style>
