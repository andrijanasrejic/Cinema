<template>
    <div>
      <h1>Projections for {{ userName }}</h1>
      <ul>
        <li v-for="(projection, index) in projections" :key="index">
          <div v-for="(value, key) in projection" :key="key">
            <strong>{{ key }}:</strong> {{ value }}
          </div>
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
    name: 'ticketPage',
    props: ['userName'],
    data() {
      return {
        projections: [],
      };
    },
    methods: {
        back(){
            this.$router.push(`/user-page/${this.userName}`);
        }
    },
    async mounted() {
      try {
        const response = await axios.get(`http://127.0.0.1:8081/user/projections/${this.userName}`);
        this.projections = response.data;
        console.log(response);
      } catch (error) {
        console.error('Error fetching projections:', error);
      }
    },
  };
  </script>
  