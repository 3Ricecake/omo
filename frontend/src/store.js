import Vue from 'vue';
import Vuex from 'vuex';
import cookies from 'vue-cookie';
import constants from './lib/constants.js'
import router from './router/index.js'
import http from './http-common.js';
import authConnect from './auth-connector';
import * as Cookies from 'js-cookie'
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export const store = new Vuex.Store({

})