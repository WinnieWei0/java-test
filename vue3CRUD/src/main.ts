import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import Axios from 'axios'

const app = createApp(App)

app.use(ElementPlus)
app.config.globalProperties.$axios=Axios

app.mount('#app')
