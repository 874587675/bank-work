<style scoped lang="less">
  .form-contain{
    max-width: 400px;
    margin: 50px auto;
  }
</style>

<template>
  <div>
    <el-form :model="ruleForm"  status-icon :rules="rules" ref="ruleForm" label-width="100px" class="form-contain">
      <el-form-item label="用户名" prop="username">
        <el-input type="text" v-model="ruleForm.username" autocomplete="off" ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import service from "@/utils/axois";


export default {
  name: "LoginView",
  data() {
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        if (this.ruleForm.password !== '') {
          this.$refs.ruleForm.validateField('password');
        }
        callback();
      }
    };

    var validatePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      }else {
        callback();
      }
    };

    return {
      ruleForm: {
        username: '',
        password: '',
      },
      rules: {
        username: [
          {validator: validateUsername, trigger: 'blur'}
        ],
        password: [
          {validator: validatePassword, trigger: 'blur'}
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          service.post('/user/selectUsers', {
            username: this.ruleForm.username,
            password: this.ruleForm.password
          }).then(response => {
            this.$message({
              type: 'success',
              message: '登陆成功'
            });
            localStorage.setItem('userId', response.data.data[0].id);
            this.$router.push({name: 'MainView'});
          })
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}

</script>
