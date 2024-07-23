// src/axios.js
import axios from 'axios';

const instance = axios.create({
  baseURL: 'https://your-api-base-url.com', // 替换为你的API基本URL
  timeout: 1000, // 设置请求超时时间
  headers: { 'Content-Type': 'application/json' } // 设置默认的请求头
});

// 可以在这里添加请求拦截器和响应拦截器
instance.interceptors.request.use(
  config => {
    // 在发送请求之前做些什么
    return config;
  },
  error => {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);

instance.interceptors.response.use(
  response => {
    // 对响应数据做点什么
    return response;
  },
  error => {
    // 对响应错误做点什么
    return Promise.reject(error);
  }
);

export default instance;
