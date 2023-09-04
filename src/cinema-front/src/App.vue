<template>
  <header>
  </header>
   <div class="container"> 

    <body>
     
      <div>
    <router-view></router-view>
        
      </div>
    </body>
  </div>

  <img src="/src/assets/Stitch.jpg" class="stitch"/>

</template>

<style>
  hr {
    width:50%;
    text-align:left;
    margin-left:0;
  }
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

  body {
    margin: 0;
    padding: 0;
  }
  
  .first-page {
    background-color: #000;
    color: #fff;
    font-family: Arial, sans-serif;
    height: 160vh;
    width: 200vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 20px;
  }
  
  header {
    margin-bottom: 20px;
  }
  
  .nav-links li {
    display: inline-block;
    margin-right: 20px;
  }
  
  .nav-links a {
    color: #fff;
    text-decoration: none;
    font-size: 16px;
  }
  
  .logo img {
    width: 80px;
  }
  
  main {
    flex-grow: 1;
    margin-bottom: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  
  .section {
    margin-bottom: 20px;
    width: 100%;
    max-width: 800px;
    padding: 20px;
  }
  
  h2 {
    font-size: 24px;
    margin-bottom: 10px;
  }
  
  input[type="text"],
  input[type="password"] {
    padding: 10px;
    margin-bottom: 10px;
  }
  
  button {
    padding: 10px 20px;
    background-color: red;
    color: #fff;
    border: none;
    cursor: pointer;
  }
  
  footer {
    background-color: #141414;
    padding: 10px;
    text-align: center;
  }
  
  footer p {
    color: #fff;
    font-size: 14px;
  }

.stitch {
  width: 150px; 
  position: absolute;
  top: 10px; 
  left: 20px; 
  background-color: transparent;
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
    BestRatedMoviesComponent,
  },
  data () {
    return  {

    }
  },
};

</script>


