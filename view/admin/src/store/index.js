import Vue from 'vue'
import Vuex from 'vuex'
import router from '../router'
import request from '../utils/request'
import {
  remove,
  set
} from '../utils/cache'


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      nickname: "",
      token: ""
    }
  },
  mutations: {
    tologin(state, token) {
      state.user.token = token;
      set("token", token); //将token保存在localstorage中
      router.push('/');
    },
    loginout(state) {
      state.user.nickname = '';
      remove("token");
      router.push('/login')
    }
  },
  actions: {
    login({
      commit
    }, params) {
      const {
        username,
        password,
      } = params;
      console.log("开始")
      request({
        url: '/api/login',
        method: 'POST',
        data: {
          username: username.trim(),
          password: password
        }
      }).then(response => {
        const {
          data
        } = response;
        commit("tologin", data.Authorization)
      });

    },

    loginout({
      commit
    }) {
      commit("loginout")
    }
  },
  modules: {}
})