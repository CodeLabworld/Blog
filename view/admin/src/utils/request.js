import axios from 'axios'
import {
  MessageBox,
  Message
} from 'element-ui'
import store from '../store'
import {
  get
} from './cache';

const instance = axios.create({
  baseURL: '',
  timeout: 0
});

// request interceptor
instance.interceptors.request.use(
  config => {
    if (get("token")) { //存在token则携带token
      config.headers['Authorization'] = get("token")
    }
    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
instance.interceptors.response.use(
  response => {
    const res = response.data

    // 用户名或密码错误
    if (res.code == 404) {
      Message({
        message: res.msg || 'Error',
        type: 'error',
        duration: 5 * 1000
      })

      // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
      if (res.code === 400 || res.code === 401) {
        // to re-login
        MessageBox.confirm('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
          confirmButtonText: 'Re-Login',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          store.dispatch('user/relogin').then(() => {
            location.reload()
          })
        })
      }
      return Promise.reject(new Error(res.message || 'Error'))
    } else {
      return res
    }
  },
  error => {
    console.log('err' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default instance

// AUTH_TOKEN = getoken();
// // Alter defaults after instance has been created
// var Headers = AUTH_TOKEN;

// var request = function (url, params, type = 'get') {
//   if (type && type.toLocaleUpperCase() === 'post') {
//     Headers['Authorization'] = 'application/x-www-form-urlencoded'
//     params.params = params;
//   }
//   return instance[type](url, params, Headers);
// }