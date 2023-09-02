<template>
    <main>
        <div>
            <NavBarComponent :user=userName></NavBarComponent>
        </div>

        <div>
            <BestRatedMoviesComponent></BestRatedMoviesComponent>
        </div>
        <hr>
        <div>
            <repertoireComponent logedIn="true" @ticketBought="handleTransaction"></repertoireComponent>
        </div>
        <hr>
        <div>
            <MovieSearchComponent :user=true></MovieSearchComponent>
        </div>
        <hr>
        <div class="spacer"></div>

        <div>
            <logOutComponent></logOutComponent>
        </div>
    </main>
    
    
</template>

<script>
    import axios from 'axios';
    import BestRatedMoviesComponent from '../components/best-rated.vue';
    import MovieSearchComponent from '../components/film-search.vue';
    import repertoireComponent from '../components/weekly-repertoire.vue';
    import logOutComponent from '../components/log-out.vue';

    export default {
        name:'userPage',
        props: ['userName'],
        components: {
            BestRatedMoviesComponent,
            MovieSearchComponent,
            repertoireComponent,
            logOutComponent
        },
        methods : {
            async handleTransaction(film) {
                const response = await axios.put('http://localhost:8081/user/projection/'
            +   film.filmName + "/"
            +   film.time + "/"
            +   film.theaterSize + "/"
            +   film.ticketPrice);

                console.log(response);
            }
        }
    }

</script>