<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>问题详情</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="fly,layui,前端社区">
<meta name="description"
	content="">
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="css/global.css">
<script src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<!--<script src="js/script.js"></script>-->
<style type="text/css" rel="stylesheet">

form {
	margin: 0;
}
.editor {
	margin-top: 5px;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<!-- <iframe src="head.jsp" scrolling="no" width="100%" height="65px" href="index.html"></iframe> -->
<%@ include file="head.jsp"%> 
	<div class="main layui-clear" style="margin-top: 80px;">
		<div class="wrap">
			<div class="content detail">
				<div class="fly-panel detail-box">
					<h1>${Question.ques_title}</h1>
					<div class="fly-tip fly-detail-hint" data-id="">
						<br>
						<div class="fly-list-hint">
							<input type="hidden" name="question_id" value="${Question.question_id }" class="${Question.collect_flag }"/><!--question_id的隐藏域-->
							<i class="layui-icon layui-icon-star" style="font-size: 20px; color: #1E9FFF; "; title="收藏"; >${Question.collect_num} </i>&nbsp;  
							<i class="layui-icon layui-icon-share" style="font-size: 20px; color: #1E9FFF; " title="分享">分享</i>  
						</div>
					</div>
					<div class="detail-body photos" style="margin-bottom: 20px;">
						<p>${Question.content}</p>
					</div>
					<div class="detail-about">						
						<a class="jie-user" href=""> <img
							src="${User.head_photo}" alt="头像"> <cite> ${User.nick_name} 
								<em>${Question.publish_time}发布</em> </cite> </a>
						<div class="detail-hits" data-id="{{rows.id}}">
							<input type="hidden" name="user_id" value="${User.user_id}" class="${User.follow_flag }" /><span></span>
							<button class="layui-btn layui-btn-radius layui-btn-sm" style="width:80px; border-radius:20px;">关注</button>
						</div>
					</div>
					<span
					id="toName">@ ${User.nick_name} (楼主)
					</span>		
					
							<textarea id="L_content" name="content"  placeholder="我要回答" 
							class="layui-textarea fly-editor" style="display: none;" lay-verify="content" >我有靠谱回答~</textarea>
							<br>
							
							
							<div class="layui-form-item">
								<button id="ans-btn" class="layui-btn" lay-filter="*" lay-submit>提交回答</button>
								<button id="start-record-btn" class="layui-btn" lay-filter="*" lay-submit>语音识别</button>
								<button id="pause-record-btn" class="layui-btn" >暂停识别</button>
							</div>
							<p id="recording-instructions">按下 <strong>语音识别</strong> 按钮并按提示给予相关权限。</p>
							<div class="no-browser-support" style="display:none">您的浏览器不支持Web Speech API，请使用Chrome浏览器打开此应用。</div>			
				</div>
			
				<div class="fly-panel detail-box" style="padding-top: 0;">
					<a name="comment"></a>
					<ul class="jieda photos" id="jieda">
						<c:forEach items="${answerlist }" var="answer" varStatus="status1">
						<li data-id="12" class="jieda-daan"><a name="item-121212121212" ></a><!--此处开始循环10次，加载10个答案-->
							<div class="detail-about detail-about-reply" >
								<input type="hidden" name="user_id" value="${answer.user.user_id }" class="${answer.user.follow_flag }" /><!--user_id的隐藏域，放此处供关注功能获取，该位置不可变动-->
								<a class="jie-user" href=""> <img src=" ${answer.user.head_photo }" alt=""> <cite> <i>${answer.user.nick_name }</i></cite> </a>
								<button class="layui-btn layui-btn-radius layui-btn-sm" style="width:80px; margin-left: 68%;">关注</button>
								<div class="detail-hits">
									<span>${answer.publish_time }</span>
								</div>
							</div>
							<div class="detail-body jieda-body">
								<p>${answer.content }</p>
							</div>							
							<div class="jieda-reply">
								<input type="hidden" name="answer_id" value="${answer.answer_id }" /><!--answer_id的隐藏域，放此处供点赞，踩，评论功能获取，该位置不可变动-->
								<span class="jieda-zan zanok" type="zan">
									<i class="layui-icon layui-icon-praise" title="赞"></i><em>${answer.dianzan_num }</em>
								</span>
								<span class="jieda-zan zanok" type="zan"><i
									class="layui-icon layui-icon-tread" title="踩"></i><em>${answer.cai_num }</em>
								</span>
								<span class="jieda-zan zanok" type="zan"><i
									class="layui-icon layui-icon-reply-fill" title="评论"></i><em>${answer.comment_num }</em>
								</span>
							</div>
							<div style="display:none; background-color:#F0F0F0;" id="comment"><!--该div为即将加载的comment的div-->
							<div id="writecomment">
								<div style="height: 60px;">
									<textarea name="" class="commentcontent" id="${status1.count }" required lay-verify="required" placeholder="请输入" style="height: 60px; width: 100% "></textarea>
								</div>
								<div style="margin-left: 88%;margin-top: 10px; width: 30px;">
									<button class="layui-btn  layui-btn-sm" style="width:85px; height: 30px;">评论</button>
								</div>
							</div>	<!--改div为循环开始基准-->
							<c:forEach items="${answer.comments }" var="comment" varStatus="status2">				
							<div class="detail-about detail-about-reply"><!--从该处开始第二次循环，循环10次，结合外层，共加载出100条热评-->
								<input type="hidden" name="user_id" value="${comment.user.user_id }" /><!--评论人的user_id隐藏域，暂时未使用，后续可能使用-->
								<a class="jie-user" href=""> <img
									src="${comment.user.head_photo }" alt=""> <cite> <i>${comment.user.nick_name }</i>
										<em style="color:#FF9E3F"></em> </cite> </a>
								<div class="detail-hits">
									<span>${comment.publish_time }</span>
								</div>
								<div >
								<p style="margin-left: 60px;">${comment.content }</p>
								</div>
							</div>							
							<div class="jieda-reply">
								<input type="hidden" name="comment_id" value="${comment.comment_id }"/><!--该条评论的id，用于评论点赞和评论的再评论，位置不可变动-->
								<span class="jieda-zan zanok" type="zan" style="margin-left: 50px;">
									<i class="layui-icon layui-icon-praise comment" title="赞"></i><em>${comment.dianzan_num }</em>
								</span>
								<span class="jieda-zan zanok" type="zan">
									<input type="hidden" name="count" value="${status1.count }"/>
									<i class="layui-icon layui-icon-reply-fill comment_for_comment" id="${status1.count }"  title=""></i><em></em>
								</span>
							</div>
							</c:forEach>		
							</div>							
						</li>
						</c:forEach>
					</ul>
					
				</div>
			</div>
		</div>

		<div class="edge">
			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">最近热帖</dt>
				<dd>
					<a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
						class="iconfont">&#xe60b;</i> 6087</span>
				</dd>
				<dd>
					<a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
						class="iconfont">&#xe60b;</i> 6087</span>
				</dd>
				<dd>
					<a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
						class="iconfont">&#xe60b;</i> 6087</span>
				</dd>
				<dd>
					<a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
						class="iconfont">&#xe60b;</i> 6087</span>
				</dd>
				<dd>
					<a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
				</dd>
			</dl>
			<dl class="fly-panel fly-list-one">
				<div class="layui-carousel" id="test10">
				  <div carousel-item="">
				    <div><img src="images/banner/banner1.png" height="200" width="340"></div>
				    <div><img src="images/banner/banner2.png" height="200" width="340"></div>
				    <div><img src="images/banner/banner3.png" height="200" width="340"></div>
				    <div><img src="images/banner/banner4.png" height="200" width="340"></div>
				   
				  </div>
				</div>
			</dl>
			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">近期热议</dt>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
				<dd>
					<a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
						class="iconfont">&#xe60c;</i> 96</span>
				</dd>
			</dl>
		</div>
	</div>
</body>
</html>

<script type="text/javascript" charset="utf-8" src="js/kindeditor.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<!--<script src='guangd.js'></script> -->
<script>	
 	//获取当前时间存入数据库中
	function getTimeIntoDB() {
	    var submitDate = new Date();
	    const d = new Date(submitDate);
        const resDate = d.getFullYear() + '-' + this.p((d.getMonth() + 1)) + '-' + this.p(d.getDate());
        const resTime = this.p(d.getHours()) + ':' + this.p(d.getMinutes()) + ':' + this.p(d.getSeconds());
        var submit_date = resDate+" "+resTime;
     	return submit_date;
	}
	function p(s) {
      return s < 10 ? '0' + s : s
    }
	
	//获取当前时间显示在前端中
	function getTime() {
    var myDate = new Date;
    var year = myDate.getFullYear(); //获取当前年
    var mon = myDate.getMonth() + 1; //获取当前月
    var date = myDate.getDate(); //获取当前日
    var h = myDate.getHours();//获取当前小时数(0-23)
    var m = myDate.getMinutes();//获取当前分钟数(0-59)
    var s = myDate.getSeconds();//获取当前秒
    var week = myDate.getDay();
    var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
    //console.log(year, mon, date, weeks[week])
    var str = year + "年  " + mon + "月  " + date + "日  " + weeks[week]+" "+h+":"+m;
    //$("#time").html(year + "年" + mon + "月" + date + "日" + weeks[week]+" "+h+":"+m);
    return str;
	}	
</script>

<!--<script>
	var commenttext;
	function addcomment(){
		str_time = getTime();
		var commenttext = $("[id='commentcontent']").val();
//		console.log(commenttext);
	}
	$('[class="layui-btn  layui-btn-sm"]').live('click',addcomment());
</script>-->

<script>	
  	var index;
   	var text;
   	var layedit;
   	var str_time;
   	var answer_id;
   	layui.use('layedit', function(){
  		layedit = layui.layedit;
 		index = layedit.build('L_content'); //建立编辑器
 		layedit.sync(index);
 		text = layedit.getContent(index);
	});
   	function addReply(text){
   		str_time = getTime();
   		text = $('textarea[id="L_content"]').val();
		//alert(text);
		if(text=='')
		{
			layui.use(['layer', 'form'], function(){
	  		var layer = layui.layer
	  			,form = layui.form;
	  			layer.msg('回答不能为空！');
			});
			return;
		}
		$.ajax({
			type:"get",
			url:"getNewAnswer_id",
			async:true,
			dataType:"text",
			success:function(e){
				answer_id=e;
				var answer_id1 = parseInt(answer_id)+1;
				var $newTr=$('<li data-id="12" class="jieda-daan"><a name="item-121212121212"></a>'+
					'<div class="detail-about detail-about-reply" > '+
								'<input type="hidden" name="user_id" value="${applicationScope.CurrentUser.user_id }" /><!--user_id的隐藏域，放此处供关注功能获取，该位置不可变动-->'+
								'<a class="jie-user" href=""> <img src="${applicationScope.CurrentUser.head_photo}" alt=""> <cite> <i>我</i></cite> </a> '+
								'<div class="detail-hits"> '+
									'<span>'+str_time+'</span>'+
								'</div>'+
							'</div>'+
							'<div class="detail-body jieda-body">'+
								'<p>'+ text +'</p>'+
							'</div>	'+						
							'<div class="jieda-reply">'+
								'<input type="hidden" name="answer_id" value="'+answer_id1+'"/><!--answer_id的隐藏域，放此处供点赞，踩，评论功能获取，该位置不可变动-->'+
								'<span class="jieda-zan zanok" type="zan">'+
									'<i class="layui-icon layui-icon-praise" title="赞"></i><em>0</em>'+
								'</span>'+
								'<span class="jieda-zan zanok" type="zan"><i '+
									'class="layui-icon layui-icon-tread" title="踩"></i><em>0</em>'+
								'</span>'+
								'<span class="jieda-zan zanok" type="zan"><i '+
									'class="layui-icon layui-icon-reply-fill" title="评论"></i><em>0</em>'+
								'</span>'+
							'</div>'+
				'</li>')
			$('#jieda').prepend($newTr);
			//清空文本框内容
			//text = $('textarea[id="L_content"]').val("");
			//弹出回答成功提示窗口
			submit_ans(text);
			
			//清空富文本框textarea
			//document.getElementById('L_content').reset();
			//$('textarea[id="L_content"]').html("");
			}
			
		});

   	}
   		
	//点击提交回答按钮触发
	$(function(){
		 //富文本编辑器自定义工具栏
		$('#ans-btn').click(function(){
			layedit.sync(index);//将富文本编辑器的内容同步到textarea
			addReply(text);
			
		})
	})
</script>


<script>
	$(function(){
		//点赞按钮的特效部分
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
		
		//对评论进行点赞
		$("i[class='layui-icon layui-icon-praise comment']").live('click',function(){
			$(this).toggle(//点赞按钮的特效部分
				function(){
				var comment_id = parseInt($(this).parent().prev().val());//用于获取answer_id(int类型的)
				$.ajax({
					type:"post",
					url:"addAcclaimforComment",
					async:true,
					data:{comment_id:comment_id,fangfa:"add"},
					dataType:"text",
					success:function(e){
					}
				});
				$(this).addClass("layui-anim layui-anim-scaleSpring");
				var i = parseInt($(this).next().html());			
				$(this).next().html(i+1);
				},
				function(){
				var comment_id = parseInt($(this).parent().prev().val());//用于获取answer_id(int类型的)
				$.ajax({
					type:"post",
					url:"addAcclaimforComment",
					async:true,
					data:{comment_id:comment_id,fangfa:"delete"},
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
	})
	
	//收藏小星星图标变换
	$(function(){
		$('i[class="layui-icon layui-icon-star"]').click(function(){
			var theclass=['layui-icon layui-icon-star','layui-icon layui-icon-star-fill'];
			var flag;
			if($(this).attr('class')=='layui-icon layui-icon-star'){
				flag = 1;
				var i = parseInt($(this).html());
				$(this).html(i+1);
				$(this).attr("class",theclass[1]);
				clickfavorite(flag);
			}
			else{
				flag = 0;
				var i = parseInt($(this).html());
				$(this).html(i-1);
				$(this).attr("class",theclass[0]);
				clickfavorite(flag);
			}
		})
		$('i[class="layui-icon layui-icon-star-fill"]').click(function(){
			var theclass=['layui-icon layui-icon-star','layui-icon layui-icon-star-fill'];
			var flag;
			if($(this).attr('class')=='layui-icon layui-icon-star'){
				flag = 1;
				var i = parseInt($(this).html());
				$(this).html(i+1);
				$(this).attr("class",theclass[1]);
				clickfavorite(flag);
			}
			else{
				flag = 0;
				var i = parseInt($(this).html());
				$(this).html(i-1);
				$(this).attr("class",theclass[0]);
				clickfavorite(flag);
			}
		})
	})
	
	$(function(){
		var theclass=['layui-icon layui-icon-star','layui-icon layui-icon-star-fill'];
		$("[name='question_id'][class='1']").next().attr("class",theclass[1]);
		$("[name='question_id'][class='0']").next().attr("class",theclass[0]);
	})

	//分享链接图标
	$(function(){
		$('i[class="layui-icon layui-icon-share"]').click(function(){
			alert("复制网站链接即可分享："+window.location.href);
		
		})
	})
	
	//关注按钮的特效部分
	$(function(){				
//		$("[class='layui-btn layui-btn-radius layui-btn-sm']").live('click',function(){//关注按钮的特效部分
//			$(this).toggle(
//			function(){
//				var follow_user_id = parseInt($(this).prev().prev().val());//用于获取user_id(int类型的)
//				$.ajax({
//					type:"get",
//					url:"addFollow",
//					async:true,
//					data:{follow_user_id:follow_user_id,fangfa:"add"},
//					dataType:"text",
//					success:function(e){
//						
//					}
//				});
//				$(this).addClass("layui-btn-primary");
//				alert($(this).attr("class"));
//				$(this).html("已关注");
//			},
//			function(){
//				var follow_user_id = parseInt($(this).prev().prev().val());
//				$.ajax({
//					type:"get",
//					url:"addFollow",
//					async:true,
//					data:{follow_user_id:follow_user_id, fangfa:"delete"},
//					dataType:"text",
//					success:function(e){
//						
//					}
//				});
//				$(this).removeClass("layui-btn-primary");
//				alert($(this).attr("class"));
//				$(this).html("关注");
//			})
//			$(this).trigger("click");
//		})
		
		$("[class='layui-icon layui-icon-reply-fill']").live('click',function(){
			$(this).toggle(
				function(){
					$(this).addClass("layui-anim layui-anim-scaleSpring");
					$(this).parent().parent().next().slideDown(700);
				},
				function(){
					$(this).removeClass("layui-anim layui-anim-scaleSpring");
					$(this).parent().parent().next().slideUp(700);
				}				
			)
			$(this).trigger("click");
		})				
	});

//	var follow_flag = 0;
	$(function(){
		
		
		$("[class='layui-btn layui-btn-radius layui-btn-sm']").click(function(){
			var theclass=['layui-btn layui-btn-radius layui-btn-sm layui-btn-primary','layui-btn layui-btn-radius layui-btn-sm'];
			var follow_flag = 0;
			if($(this).attr("class")=="layui-btn layui-btn-radius layui-btn-sm"){
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
				$(this).attr("class",theclass[0]);
				$(this).html("已关注");
				follow_flag = 1;
			}else{
				var follow_user_id = parseInt($(this).prev().prev().val());//用于获取user_id(int类型的)
				$.ajax({
					type:"get",
					url:"addFollow",
					async:true,
					data:{follow_user_id:follow_user_id,fangfa:"delete"},
					dataType:"text",
					success:function(e){
						
					}
				});				
				$(this).attr("class",theclass[1]);
				$(this).html("关注");
				follow_flag = 0;
			}
		})
		$("[class='layui-btn layui-btn-radius layui-btn-sm layui-btn-primary']").click(function(){
			var theclass=['layui-btn layui-btn-radius layui-btn-sm layui-btn-primary','layui-btn layui-btn-radius layui-btn-sm'];
			var follow_flag = 0;
			if($(this).attr("class")=="layui-btn layui-btn-radius layui-btn-sm"){
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
				$(this).attr("class",theclass[0]);
				$(this).html("已关注");
				follow_flag = 1;
			}else{
				var follow_user_id = parseInt($(this).prev().prev().val());//用于获取user_id(int类型的)
				$.ajax({
					type:"get",
					url:"addFollow",
					async:true,
					data:{follow_user_id:follow_user_id,fangfa:"delete"},
					dataType:"text",
					success:function(e){
						
					}
				});				
				$(this).attr("class",theclass[1]);
				$(this).html("关注");
				follow_flag = 0;
			}
		})
	})


	$(function(){
		
//		setTimeout(function () { 
//      var theclass=['layui-btn layui-btn-radius layui-btn-sm layui-btn-primary','layui-btn layui-btn-radius layui-btn-sm'];
//		if($("[type='hidden'][name='user_id']").attr("class") == "1"){
////			alert(1);
////			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[0]);
//			$(this).html("已关注");
//		}else{
//			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[1]);
//			$(this).html("关注");
//		}
//  	}, 500);
    	
//		var theclass=['layui-btn layui-btn-radius layui-btn-sm layui-btn-primary','layui-btn layui-btn-radius layui-btn-sm'];
//		if($("[type='hidden'][name='user_id']").attr("class") == "1"){
//			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[0]);
//			$(this).html("已关注");
//		}else{
//			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[1]);
//			$(this).html("关注");
//		}
		var theclass=['layui-btn layui-btn-radius layui-btn-sm layui-btn-primary','layui-btn layui-btn-radius layui-btn-sm'];
		$("[type='hidden'][name='user_id'][class='1']").next().next().attr("class",theclass[0]);
		$("[type='hidden'][name='user_id'][class='1']").next().next().html("已关注");
		$("[type='hidden'][name='user_id'][class='0']").next().next().attr("class",theclass[1]);
	    $("[type='hidden'][name='user_id'][class='0']").next().next().html("关注");
//			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[0]);
//			$("[type='hidden'][name='user_id']").next().next().html("已关注");
//		}
//		else{
//			alert($("[type='hidden'][name='user_id']").attr("class"));
//			$("[type='hidden'][name='user_id']").next().next().attr("class",theclass[1]);
//			$(this).html("关注");
//		}
		
	})

//	function addcomment(text){
//		str_time = getTime();
//		var $textarea = $("[id='commentcontent']");
//		var commentcontent = $textarea.val();
//	}
	var comment_flag = 0;
	$('[class="layui-btn  layui-btn-sm"]').live('click',function(){
		var str_time = getTime();
		var ans_time = getTimeIntoDB();
		var $textarea = $(this).parent().prev().find("textarea");
		var commentcontent = $textarea.val();
		var answer_id = $(this).parent().parent().parent().prev().find("input").val();
		var comment_time = getTimeIntoDB();
		if(commentcontent=='')
		{
			layui.use(['layer', 'form'], function(){
	  		var layer = layui.layer
	  			,form = layui.form;
	  			layer.msg('回答不能为空！');
			});
			return;
		}
		$.ajax({
					type:"post",
					url:"addComment",
					async:true,
					data:{answer_id:answer_id,comment_content:commentcontent,comment_flag:comment_flag,time:ans_time},
					dataType:"text",
					success:function(e){
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){	
					}

				});
		var $commentdiv=$(
			'<div class="detail-about detail-about-reply"><!--从该处开始第二次循环，循环10次，结合外层，共加载出100条热评-->'+
								'<input type="hidden" name="user_id" value="${applicationScope.CurrentUser.user_id}" /><!--评论人的user_id隐藏域，暂时未使用，后续可能使用-->'+
								'<a class="jie-user" href=""> <img '+
									'src="${applicationScope.CurrentUser.head_photo}" alt=""> <cite> <i>我</i> '+
										'<em style="color:#FF9E3F"></em> </cite> </a>'+
								'<div class="detail-hits">'+
									'<span>'+str_time+'</span>'+
								'</div>'+
								'<div >'+
								'<p style="margin-left: 60px;">'+commentcontent+'</p>'+
								'</div>'+
							'</div>	'+						
							'<div class="jieda-reply">'+
								'<input type="hidden" name="comment_id" value="${comment.comment_id }"/><!--该条评论的id，用于评论点赞和评论的再评论，位置不可变动-->'+
								'<span class="jieda-zan zanok" type="zan" style="margin-left: 50px;">'+
									'<i class="layui-icon layui-icon-praise" title="赞"></i><em>'+0+'</em>'+
								'</span>'+
								'<span class="jieda-zan zanok" type="zan"><i '+
								'	class="layui-icon layui-icon-reply-fill " id="comment_for_comment" title="评论"></i><em>'+0+'</em>'+
								'</span>'+
							'</div>'
		)
		$commentdiv.insertAfter($(this).parent().parent());
		comment_flag = 0;
	});
	$("[class='layui-icon layui-icon-reply-fill comment_for_comment']").live("click",function(){
		var id = $(this).prev().val();
		var name = $(this).parent().parent().prev().find("i").text();
		var content = $(this).parent().parent().prev().find("p").text();
		var setcontent = "//@"+name+"："+content;
		$("[class='commentcontent'][id='"+id+"']").val(setcontent);
		comment_flag = 1;
		})
	
		$("[class='layui-icon layui-icon-reply-fill comment_for_comment']").live("click",function(){
		var id = $(this).prev().val();
		var name = $(this).parent().parent().prev().find("i").text();
		var content = $(this).parent().parent().prev().find("p").text();
		var setcontent = "//@"+name+"："+content;
		$("[class='commentcontent'][id='"+id+"']").val(setcontent);
		comment_flag = 1;
		})

	
		//实现提交回答post到后端数据库
	function submit_ans(text)
	{
		//获取文本框中元素的value值,重新绑定一下再传
		var ans_text = text;
		var user_id = "${applicationScope.CurrentUser.user_id }";
		var question_id = "${Question.question_id}";
		var ans_time = getTimeIntoDB();
		
		//1.new
		var xhr = new XMLHttpRequest();
		//2.open
		//注意与get方法时对比，在第二个参数后面不能加？。应该将传递到后台的参数用send()方法传递
		xhr.open('post','submitAnswer',true);
		//3.send
		//需要加一个头文件，才能用post提交
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//xhr.send(JSON.stringify(data));
		xhr.send('ans_text='+ans_text+'&user_id='+user_id+'&question_id='+question_id+'&ans_time='+ans_time);
		//xhr.send('question_id='+question_id);
		//4.回调
		xhr.onload = function()
		{
			//弹出回答成功提示窗口
			layui.use(['layer', 'form'], function(){
	  		var layer = layui.layer
	  			,form = layui.form;
	  			layer.msg('回答成功！');
			});
		}
	}

	//实现收藏问题post到数据库，相应问题的收藏量+1-1用触发器实现
	function clickfavorite(flag)
	{
		//获取文本框中元素的value值,重新绑定一下再传
		var user_id = "${applicationScope.CurrentUser.user_id }";//登陆者id
		var question_id =  $("[name='question_id']").val();//获取这个问题的id
		var the_flag = flag;
		//1.new
		var xhr = new XMLHttpRequest();
		
		//2.open
		//注意与get方法时对比，在第二个参数后面不能加？。应该将传递到后台的参数用send()方法传递
		xhr.open('post','favoriteQues',true);
		//3.send
		//需要加一个头文件，才能用post提交
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//xhr.send(JSON.stringify(data));
		xhr.send('flag='+the_flag+'&user_id='+user_id+'&question_id='+question_id);
		//xhr.send('question_id='+question_id);
		//4.回调
		xhr.onload = function(){}
	}
	



</script>


<script>
	//实现右侧图片轮播的效果
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;

  //图片轮播
  carousel.render({
    elem: '#test10'
    ,width: '330px'
    ,height: '200px'
    ,interval: 2000
  });
  
  
  var $ = layui.$, active = {
    set: function(othis){
      var THIS = 'layui-bg-normal'
      ,key = othis.data('key')
      ,options = {};
      othis.css('background-color', '#5FB878').siblings().removeAttr('style'); 
      options[key] = othis.data('value');
      ins3.reload(options);
    }
  };
  
  //监听开关
  form.on('switch(autoplay)', function(){
    ins3.reload({
      autoplay: this.checked
    });
  });
    
});
</script>
<script>
	$(function(){
		try {
		  var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
		  var recognition = new SpeechRecognition();
		}
		catch(e) {
		  console.error(e);
		  $('.no-browser-support').attr('style','display: block');
		  alert("想不到吧，调用不了API");
		}
		
		
		//var noteTextarea = $('#note-textarea');
		var noteTextarea = $('#L_content');
		var instructions = $('#recording-instructions');
		
		var noteContent = '';
		
		/*-----------------------------
		      语音识别 
		------------------------------*/
		
		recognition.continuous = true;//使用户在录入语音时能有更长的停顿时间，大约15秒
		
		recognition.onresult = function(event) {
		
		  // event 是一个SpeechRecognitionEvent 对象
		  // 保存了所有历史捕获对象 
		  // 我们只取当前的内容
		  var current = event.resultIndex;
		
		  // 获取此前所说话的记录
		  var transcript = event.results[current][0].transcript;
		
		  // 将当前记录添加到笔记内容中
		  // 解决安卓设备的bug
		  var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);
		
		  if(!mobileRepeatBug) {
		  	layedit.sync(index);
		    noteContent += transcript;
		    noteTextarea.val(noteContent);
		    layedit.sync(index);//将富文本编辑器的内容同步到textarea
		    layedit.setContent(index,noteContent); 
		  }
		};
		
		recognition.onstart = function() { 
		  instructions.text('语音识别功能激活！请对着麦克风讲话。');
		}
		
		recognition.onspeechend = function() {
		  instructions.text('录音结束。');
		}
		
		recognition.onerror = function(event) {
		  if(event.error == 'no-speech') {
		    instructions.text('未检测到语音，请再试一次。');  
		  };
		}
		
		/*-----------------------------
		      应用功能按钮与输入 
		------------------------------*/
		
		$('#start-record-btn').on('click', function(e) {
			 
		  if (noteContent.length) {
		    noteContent += ' ';
		    layedit.setContent(index,noteContent); 
		  }
		  recognition.start();
		 
		});
		
		
		$('#pause-record-btn').on('click', function(e) {
			
			layedit.setContent(index,noteContent); 
		  recognition.stop();
		  instructions.text('语音识别暂停。');
		  layedit.sync(index);
		});
		
		// 同步文本框文本与noteContent变量
		noteTextarea.on('input', function() {
		 
		  noteContent = $(this).val();
		  layedit.setContent(index,noteContent); 
		  layedit.sync(index);//将富文本编辑器的内容同步到textarea
		})
	})
</script>