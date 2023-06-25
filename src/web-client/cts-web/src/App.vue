<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import index from './views/index.vue'
export default {
  name: 'App',
  components: {
    index
  }
}
</script>

<style>
#app {

}
</style>
