<template>
  <div class="headerbox">
    <div class="box"></div>
    <div class="headerinfo">
      <el-col :span="2" width="100px">
        <el-dropdown>
          <span class="el-dropdown-link">
            <i class="el-icon-user-solid el-icon--right"></i
            >{{ this.$store.state.user.nickname }}
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item icon="el-icon-user">个人中心</el-dropdown-item>
            <el-dropdown-item icon="el-icon-s-tools">个人设置</el-dropdown-item>
            <el-dropdown-item icon="el-icon-warning-outline"
              ><span @click="loginout">退出登录</span></el-dropdown-item
            >
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  components: {},
  methods: {
    loginout: function() {
      var that = this.$store;
      this.$confirm("是否退出登录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$message(
            {
              type: "success",
              message: "退出成功!",
            },
            that.dispatch("loginout")
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
  },
};
</script>

<style scoped>
.box {
  left: 0;
  width: 900px;
  height: 60px;
  display: inline-block;
}
.el-dropdown {
  /* display: inline-block; */
  width: 100px;
  text-align: center;
  position: absolute;
  right: 30px;
}
.headerbox {
  height: 60px;
}
.headerinfo {
  height: 60px;
  display: inline-block;
}
</style>
