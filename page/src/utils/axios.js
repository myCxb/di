import axios from "axios";

const request = axios.create({
	baseURL: "http://127.0.0.1:8081/",
	timeout: 1000,
	headers: {'X-Custom-Header': 'foobar'}
})


export default request
