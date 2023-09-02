<template>
    <nav class="nav-bar">      
      <ul class="nav-list">
        <li class="nav-item">
          <span @click="moviePage" class="nav-link">Movies</span>
        </li>
        <li class="nav-item">
          <span @click="ticketPage" class="nav-link">Tickets</span>
        </li>
      </ul>
    </nav>
</template>


<script>

export default {
        name: 'NavBarComponent',
        components:{

        },
        data (){
            return  {

            }
        },
        methods: {
          ticketPage(){
              const userName = this.$router.currentRoute._value.params.userName
              if(!userName){
                alert("Log in for this feature");
                return;
              }

              this.$router.push(`/tickets/${userName}`);
          },
          moviePage(){
            const userName = this.$router.currentRoute._value.params.userName
            this.$router.push(`/movies/${userName}`);

          }
        },
        mounted() {
          console.log(this.user);
        }
    }

</script>


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

