<template>
    <h2>Best Rated Movies</h2>
    <ul>
      <li v-for="movie in movies" :key="movie.name">{{ movie.name }}</li>
    </ul>
</template>

<script>
import axios from "axios";

export default {
    name:'BestRatedMoviesComponent',
    components:{

    },
    data() {
        return {
            movies:[]
        };
    },
    mounted() {
        this.fetchMovies();
    },
    methods: {
        fetchMovies() {
            console.log("Mrk");
            axios.get('http://127.0.0.1:8081/api/v1/filmovi').then(response => {
                //this.movies = response.data;
                console.log(response.data);
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });
        }
    }
};
</script>

