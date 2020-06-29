<template>
  <div class="home-bg">
    <div class="home-bg-transparency d-flex flex-column">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand logo-text" href="#">
          <!--<img src="/docs/4.5/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">-->
          eFeira!
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav w-100">
            <li class="nav-item active">
              <a class="nav-link" href="#"
                >Home <span class="sr-only">(current)</span></a
              >
            </li>
            <li class="nav-item dropdown ml-auto">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdown"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
                ><font-awesome-icon icon="user-circle" size="x2"
              /></a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Sair</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      <router-view></router-view>
      <div class="footer mt-auto"><Footer></Footer></div>
    </div>
  </div>
</template>
<style scoped>
.login-card {
  min-width: 300px;
}

.home-bg {
  background-image: url("/img/potatoes-411975_1920.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 100vh;
}

.home-bg-transparency {
  background-color: #ffffffbb;
  min-height: 100vh;
}
</style>
<script>
import Footer from "@/components/Footer.vue";

export default {
  components: { Footer },
};
</script>
