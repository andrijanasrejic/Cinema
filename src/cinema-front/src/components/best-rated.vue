<template>
    <h2>Best Rated Films</h2>
    <ul>
      <li v-for="film in films">{{ film.name }}</li>       
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
            films:[]
        };
    },
    mounted() {
        this.fetchMovies();
    },
    methods: {
        fetchMovies() {
            
            axios.get('http://127.0.0.1:8081/api/v1/films').then(response => {
                this.films = response.data.sort((f1,f2) => f1.overall_rating - f2.overall_rating);
                this.films = this.films.slice(0,3);
            })
            .catch(error => {
                console.log("Error when fetching movies:", error);
            });
        }
    }
};
</script>

