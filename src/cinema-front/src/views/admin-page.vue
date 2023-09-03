<template>
    <div class="admin-page">
      <main>
        <div>
          <NavBarComponent></NavBarComponent>
        </div>
      
      <div>
        <repertoireComponent></repertoireComponent>
      </div>
      
      <div>
        <MovieSearchComponent :user=true></MovieSearchComponent>
      </div>
    
      <div>
        <addMovieComponent></addMovieComponent>
      </div>

      
      <div class="spacer"></div>

      
      <div>
        <projectionTime></projectionTime>
      </div>

      
      <div class="spacer"></div>

      
  </main>
    <div>
        <logOutComponent></logOutComponent>
      </div>
    </div>
    <footer>
        <p>&copy; 2023 Andrijana Srejić. All rights reserved.</p>
      </footer>
  </template>
  
  <script>

import BestRatedMoviesComponent from '../components/best-rated.vue';
import MovieSearchComponent from '../components/film-search.vue';
import repertoireComponent from '../components/weekly-repertoire.vue';
import addMovieComponent from '../components/add-movie.vue';
import logOutComponent from '../components/log-out.vue';
import projectionTime from '../components/add-projection.vue';
import NavBarComponent from '../components/nav-bar.vue';
  export default {
    name:'adminPageVue',
    components: {
     BestRatedMoviesComponent,
     MovieSearchComponent,
     repertoireComponent,
     addMovieComponent,
     logOutComponent,
     projectionTime,
     NavBarComponent
    },
    data() {
      return {
          
      };
    },
       
  };
  </script>
  
<style scoped>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
}

.admin-page {
  background-color: #9a2323;
  color: #333;
  height: 130vh; /* Increase the height as needed */
  width: 70vw; /* Increase the width as needed */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.section {
  width: 100%;
  max-width: 800px;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.divider {
  border: none;
  border-top: 1px solid #ddd;
  margin: 20px 0;
}

.spacer {
  height: 20px;
}


button {
  padding: 10px 20px;
  background-color: red;
  color: #fff;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #d50000;
}

</style>