import path from 'path'
import { createRouter, createWebHistory } from 'vue-router'
import Vue from 'vue';
import firstPageVue from '../views/first-page.vue';
import adminPageVue from '../views/admin-page.vue';
import userPage from '../views/user-page.vue';
import ticketPage from '../views/ticket-page.vue';
import moviePage from '../views/movies-page.vue';

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
    },
    {
      path:'/tickets/:userName/:admin',
      name:'ticket-page',
      component: ticketPage,
      props: true
    },
    {
      path:'/movies/:userName',
      name:'movie-page',
      component: moviePage,
      props: true
    }
  ]
});

export default router;
