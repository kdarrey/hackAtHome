import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const guestPages = {
  path: "/",
  component: () =>
    import(/* webpackChunkName: "templates" */ "@/templates/GuestTemplate.vue"),
  name: "Guest",
  children: [
    {
      path: "login",
      name: "Login",
      component: () =>
        import(/* webpackChunkName: "guest" */ "@/views/Login.vue"),
    },
    {
      path: "about",
      name: "About",
      component: () =>
        import(/* webpackChunkName: "guest" */ "@/views/About.vue"),
    },
    {
      path: "register",
      name: "Register",
      component: () =>
        import(/* webpackChunkName: "guest" */ "@/views/Register.vue"),
    },
  ],
};

const homePages = {
  path: "/home",
  component: () =>
    import(/* webpackChunkName: "templates" */ "@/templates/HomeTemplate.vue"),
  children: [
    {
      path: "",
      name: "Home",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Home.vue"),
    },
    {
      path: "/oferta",
      name: "OfferList",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/OfferList.vue"),
    },
    {
      path: "/compra",
      name: "DemandList",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/DemandList.vue"),
    },
    {
      path: "/oferta/nova",
      name: "NewOffer",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Oferta.vue"),
    },
    {
      path: "/oferta/:idOffer/ver",
      name: "ViewOffer",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Oferta.vue"),
    },
    {
      path: "/compra/nova",
      name: "NewDemand",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Demanda.vue"),
    },
    {
      path: "/compra/:idDemand/ver",
      name: "ViewDemand",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Demanda.vue"),
      props: true,
    },
  ],
};

const routes = [
  {
    path: "/",
    redirect: "/login",
  },
  guestPages,
  homePages,
];

const router = new VueRouter({
  routes,
});

export default router;
