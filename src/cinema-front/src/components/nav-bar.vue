<template>
    <nav class="nav-bar">      
      <ul class="nav-list">
        <li class="nav-item">
          <router-link to="/movies" class="nav-link">Movies</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/cinemas" class="nav-link">Cinemas</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/tickets" class="nav-link">Tickets</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/accounts" class="nav-link">Accounts</router-link>
        </li>
        
      </ul>
    </nav>
      </template>


<style scoped>
.navbar {
    background-color: #000;
    color: #fff;
}
.nav-list {
  display: flex;
  list-style: none;
  padding: 0;
  
}


.nav-link {
  text-decoration: none;
  color: #fff;
  padding: 10px;
}

.nav-link:hover {
  cursor: pointer;
  background-color: #555;
}
</style>

<script>

export default {
        name: 'NavBarComponent',
        components:{

        },
        data (){
            return  {

            }
        },
    }

</script>
