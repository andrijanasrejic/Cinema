<template>
    <h2>Movie Search</h2>
        <input type="text" v-model="searchTerm" placeholder="Search for a movie">
        <ul>
            <li v-for="movie in searchResults" :key="movie.id">{{ movie.title }}</li>
        </ul>
</template>

<script>
import axios from "axios";

export default {
    name:'MovieSearchComponent',
    components:{

    },
    data() {
        return {
            movies:[]
        };
    },
    mounted() {
        this.fetchMoviesByName();
    },
    methods: {
        fetchMoviesByName() {
            axios.get('http://127.0.0.1:8081/api/v1/films/' + this.searchTerm).then(response => {
                this.films = response.data;
                
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });
        }
    }
};

</script>