import request from '../utils/axios'

//响应验证码
export function VerificationCode(){
	return request({
		method: "get",
		url: "graphic/VerificationCode"
	})
}

export function login(data){
	console.log(data);
}