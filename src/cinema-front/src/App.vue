<template>
   <div class="container"> 
    <body>
      <div>
        <NavBarComponent></NavBarComponent>
      <div>
    <router-view></router-view>
    
      </div>
      </div>
    </body>
  </div>
</template>

<style>
  
  .container {
    max-height: 1000px;
    margin: 0 auto;
    padding: 20px;
    border-radius: 10px;
  }
  .input-list-container{
    max-height: 170px;
    overflow-y: auto;
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    box-sizing: border-box;
    border-radius: 5px;
    position: relative;
  }
  .input-container{
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    box-sizing: border-box;
    border-radius: 5px;
  }
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


