import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import login from '../views/login/login.vue'
import dashboard from '../views/dashboard/dashboard.vue'
import blog from '../views/blogmanage/blog.vue'
import dynamic from '../views/blogmanage/dynamic.vue'


Vue.use(VueRouter)

const routes = [{
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/',
    name: 'Home',
    redirect: '/dashboard',
    component: Home,
    children: [{
      path: 'dashboard',
      component: dashboard
    }]
  },
  {
    path: '/blogmanage',
    name: 'blogmanage',
    component: Home,
    children: [{
      path: 'writeBlog',
      component: blog
    }, {
      path: 'writeDynamic',
      component: dynamic
    }]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import( /* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router