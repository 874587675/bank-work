<style scoped lang="less">
.form-contain{
  max-width: 400px;
  margin: 50px auto;
}
</style>

<template>
  <div>
    <el-button type="success" round style="margin-top: 10px;float: right" @click="addUser">开户</el-button>
    <el-table :data="tableData" stripe style="width: 100%" >
      <el-table-column prop="id" label="用户编号" align="center">
      </el-table-column>
      <el-table-column prop="username" label="用户名" align="center">
      </el-table-column>
      <el-table-column prop="name" label="姓名" align="center">
      </el-table-column>
      <el-table-column prop="phone" label="手机号" align="center">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" align="center">
      </el-table-column>
      <el-table-column prop="status" label="状态" align="center">
          <template slot-scope="scope">
            {{ scope.row.status === 0? '正常' : '冻结' }}
          </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <span v-if="scope.row.status===0">
            <el-button type="warning" size="small" @click="freezeUser(scope.row)">冻结</el-button>
          </span>
          <span v-else>
            <el-button type="success" size="small" @click="freezeUser(scope.row)">解冻</el-button>
          </span>
          <el-button type="danger" size="small" @click="deleteUser(scope.row)" style="margin-left: 5px">注销</el-button>
        </template>
      </el-table-column>
    </el-table>

<!--    开户弹出框-->
    <el-dialog title="开户" :visible.sync="dialogVisible" width="60%" :before-close="handleClose">
      <el-form :model="ruleForm"  status-icon :rules="rules" ref="ruleForm" label-width="100px" class="form-contain">
        <el-form-item label="用户名" prop="username">
          <el-input type="text" v-model="ruleForm.username" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input type="text" v-model="ruleForm.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户类型" prop="userType">
          <el-input type="text" v-model="userTypeDisplay" autocomplete="off" disabled ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import service from "@/utils/axois";

export default {
  name: "UserView",
  data() {
    return {
      // 用户表格数据
      tableData: [],
      dialogVisible: false,

      ruleForm: {
        username: '',
        password: '',
        name: '',
        phone: '',
        userType: '0',
        status: '0',
        deleted: '0',
      },

      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 5, max: 15, message: '用户名长度在 5 到 15 个字符', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 6, max: 20, message: '密码长度在 6 到 20 个字符', trigger: 'blur'},
        ],
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 3, max: 5, message: '姓名长度在 3 到 5 个字符', trigger: 'blur'},
        ],
        phone: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {min: 11, max: 11, message: '手机号长度11个字符', trigger: 'blur'},
        ],
      },
    }
  },
  //计算属性
  computed: {
    userTypeDisplay: {
      get() {
        return this.ruleForm.userType === '0' ? '普通用户' : '其他用户'; // 根据需要扩展其他用户类型
      },
      set(value) {
        this.ruleForm.userType = value === '普通用户' ? '0' : '1'; // 设置对应的值
      }
    }
  },

  methods:{
    // 冻结用户
    freezeUser(row){
      service.post('/user/updateUser',{
         id:row.id,
         status:(row.status+1)%2,
      }).then(response=>{
        if (response.data.code===200){
            this.$message({
            type:'success',
            message: '操作成功',
          });
          this.selectUsers();
        }
      })
    },

    // 删除用户
    deleteUser(row){
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        service.post('/user/deleteUser',{
           id:row.id,
           deleted:1,
        }).then(response=>{
          if (response.data.code===200){
              this.$message({
              type:'success',
              message: '删除成功',
            });
            this.selectUsers();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    // 查询所有用户信息
    selectUsers(){
      service.post('/user/selectUsers',{})
          .then(response=>{
        if (response.data.code===200){
            this.$message({
            type:'success',
            message: '查看用户成功',
          });
        this.tableData = response.data.data;
        }
      })
    },
    // 开户弹出框
    handleClose() {
      this.dialogVisible = false;
    },

    //开户
    addUser(){
      this.dialogVisible = true;
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          service.post('/user/insertUser',this.ruleForm)
              .then(response=>{
                if (response.data.code===200){
                    this.$message({
                    type:'success',
                    message: '开户成功',
                  });
                  this.dialogVisible = false;
                  this.selectUsers();
                } else {
                  this.$message({
                    type: 'error',
                    message: response.data.msg,
                  });
                }
              })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },

  created() {
    this.selectUsers();
  },
}
</script>
