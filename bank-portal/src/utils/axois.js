import axios from "axios";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    // baseURL: process.env.VUE_APP_BASE_API,
    baseURL: 'http://api.bank.work/api/',
    // 超时
    timeout: 10000
})

export default service
