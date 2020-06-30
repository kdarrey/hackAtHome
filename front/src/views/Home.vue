<template>
  <div class="container-fluid">
    <el-card class="my-3">
      <div class="jumbotron">
        <h1 class="display-4">Benvid@ á eFeira!</h1>
        <p class="lead">
          Aquí poderás ver demandas de compra, sumarte a elas, e facer ofertas
        </p>
        <hr class="my-4" />
        <p>
          Se es <strong>vendedor</strong>, crea ofertas de produtos para vender
        </p>
        <p>
          Se es <strong>comprador</strong> busca ofertas e crea compras en
          grupo, ou adhírete a algunha en curso
        </p>
      </div>

      <el-card class="shadow-none m-3">
        <div slot="header" class="d-flex flex-row">
          <strong>As miñas ofertas</strong>
          <router-link
            :to="{ name: 'NewOffer' }"
            class="ml-auto btn btn-primary"
            >Nova oferta</router-link
          >
        </div>
        <div class="d-flex flex-row flex-wrap">
          <div v-for="item in offers" :key="item.id">
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
                    :to="{ name: 'ViewOffer', params: { idOffer: item.id } }"
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

      <el-card class="shadow-none m-3">
        <div slot="header" class="d-flex flex-row">
          <strong>Compras en grupo activas que organicei eu</strong>
          <router-link
            :to="{ name: 'Home' }"
            class="ml-auto btn btn-primary"
            >Ver historial</router-link
          >
        </div>
        <div class="d-flex flex-row flex-wrap">
          <div v-for="item in demands" :key="item.id">
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

      <el-card class="shadow-none m-3">
        <div slot="header" class="d-flex flex-row">
          <strong>Compras en grupo activas nas que participo</strong>
          <router-link :to="{ name: 'Home' }" class="ml-auto btn btn-primary"
            >Ver historial</router-link
          >
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
    </el-card>
  </div>
</template>
<style scoped></style>
<script>
import MockUtils from "@/utils/MockUtils";

export default {
  name: "Home",
  data() {
    return {
      offers: [],
      buys: [],
      demands: [],
    };
  },
  methods: {
    generateRandomOffers() {
      let numberOfResults = MockUtils.getRandomInt(5) + 1;
      let randomResults = [];
      for (let i = 0; i < numberOfResults; i++) {
        randomResults.push({
          id: i,
          title: MockUtils.getMockProducts()[
            MockUtils.getRandomInt(MockUtils.getMockProducts().length)
          ],
          daysLeft: MockUtils.getRandomInt(30),
          owner: {
            alias: "usuario_" + MockUtils.getRandomInt(1000),
            provincia: "A Coruña",
            concello: "Santiago",
          },
        });
      }
      this.offers = randomResults;
    },
    generateRandomDemands() {
      let numberOfResults = MockUtils.getRandomInt(2) + 1;
      let randomResults = [];
      for (let i = 0; i < numberOfResults; i++) {
        randomResults.push({
          id: i,
          title: MockUtils.getMockProducts()[
            MockUtils.getRandomInt(MockUtils.getMockProducts().length)
          ],
          daysLeft: MockUtils.getRandomInt(30),
          owner: {
            alias: "usuario_" + MockUtils.getRandomInt(1000),
            provincia: "A Coruña",
            concello: "Santiago",
          },
        });
      }
      this.demands = randomResults;
    },
    generateRandomBuys() {
      let numberOfResults = MockUtils.getRandomInt(5) + 1;
      let randomResults = [];
      for (let i = 0; i < numberOfResults; i++) {
        randomResults.push({
          id: i,
          title: MockUtils.getMockProducts()[
            MockUtils.getRandomInt(MockUtils.getMockProducts().length)
          ],
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
  },
  created() {
    this.generateRandomOffers();
    this.generateRandomDemands();
    this.generateRandomBuys();
  },
};
</script>
