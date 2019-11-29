import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Goods from '@/components/Goods'
import add from '@/components/add'
import update from '@/components/update'
import newS from '@/components/newS'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Goods',
      component: Goods
    },
    {
      path: '/add',
      name: 'add',
      component: add
    },
    {
      path: '/update/:id',
      name: 'update',
      component: update
    },
    {
      path: '/newS',
      name: 'newS',
      component: newS
    }
  ]
})
