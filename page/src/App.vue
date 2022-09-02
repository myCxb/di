<template>
  <div id="app">
	<GameLogin></GameLogin>
  </div>
</template>

<script>
import GameLogin from './components/GameLogin.vue'


export default {
  name: 'app',
  components: {
    GameLogin
  }
}
</script>

<style>
window,
body{
	margin: 0px;
	padding: 0px;
}
	
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
