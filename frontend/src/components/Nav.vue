<template>
  <div class="nav">
    <head>
      <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    </head>
    <router-link to="/main">
      <img class="logo" @click="goMain()" src="@/assets/icon.png" width="100px" />
    </router-link>

    <div class="menu">
      <button>
        <router-link to="/service">서비스 소개</router-link>
      </button>
      <button>
        <router-link to="/notice">공지사항</router-link>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goMain() {
      try {
        this.$router.push("Main");
      } catch (error) {
        // console.log("route same path!");
      }
    },
  },
};
</script>
<style scoped>
.nav {
  margin: 1% 7% 0 6.5%;
  display: flex;
  justify-content: space-between;
  justify-items: center;
  margin-bottom : 4%;
}
a:link {
  color: white;
  text-decoration: none;
}
a:visited {
  color: white;
  text-decoration: none;
}
a:hover {
  color: #ffffffbb;
  text-decoration: none;
}
img {
  padding-top: 25px;
  transform: scale(1);
  -webkit-transform: scale(1);
}
img:hover {
  transform: scale(1.1);
  -webkit-transform: scale(1.1);
}
.logo:hover,
button:hover {
  color: #ffffffbb;
}
.menu {
  display: flex;
  justify-content: space-between;
  justify-items: center;
}
button {
  background: none;
  outline: none;
  border: none;
  color: white;
  font-size: 15px;
}
* {
    font-family: 'Noto Sans KR', sans-serif;

}
</style>