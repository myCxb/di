<template>
	<div id="login">

		<div class="back">
			<div class="back_left"></div>
			<div class="back_right"></div>
		</div>
		<div class="button">
			<div class="button_login" v-on:click="login_show()">登录</div>
			<div class="button_registered" v-on:click="registered_show()">注册</div>
		</div>

		<div class="login_page">
			<div class="login">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">账号：</label>
						<input type="text" class="form-control" id="login_account" placeholder="Account" v-model="user.name">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">密码：</label>
						<input type="password" class="form-control" id="login_password" placeholder="Password" v-model="user.password">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1" class="exampleInputPassword1">验证码：</label>
						<div>
							<input type="text" class="form-control" id="long_verification_code" placeholder="验证码" v-model="user.Vcode">
							<img id="long_verification_code_img" :src="captchaSrc" alt="验证码" v-on:click="code()" />
						</div>
					</div>
					<br />
					<br />
					<div class="checkbox">
						<label>
							<input type="checkbox" v-model="user.Rememb"> 记住密码
						</label>
					</div>
					<div class="util_btn">
						<button type="button" class="bte bte_the" v-on:click="login()">确定</button>
						<button type="button" class="bte" v-on:click="back()">返回</button>
					</div>
					<br />
				</form>
			</div>
		</div>

		<div class="registered_page">
			<div class="registered">
				<form>
					<div>
						<div style="text-align: center;">
							<div>
								<img src="img/default.jpg" class="default">
							</div>
							<div class="add" v-on:click="choosefile()">
								<input type="file" style="display: none;" id="file"
									accept="image/x-png,image/gif,image/jpeg,image/bmp" />
								<div class="add_x"></div>
								<div class="add_y"></div>
							</div>
						</div>
						<!-- <img class="img-circle" alt="Responsive image"> -->
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">邮箱：</label>
						<input type="email" class="form-control" id="registered_email" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">邀请码：</label>
						<input type="password" class="form-control" id="invite_code" placeholder="Invite code">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">账号名：</label>
						<input type="text" class="form-control" id="nickname" placeholder="nickname">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">密码：</label>
						<input type="password" class="form-control" id="registered_password1" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">确认密码：</label>
						<input type="password" class="form-control" id="registered_password2" placeholder="Password">
					</div>
					<div class="checkbox">
						<label>
							<input type="checkbox"> Check me out
						</label>
					</div>
					<div class="util_btn">
						<button type="button" class="btt btt_the">确定</button>
						<button type="button" class="btt" v-on:click="back()">返回</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</template>

<script>
	import api from '../api/login'
	export default {
		name: "GameLogin",
		data() {
			return {
				captchaSrc: null,
				user: {
					name: "",
					password: "",
					Vcode: "",
					Rememb: false
				}
			}
		},
		created() {
			this.code();
		},
		methods: {
			/**
			 * 显示login登录页面
			 * 隐藏按钮，隐藏注册页面，单独显示登录页面
			 */
			login_show() {
				var button = document.getElementsByClassName("button")[0];
				button.style.display = "none";
				var registered = document.getElementsByClassName("registered_page")[0];
				registered.style.display = "none";
				var login = document.getElementsByClassName("login_page")[0];
				login.style.display = "block";
			},
			/**
			 * 显示注册页面
			 * 隐藏button ， 隐藏登录页面，单独显示注册页面
			 */
			registered_show() {
				var button = document.getElementsByClassName("button")[0];
				button.style.display = "none";
				var login = document.getElementsByClassName("login_page")[0];
				login.style.display = "none";
				var registered = document.getElementsByClassName("registered_page")[0];
				registered.style.display = "block";
			},
			/**
			 * 返回页面
			 * 隐藏登陆页面，隐藏注册页面，单独显示buttom页面
			 */
			back() {
				var login = document.getElementsByClassName("login_page")[0];
				login.style.display = "none";
				var registered = document.getElementsByClassName("registered_page")[0];
				registered.style.display = "none";
				var button = document.getElementsByClassName("button")[0];
				button.style.display = "block";
			},
			/**
			 * 图片文件选择器
			 */
			choosefile() {
				var file = document.getElementById("file");
				file.click();
			},
			/**
			 * 获取验证码
			 */
			code() {
				this.captchaSrc = "http://127.0.0.1:8081/graphic/VerificationCode?a=" + new Date().getTime();
			},
			/**
			 * 登录按钮所需要执行的业务逻辑
			 */
			login(){
				console.log("sfsf")
				api.login(33);
			}
		}
	}
