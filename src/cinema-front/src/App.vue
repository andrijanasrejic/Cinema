<template>
    <div>
      <NavBarComponent></NavBarComponent>
    </div>
    <body>
    <router-view></router-view>
    </body>
</template>

<style>
  #app {
    position: relative;
    text-align: center;
  }

  NavBarComponent {
    position: absolute;
    z-index: 999;
    top: 20px;
    left: 100000px;
    transform: translateX(100%);
  }  

</style>

<script>

import { RouterLink, RouterView } from 'vue-router'
import NavBarComponent from './components/nav-bar.vue';

export default {
  name:'App',
  components:{
    NavBarComponent,
  },
  data () {
    return  {

    }
  },
};

</script>


