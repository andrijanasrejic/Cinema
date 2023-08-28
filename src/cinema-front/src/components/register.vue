<template>
    
    <form @submit.prevent="register">
      <div>
        <label for="username">Username:</label>
        <input type="text" required="required" id="username" v-model="username">
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" required="required" id="password" v-model="password">
      </div>
      <div>
        <label for="email">   Email:</label>
        <input type="email" required="required" id="email" v-model="email">
      </div>
      <button type="submit">Register</button>
    </form>

    
</template>

<script>
import axios from "axios";


export default {
name:'registerComponent',
data() {
  return {
      username:"",
      password:"",
      email:""
  };
},
methods: {
    async register() {
            try {
                
            const response = await axios.post('http://localhost:8081/register' + '/' + this.username + '/' + this.password + '/' + this.email);
             // Handle success response
            console.log('Registration successful:', response.data);
            alert('Registration successful');
        
        // Reset form fields
            this.username = '';
            this.password = '';
            this.email = '';
        } catch (error) {
        // Handle error response
            console.error('Registration failed:', error);
      }

            }
}
}
</script>