</script>

<style>
	.back {
		width: 100%;
		height: 100%;
		background-color: black;
		float: left;
	}

	.back_left,
	.back_right {
		width: 50%;
		height: 100vh;
		float: left;
	}

	.back_left {
		background-color: #33224f;
	}

	.back_right {
		background-color: #fcde5f;
	}

	.button {
		position: absolute;
		height: 100%;
		width: 100%;
		z-index: auto;
	}

	.button_login,
	.button_registered {
		position: absolute;
		height: 200px;
		width: 600px;
		left: 50%;
		top: 50%;
		z-index: auto;
		border-radius: 30px;
		font-family: "潮字社風雲繁";
		text-align: center;
		box-shadow: 0px 0px 10px 1px #000000;
		font-size: 100px;
		line-height: 200px;
		cursor: pointer;
	}

	.button_login {
		/* margin: auto; */
		background-color: #33224F;
		margin-left: -300px;
		margin-top: -250px;
		color: #FCDE5F;
	}

	.button_registered {
		background-color: #FCDE5F;
		margin-left: -300px;
		color: #33224F;
	}

	/* .button_login,
	.button_registered:hover{
		box-shadow: 0px 0px 50px 1px #000000;
	} */

	.button_login:hover {
		box-shadow: 0px 0px 30px 1px #000000;
		transition: 0.5s;
	}

	.button_registered:hover {
		box-shadow: 0px 0px 30px 1px #000000;
		transition: 0.5s;
		/* transform: scale(1.2);
		transition: all 500ms linear; */
	}

	.login_page,
	.registered_page {
		width: 700px;
		height: 700px;
		position: absolute;
		left: 50%;
		top: 50%;
		margin-left: -350px;
		margin-top: -350px;
		box-shadow: 0px 0px 30px 1px #000000;
	}

	.login_page {
		display: none;
		background-color: #33224F;
	}

	.registered_page {
		display: none;
		background-color: #FCDE5F;
	}

	.login {
		/* height: 100%; */
		padding: 100px;
		/* background-color: aqua; */
		color: white;
	}

	#login_account,
	#login_password,
	#long_verification_code,
	#long_verification_code_img {
		height: 40px;
	}

	#long_verification_code {
		float: left;
		width: 350px;
	}

	#long_verification_code_img {
		width: 100px;
		float: right;
	}

	.bte {
		width: 100px;
		height: 40px;
		background-color: inherit;
		border-radius: 5px;
		text-align: center;
		border: 1px dashed white;
	}

	.bte_the {
		margin-right: 50px;
	}

	.bte:hover {
		background-color: #F0AD4E;
		transition: 0.5s;
	}

	.util_btn {
		width: 100%;
		height: 100%;
		margin-top: 50px;
		text-align: center;
	}

	.registered {
		padding: 100px;
		padding-top: 50px;
	}

	#nickname,
	#invite_code,
	#registered_password1,
	#registered_email,
	#registered_password2 {
		height: 40px;
	}

	.btt {
		width: 100px;
		height: 40px;
		background-color: inherit;
		border-radius: 5px;
		text-align: center;
		border: 1px dashed #33224F;
	}

	.btt_the {
		margin-right: 50px;
	}

	.btt:hover {
		background-color: #33224F;
		color: white;
		transition: 0.5s;
	}

	.default {
		width: 130px;
		height: 130px;
		border-radius: 75px;
		padding: 0px;
	}

	.portrait {
		width: 150px;
		height: 150px;
		background-color: aliceblue;
	}

	.add {
		border-radius: 100px;
		float: right;
		margin-top: -100px;
		margin-right: 80px;
		width: 70px;
		height: 70px;
		border: 5px solid #33224F;
		text-align: center;
		cursor: pointer;
	}

	.add:hover {
		background-color: #c89142;
	}

	.add_x,
	.add_y {
		border-radius: 10px;
		background-color: #33224F;
		float: left;
		position: absolute;
	}

	.add_x {
		margin-top: 26px;
		margin-left: 10px;
		width: 45px;
		height: 8px;
	}

	.add_y {
		margin-left: 26px;
		margin-top: 10px;
		width: 8px;
		height: 45px;
	}

	#portrait {}

	label {
		float: left;
	}

	.exampleInputPassword1 {
		float: none;
		margin-left: -440px;
	}
</style>
