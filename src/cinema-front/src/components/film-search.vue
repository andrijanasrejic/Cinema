<template>
    <h2>Movie Search</h2>
    <div class="input-container">
      <input type="text" v-model="searchTerm" placeholder="Search for a movie">
      <div class="spacer"></div>
      <button @click="fetchMovieByName">Search</button>
      <div v-if="showMovie">
        <form>
          <output>{{ film.name }}</output>
          <div class="spacer"></div>
          <output>Overall rating: {{ film.rating }}</output>
          <div class="spacer"></div>
          <output>Release year: {{ film.release_year }}</output>
          <div class="spacer"></div>
          <output>Content rating: {{ film.content_rating }}</output>
          <div class="spacer"></div>
          <template v-if="user">
            <label for="userRating">Your Rating:</label>
            <input type="number" v-model="userRating" min="1" max="5">

            <button @click.prevent="submitRating">Submit Rating</button>
         </template>
        </form>
        <button @click.prevent="clear">Clear</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    name: "MovieSearchComponent",
    props: ["user"],
    data() {
      return {
        showMovie: false,
        film: {},
        searchTerm: "", 
        userRating: 0
      };
    },
    methods: {
      fetchMovieByName() {
        this.showMovie = false;
        axios
          .get('http://127.0.0.1:8081/api/v1/films/' + this.searchTerm)
          .then((response) => {
            this.film = response.data;
          })
          .catch((error) => {
            console.log("Error when fetching movies:", error);
          });
  
        this.showMovie = true;
      },
      async submitRating() {
        if(this.film == {}){
          alert("Pick a movie!");
          return;
        }
        
        try {const response = await axios.put('http://127.0.0.1:8081/api/v1/films/updateFilm/'
         + this.film.name + '/' + this.userRating);
         console.log('Rated', response.data);
         alert("Rated");
      }catch(error){
        console.error("An error occurred:", error);

      }

      },
      clear() {
        this.showMovie = false;
        this.searchResults = "";
      },
    },
  };
  </script>
  