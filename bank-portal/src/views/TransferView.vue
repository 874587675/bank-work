<style scoped lang="less">
.form-contain{
  max-width: 400px;
  margin: 50px auto;
}
</style>

<template>
  <div>
    <el-form :model="ruleForm"  status-icon :rules="rules" ref="ruleForm" label-width="130px" class="form-contain">
      <el-form-item label="收款用户编号" prop="receiverId">
        <el-input type="text" v-model="ruleForm.receiverId" autocomplete="请输入要转账的用户编号" ></el-input>
      </el-form-item>
<!--      <el-form-item label="姓名" prop="name">-->
<!--        <el-input type="text" v-model="ruleForm.name" autocomplete="请输入要转账的用户姓名"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="手机号" prop="phone">-->
<!--        <el-input type="text" v-model="ruleForm.phone" autocomplete="请输入要转账的手机号"></el-input>-->
<!--      </el-form-item>-->
      <el-form-item label="转账金额" prop="amount">
        <el-input type="text" v-model="ruleForm.amount" autocomplete="请输入要转账的金额"></el-input>
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
  name: "TransferView",
  data() {
    return {
      // 用户表格数据
      tableData: [],
      dialogVisible: false,

      ruleForm: {
        senderId: localStorage.getItem("userId"),
        receiverId: '',
        // name: '',
        // phone: '',
        amount: '',
      },

      rules: {
        receiverId: [
          {required: true, message: '请输入用户编号', trigger: 'blur'},
          {min: 1, max: 15, message: '用户编号长度在 1 到 15 个字符', trigger: 'blur'},
        ],
        // name: [
        //   {required: true, message: '请输入姓名', trigger: 'blur'},
        //   {min: 3, max: 5, message: '姓名长度在 3 到 5 个字符', trigger: 'blur'},
        // ],
        // phone: [
        //   {required: true, message: '请输入手机号', trigger: 'blur'},
        //   {min: 11, max: 11, message: '手机号长度11个字符', trigger: 'blur'},
        // ],
        amount: [
          {required: true, message: '请输入转账金额', trigger: 'blur'},
        ],
      },
    }
  },

  methods:{
    // 确认转账
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // 假设转账成功
          service.post('/pay/insertTransferRecord', this.ruleForm).then(response => {
            this.$message({
              type: 'success',
              message: '转账成功'
            });
            console.log(response.data)
          })
        } else {
          console.log('error submit!!');
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },

}
</script>
