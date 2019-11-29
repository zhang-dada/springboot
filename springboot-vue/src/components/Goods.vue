<template>
  <el-main>

    <el-form :inline="true" :model="queryForm" class="demo-form-inline">
      <el-select v-model="queryForm.typeid" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.tid"
          :label="item.tname"
          :value="item.tid">
        </el-option>
      </el-select>
      <el-form-item label="名称">
        <el-input v-model="queryForm.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="采购日期">
        <el-date-picker
          v-model="queryForm.startTime"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="至">
        <el-date-picker
          v-model="queryForm.endTime"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <el-button type="primary" @click="open()">添加</el-button>
    <el-button type="primary" @click="dels()">批量删除</el-button>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55"
        prop="id">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>

      <el-table-column
        prop="description"
        label="描述"
        width="180">
      </el-table-column>

      <el-table-column
        prop="createTime"
        label="日期"
        width="180">
      </el-table-column>

      <el-table-column
        prop="price"
        label="单价"
        width="180">
      </el-table-column>

      <el-table-column
        prop="num"
        label="数量"
        width="180">
      </el-table-column>
      <el-table-column
        prop="username"
        label="采购人"
        width="180">
      </el-table-column>
      <el-table-column
      prop="supplier"
      label="供应商"
      width="180">
    </el-table-column>

      <el-table-column
        prop="tname"
        label="分类名称">
      </el-table-column>

    <el-table-column>
      <template slot-scope="scope">
        <el-button type="primary" @click="gethui(scope.row.id)">修改</el-button>
        <el-button type="primary" @click="del(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
<!--添加修改模态框-->
    <el-dialog
      title="添加/修改"
      :visible.sync="detailDialogVisible"
      width="60%"
      :before-close="handleClose">
      <el-form :inline="true" :model="saveForm" class="demo-form-inline">
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
          <el-input v-model="saveForm.num" placeholder="请输入数量" oninput="value=value.replace(/[^\d]/g, '')" ></el-input>
        </el-form-item><br>
        <el-form-item label="供应商">
          <el-input v-model="saveForm.supplier" placeholder="请输入供应商"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="saveForm.description" placeholder="请输入描述"></el-input>
        </el-form-item>
        <el-form-item label="单价">
          <el-input v-model="saveForm.price" placeholder="请输入单价"  oninput="value=value.replace(/[^\d]/g, '')"></el-input>
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
      </el-form>

      <span slot="footer" class="dialog-footer">
      <el-button @click="detailDialogVisible= false">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
    </span>
    </el-dialog>
    <!--详情框-->


    <!--分页-->
    <div>
      <el-pagination
        background
        layout="prev, pager, next"
        @current-change="gotopage"
        :page-count="pages">
      </el-pagination>
    </div>
  </el-main>
</template>

<script>
    const axios=require("axios");
    const basePath="http://127.0.0.1";
    export default {
        name: "Goods",
        data(){
            return{
                tableData:[],
                queryForm:{
                    pageNum:1,
                    pageSize:3
                },
                pages:0,
                ids:{},
                formInline:{},
                options:{},
                detailDialogVisible:false,
                saveForm:{},
            }
        },
        methods:{
            handleSelectionChange(rows){
                let ids=null;
                rows.forEach(res=>{
                      if (ids==null){
                          ids=res.id;
                      }else{
                          ids=ids+","+res.id;
                      }
                })
                this.ids=ids;
                console.log(ids)
            this.ids=ids;
            },
            /*-----------------打开对话框----------------*/
            open(){
              this.detailDialogVisible=true;
              this.saveForm={};
            },
            /*-----------------关闭对话框----------------*/
            handleClose(){
                this.detailDialogVisible=false;
            },
            save(){
                this.detailDialogVisible=false;
                const self=this;
                axios({
                    url:basePath+"/Office/insert",
                    method:"post",
                    params:this.saveForm
                }).then(res=>{
                    if (res){
                        alert("添加成功！");
                        this.getlist()
                    }else{
                        alert("添加失败！");
                    }
                })
            },
            gethui(id){
                this.detailDialogVisible=true;
                const self=this;
                axios({
                    url:basePath+"/Office/selectByid",
                    methods:"get",
                    params: {id:id}
                }).then(res=>{
                    self.saveForm=res.data;

                })
            },
            gettlist(){
                const self=this;
                axios({
                    url:basePath+"/Office/types",
                    methods: "get",
                }).then(res=>{
                    console.log(res);
                    self.options=res.data;
                })
            },
            getlist(){
                const self=this;
                axios({
                    url:basePath+"/Office/list",
                    methods: "get",
                    params:this.queryForm
                }).then(res=>{
                    console.log(res);
                    self.tableData=res.data.list;
                    self.pages=res.data.pages;
                })
            },
            gotopage(pageNum){
                this.queryForm.pageNum=pageNum;
                this.getlist();
            },
            onSubmit(){
                this.queryForm.pageNum=1,
                    this.getlist();
            },
            del(id) {
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        url:basePath+"/Office/dele",
                        methods:"get",
                        params: {id:id}
                    }).then(res=>{
                        if (res){
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            this.getlist();
                        } else{
                            alert("删除失败！")
                        }
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            add(){
                this.$router.push("/add")
            },
            upd(id){
                this.$router.push("/update/"+id)
            },
            dels(){
                const self=this;
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                        axios({
                            url:basePath+"/Office/deles",
                            methods:"get",
                            params: {ids:self.ids}
                        }).then(res=>{
                            if (res){
                                this.$message({
                                    type: 'success',
                                    message: '删除成功!'
                                });
                                this.getlist();
                            } else{
                                alert("删除失败！")
                            }
                        });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        },
        created() {
            this.getlist();
            this.gettlist();
        }
    }
</script>

<style scoped>

</style>
