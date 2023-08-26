<template>
    <div class="first-page">
      <header>
     </header>
  
      <main>
        
        <section class="section weekly-repertoire">
          <repertoireComponent></repertoireComponent>
        </section>
        <hr>
        <section class="section best-rated-movies">
          <div>
            <BestRatedMoviesComponent></BestRatedMoviesComponent>
          </div>
        </section>

        <hr>
        <section class="section movie-search">
          
          <MovieSearchComponent :user=false></MovieSearchComponent>
        </section>
        <hr>
       <section class="section login-form">
          <h2>Login</h2>
          <loginComponent></loginComponent>
        </section>
        <hr>
        <section class="section register-form">
          <h2>Register</h2>
          <registerComponent></registerComponent>
        </section>
      </main>
  
      
    </div>
  </template>
  
  <script>

  
  import BestRatedMoviesComponent from '../components/best-rated.vue';
  import MovieSearchComponent from '../components/film-search.vue';
  import repertoireComponent from '../components/weekly-repertoire.vue';
  import loginComponent from '../components/login.vue';
  import registerComponent from '../components/register.vue';

  export default {
    components:{
      BestRatedMoviesComponent,
      MovieSearchComponent,
      repertoireComponent,
      loginComponent,
      registerComponent
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
        ],
        loginData: {
          username: "",
          password: ""
        }
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
  </style>