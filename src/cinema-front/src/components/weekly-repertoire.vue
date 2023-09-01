<template>
    <h2>Weekly Repertoire</h2>
    <div class="list-container">
        <ul>
            <li v-for="film in films" @click="handleFilmClick(film)" class="film-item">
                {{ film.filmName }}
                <template v-if="logedIn">
                    <button @click="buyTicket(film)">
                        Buy ticket: {{ film.ticketPrice }}$
                    </button>
                </template>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: 'repertoireComponent',
    props: {logedIn: {
        default: 'false'
    }},
    components:{

    },
    data() {
        return {
            showMovies:false,
            weeklyRepertoire:{},
            films:[],
            selectedMovie:false
        };
    },
    methods: {
        fetchMoviesByWeek() {
            this.showMovies = false;
            axios.get('http://127.0.0.1:8081/api/v1/films/week').then(response => {
                this.films = response.data;
                console.log(this.films);
                window.console.log(this.films);
            })
            .catch(error => {
                console.log("Error when fetching projections:", error);
            });
            
            this.showMovies = true;
        },
        handleFilmClick(film){
            this.selectedMovie = !this.selectedMovie;
            console.log(this.logedIn);
            console.log(this.selectedMovie);

        },
        async buyTicket(film) {
            console.log(film);
            if(film.theaterSize == 0){
                alert("This projection is sold out");
                return;
            }
            film.theaterSize -= 1;
            const response = await axios.put("http://127.0.0.1:8081/api/v1/films/week/"
            + film.filmName + "/"
            + film.time + "/"
            + film.theaterSize);

            console.log(response);
        },
        clear(){
            this.showMovies = false;
            this.searchResults = "";
        },
    },
    mounted() {
        this.fetchMoviesByWeek();
    }
}
</script>