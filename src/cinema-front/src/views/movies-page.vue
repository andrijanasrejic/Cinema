<template>
    <div class="movies">

        <ul>
            <h1>Movies:</h1>

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

            </li>
            
        </ul>
    </div>


    <div class="spacer"></div>

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

<style scoped>
.movies {
  background-color: #9a2323;
  color: #333;
  height: 550vh;
  width: 70vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  overflow-y: auto;
}


h1 {
  font-size: 24px;
  color: #333;
}

.movie-list {
  list-style: none;
  padding: 0;
  margin: 20px 0;
}

.movie-item {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px 0;
  background-color: #f9f9f9;
}

strong {
  font-weight: bold;
}

.divider {
  border: none;
  border-top: 1px solid #ccc;
  margin: 10px 0;
}

.rating-form {
  margin-top: 10px;
}

.label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input[type="number"] {
  width: 50px;
  padding: 5px;
}

.rating-button {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
  font-size: 14px;
  border-radius: 5px;
  margin-top: 5px;
}

.rating-button:hover {
  background-color: #0056b3;
}

.button-container {
  text-align: center;
  margin-top: 20px;
}
</style>