<template>
    <h2>Weekly Repertoire</h2>
        <input type="text" v-model="searchTerm" placeholder="Enter week">
        <div class="spacer"></div>
        <button @click="fetchMoviesByWeek">Search</button>
        <ul>
            <li v-for="movie in weeklyRepertoire" :key="movie.id">{{ movie.title }}</li>
        </ul>
</template>

<script>
import axios from "axios";

export default() {
    name: repertoireComponent,
    data() {
        return {
            showMovies = false;
            weeklyRepertoire:{}
        };
    },
    methods: {
        fetchMoviesByWeek() {
            this.showMovies = false;
            axios.get('http://127.0.0.1:8081/api/v1/films/week/' + this.searchTerm).then(response => {
                this.film = response.data;
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });

            this.showMovies = true;
        },
        clear(){
            this.showMovies = false;
            this.searchResults = "";
        }
    }
}
</script>