<template>
    <h2>Add a new projection</h2>

    <form @submit.prevent="uploadProjectionTime">
        <div>
            <time datetime="">Projection time:</time>
            <input type="text" required="required" id="projectionTime" v-model="projectionTime">
        </div>
       
        <button type="submit">Add projection time</button>
    </form>

</template>



<script>
import axios from 'axios';

export default {
    name: "projectionTime",
    methods: uploadProjectionTime(){

    },
    data: {
        projectionTime: null
    }
}


</script>