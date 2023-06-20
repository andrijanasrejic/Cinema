<template>
    
    <body>
      <div>
        <NavBarComponent></NavBarComponent>
      <div>
    <router-view></router-view>
    
      </div>
      </div>
    </body>
</template>

<style>
  #app {
    position: relative;
    text-align: center;
  }

  NavBarComponent {
    position: relative;
    z-index:999;
    top: 20px;
    left: -100px;
    transform: translateX(100%);
  }  

</style>

<script>

import { RouterLink, RouterView } from 'vue-router'
import NavBarComponent from './components/nav-bar.vue';
import BestRatedMoviesComponent from './components/best-rated.vue';

export default {
  name:'App',
  components:{
    NavBarComponent,
    BestRatedMoviesComponent
  },
  data () {
    return  {

    }
  },
};

</script>


