import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const guestPages = {
  path: "/",
  component: () => import(/* webpackChunkName: "templates" */ "@/templates/GuestTemplate.vue"),
  name: "Guest",
  children: [
    {
      path: "login",
      name: "Login",
      component: () =>
        import(/* webpackChunkName: "guest" */ "@/views/Login.vue")
    },
    {
      path: "about",
      name: "About",
      component: () => import(/* webpackChunkName: "guest" */ "@/views/About.vue")
    },
    {
      path: "register",
      name: "Register",
      component: () => import(/* webpackChunkName: "guest" */ "@/views/Register.vue")
    },
  ] 
};

const homePages = {
  path: "/home",
  component: () => import(/* webpackChunkName: "templates" */ "@/templates/HomeTemplate.vue"),
  name: "Home",
  children: [
    {
      path: "",
      name: "Home Root",
      component: () => import(/* webpackChunkName: "home" */ "@/views/Home.vue")
    }
  ]
}

const routes = [
  {
    path: "/",
    redirect: "/login"
  },
  guestPages,
  offerPages,
  {
    path: "/offer",
    name: "Offer",
    component: () => import(/* webpackChunkName: "home" */ "@/views/Offer.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
