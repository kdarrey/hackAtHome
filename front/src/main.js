import Vue from "vue";
import App from "./App.vue";
import router from "./router";

import "bootstrap/dist/css/bootstrap.css";
import "element-ui/lib/theme-chalk/index.css";

import { extend } from "vee-validate";
import * as rules from "vee-validate/dist/rules";
import { messages } from "vee-validate/dist/locale/es.json";

import { ValidationProvider, ValidationObserver } from "vee-validate";
import ElementUI from "element-ui";
import { Input, Tooltip, Popover } from "element-ui";

import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserCircle, faShoppingBag, faHandHoldingUsd, faSearch } from "@fortawesome/free-solid-svg-icons";

Object.keys(rules).forEach(rule => {
  extend(rule, {
    ...rules[rule], // copies rule configuration
    message: messages[rule] // assign message
  });
});

Vue.component("validation-provider", ValidationProvider);
Vue.component("validation-observer", ValidationObserver);
Vue.component(Input.name, Input);
Vue.component("font-awesome-icon", FontAwesomeIcon);

Vue.use(ElementUI);
Vue.use(Tooltip);
Vue.use(Popover);


library.add(faUserCircle, faShoppingBag, faHandHoldingUsd, faSearch);


Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
