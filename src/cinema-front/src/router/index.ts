import path from 'path'
import { createRouter, createWebHistory } from 'vue-router'
import Vue from 'vue';
import firstPageVue from '../views/first-page.vue';
import adminPageVue from '../views/admin-page.vue';
import userPage from '../views/user-page.vue';

const router = createRouter({

  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
    path:'/',
    name: 'firstPage',
    component: firstPageVue
    },
    
    {
      path:'/admin-page/:userName',
      name:'adminPage',
      component:adminPageVue
    },
    {
      path:'/user-page/:userName',
      name:'user-page',
      component: userPage,
      props: true
    }
  ]
});

export default router;
