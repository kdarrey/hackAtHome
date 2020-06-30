<template>
  <div class="container">
    <el-card class="my-5">
      <div slot="header">
        <h1 class="h3 text-bold">
          {{ idOffer !== undefined ? "" : "Nova" }} Oferta
        </h1>
      </div>
      <div>
        <el-form :data="form">
          <div class="row">
            <el-form-item label="Nome" class="col-12">
              <el-input name="name" v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="Descrición" class="col-12">
              <el-input
                type="textarea"
                name="description"
                v-model="form.description"
              ></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Cantidade mínima" class="col-lg-6 col-12">
              <el-input name="minUnit" v-model="form.minUnit"></el-input>
            </el-form-item>
            <el-form-item
              label="Tipo unidade (kilos, unidade,...)"
              class="col-lg-6 col-12"
            >
              <el-input name="unit" v-model="form.unit"></el-input>
            </el-form-item>
          </div>
          <div class="row">
            <el-form-item label="Válida ata" class="col-lg-6 col-12">
              <el-input type="date" name="date" v-model="form.date"></el-input>
            </el-form-item>
            <el-form-item label="Modo de entrega" class="col-12">
              <el-input
                type="textarea"
                name="shippingDetails"
                v-model="form.shippingDetails"
              ></el-input>
            </el-form-item>

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
          <el-card class="shadow-none my-3">
            <div slot="header" class="d-flex">
              <strong>Prezos</strong>
              <el-button type="primary" @click="addPrice" class="ml-auto"
                >+</el-button
              >
            </div>
            <table class="table">
              <thead class="thead-light">
                <tr>
                  <th scope="col">Prezo unitario</th>
                  <th scope="col">Límite inferior (unidades)</th>
                  <th></th>
                </tr>
              </thead>
              <tbody v-if="form.prices.length < 1">
                <tr>
                  <td colspan="3">Non hai prezos definidos</td>
                </tr>
              </tbody>
              <tbody v-for="(price, index) in form.prices" :key="index">
                <tr>
                  <td>
                    <input type="text" v-model="form.prices[index].price" /> €
                  </td>
                  <td>
                    dende
                    <input type="text" v-model="form.prices[index].limit" />
                    unidades
                  </td>
                  <td>
                    <el-button type="danger" @click="removePrice(index)"
                      ><font-awesome-icon icon="trash"
                    /></el-button>
                  </td>
                </tr>
              </tbody>
            </table>
          </el-card>

          <el-form-item>
            <el-button type="primary" @click="save" class="w-100"
              >Gardar</el-button
            >
          </el-form-item>
        </el-form>
      </div>

      <el-card class="border-none" v-if="idOffer !== undefined">
        <div slot="header" class="d-flex">
          <strong>Compras activas sobre esta oferta</strong>
          <router-link
            class="btn btn-primary ml-auto"
            :to="{ name: 'NewDemand' }"
            >Crear compra</router-link
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
        unit: "",
        minUnit: "",
        concello: "",
        provincia: "",
        date: "",
        shippingDetails: "",
        prices: [],
      },
      buys: [],
      provincias: ["A Coruña"],
      concellos: ["A Coruña", "Ferrol", "Santiago", "Carballo"],
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
    addPrice() {
      let newPrices = this.form.prices.slice();
      newPrices.push({ price: "", limit: "" });
      this.form.prices = newPrices;
    },
    removePrice(index) {
      this.form.prices.splice(index, 1);
    },
  },
  created() {
    if(this.idOffer !== undefined) {
      this.generateRandomBuys();

      this.form.name =  "Patacas";
      this.form.description = "Bla bla";
      this.form.unit = "kg";
      this.form.minUnit = "100";
      this.form.concello = this.concellos[2];
      this.form.provincia = this.provincias[0];

      this.form.prices = [
        {
          price: "10",
          limit: "0"
        }
      ]
    }
  },
};
</script>
