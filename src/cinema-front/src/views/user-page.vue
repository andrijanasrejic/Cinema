<template>
    <main>
        <div>
            <NavBarComponent></NavBarComponent>
        </div>

        <div>
            <BestRatedMoviesComponent></BestRatedMoviesComponent>
        </div>
        <hr>
        <div>
            <repertoireComponent></repertoireComponent>
        </div>
        <hr>
        <div>
            <MovieSearchComponent :user=true></MovieSearchComponent>
        </div>
        <hr>
        <div class="spacer"></div>

        <div>
            <logOutComponent></logOutComponent>
        </div>
    </main>
    
    
</template>

<script>
    import BestRatedMoviesComponent from '../components/best-rated.vue';
    import MovieSearchComponent from '../components/film-search.vue';
    import repertoireComponent from '../components/weekly-repertoire.vue';
    import logOutComponent from '../components/log-out.vue';

    export default {
        name:'userPage',
        props: ['userName'], 
        components: {
            BestRatedMoviesComponent,
            MovieSearchComponent,
            repertoireComponent,
            logOutComponent
        }
    }

</script>