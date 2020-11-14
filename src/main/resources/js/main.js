import Vue from 'vue'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import './api/resource'
import router from './router/router'
import App from './pages/App.vue'
import store from './store/store'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'
import * as Sentry from '@sentry/browser'
import {Vue as VueIntegration} from '@sentry/integrations'
import {Integrations} from '@sentry/tracing'

Sentry.init({
    dsn: "https://54b541e1dd1e446c9ff55fb9b205438a@o475747.ingest.sentry.io/5514132",
    integrations: [
        new VueIntegration({
            Vue,
            tracing: true,
        }),
        new Integrations.BrowserTracing(),
    ],
    tracesSampleRate: 1.0,
})

Sentry.configureScope(scope =>
    scope.setUser({
        id: profile && profile.id,
        username: profile && profile.name
    })
)

if (profile) {
    connect()
}

Vue.use(Vuetify)

new Vue({
    el: '#app',
    store,
    router,
    vuetify: new Vuetify(),
    render: a => a(App)
})