<template>
  <div class="container-fluid">
    <el-card class="shadow-none my-5">
      <div slot="header">
        <strong>Ofertas de compra</strong>
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
              <el-button type="primary" @click="search" class="ml-1"
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
                <router-link
                  :to="{ name: 'ViewOffer', params: { idOffer: item.id } }"
                  >{{ item.title }}</router-link
                >
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

<script>
export default {
  name: "offer-list",
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
  },
};
</script>
