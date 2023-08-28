<template>
    <div class="admin-page">
      <main>
    <div>
        <BestRatedMoviesComponent></BestRatedMoviesComponent>
    </div>
    <hr>
    <div>
        <repertoireComponent></repertoireComponent>
    </div>
    <hr>
    <div>
        <MovieSearchComponent :user=true></MovieSearchComponent>
    </div>
  <hr>
    <div>
      <addMovieComponent></addMovieComponent>
    </div>

    <hr>
    <div class="spacer"></div>

    <div>
        <logOutComponent></logOutComponent>
    </div>
  </main>
    
    
   
    </div>
  </template>
  
  <script>

import BestRatedMoviesComponent from '../components/best-rated.vue';
import MovieSearchComponent from '../components/film-search.vue';
import repertoireComponent from '../components/weekly-repertoire.vue';
import addMovieComponent from '../components/add-movie.vue';
import logOutComponent from '../components/log-out.vue';

  export default {
    name:'adminPageVue',
    components: {
     BestRatedMoviesComponent,
     MovieSearchComponent,
     repertoireComponent,
     addMovieComponent,
     logOutComponent
    },
    data() {
      return {
        weeklyRepertoire: [
          { id: 1, title: "Movie 1" },
          { id: 2, title: "Movie 2" },
          { id: 3, title: "Movie 3" }
        ],
        bestRatedMovies: [
          { id: 4, title: "Movie 4" },
          { id: 5, title: "Movie 5" },
          { id: 6, title: "Movie 6" }
        ],
        searchTerm: "",
        movies: [
          { id: 7, title: "Movie 7" },
          { id: 8, title: "Movie 8" },
          { id: 9, title: "Movie 9" }
        ]
      };
    },
    computed: {
      searchResults() {
        if (this.searchTerm) {
          const searchTermLowerCase = this.searchTerm.toLowerCase();
          return this.movies.filter(movie =>
            movie.title.toLowerCase().includes(searchTermLowerCase)
          );
        }
        return [];
      }
    }
  };
  </script>
  
  <style scoped>
  body {
    margin: 0;
    padding: 0;
  }
  
  .admin-page {
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
  </style>