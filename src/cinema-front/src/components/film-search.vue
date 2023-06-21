<template>
    <h2>Movie Search</h2>
        <input type="text" v-model="searchTerm" placeholder="Search for a movie">
        <div class="spacer"></div>
        <button @click="fetchMovieByName">Search</button>
        <div v-if="showMovie">
            <form>
                <output>{{this.film.name}}</output>
                <div class="spacer"></div>
                <output>Overall rating: {{this.film.rating}}</output>
            </form>
            <button @click="clear">Clear</button>
        </div>
</template>

<script>
import axios from "axios";

export default {
    name:'MovieSearchComponent',
    components:{

    },
    data() {
        return {
            showMovie: false
        };
    },
    mounted() {
        this.fetchMovieByName();
    },
    methods: {
        fetchMovieByName() {
            this.showMovie = false;
            axios.get('http://127.0.0.1:8081/api/v1/films/' + this.searchTerm).then(response => {
                this.film = response.data;
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });

            this.showMovie = true;
        },
        clear(){
            this.showMovie = false;
            this.searchResults = "";
        }
    }
};

</script>