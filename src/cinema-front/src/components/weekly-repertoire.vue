<template>
    <h2>Weekly Repertoire</h2>
    <div class="input-list-container">
        <input type="text" v-model="searchTerm" placeholder="Enter week">
        <div class="spacer"></div>
        <button @click="fetchMoviesByWeek">Search</button>
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
            axios.get('http://127.0.0.1:8081/api/v1/films/week/' + this.searchTerm).then(response => {
                this.films = response.data;
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