<template>
    
    <form @submit.prevent="register">
      <div>
        <input type="text" required="required" id="username" v-model="username" placeholder="User name">
      </div>
      <div>
        <input type="password" required="required" id="password" v-model="password" placeholder="Password">
      </div>
      <div>
        <input type="email" required="required" id="email" v-model="email" placeholder="Email adress">
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
            console.log('Registration successful:', response.data);
            alert('Registration successful');
        
            this.username = '';
            this.password = '';
            this.email = '';
        } catch (error) {
            console.error('Registration failed:', error);
      }

            }
}
}
</script>