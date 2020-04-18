import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManage from '../views/BookManage'
import AddBook from '../views/AddBook'
import BookUpdate from '../views/BookUpdate'
import Index from '../Index.vue'

Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: '图书展示系统',
    redirect: '/BookManage',
    show: true,
    component: Index,
    children: [{
        path: '/BookManage',
        name: '查询图书',
        // show: true,
        meta: {
          title: '图书列表信息'
        },
        component: BookManage
      },
      {
        path: '/AddBook',
        name: '添加图书',
        // show: true,
        meta: {
          title: '添加图书'
        },
        component: AddBook
      },
    ]
  },
  {
    path: '/BookUpdate',
    component: BookUpdate,
    name: '修改图书信息',
    show: false,
    meta: {
      title: '修改图书信息'
    }
  }
]

const router = new VueRouter({
  routes

})

export default router