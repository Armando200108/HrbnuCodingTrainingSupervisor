<template>
  <div id="problem">
    <header id="header">
      <el-menu style="margin-left: 10%" id="menu" :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
               @select="handleSelect" router>
        <el-menu-item class="header_menu_item" index="/"><img height="75
        .px" src="@/assets/logo.svg"></el-menu-item>
        <el-menu-item class="header_menu_item" index="/problems" route="problems">题库</el-menu-item>
        <el-menu-item class="header_menu_item" index="2">比赛</el-menu-item>

      </el-menu>
      <el-menu style="width: 15%;margin-right: 10%" id="menu" :default-active="activeIndex" class="el-menu-demo"
               mode="horizontal" @select="handleSelect">
        <el-submenu class="header_menu_item" index="1">
          <template slot="title">Armando</template>
          <el-menu-item index="2-1">用户中心</el-menu-item>
          <el-menu-item index="2-2">退出登录</el-menu-item>
        </el-submenu>
      </el-menu>
    </header>

    <!--    题目页-->
    <div class="problem-container">
      <div class="problem-info">
        <TextDisplay />
      </div>
      <div class="problem-editor">
        <CodeEdit class="editor" v-model="content" />
<!--        <a-button @click="getCode">获取代码</a-button>-->
      </div>
    </div>


  </div>
</template>

<script>
import CodeEdit from '@/components/CodeEdit.vue';
import TextDisplay from "@/components/TextDisplay.vue";

export default {
  name: "problem",
  components: {
    CodeEdit,
    TextDisplay
  },
  data() {
    return {
      content: '' // 代码块
    }
  },
  methods: {
    // 获取代码
    getCode() {
      console.log(this.content)
    }
  }
}
</script>

<style scoped>
header {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-between;
}

#menu {
  flex-grow: 1;
  width: 95%;
}

.problem-container {
  display: flex;
  height: calc(100vh - 61px);
  justify-content: space-between;
}

.problem-container .problem-info {
  width: 50%;
  flex-grow: 1;
  /*background-color: #42b983;*/
}

.problem-container .problem-editor {
  width: 50%;
  height: 100%;
  flex-grow: 1;
  /*background-color: antiquewhite;*/
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
.problem-editor .editor{
  flex-grow: 1;
}
</style>
