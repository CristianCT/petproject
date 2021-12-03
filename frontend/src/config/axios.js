import axios from 'axios';

const HOST_API = "http://localhost:4000"

const clienteAxios = axios.create({
    baseURL : HOST_API
});

export default clienteAxios;