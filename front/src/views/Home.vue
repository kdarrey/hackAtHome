<template>
  <div class="container">
    <el-card class="my-3">
      <!--
      <el-tabs type="border-card">
        <el-tab-pane>
          <span slot="label" class="h5">
            <font-awesome-icon icon="shopping-bag"/> Mercar
          </span>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label" class="h5">
            <font-awesome-icon icon="hand-holding-usd"/> Vender
          </span>
        </el-tab-pane>
      </el-tabs>
      -->

      <div class="jumbotron">
        <h1 class="display-4">Benvid@ á eFeira!</h1>
        <p class="lead">
          Aquí poderás ver demandas de compra, sumarte a elas, e facer ofertas
        </p>
        <hr class="my-4" />
        <p>
          Primeiro, empeza por buscar se hai algunha demanda de compra
          interesante.
        </p>
        <p>
          Se es <strong>vendedor</strong>, e atopas algunha interesante, entra e
          fai unha oferta.
        </p>
        <p>
          Se es <strong>comprador</strong> e deches cunha do teu interese, entra
          e únete. Se non, preme o botón de abaixo e
        </p>
        <el-button @click="newDemand" type="primary"
          >Crea unha nova demanda de compra</el-button
        >
      </div>

      <div>
        <el-form :data="form" @submit.native.prevent="search">
          <div class="d-flex flex-row flex-nowrap">
            <el-form-item class="flex-grow-1">
              <el-input
                name="query"
                placeholder="Introduce o texto a buscar nas demandas existentes"
                v-model="form.query"
              />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="search"
                ><font-awesome-icon icon="search"
              /></el-button>
            </el-form-item>
          </div>
        </el-form>
      </div>

      <div v-if="results.isVisible" class="d-flex flex-row flex-wrap">
        <div v-for="item in results.items" :key="item.id">
          <el-card class="m-3" :body-style="{ padding: '0px', width: '300px' }">
            <div
              class="offer-img"
              style="background-image:url(/img/potatoes-411975_1920.jpg)"
            ></div>
            <div class="p-3">
              <div>
                <router-link :to="{ name: 'ViewDemand' }">{{
                  item.title
                }}</router-link>
              </div>
              <div><strong>Creada por</strong> {{ item.owner.alias }}</div>
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
  </div>
</template>
<style scoped>
.offer-img {
  background-size: cover;
  height: 160px;
}
</style>
<script>
export default {
  name: "Home",
  data() {
    return {
      form: {
        query: "",
      },
      results: {
        isVisible: false,
        items: [],
      },
    };
  },
  methods: {
    search() {
      this.results.isVisible = true;
      this.generateRandomResults();
    },
    generateRandomResults() {
      let numberOfResults = this.getRandomInt(20);
      let randomResults = [];
      for (let i = 0; i < numberOfResults; i++) {
        randomResults.push({
          id: i,
          title: this.form.query || "patacas",
          daysLeft: this.getRandomInt(30),
          owner: {
            alias: "usuario_" + this.getRandomInt(1000),
            provincia: "A Coruña",
            concello: "Santiago",
          },
        });
      }
      this.results.items = randomResults;
    },
    getRandomInt(max) {
      return Math.floor(Math.random() * Math.floor(max));
    },
    newDemand() {
      this.$router.replace({ name: "NewDemand" });
    },
  },
};
</script>
