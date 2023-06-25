import Vue from 'vue'
import Router from 'vue-router'
import index from '../views/index.vue'
import Antd from 'ant-design-vue';
import problems from '../views/problemList.vue'
import problem from "../views/problem.vue";
import 'ant-design-vue/dist/antd.css';

Vue.use(Router)
Vue.use(Antd);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index,
      children: [
        {
          path: '/problems',
          name: 'problemList',
          component: problems
        }
      ]
    },
    {
      path: '/problem',
      name: 'problem',
      component: problem
    }
  ]
})
