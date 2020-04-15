<template>
  <div>
    <el-table :data="tableData" border style="width: 100%;">
      <el-table-column fixed prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="书名"></el-table-column>
      <el-table-column prop="author" label="作者"></el-table-column>
      <el-table-column prop="publish" label="出版社"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="padding-top:20px"
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="changePage"
    ></el-pagination>
  </div>
</template>

<style>
</style>
<script>
export default {
  methods: {
    deleteBook(row) {
      axios.delete("http://localhost:9999/book/delete/" + row.id).then(ret => {
        this.$alert("《" + row.name + "》已删除", {
          callback: action => {
            this.$router.go(0);
          }
        });
      });
    },
    update(row) {
      this.$router.push({
        path: "/BookUpdate",
        query: {
          id: row.id
        }
      });
    },
    changePage(page) {
      axios
        .get(
          "http://localhost:9999/book/findAll/" +
            (page - 1) +
            "/" +
            this.pageSize,
          {
            params: {}
          }
        )
        .then(ret => {
          console.log(ret.data);
          this.tableData = ret.data.content;
          this.total = ret.data.totalElements;
          this.pageSize = ret.data.size;
        });
    }
  },

  data() {
    return {
      pageSize: null,
      total: null,
      tableData: [
        {
          id: 1,
          name: "解忧杂货店",
          author: "东野圭吾",
          publish: "电子工业出版社"
        }
      ]
    };
  },
  created() {
    axios
      .get("http://localhost:9999/book/findAll/0/8", {
        params: {}
      })
      .then(ret => {
        this.tableData = ret.data.content;
        this.total = ret.data.totalElements;
        this.pageSize = ret.data.size;
      });
  }
};
</script>
