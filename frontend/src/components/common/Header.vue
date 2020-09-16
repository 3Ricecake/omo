<template>
  <div id="Header">
    <div id="menu">
      <router-link to="/">서비스 소개</router-link>
      <router-link to="/notice">공지사항</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainHeader",
};
</script>

<style scoped>
#menu {
  height: 20px;
  /* color: red; */
  z-index: 3;
  padding: 1% 0%;
  padding-right: 30px;
  /* background: red;  */
  text-align: right;
}
a {
  margin-left: 30px;
  color: white;
}
</style>
