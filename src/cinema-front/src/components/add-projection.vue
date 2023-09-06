<template>
    <h2>Add a new projection</h2>

    <form @submit.prevent="uploadProjectionTime"  class="projection-form">
        <div class="input-group">
            <input type="text" v-model="filmName" placeholder="Movie name" required="true">
        </div>
        <div class="input-group">
            <input type="text" v-model="theaterSize" placeholder="Theater size" required="true">
        </div>

        <div class="input-group">
            <input type="text" v-model="ticketPrice" placeholder="Ticket price" required="true">
        </div>

        <div class="input-group">
            <flat-pickr
                v-model="projectionTime"
                :config="flatpickrConfig"
                placeholder="Time"
            ></flat-pickr>
        </div>
       
        <button type="submit">Add projection time</button>
    </form>
</template>

<script>
import FlatPickr from "vue-flatpickr-component";
import "flatpickr/dist/flatpickr.css"; 
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
                dateFormat: "Y-m-d H:i", 
            },
        };
    },
    methods: { 
        async uploadProjectionTime() {
            
            const response = await axios.put('http://localhost:8081/api/v1/films/projection/'
            + this.filmName + "/"
            + this.projectionTime + "/"
            + this.theaterSize + "/"
            + this.ticketPrice);
        }
    }
}
</script>

<style scoped>
.projection-form {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.input-group {
  margin-bottom: 10px;
}

</style>






