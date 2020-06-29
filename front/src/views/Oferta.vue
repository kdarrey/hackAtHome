<template>
  <div class="container">
    <el-card class="mt-5">
      <div slot="header">
        <h1 class="h3 text-bold">
          {{ idOffer !== undefined ? "" : "Nova" }} Oferta
        </h1>
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
            <el-form-item label="Prezo" class="col-lg-6 col-12">
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
            <el-form-item label="Cantidade mínima" class="col-lg-6 col-12">
              <el-input name="minUnit" v-model="form.minUnit"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Localización" class="col-lg-6 col-12">
              <el-input name="location" v-model="form.location"></el-input>
            </el-form-item>
            <el-form-item label="Data máxima" class="col-lg-6 col-12">
              <el-input name="date" v-model="form.date"></el-input>
            </el-form-item>
            <el-form-item label="Modo de entrega" class="col-lg-6 col-12">
              <el-input name="mode" v-model="form.mode"></el-input>
            </el-form-item>
          </div>

          <el-form-item>
            <el-button type="primary" @click="save" class="w-100"
              >Gardar</el-button
            >
          </el-form-item>
        </el-form>
      </div>

      <el-card class="border-none" v-if="idOffer !== undefined">
        <div slot="header">
          <strong>Compras activas sobre esta oferta</strong>
        </div>
        <div class="d-flex flex-row flex-wrap">
          <div v-for="item in buys" :key="item.id">
            <el-card
              class="m-3"
              :body-style="{ padding: '0px', width: '300px' }"
            >
              <div
                class="offer-img"
                style="background-image:url(/img/potatoes-411975_1920.jpg)"
              ></div>
              <div class="p-3">
                <div>
                  <router-link
                    :to="{ name: 'ViewDemand', params: { idDemand: item.id } }"
                    >{{ item.title }}</router-link
                  >
                </div>
                <div>
                  <strong>Localidade:</strong> {{ item.owner.concello }} ({{
                    item.owner.provincia
                  }})
                </div>
                <div><strong>Finaliza en</strong> {{ item.daysLeft }} días</div>
              </div>
            </el-card>
          </div>
        </div>
      </el-card>
    </el-card>
  </div>
</template>
<script>
import MockUtils from "@/utils/MockUtils";

export default {
  name: "offer-page",
  props: {
    idOffer: {
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
        minunit: "",
        locatiom: "",
        date: "",
        mode: "",
      },
      buys: [],
    };
  },
  methods: {
    save() {
      this.$router.replace({ name: "Home" });
    },
    generateRandomBuys() {
      let numberOfResults = MockUtils.getRandomInt(10);
      let title = MockUtils.getMockProducts()[
        MockUtils.getRandomInt(MockUtils.getMockProducts().length)
      ];
      let randomResults = [];
      for (let i = 0; i < numberOfResults; i++) {
        randomResults.push({
          id: i,
          title: title,
          daysLeft: MockUtils.getRandomInt(30),
          owner: {
            alias: "usuario_" + MockUtils.getRandomInt(1000),
            provincia: "A Coruña",
            concello: "Santiago",
          },
        });
      }
      this.buys = randomResults;
    },
    getRandomInt(max) {
      return Math.floor(Math.random() * Math.floor(max));
    },
  },
  created() {
    this.generateRandomBuys();
  },
};
</script>
