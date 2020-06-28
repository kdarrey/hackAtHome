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
      path: "/offer/new",
      name: "NewOffer",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Oferta.vue"),
    },
    {
      path: "/offer/mock/view",
      name: "ViewOffer",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Oferta.vue"),
    },
    {
      path: "/demand/new",
      name: "NewDemand",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Demanda.vue"),
    },
    {
      path: "/demand/mock/view",
      name: "ViewDemand",
      component: () =>
        import(/* webpackChunkName: "home" */ "@/views/Demanda.vue"),
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
