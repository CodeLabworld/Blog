<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    style="height: 100%"
  >
    <el-menu-item index="1">
      <i class="el-icon-document"></i>
      <span slot="title">
        <router-link to="/dashboard">仪表盘</router-link>
      </span>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-location"></i>
        <span>博客管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="2-1"
          ><router-link to="/blogmanage/writeBlog"
            >写文章</router-link
          ></el-menu-item
        >
        <el-menu-item index="2-2"
          ><router-link to="/blogmanage/writeDynamic"
            >写动态</router-link
          ></el-menu-item
        >
      </el-menu-item-group>
    </el-submenu>
    <el-menu-item index="3">
      <i class="el-icon-document"></i>
      <span slot="title">导航三</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-setting"></i>
      <span slot="title">导航四</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  naem: "aside",
  methods: {
    // handleOpen(key, keyPath) {
    //   // console.log(key, keyPath);
    // },
    // handleClose(key, keyPath) {
    //   // console.log(key, keyPath);
    // },
  },
};
</script>

<style scoped>
.el-submenu .el-menu-item {
  padding: 0;
}
</style>
