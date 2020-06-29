let products = ["patacas", "cebolas", "tomates", "pementos", "lechugas"];

const MockUtils = {
  getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
  },

  getMockProducts() {
    return products;
  },
};

export default MockUtils;