import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:81',
        changeOrigin: true,
      }
    }
  },
  resolve: {
    alias: {
      '@': resolve(__dirname, 'src') // 设置 '@' 映射到 'src' 目录
    }
  }

})
