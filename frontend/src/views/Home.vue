<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->

    <div id="title">
      <h1>Only Mask On your face,</h1>
      <h1>OMO!</h1>
    </div>

    <br />
    <div id="subTitle">
      <h5>위험한 코로나 시대, 마스크를 벗지 않아도</h5>
      <h5>당신을 알아봐주는 자동 출입 명부 작성 서비스</h5>
    </div>

    <div class="loginForm">
      <form action="login" method="post">
        <input type="text" id="Username" />
        <input type="password" id="Password" />
      </form>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    // HelloWorld,
  },
};
</script>

<style scoped>
#title {
  text-align: left;
  padding: 5%;
}
#subTitle {
  text-align: left;
  padding: 5%;
}
</style>
