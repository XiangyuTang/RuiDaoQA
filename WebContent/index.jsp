<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>问答系统首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="keywords" content="">
		<meta name="description" content="">
		 <meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" href="css/global.css">
		<script src="layui/layui.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<style type="text/css" rel="stylesheet">
		.change{
			background-color: #58A571;
		}
		form {
			margin: 0;
		}
		.editor {
			margin-top: 5px;
			margin-bottom: 5px;
		}
		</style>
		<style>
    	.selected{
    		font-weight:bold; 
    		/*background: #ff99cc; */
    		color:#fff;
    		}
		</style>
<!-- 		///蒂哈德 -->
		
	</head>
	
	<body>
		<%@ include file="head.jsp"%>
		<div class="main layui-clear" style="margin-top: 80px;">
			<div>
				<ul class="layui-nav" id="nav">
				  <li class="layui-nav-item" ><a href="#" id='1'>热门</a></li>
				  <li class="layui-nav-item" ><a href="#" id='2'>社会</a></li>
				  <li class="layui-nav-item" ><a href="#" id='3'>娱乐</a></li>
				  <li class="layui-nav-item" ><a href="#" id='4'>体育</a></li>
				  <li class="layui-nav-item" ><a href="#" id='5'>军事</a></li>
				  <li class="layui-nav-item" ><a href="#" id='6'>汽车</a></li>
				  <li class="layui-nav-item" ><a href="#" id='7'>财经</a></li>
				  <li class="layui-nav-item" ><a href="#" id='8'>科技</a></li>
				  <li class="layui-nav-item" ><a href="#" id='9'>育儿</a></li>
				  <li class="layui-nav-item" ><a href="#" id='10'>历史</a></li>
				  <li class="layui-nav-item" ><a href="#" id='11'>美食</a></li>
				  <li class="layui-nav-item" ><a href="#" id='12'>数码</a></li>
				  <li class="layui-nav-item" ><a href="#" id='13'>时尚</a></li>
				  <li class="layui-nav-item" ><a href="#" id='14'>宠物</a></li>

				  <li class="layui-nav-item">
				    <a href="#">更多</a>
				    <dl class="layui-nav-child">
				      <dd><a href="#" id='15'>家居</a></dd>
				      <dd><a href="#" id='16'>文化</a></dd>
				      <dd><a href="#" id='17'>健康</a></dd>
				      <dd><a href="#" id='18'>游戏</a></dd>
				    </dl>
				  </li>
				</ul>
			</div>
			
			<div class="wrap">
				<div class="content detail">
				<!--	<ul class="flow-default" id="LAY_demo1"></ul>-->
				<%-- <c:forEach items="${getQuestionByType}" var="q" varStatus="status"> --%>
				<ul class="flow-default" id="LAY_demo">
					<!--动态加载流对象-->
				</ul>
<%-- 				</c:forEach> --%>
				</div>
			</div>
		
			<div class="edge">
					<dl class="fly-panel fly-list-one">
						<dt class="fly-panel-title">近期最热收藏</dt>
						<ul id="zuirehuida"></ul>
					</dl>
		
					<dl class="fly-panel fly-list-one">
						<dt class="fly-panel-title">近期最热评论</dt>
						<ul id="zuirewenti"></ul>
					</dl>
			</div>
	</div>
</body>
</html>

<script src="layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use('element', function(){
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
				  
		//监听导航点击
		element.on('nav(demo)', function(elem){
			console.log(elem)
			layer.msg(elem.text());
		});
		});
</script>

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
 <script type="text/javascript">
	// 200毫秒后模拟点击
	setTimeout(function() {
	    // IE
	    if(document.all) {
	        document.getElementById("1").click();
	    }
	    // 其它浏览器
	    else {
	        var e = document.createEvent("MouseEvents");
	        e.initEvent("click", true, true);
	        document.getElementById("1").dispatchEvent(e);
	    }
	}, 200);
</script>
  
<!--<script>
	$(function(){
		$("#nav li:first").trigger("click");//在页面加载时，触发点击热门事件
	})
