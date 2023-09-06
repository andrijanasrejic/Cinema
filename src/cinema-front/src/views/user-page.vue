<template>
    <main class="user-page">
        <div>
            <NavBarComponent :user=userName></NavBarComponent>
        </div>
        
        <div class="spacer"></div>

        <div class="best-rated-movies">
            <BestRatedMoviesComponent></BestRatedMoviesComponent>
        </div>

        <div class="spacer"></div>

        <div class="weekly-repertoire">
            <repertoireComponent logedIn="true" @ticketBought="handleTransaction"></repertoireComponent>
        </div>

        <div class="spacer"></div>

        <div class="movie-search">
            <MovieSearchComponent :user=true></MovieSearchComponent>
        </div>
        
        <div class="spacer"></div>

        <div>
            <logOutComponent></logOutComponent>
        </div>
    </main>
    
    <footer>
        <p>&copy; 2023 Andrijana Srejić. All rights reserved.</p>
    </footer>
    
</template>

<script>
    import axios from 'axios';
    import BestRatedMoviesComponent from '../components/best-rated.vue';
    import MovieSearchComponent from '../components/film-search.vue';
    import repertoireComponent from '../components/weekly-repertoire.vue';
    import logOutComponent from '../components/log-out.vue';
    import NavBarComponent from '../components/nav-bar.vue';
    export default {
        name:'userPage',
        props: ['userName'],
        components: {
            BestRatedMoviesComponent,
            MovieSearchComponent,
            repertoireComponent,
            logOutComponent,
            NavBarComponent
        },
        methods : {
            async handleTransaction(film) {
                const response = await axios.put('http://localhost:8081/user/projection/'
            +   this.userName + "/"
            +   film.filmName + "/"
            +   film.time + "/"
            +   film.theaterSize + "/"
            +   film.ticketPrice);

            }
        }
    }

</script>

<style>
.user-page {
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
  overflow-y: auto;
  }

  .best-rated-movies {
  margin-bottom: 20px;
}

.weekly-repertoire {
  margin-bottom: 20px;
}

.movie-search {
  margin-bottom: 20px;
}

.spacer {
  height: 20px;
}

</style>
  