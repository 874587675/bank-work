<script>
export default {
  name: "MainView",
  data() {
    return {
      activeIndex: '1',
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  },

}
</script>

<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
      <el-menu-item index="/main/user">用户模块</el-menu-item>
      <el-menu-item index="/main/deposit">存款模块</el-menu-item>
      <el-menu-item index="/main/transfer">转账模块</el-menu-item>
    </el-menu>
    <router-view></router-view>
  </div>
</template>

<style scoped lang="less">

</style>
