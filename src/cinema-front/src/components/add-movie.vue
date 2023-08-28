<template>
    <h2>Add a new movie</h2>

    <form @submit.prevent="uploadMovieData">
        <div>
            <label for="filmName">Name:</label>
            <input type="text" required="required" id="filmName" v-model="filmName">
        </div>
        <!--<div>
            <label for="image">Poster:</label>
           <input type="file" required="required" @change="handleImageChange">
        </div>-->
        <button type="submit">Add movie</button>
    </form>

    <div v-if="image">
        <h3>Selected Poster:</h3>
        <img :src="image">
    </div>

</template>

<script>
import axios from "axios";

export default {
    name: 'addMovieComponent',
    data() {
        return {
            filmName:"",
            image: null,
            showPoster:false,
            maxWidth: 360,
            maxHeight: 510,
            formData:null
        };
    },
    methods: {
        async uploadMovieData() {
          
         
            
           
            try {
                console.log(this.filmName)
                const response = await axios.post(
                    "http://localhost:8081/api/v1/films/upload/" + this.filmName
                ); 


            }catch(error){
                console.error("An error occurred:", error);
            }
        },
        handleImageChange(event) {
       
         this.image = URL.createObjectURL(event.target.files[0]);
         
        }
    }
}
</script>