<template >
  <div id="app">
    <el-container direction="vertical">
      <el-header>欢迎来到心湖图书</el-header>
      <el-container style="border: 1px solid #eee; ">
        <el-aside width="230px" style="background-color: rgb(238, 241, 246)">
          <el-menu router :default-openeds="['0']">
            <el-submenu
              v-for="(item,index) in $router.options.routes"
              v-if="item.show"
              :key="index"
              :index="String(index)"
              
            >
              <template slot="title">
                <i class="el-icon-edit-outline"></i>
                {{item.name}}
              </template>

              <el-menu-item
                v-for="(item2,index2) in item.children"
                :key="index2"
                :index="item2.path"
                :class="$route.path==item2.path?'is-active':''"
              >
                <i class="el-icon-arrow-right"></i>
                {{item2.name}}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <router-view></router-view>
          </el-main>

          <el-footer>
            <a href="http://beian.miit.gov.cn/">粤 ICP备18132513号</a>
          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

a {
  text-decoration: none;
  color: rgb(37, 33, 51);
}

html,
body,
#index,
.el-container,
#app {
  padding: 0px;
  margin: 0px;
  height: 100%;
}

.el-footer {
  text-align: center;
  background-color: #cbced1;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>

<script>
</script>