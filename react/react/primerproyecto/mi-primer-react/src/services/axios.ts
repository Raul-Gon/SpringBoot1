import axios from "axios";


export const api = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com',
    timeout: 3000,
    headers: {
        'Content-Type': 'aplication/json'
    }
})

export const apiUsers = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com',
    timeout: 3000,
    headers: {
        'Content-Type': 'aplication/json'
    }
})

export const apiProducts = axios.create({
    baseURL: 'https://fakestoreapi.com/',
    timeout: 3000,
    headers: {
        'Content-Type': 'aplication/json'
    }
})