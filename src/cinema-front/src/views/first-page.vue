<template>
    <div class="first-page">
      <header>
        
     </header>
  
      <main>
        <div>
            <NavBarComponent></NavBarComponent>
        </div>
        
        <section class="section weekly-repertoire">
          <repertoireComponent ></repertoireComponent>
        </section>
        
        <section class="section best-rated-movies">
          <div>
            <BestRatedMoviesComponent></BestRatedMoviesComponent>
          </div>
        </section>

        
        <section class="section movie-search">
          
          <MovieSearchComponent :user=false></MovieSearchComponent>
        </section>
        
       <section class="section login-form">
          <h2>Login</h2>
          <loginComponent></loginComponent>
        </section>
        
        <section class="section register-form">
          <h2>Register</h2>
          <registerComponent></registerComponent>
        </section>
      </main>    
    </div>
    <footer>
        <p>&copy; 2023 Andrijana Srejić. All rights reserved.</p>
      </footer>
  </template>
  
  <script>

  
  import BestRatedMoviesComponent from '../components/best-rated.vue';
  import MovieSearchComponent from '../components/film-search.vue';
  import repertoireComponent from '../components/weekly-repertoire.vue';
  import loginComponent from '../components/login.vue';
  import registerComponent from '../components/register.vue';
  import NavBarComponent from '../components/nav-bar.vue';
  export default {
    components:{
      BestRatedMoviesComponent,
      MovieSearchComponent,
      repertoireComponent,
      loginComponent,
      registerComponent,
      NavBarComponent
    },
    data() {
      return {
      
      };
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
    height: 190vh;
    width: 120vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    overflow-y: auto;
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
 
  </style>