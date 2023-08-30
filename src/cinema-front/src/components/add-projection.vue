<template>
    <h2>Add a new projection</h2>

    <form @submit.prevent="uploadProjectionTime">
        <input type="text" v-model="searchTerm" placeholder="Search for a movie">
        <div>
            <label for="projectionTime">Projection time:</label>
            <flat-pickr
                v-model="projectionTime"
                :config="flatpickrConfig"
            ></flat-pickr>
        </div>
       
        <button type="submit">Add projection time</button>
    </form>
</template>

<script>
import FlatPickr from "vue-flatpickr-component";
import "flatpickr/dist/flatpickr.css"; // Import the Flatpickr CSS
import axios from 'axios';

export default {
    name: "projectionTime",
    components: {
        FlatPickr
    },
    data() {
        return {
            projectionTime: null,
            searchTerm: null,
            flatpickrConfig: {
                enableTime: true,
                dateFormat: "Y-m-d H:i", // Adjust the format as needed
            },
        };
    },
    methods: { 
        async uploadProjectionTime() {
            console.log("Film:", this.searchTerm);
            console.log("Projection time:", this.projectionTime);

            const response = await axios.put('http://localhost:8081/api/v1/films/projection/' + this.searchTerm + "/" + this.projectionTime);
        }
    }
}
</script>
c