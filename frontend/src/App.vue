<template>
  <dir id="App">
    <main-header />
    <div id="nav">
      <router-link to="/">Home</router-link>|
      <router-link to="/about">About</router-link>
    </div>
    <router-view id="container" />
  </dir>
</template>

<script>
import "./assets/css/style.scss";
import "./assets/css/main.scss";

import MainHeader from "./components/common/Header.vue";
import constants from "./lib/constants";
// import constants from "./lib/constants";
// import axios from "axios";

export default {
  name: "App",
  component: {
    "main-header": MainHeader,
  },
  data() {
    return {
      constants,
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
