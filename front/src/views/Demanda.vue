<template>
  <div class="container">
    <el-card class="my-5">
      <div slot="header" class="d-flex flex-row">
        <h1 class="h3 text-bold">
          {{ idDemand !== undefined ? "" : "Nova" }} Compra
        </h1>
        <router-link
          v-if="idDemand !== undefined"
          class="ml-auto btn btn-success"
          :to="{ name: 'Home' }"
          >Unirse á compra</router-link
        >
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
            <el-form-item label="Data límite" class="col-lg-6 col-12">
              <el-input type="date" name="date" v-model="form.date"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Provincia" class="col-lg-6 col-12">
              <el-select
                v-model="form.provincia"
                clearable
                placeholder="Select"
              >
                <el-option
                  v-for="item in provincias"
                  :key="item"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="Concello" class="col-lg-6 col-12">
              <el-select v-model="form.concello" clearable placeholder="Select">
                <el-option
                  v-for="item in concellos"
                  :key="item"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
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
          <el-collapse-item name="totais">
            <template #title>
              <h2 class="h5">Totais</h2>
            </template>
            <table class="table">
              <thead class="thead-light">
                <tr>
                  <th scope="col">Unidades</th>
                  <th scope="col">Prezo</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{{ totalUnits }}</td>
                  <td>€€€€€</td>
                </tr>
              </tbody>
            </table>
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
      provincias: ["A Coruña"],
      concellos: ["A Coruña", "Ferrol", "Santiago", "Carballo"],
    };
  },
  computed: {
    totalUnits() {
      return this.participants.reduce(
        (previousValue, participant) => previousValue + participant.units,
        0
      );
    },
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
