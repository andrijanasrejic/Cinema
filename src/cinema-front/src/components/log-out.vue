<template>
        <form @submit.prevent="logOut">
            <button type="submit">Log out</button>
        </form>
</template>


<script>
export default {
    name: 'logOutComponent',
    props: ['user'],
    methods: {
        logOut() {
            this.$router.push('/');
        }
    }
};
</script>