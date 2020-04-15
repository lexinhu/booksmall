<template>
  <div>
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
    <el-form-item label="图书编号" >
        <el-input v-model="ruleForm.id" readonly ></el-input>
      </el-form-item>
      <el-form-item label="书名" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publish">
        <el-input v-model="ruleForm.publish"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
        id: "",
        name: "",
        author: "",
        publish: ""
      },
      rules: {
        name: [
          {
            required: true,
            message: "图书名称不能为空",
            trigger: "blur"
          }
        ],
        author: [
          {
            required: true,
            message: "作者不能为空",
            trigger: "blur"
          }
        ],
        publish: [
          {
            min: 3,
            max: 30,
            message: "长度在 3 到 30 个字符",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          axios
            .put(`http://localhost:9999/book/update/`, this.ruleForm)
            .then(ret => {
              if (ret.data == "success") {
                this.$message({
                  message: "恭喜你，修改成功！",
                  type: "success"
                });
                this.$router.push('/BookManage')
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created(){
    console.log(this.$route.query.id); 
    axios.get("http://localhost:9999/book/findById/"+this.$route.query.id,{
      params:{}
    }).then(ret=>{
      console.log(ret);
      this.ruleForm = ret.data;
    })
  }
};
</script>