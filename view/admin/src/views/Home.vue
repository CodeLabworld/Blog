<template>
  <div class="home">
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <Aside></Aside>
        </el-aside>
        <el-main>
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import Aside from "./aside/aside.vue";
import Header from "../components/header/header.vue";
// import { get } from "../utils/cache";
export default {
  name: "Home",
  data() {
    return {};
  },
  components: { Aside, Header },
  created: function() {
    // console.log(get("token"));
    // if (!get("token")) {
    //   console.log(111);
    //   this.$router.push("/login");
  },
  // },
};
</script>

<style scoped>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  /* text-align: center; */
  line-height: 60px;
  margin-left: 200px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  position: fixed;
  left: 200px;
  top: 60px;
  bottom: 0;
  right: 0;
}
</style>