</script>-->
<script>
	
	$(function(){
		$("i[class='layui-icon layui-icon-praise']").live('click',function(){
			$(this).toggle(//点赞按钮的特效部分
				function(){
				var answer_id = parseInt($(this).parent().prev().val());//用于获取answer_id(int类型的)
				$.ajax({
					type:"get",
					url:"addAcclaim",
					async:true,
					data:{answer_id:answer_id,fangfa:"add"},
					dataType:"text",
					success:function(e){
					}
				});
				$(this).addClass("layui-anim layui-anim-scaleSpring");
				var i = parseInt($(this).next().html());			
				$(this).next().html(i+1);
				},
				function(){
				var answer_id = parseInt($(this).parent().prev().val());//用于获取answer_id(int类型的)
				$.ajax({
					type:"get",
					url:"addAcclaim",
					async:true,
					data:{answer_id:answer_id,fangfa:"delete"},
					dataType:"text",
					success:function(e){
					}
				});
				$(this).removeClass("layui-anim layui-anim-scaleSpring");
				var i = parseInt($(this).next().html());		
				$(this).next().html(i-1);
				}
			);
			//先触发click，不然第一次失效
       		$(this).trigger("click");
		});
		
		//踩按钮的特效部分
		$("i[class='layui-icon layui-icon-tread']").live('click',function(){
			$(this).toggle(//踩按钮的特效部分
				function(){
				var answer_id = parseInt($(this).parent().prev().prev().val());
				$.ajax({
					type:"get",
					url:"addDefame",
					async:true,
					data:{answer_id:answer_id,fangfa:"add"},
					dataType:"text",
					success:function(e){
						
					}
				});
				$(this).addClass("layui-anim layui-anim-scaleSpring");
				var i = parseInt($(this).next().html());			
				$(this).next().html(i+1);
				},
				function(){
				var answer_id = parseInt($(this).parent().prev().prev().val());
				$.ajax({
					type:"get",
					url:"addDefame",
					async:true,
					data:{answer_id:answer_id,fangfa:"delete"},
					dataType:"text",
					success:function(e){
						
					}
				});
				$(this).removeClass("layui-anim layui-anim-scaleSpring");
				var i = parseInt($(this).next().html());		
				$(this).next().html(i-1);
				}
			);
			//先触发click，不然第一次失效
       		$(this).trigger("click");
		});
		
		$("[class='layui-btn layui-btn-radius layui-btn-sm']").live('click',function(){//关注按钮的特效部分
			$(this).toggle(
			function(){
				var follow_user_id = parseInt($(this).prev().prev().val());//用于获取user_id(int类型的)
				$.ajax({
					type:"get",
					url:"addFollow",
					async:true,
					data:{follow_user_id:follow_user_id,fangfa:"add"},
					dataType:"text",
					success:function(e){	
					}

				});
				$(this).addClass("layui-btn-primary");
				$(this).html("已关注");
			},
			function(){
				var follow_user_id = parseInt($(this).prev().prev().val());
				$.ajax({
					type:"get",
					url:"addFollow",
					async:true,
					data:{follow_user_id:follow_user_id, fangfa:"delete"},
					dataType:"text",
					success:function(e){
					}
				});
				$(this).removeClass("layui-btn-primary");
				$(this).html("关注");
			})
			$(this).trigger("click");
		})
		
	})
</script>

