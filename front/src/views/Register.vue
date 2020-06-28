<template>
  <div class="container">
    <el-card class="mt-5">
      <div slot="header">
        <h1 class="h3 text-bold">Formulario de rexistro</h1>
      </div>
      <div>
        <el-form :data="form">
          <div class="row">
            <el-form-item label="Nome" class="col-lg-6 col-12">
              <el-input name="name" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="Apelidos" class="col-lg-6 col-12">
              <el-input name="surname" v-model="form.surname"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="E-mail" class="col-lg-6 col-12">
              <el-input
                name="email"
                type="email"
                v-model="form.email"
              ></el-input>
            </el-form-item>
            <el-form-item label="DNI" class="col-lg-6 col-12">
              <el-input name="dni" v-model="form.dni"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Teléfono" class="col-lg-6 col-12">
              <el-input name="phone" v-model="form.phone"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="Dirección">
            <el-input name="address" v-model="form.address"></el-input>
          </el-form-item>
          <div class="row">
            <el-form-item
              label="Alias (nome visible dentro da plataforma)"
              class="col-lg-6 col-12"
            >
              <el-input name="alias" v-model="form.alias"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Contrasinal" class="col-lg-6 col-12">
              <el-input
                name="password"
                type="password"
                v-model="form.password"
              ></el-input>
            </el-form-item>
            <el-form-item label="Repita a contrasinal" class="col-lg-6 col-12">
              <el-input
                name="passwordAgain"
                type="password"
                v-model="form.passwordAgain"
              ></el-input>
            </el-form-item>
          </div>
          <el-form-item>
            <el-button type="primary" @click="save" class="w-100"
              >Enviar</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>
<script>
export default {
  name: "registration-page",
  data() {
    return {
      form: {
        name: "",
        surname: "",
        email: "",
        dni: "",
        phone: "",
        address: "",
        alias: "",
        password: "",
        passwordAgain: "",
      },
    };
  },
  methods: {
    save() {
      this.$router.replace({ name: "Home" });
    },
  },
};
</script>
