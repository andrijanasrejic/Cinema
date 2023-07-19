<template>
    
          <form>
            <div>
              <label for="username">Username:</label>
              <input type="text" id="username" v-model="username">
            </div>
            <div>
              <label for="password">Password:</label>
              <input type="password" id="password" v-model="password">
            </div>
            <button type="submit" @click="Login">Log in</button>
          </form>
        
</template>

<script>
export default {
    name:'loginComponent',
    data() {
        return {
            username:"",
            password:""
        };
    },
    methods: {
            Login(){
                console.log("Trying to login");
        }   
    }
}
</script>