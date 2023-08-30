<template>
    <h2>Weekly Repertoire</h2>
    <div class="list-container">
        <ul>
            <li v-for="film in films" :key="film.id">{{ film.name }}</li>
        </ul>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: 'repertoireComponent',
    components:{

    },
    data() {
        return {
            showMovies:false,
            weeklyRepertoire:{},
            films:[]
        };
    },
    methods: {
        fetchMoviesByWeek() {
            this.showMovies = false;
            axios.get('http://127.0.0.1:8081/api/v1/films/week').then(response => {
                this.films = response.data;
                window.console.log(this.films);
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });
            
            this.showMovies = true;
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