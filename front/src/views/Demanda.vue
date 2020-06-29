<template>
  <div class="container">
    <el-card class="mt-5">
      <div slot="header" class="d-flex flex-row">
        <h1 class="h3 text-bold">
          {{ idDemand !== undefined ? "" : "Nova" }} Compra
        </h1>
        <el-button type="success" class="ml-auto">Unirse á compra</el-button>
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
        <el-collapse v-if="idDemand !== undefined">
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
                <div class="m-3">
                  <dt>Unidades</dt>
                  <dd>Kg</dd>
                </div>
                <div class="m-3">
                  <dt>Prezos</dt>
                  <dd>
                    <dl class="d-flex flex-row flex-wrap">
                      <div class="m-3">
                        <dt>Ata 10</dt>
                        <dd>1€</dd>
                      </div>
                      <div class="m-3">
                        <dt>Ata 50</dt>
                        <dd>0.90€</dd>
                      </div>
                      <div class="m-3">
                        <dt>Ata 100</dt>
                        <dd>0.80€</dd>
                      </div>
                      <div class="m-3">
                        <dt>Máis de 100</dt>
                        <dd>0.70€</dd>
                      </div>
                    </dl>
                  </dd>
                </div>
              </dl>
            </div>
          </el-collapse-item>
          <el-collapse-item name="participantes">
            <template #title>
              <h2 class="h5">Participantes na compra</h2>
            </template>
            <el-table
              class="table-responsive table-flush table-striped"
              header-row-class-name="thead-light"
              row-key="id"
              :data="participants"
              empty-text="Aínda non se adscribiu ninguén a esta compra"
            >
              <el-table-column
                label="Usuario"
                min-width="100px"
                prop="alias"
                sortable
              ></el-table-column>
              <el-table-column
                label="Cantidade"
                min-width="100px"
                prop="units"
                sortable
              ></el-table-column>
            </el-table>
          </el-collapse-item>
        </el-collapse>
      </div>
    </el-card>
  </div>
</template>
<script>
import MockUtils from "@/utils/MockUtils";

export default {
  name: "offer-page",
  props: {
    idDemand: {
      type: [Number, String],
      required: false,
    },
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
      participants: [],
    };
  },
  methods: {
    save() {
      this.$router.replace({ name: "Home" });
    },
    createMockParticipants() {
      let mockParticipants = [];
      let numberOfParticipants = MockUtils.getRandomInt(10) + 1;
      for (let i = 0; i < numberOfParticipants; i++) {
        mockParticipants.push({
          alias: "user_" + MockUtils.getRandomInt(1000),
          units: MockUtils.getRandomInt(100),
        });
      }
      this.participants = mockParticipants;
    },
  },
  created() {
    if (this.idDemand !== undefined) {
      this.createMockParticipants();
    }
  },
};
</script>
