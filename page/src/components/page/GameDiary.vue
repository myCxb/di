<template>
	<div id="gamDiary">

		<div class="container bs-docs-container">
			<div class="row">
				<div class="col-md-9">
					<div class="head">{{title}}</div>
					<div class="main">
						<!--表头-->
						<ul class="nav nav-tabs">
							<li>全部</li>
							<li>日期
								<span class="glyphicon glyphicon-sort-by-attributes" v-show="attributes"></span>
								<span class="glyphicon glyphicon-sort-by-attributes-alt" v-show="attributes_alt"></span>
							</li>
							<li>浏览</li>
							<li style="float: right;">共查出1000条</li>
						</ul>

						<!--需要渲染的页面结构-->
						<div class="msg" v-for="(item,index) in list">
							<div class="title">{{item.title}}</div>
							<div class="chinese_explain"><span
									style="font-weight: 800;">中文解释：</span>{{item.customChinese}}</div>
							<div class="content">{{item.content}}</div>
							<div class="tail">
								<span class="glyphicon glyphicon-eye-open"></span>
								<span class="number">{{item.browseTotal}}</span>

								<span class="glyphicon glyphicon-comment"></span>
								<span class="number">{{item.comments}}</span>
								<span class="time">{{item.time}}</span>
							</div>
						</div>
					</div>
					
					<div class="footer">
						<!--表尾，显示分页按钮-->
						<nav aria-label="Page navigation">
						  <ul class="pagination pagination-sm">
						    <li>
						      <a href="#" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li>
						      <a href="#" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>
					</div>
				</div>
				<div class="col-md-3">
					<div style="width: 90%;float: right;">
						<div class="head">{{news}}</div>
						<div class="main">
							
						</div>
					</div>
					
					
				</div>
			</div>
		</div>



	</div>
</template>

<script>
	export default {
		name: "GameDiary",
		data() {
			return {
				title: "日记",
				news:"热门",
				//用于显示页面排序 升序 or 降序的显示Boolean值
				attributes: false,
				attributes_alt: false,
				list: [{
						"title": "msg消息及自定义msg消息",
						"customChinese": "信息消息及自定义信息消息",
						"content": "msg消息 1.1 基本概念 msg消息 是ROS topic通讯节点间传递的内容。 msg消息描述的是业务间传递数据，也可以理解为业务间数据的抽象化。 1.2 常见Msg消息 1.2.1 std消息 std消息属于基本数据类型消息，和python...",
						"browseTotal": 1000,
						"comments": 1,
						"time": "2022-1-1 23:59:59"
					},
					{
						"title": "msg消息及自定义msg消息",
						"customChinese": "信息消息及自定义信息消息",
						"content": "msg消息 1.1 基本概念 msg消息 是ROS topic通讯节点间传递的内容。 msg消息描述的是业务间传递数据，也可以理解为业务间数据的抽象化。 1.2 常见Msg消息 1.2.1 std消息 std消息属于基本数据类型消息，和python...",
						"browseTotal": 1000,
						"comments": 1,
						"time": "2022-1-1 23:59:59"
					},
					{
						"title": "msg消息及自定义msg消息",
						"customChinese": "信息消息及自定义信息消息",
						"content": "msg消息 1.1 基本概念 msg消息 是ROS topic通讯节点间传递的内容。 msg消息描述的是业务间传递数据，也可以理解为业务间数据的抽象化。 1.2 常见Msg消息 1.2.1 std消息 std消息属于基本数据类型消息，和python...",
						"browseTotal": 1000,
						"comments": 1,
						"time": "2022-1-1 23:59:59"
					},
					{
						"title": "msg消息及自定义msg消息",
						"customChinese": "信息消息及自定义信息消息",
						"content": "msg消息 1.1 基本概念 msg消息 是ROS topic通讯节点间传递的内容。 msg消息描述的是业务间传递数据，也可以理解为业务间数据的抽象化。 1.2 常见Msg消息 1.2.1 std消息 std消息属于基本数据类型消息，和python...",
						"browseTotal": 1000,
						"comments": 1,
						"time": "2022-1-1 23:59:59"
					}
					
				]
			}
		},
		methods: {

		}
	}
</script>

<style>
	#gamDiary {
		padding: 0px;
		margin: 0px;
	}

	.row {
		padding: 0px;
		margin: 0px;
		margin-left: 0px;
		margin-right: 0px;
	}

	.row>div {
		padding: 0px;
	}

	.head , .footer{
		background-color: #f8f8f8;
		font-size: 30px;
		text-align: left;
		border: solid 2px #e7e7e7;
		padding: 5px;
	}
	
	.head{
		border-top-left-radius: 8px;
		border-top-right-radius: 8px;
	}
	
	.footer{
		border-bottom-left-radius: 8px;
		border-bottom-right-radius: 8px;
		height: 80px;
	}
	
	.footer > nav{
		float: right;
	}

	.main {
		width: 100%;
		border: 2px solid #e7e7e7;
		/* height: 100px; */
	}

	.nav-tabs>li {
		margin-left: 20px;
		color: black;
		font-size: 15px;
		padding: 10px;
	}

	.msg {
		padding: 20px;
		text-align: left;
	}

	.title {
		font-size: 16px;
		margin-bottom: 10px;
	}

	.chinese_explain {
		font-size: 13px;
	}

	.content {
		/* width: 100%; */
		font-size: 13px;
		padding: 5px 0px 5px 0px;
	}

	.tail {
		margin-top: 10px;
		padding-bottom: 10px;
		border-bottom: 2px solid #e7e7e7;
	}

	/* .glyphicon-eye-open{
		margin-top: 10px;
	} */

	.number {
		margin-right: 20px;
		/* margin-top: -30px; */
		/* margin-top: ; */
		margin-left: 2px;
	}

	.time {
		float: right;
	}
	
</style>
