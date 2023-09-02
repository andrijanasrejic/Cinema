<template>
    <div>
        <h1>Movies:</h1>
        <ul>
            <li v-for="(movie, index) in movies" :key="index">
                <div v-for="(value, key) in movie" :key="key">
                    <template v-if="key == 'name' || key=='poster' || key =='rating'">
                        <strong>{{ key }}:</strong> {{ value }}
                    </template>
                </div>
            <template v-if="userName != 'undefined'">
                <form>
                <div class="spacer"></div>

                <label for="userRating">Your Rating:</label>
                <input type="number" v-model="inputRating" @placeholder="0" min="1" max="5">

                <button @click.prevent="submitRating(movie.name, inputRating)">Submit Rating</button>
                </form>
            </template>
            <hr />

            </li>
            
        </ul>
    </div>



    <div>
        <button @click="back">
            Back
        </button>
    </div>

</template>

<script>
import axios from 'axios';

export default {
    name: 'moviePage',
    props: ['userName'],
    data() {
        return {
            movies: []
                }
    },
    methods: {
        async submitRating(name, rating){
            try {
                const response = await axios.put('http://127.0.0.1:8081/api/v1/films/updateFilm/'
                + name + '/' + rating);
                console.log('Rated', response.data);
                alert("Rated");

            }catch(error){
                console.error("An error occurred:", error);
            }
        },
        back(){
            if(this.userName != 'undefined'){
                this.$router.push(`/user-page/${this.userName}`);
            } else {
                this.$router.push('/');
            }
        }
    },
    async mounted() {
        console.log(this.userName);
        try {
        const response = await axios.get('http://localhost:8081/api/v1/films');
        this.movies = response.data

  
        
      } catch (error) {
        console.error("An error occurred:", error);
      } 
    }

};
</script>