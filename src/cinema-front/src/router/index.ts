import path from 'path'
import { createRouter, createWebHistory } from 'vue-router'
import Vue from 'vue';
//import firstPageVue from '@/components/first-page/first-page.vue';
//import adminPageVue from './views/admin-page.vue';
//import firstPageVue from './views/firstPageVue'
import firstPageVue from '../views/first-page.vue';
import adminPageVue from '../views/admin-page.vue';

const router = createRouter({

  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
    path:'/',
    name: 'firstPage',
    component: firstPageVue
    },
    
    {
      path:'/admin-page',
      name:'adminPage',
      component:adminPageVue
    }
  ]
});

export default router;
