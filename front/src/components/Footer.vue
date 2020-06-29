<template>
  <div class="w-100 bg-primary d-flex">
    <a href="#" class="m-auto text-light" @click="showAbout"
      >Acerca de <span class="logo-text">eFeira!</span></a
    >
    <el-dialog :visible.sync="dialog.isVisible" width="30%" center>
      <about></about>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="hideAbout">Pechar</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import About from "@/views/About.vue";

export default {
  name: "footer",
  components: { About },
  data() {
    return {
      dialog: {
        isVisible: false,
      },
    };
  },
  methods: {
    showAbout() {
      this.dialog.isVisible = true;
    },
    hideAbout() {
      this.dialog.isVisible = false;
    },
  },
};
</script>
