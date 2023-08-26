<template>
    <main>
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
    </main>
    
    
</template>

<script>
    import BestRatedMoviesComponent from '../components/best-rated.vue';
    import MovieSearchComponent from '../components/film-search.vue';
    import repertoireComponent from '../components/weekly-repertoire.vue';

    export default {
        name:'userPage',
        props: ['userName'], 
        components: {
            BestRatedMoviesComponent,
            MovieSearchComponent,
            repertoireComponent
        }
    }

</script>