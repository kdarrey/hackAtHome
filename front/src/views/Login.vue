<template>
  <div class="login-bg d-flex flex-column vh-100">
    <div class="m-auto">
      <h1 class="text-center"><strong>eFeira</strong></h1>
      <el-card class="login-card mt-5">
        <div class="text-center m-3">
          <font-awesome-icon icon="user-circle" size="6x" />
        </div>
        <el-form :model="form">
          <el-form-item>
            <el-input
              name="username"
              placeholder="Nombre de usuario"
              v-model="form.username"
            />
          </el-form-item>
          <el-form-item>
            <el-input
              name="password"
              placeholder="Contraseña"
              v-model="form.password"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="authenticate" class="w-100"
              >Acceder</el-button
            >
          </el-form-item>
        </el-form>
      </el-card>
    </div>
    <div class="footer"></div>
  </div>
</template>
<style scoped>
.login-card {
  min-width: 300px;
}

.login-bg {
  background-image: url("/img/potatoes-411975_1920.jpg");
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
<script>
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserCircle } from "@fortawesome/free-solid-svg-icons";

library.add(faUserCircle);

export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    authenticate() {
      this.$router.replace({ name: "Home" });
    }
  }
};
</script>
