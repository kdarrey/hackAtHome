<template>
  <div class="guest-bg d-flex flex-column">
    <nav class="navbar navbar-dark bg-primary">
      <a class="navbar-brand logo-text" href="#">
        <!--<img src="/docs/4.5/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">-->
        eFeira!
      </a>
    </nav>
    <router-view></router-view>
    <div class="footer"></div>
  </div>
</template>
<style scoped>
.login-card {
  min-width: 300px;
}

.guest-bg {
  background-image: url("/img/potatoes-411975_1920.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 100vh;
}
</style>
<script>
export default {};
</script>
