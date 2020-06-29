<template>
  <div class="container">
    <el-card class="mt-5">
      <div slot="header">
        <h1 class="h3 text-bold">{{ idDemanda ? "Modificar" : "Nova"}} demanda</h1>
      </div>
      <div>
        <el-form :data="form">
          <div class="row">
            <el-form-item label="Nome" class="col-lg-6 col-12">
              <el-input name="name" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="Descripcion" class="col-lg-6 col-12">
              <el-input
                name="description"
                v-model="form.description"
              ></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Prezo máximo" class="col-lg-6 col-12">
              <el-input name="prize" v-model="form.prezo"></el-input>
            </el-form-item>
            <el-form-item
              label="Tipo unidade (kilos, unidade,...)"
              class="col-lg-6 col-12"
            >
              <el-input name="unit" v-model="form.unit"></el-input>
            </el-form-item>
          </div>

          <div class="row">
            <el-form-item label="Data máxima" class="col-lg-6 col-12">
              <el-input name="date" v-model="form.date"></el-input>
            </el-form-item>
          </div>

          <el-form-item>
            <el-button type="primary" @click="save" class="w-100"
              >Gardar</el-button
            >
          </el-form-item>
        </el-form>
        <el-collapse>
          <el-collapse-item name="oferta">
            <template #title>
              <h2 class="h5">Datos da oferta</h2>
            </template>
            <div>
              <dl class="d-flex flex-row flex-wrap">
                <div class="m-3">
                <dt>Categoría</dt>
                <dd>Alimentación</dd>
                </div>
                <div class="m-3">
                <dt>Nome</dt>
                <dd>Patacas</dd>
                </div>
              </dl>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
    </el-card>
  </div>
</template>
<script>
export default {
  name: "offer-page",
  props: {
    idDemanda: {
      type: Number,
      required: false
    }
  },
  data() {
    return {
      form: {
        name: "",
        description: "",
        prezo: "",
        unit: "",
        date: "",
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