<script src="layui/layui.js" charset="utf-8"></script>
<script>
	//点击导航栏某一话题触发事件
	$(function(){
		$("li[class='layui-nav-item']").click(function() {
        	$(this).siblings('li').removeClass('selected');  // 删除其他兄弟元素的样式
        	$(this).addClass('selected'); // 添加当前元素的样式
        	//在这个地方执行ajax
        	var topic = $(this).find('a[id]').attr('id');
        	if (topic!=15) {
        		var ajax = new XMLHttpRequest();
				ajax.open('get','getQuestion?topic='+topic,true);
				ajax.send();
				//responseText 该变量是引擎内置的属性，专门负责从后台接收文本类型的内容
				
				//回调函数实现流加载
				ajax.onload=function(){
					console.log(ajax.responseText);
					var json=JSON.parse(ajax.responseText); 
					
					var ul = document.getElementById('LAY_demo');
					ul.innerHTML = "";//导航栏切换刷新流加载的关键！!
					var pages;
					if(ajax.responseText=="")
						pages = 1;
					else{
						pages = json.pages;
					}
					layui.use('flow', function(){
						var i = 0;
					  	var flow = layui.flow;
						  	flow.load({
						    elem: '#LAY_demo' //流加载容器
						    ,scrollElem: '#LAY_demo' //滚动条所在元素，一般不用填，此处只是演示需要。
						    ,done: function(page, next){ //执行下一页的回调
					      	//模拟数据插入
					      	setTimeout(function(){
						        var lis = [];
				          		lis.push(json.s[i]);
				          		i = i+1;
					       		//执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
					        	//pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
					        	next(lis.join(''), page < pages); //假设总页数为 3
						      	}, 500);
				    		}
				  			});
				  	})			
				}
        	}
			
    	});
    	
    	//下面是点击更多出现的内容，还没有实现
    	/*$("dl[class='layui-nav-child']").click(function() {
        	$(this).children().siblings('li').removeClass('selected');  // 删除其他兄弟元素的样式
        	$(this).children().addClass('selected'); // 添加当前元素的样式
        	//在这个地方执行ajax
        	var topic = $(this).find('a[id]').attr('id');
			var ajax = new XMLHttpRequest();
			ajax.open('get','getQuestion?topic='+topic,true);
			ajax.send();
			//responseText 该变量是引擎内置的属性，专门负责从后台接收文本类型的内容
			ajax.onload=function(){
			}
    	});*/
	})
</script>
<!--<script>
	$(function(){
		var $newTr=$("<div class='fly-panel box'>"+
						"<h1><a href='toDetailQues?question_id="+q.getQuestion_id()+"'>"+q.getQues_title()+"</a></h1>"+
						"<div class='question-info'><span class='question-answer-num'>"+q.getAnswer_num()+"回答</span> <span class='question-follow-num'>"+q.getCollect_num()+"人收藏</span></div>"+
						"<div class='detail-about'>"+
							"<a class='jie-user' href=''> <img "+
								"src='images/uer.jpg' alt='头像'> <cite> 压缩"+
									"<em>2017-05-01发布</em> </cite> </a>"+
							"<div class='detail-hits' data-id='{{rows.id}}'>"+
								"<button class='layui-btn layui-btn-radius layui-btn-sm' style='width:80px; border-radius:20px;'>关注</button>"+
							"</div>"+
						"</div>"+
						"<div class='detail-body photos' style='margin-bottom: 0px;'>"+
							"<p>"+q.getContent()+
							"</p>"+
						"</div>"+
						"<div class='jieda-reply'>"+
								"<input type='hidden' name='answer_id' value='2'/>"+
								"<span class='jieda-zan zanok' type='zan'>"+
									"<i class='layui-icon layui-icon-praise' style='font-size: 20px; color: #009688;' title='赞'></i><em style='font-size: 15px; color: #009688;'>"+12+"</em>"+
								"</span>"+
								"<span class='jieda-zan zanok' type='zan'><i "+
									"class='layui-icon layui-icon-tread' style='font-size: 20px; color: #009688;' title='踩'></i><em style='font-size: 15px; color: #009688;'>3</em>"+
								"</span>"+
								"<span class='jieda-zan zanok' type='zan'><i "+
									"class='layui-icon layui-icon-reply-fill'  style='font-size: 20px; color: #009688;' title='评论'></i><em style='font-size: 15px; color: #009688;'>"+q.getAnswer_num()+"</em>"+
								"</span>"+
								"<div class='jieda-admin'>"+
									"<span class='jieda-accept' type='accept'>"+
								"</div>"+
						"</div>"+
				"</div>")
			$('#jieda').prepend($newTr);
	})
</script>-->

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script>
	window.onload = function(){
		var ajax1 = new XMLHttpRequest();
		var ajax2 = new XMLHttpRequest();
		ajax1.open('get','getQuestionByCollectnum',true);
		ajax1.send();
		ajax2.open('get','getAnswerByAcclaimNum',true);
		ajax2.send();
		//responseText 该变量是引擎内置的属性，专门负责从后台接收文本类型的内容
		
		//回调函数实现流加载
		ajax1.onload=function(){
			console.log(ajax1.responseText);
			var ul1 = document.getElementById('zuirehuida');
			ul1.innerHTML = ajax1.responseText;
		}
		ajax2.onload=function(){
			console.log(ajax2.responseText);
			var ul2 = document.getElementById('zuirewenti');
			ul2.innerHTML = ajax2.responseText;
		}
	}
</script>
