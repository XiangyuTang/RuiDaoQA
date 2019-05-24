<html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<head>
	<meta charset="utf-8">
	<title>发表问题</title>
	<link rel="stylesheet" type="text/css" href="./layui/css/layui.css" media="all">
	<script src="./layui/layui.js" charset="utf-8" type="text/javascript"></script>


	<script>
		layui.use(['layer', 'form', 'element'], function () {

			var layer = layui.layer, form = layui.form, element = layui.element
			$ = layui.$
			
				$("#submit_button").click(function(){
				
				$.ajax({
					url:"askQuestion",
					type:"post",
					dataType:"text",
					data:{user_id:$("#user_id").val(),type:$("#type").val(),desc:$("#desc").val(),title:$("#title").val()},
					success:function(data){
						
						if(data=="success"){
							alert("发布问题成功！")
						}
						if(data=="failed"){
							alert("服务异常！")
						}
	                    window.parent.layer.closeAll();//关闭弹窗


					}

				})
			})
			
			
		/*	form.on('submit(111)', function (data) {
			

				layer.msg(JSON.stringify(data.field));
			
	
				return false;
			});*////layui自带的判断方法，需要的可以用  使用时必须加上lay-filter
		
			
		})
	</script>

</head>                                     


<body>

<!-- 此处的user_id值需要从users表中得到 -->
	<form class="layui-form" id="111" style="width: 60%; margin: 0px auto;"  >
		<input type="text" id="user_id" name="user_id" value="${user_id }" style="display:none"/>
		<div class="layui-form-item">
			<label class="layui-form-label">添加标题</label>
			<div class="layui-input-block">
				<input type="text" id="title" name="title" required lay-verify="required" placeholder="请输入问题"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">话题</label>
			<div class="layui-input-block">
				<select name="type" id="type" lay-verify="required">
					<option value="">请选择</option>
					<option value="0"></option>
					<option value="1">体育</option>
					<option value="2">娱乐</option>
					<option value="3">财经</option>
					<option value="4">IT</option>
				</select>
			</div>
		</div>



		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">详情</label>
			<div class="layui-input-block">
				<textarea id="desc" style="resize: none; height: 200px;" name="desc" placeholder="请输入内容"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" id="submit_button" class="layui-btn" style="width: 30%; float: left;"  lay-submit 
					value="立即提交" />
				<button type="reset" class="layui-btn layui-btn-primary" style="width: 30%; float: right;">重置</button>
			</div>
		</div>
<!--  lay-submitc="111" -->
	</form>


</body>

</html>