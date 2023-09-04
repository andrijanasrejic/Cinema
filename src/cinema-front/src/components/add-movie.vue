<template>
    <h2>Add a new movie</h2>

    <form @submit.prevent="uploadMovieData">
        <div>
            <input type="text" required="required" id="filmName" v-model="filmName" placeholder="Name">
        </div>
        <div>
            <input type="text" required="required" id="releaseYear" v-model="releaseYear" placeholder="Year">
        </div>
        <div>
            <input type="text" required="required" id="contentRating" v-model="contentRating" placeholder="Content rating">
        </div>
       
        <button type="submit">Add movie</button>
    </form>

</template>

<script>
import axios from "axios";

export default {
    name: 'addMovieComponent',
    data() {
        return {
            filmName:"",
            releaseYear:"",
            contentRating:"",
        };
    },
    methods: {
        async uploadMovieData() {
          
            try {
                console.log(this.filmName)
                const response = await axios.post(
                    "http://localhost:8081/api/v1/films/upload/" 
                    + this.filmName + "/"
                    + this.releaseYear + "/"
                    + this.contentRating
                ); 


            }catch(error){
                console.error("An error occurred:", error);
            }
        }
    }
}
</script>