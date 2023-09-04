<template>
  <div class="ticket-page">
    <h1>Projections for {{ userName }}:</h1>
    <ul class="projection-list">
      <li v-for="(projection, index) in projections" :key="index" class="projection-item">
        <div v-for="(value, key) in projection" :key="key">
          <template v-if="key == 'theaterSize'">
            <strong class="key">
              ticketNumber:
            </strong> {{ value }}
          </template>
          <template v-else>
            <strong class="key">{{ key }}:</strong> {{ value }}
          </template>
        </div>
      </li>
    </ul>
  </div>

  <div class="button-container">
    <button @click="back" class="back-button">Back</button>
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

<style scoped>
.ticket-page {
  background-color: #9a2323;
  color: #333;
  height: 130vh; /* Increase the height as needed */
  width: 70vw; /* Increase the width as needed */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  overflow-y: auto;
}



.projection-list {
  list-style: none;
  padding: 0;
  margin: 20px 0;
}

.projection-item {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px 0;
  background-color: #f9f9f9;
}

.key {
  font-weight: bold;
}




.button-container {
  text-align: center;
  margin-top: 20px;
}

.back-button {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 16px;
  border-radius: 5px;
}

.back-button:hover {
  background-color: #0056b3;
}
</style>
  