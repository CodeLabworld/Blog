<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>博客管理</el-breadcrumb-item>
      <el-breadcrumb-item>写博客</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="title">
      <h2>新文章</h2>
      <el-button
        id="fabu"
        @click="
          dialogFormVisible = true;
          initinfo();
        "
        type="primary"
        round
        >发布</el-button
      >
    </div>
    <el-dialog
      title="发布设置"
      :visible.sync="dialogFormVisible"
      append-to-body
    >
      <el-form :model="form">
        <el-form-item label="文章别名" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            placeholder="https://congloveqiu.cn/archives/{slug}"
          ></el-input>
        </el-form-item>
        <el-form-item label="发表时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="form.datavalue"
              align="right"
              type="datetime"
              format="yyyy-MM-dd HH:mm"
              value-format="yyyy-MM-dd HH:mm"
              placeholder="选择日期"
            >
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="是否置顶" :label-width="formLabelWidth">
          <el-switch
            v-model="form.istop"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-value="1"
            inactive-value="0"
          >
            >
          </el-switch>
        </el-form-item>

        <el-form-item label="是否可见" :label-width="formLabelWidth">
          <el-switch
            v-model="form.ispublished"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-value="1"
            inactive-value="0"
          >
            >
          </el-switch>
        </el-form-item>

        <el-form-item label="是否开启评论" :label-width="formLabelWidth">
          <el-switch
            v-model="form.iscommentenable"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-value="1"
            inactive-value="0"
          >
            >
          </el-switch>
        </el-form-item>

        <el-form-item label="分类" :label-width="formLabelWidth">
          <el-select v-model="form.category" filterable placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.name"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="摘要" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="form.textarea"
          >
          </el-input>
        </el-form-item>

        <el-form-item label="封面图" :label-width="formLabelWidth">
          <el-input placeholder="请输入图片url" v-model="form.imgurl">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button
          type="primary"
          @click="
            dialogFormVisible = false;
            fabu();
          "
          >确 定</el-button
        >
      </div>
    </el-dialog>
    <!-- 标题输入框 -->
    <el-input id="title" v-model="title" placeholder="请输入内容"></el-input>
    <div id="editor">
      <mavon-editor v-model="content" style="height:450px" />
    </div>
  </div>
</template>

<script>
import request from "../../utils/request";
export default {
  components: {},
  data() {
    return {
      dialogFormVisible: false,
      form: {
        name: "", //文章别名
        istop: 1, //是否置顶
        ispublished: 1, //是否可见
        datavalue: "", // 发表时间
        iscommentenable: 1, //是否开启评论
        category: "", //分类id
        textarea: "", //文章摘要
        imgurl: "", //图片url
      },
      options: [],
      value: "",
      title: "", //文章标题
      content: "", //文章内容
      formLabelWidth: "120px",
    };
  },
  methods: {
    initinfo() {
      //表单内分类信息初始化
      request({
        url: "/api/category",
        method: "GET",
      }).then((res) => {
        this.options = res;
      });
    },
    fabu() {
      //发布文章
      const artical = {
        title: this.title,
        name: this.form.name,
        content: this.content,
        istop: this.form.istop,
        datavalue: this.form.datavalue,
        iscommentenable: this.form.iscommentenable,
        ispublished: this.form.ispublished,
        categoryid: this.form.category,
        textarea: this.form.textarea,
        imgurl: this.form.imgurl,
      };

      request({
        url: "/api/writeArtical",
        method: "POST",
        data: artical,
      }).then((res) => {
        this.$message({
          type: "success",
          message: res.msg,
        });
      });
    },
  },
};
</script>

<style scoped>
.title {
  height: 50px;
  margin: 0 auto;
  margin-top: 5px;
  /* border: 1px solid #000; */
  text-align: left;
}
h2 {
  display: inline-block;
  margin: 10px 0 0 10px;
}
#fabu {
  position: fixed;
  margin-top: 5px;
  right: 50px;
}
#title {
  margin-top: 15px;
}
#editor {
  margin-top: 15px;
}
</style>
