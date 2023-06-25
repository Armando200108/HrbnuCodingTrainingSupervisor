<template>

  <div id="index">

    <!--    <el-container>-->
    <header id="header">
      <el-menu style="margin-left: 10%" id="menu" :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
               @select="handleSelect" router>
        <div class="logo">
          <img height="75
        .px" src="@/assets/logo.svg">
        </div>
        <el-menu-item class="header_menu_item" index="/problems" route="problems">题库</el-menu-item>
        <el-menu-item class="header_menu_item" index="2">比赛</el-menu-item>
        <el-submenu class="header_menu_item" index="1">
          <template slot="title" float="right">Armando</template>
          <el-menu-item index="2-1">用户中心</el-menu-item>
          <el-menu-item index="2-2">退出登录</el-menu-item>
        </el-submenu>

      </el-menu>

    </header>


    <el-main>
      <div class="main">
        <router-view/>

      </div>

    </el-main>

    <footer id="footer">
      <div class="footer_menu">
        <div class="footer_menu_group">
          <h4>CTS</h4>
          <div class="menu_item">题库</div>
          <div class="menu_item">比赛</div>
          <div class="menu_item">博客</div>
        </div>

        <div class="footer_menu_group">
          <h4>关于我们</h4>
          <div class="menu_item">SimRobot Studio</div>
          <div class="menu_item">加入我们</div>
        </div>
      </div>


      <el-divider></el-divider>
      <div class="footer_menu">
        <div class="footer_menu_group" style="color: #909399;">
          ©2020 - 2023 SimRobot Studio
        </div>

        <div class="footer_menu_group" style="color: #909399;">
          黑ICP备20000606号-1
        </div>
        <div class="footer_menu_group" style="color: #909399;">
          <img src="@/assets/img.png">
          黑公网安备 23030202000083号
        </div>
      </div>
    </footer>
    <!--    </el-container>-->

    <el-backtop></el-backtop>
  </div>
</template>

<script>
export default {
  name: "index",
  components: {},
  data() {
    return {
      activeIndex: '/problems',
      activeIndex2: '/problems'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }

}
</script>

<style scoped>
#footer {
  background-color: #f7fbfd;
  padding: 3vw 15vw;
  /*height: 200px;*/
}

h4 {
  color: #303133;
}

.footer_menu {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
}

.footer_menu_group {
  flex-grow: 1;
}

.footer_menu_group .menu_item {
  color: #606266;
  margin: 5px 0;
}

#menu {
  display: flex;
  justify-content: space-between;
}

.main {
  margin: 2vw 8vw;
}

.logo {
  display: flex;
  align-items: center;
  padding: 10px;
}

.logo img {

}

.logo span {
  font-size: 18px;
  margin-left: 10px;
}

</style>
