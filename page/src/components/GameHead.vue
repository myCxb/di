<template>
	<div id="gameHead">
	
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">BUG啦</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">日记 <span class="sr-only">(current)</span></a></li>
		        <li><a href="#">日志</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">统计 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#">目录</a></li>
		            <li><a href="#">记录</a></li>
		            <li><a href="#">Something else here</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">Separated link</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">One more separated link</a></li>
		          </ul>
		        </li>
		      </ul>
		      <form class="navbar-form navbar-left">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="日志">
		        </div>
		        <button type="submit" class="btn btn-default">搜索</button>
		      </form>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#">长无眠</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">详细信息 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#">个人信息</a></li>
		            <li><a href="#">修改页面</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">设置</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<GameDiary></GameDiary>
	</div>
</template>

<script>
	import GameDiary from './page/GameDiary.vue'
	export default {
		name: "GameHead",
		components: {
		  GameDiary
		},
		data(){
			return  {
					
			}
		},
		methods:{
			
		}
	}
</script>

<style scoped>
	#gameHead{
		padding: 0px;
		margin: 0px;
		width: 100%;
		height: 100px;
		/* background-color: #33224f; */
	}
	
</style>