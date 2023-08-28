<template>
        <form @submit.prevent="logOut">
            <button type="submit">Log out</button>
        </form>
</template>


<script>
export default {
    name: 'logOutComponent',
    methods: {
        logOut() {
            this.$router.push('/');
        }
    }
};
</script>