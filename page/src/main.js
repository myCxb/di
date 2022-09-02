import Vue from 'vue'
import App from './App.vue'
// import api from './api'

import Jquery from '../jQuery/jquery-3.5.1/jquery-3.5.1/jquery-3.5.1.js'
import Bootstrap from '../bootstrap/bootstrap-3.4.1-dist/bootstrap-3.4.1-dist/css/bootstrap.css'
import BootstrapJs from '../bootstrap/bootstrap-3.4.1-dist/bootstrap-3.4.1-dist/js/bootstrap.js'


Vue.config.productionTip = false

// Vue.prototype.$api = api

new Vue({
  render: h => h(App)
}).$mount('#app')
