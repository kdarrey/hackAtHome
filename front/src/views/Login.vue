<template>
  <div class="m-auto">
    <h1 class="text-center p-5 logo-text logo-transparent-bg text-light">
      <strong>eFeira!</strong>
    </h1>
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
      <div>
        <div>
          <router-link :to="{ name: 'Register' }"
            >¿Aún no tienes usuario? ¡Regístrate!</router-link
          >
        </div>
      </div>
    </el-card>
  </div>
</template>
<style scoped>
.logo-transparent-bg {
  background-color: #00000066;
}
</style>
<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    authenticate() {
      this.$router.replace({ name: "Home" });
    },
  },
};
</script>
