import axios from 'axios'
import { getToken } from '../utils/auth'

const http = axios.create({
  baseURL: '/api'
})

http.interceptors.request.use(config => {
  const token = getToken()
  if (token) config.headers.Authorization = `Bearer ${token}`
  return config
})

export default http
