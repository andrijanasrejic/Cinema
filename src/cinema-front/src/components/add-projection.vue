<template>
    <h2>Add a new projection</h2>

    <form @submit.prevent="uploadProjectionTime">
        <input type="text" v-model="filmName" placeholder="Movie name" required="true">
        <div>
            <input type="text" v-model="theaterSize" placeholder="Theater size" required="true">
        </div>

        <div>
            <input type="text" v-model="ticketPrice" placeholder="Ticket price" required="true">
        </div>

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
            filmName: null,
            theaterSize: null,
            ticketPrice: null,
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

            const projection = {
                "filmName": this.filmName,
                "projectionTime": this.projectionTime,
                "theaterSize": this.theaterSize,
                "ticketPrice": this.ticketPrice
            }
            

            const response = await axios.put('http://localhost:8081/api/v1/films/projection/'
            + this.filmName + "/"
            + this.projectionTime + "/"
            + this.theaterSize + "/"
            + this.ticketPrice);
        }
    }
}
</script>
c