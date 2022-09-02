// window.onload = function(){
// 	console.log("login")
// }


/**
 * 显示login登录页面
 * 隐藏按钮，隐藏注册页面，单独显示登录页面
 */
function login_show(){
	var button = document.getElementsByClassName("button")[0];
	button.style.display = "none";
	var registered = document.getElementsByClassName("registered_page")[0];
	registered.style.display = "none";
	var login = document.getElementsByClassName("login_page")[0];
	login.style.display = "block";
}


/**
 * 显示注册页面
 * 隐藏button ， 隐藏登录页面，单独显示注册页面
 */
function registered_show(){
	var button = document.getElementsByClassName("button")[0];
	button.style.display = "none";
	var login = document.getElementsByClassName("login_page")[0];
	login.style.display = "none";
	var registered = document.getElementsByClassName("registered_page")[0];
	registered.style.display = "block";
	
}

/**
 * 返回页面
 * 隐藏登陆页面，隐藏注册页面，单独显示buttom页面
 */
function back(){
	var login = document.getElementsByClassName("login_page")[0];
	login.style.display = "none";
	var registered = document.getElementsByClassName("registered_page")[0];
	registered.style.display = "none";
	var button = document.getElementsByClassName("button")[0];
	button.style.display = "block";
}

/**
 * 图片文件选择器
 */
function choosefile(){
	var file = document.getElementById("file");
	file.click();
}