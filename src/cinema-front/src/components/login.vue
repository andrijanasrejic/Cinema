<template>
    
    <form @submit.prevent="login">
            <div>
              <label for="username">Username:</label>
              <input type="text" required="required" id="username" v-model="username">
            </div>
            <div>
              <label for="password">Password:</label>
              <input type="password" required="required" id="password" v-model="password">
            </div>
            <button type="submit">Log in</button>
          </form>

          
</template>

<script>
import axios from "axios";

export default {
    name:'loginComponent',
    data() {
        return {
            username:"",
            password:""
        };
    },
    methods: {
     
      login() {
      try {
        const response = axios.get('http://localhost:8081/login/' + this.username + '/' + this.password);

        console.log('Login successful:', response.data);
        alert('Login successful');
       
        this.$router.push(`/user-page/${this.username}`);

      } catch (error) {
        console.error("An error occurred:", error);
      }
    }
      
    }
}
</script>