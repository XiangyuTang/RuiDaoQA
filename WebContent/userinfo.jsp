<html>
<%@ page  language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@page import="com.neu.ruidaoQA.entity.User"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

    <title>Insert title here</title>
    <link rel="stylesheet" href="./layui/css/layui.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/global.css">
    <script src="./layui/layui.js" charset="utf-8" type="text/javascript"></script>
    <script src="./js/admin.js"> </script>
    <style>
        .datetime {
            font-size: 14px;
            color: #999;
            margin-top: 4px;
            line-height: 22px;
        }
    </style>

    <script>

        layui.use(['layer', 'form', 'element', 'flow', 'laypage'], function () {
            var layer = layui.layer
                , form = layui.form
                , element = layui.element
                , laypage = layui.laypage


            $ = layui.$
            layer.msg('hello');

            $("#ask").on("click", function (e) {
                layer.open({
                    type: 2,
                    offset: 'auto',
                    area: ['50%', '50%'],
                    content: 'toAsk?user_id=${current_user_id}',//这里content是一个普通的String,


                }
                );
            });
            $("#selectImg").click(function(){
                $("#pic").click();
            })
            $("#showUserMessage").on("click", function (e) {
                alert("nima")
                layer.open({
                    type: 2,
                    scrollbar: false,
                    offeset: 'auto',
                    area: ['80%', '70%'],
                    content: "UserMessageServlet",
                })
            })
            $("#focus").on("click", function (e) {
                alert("nimabi")
                layer.open({
                    type: 2,
                    scrollbar: false,
                    offeset: 'auto',
                    area: ['80%', '70%'],
                    content: "GuanZhuServlet",
                })
            })
            $("#fans").on("click", function (e) {
                alert("nimabi")
                layer.open({
                    type: 2,
                    scrollbar: false,
                    offeset: 'auto',
                    area: ['80%', '70%'],
                    content: "FansMessageServlet",
                })
            })
            $("#3").on("click", function (e) {
                $.ajax({
                    async: false,
                    url: "showUsersQuestionListServlet",
                    data: { user_id: "${current_user_id}" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        var str = ""
                        for (i = 0; i < data.length; i++) {
                            str += "<div class='layui-row'> <div class='layui-col-md12'>" +
                                "  <div class='layui-card' style='width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                                " <div class='layui-card-body'>" +
                                "<h1><a href='toDetailQues?question_id=" + data[i].question_id + "'</a>" + data[i].ques_title + "</h1><br>" +
                                "<p>" + data[i].answer_num + "人回答" + "·" + data[i].collect_num + "人收藏" + "</p>" +

                                " <a class='layui-icon layui-icon-edit ' style='color:#01AAED;font-size: 18' href='#'>回答</a> " +
                                "</div></div></div> <hr>"
                         

                        }
                        $("#questionlist").html(str)
                      

                    }
                })

            })
            $("#4").on("click", function (e) {
                $.ajax({
                    async: false,
                    url: "showFavoriteQuestions",
                    data: { user_id: "${current_user_id}" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        var str = ""
                        for (i = 0; i < data.length; i++) {
                            str += "<div class='layui-col-md12'>" +
                                "  <div class='layui-card' style='width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                                " <div class='layui-card-body'>" +
                                "<h1><a href='toDetailQues?question_id=" + data[i].question_id + "'</a>" + data[i].ques_title + "</h1><br>" +
                                "<p>" + data[i].answer_num + "人回答" + "·" + data[i].collect_num + "人收藏" + "</p>" +

                                " <a class='layui-icon layui-icon-edit ' style='color:#01AAED;font-size: 18' href='#'>回答</a> " +
                                "</div></div></div> <hr>"

                          

                        }
                        $("#collectlist").html(str)
                      

                        
                    }
                })
            }
            )






            $("#2").on("click", function (e) {

                $.ajax({
                    async: false,
                    url: "showUsersAnswerList",
                    data: { user_id: "${current_user_id}" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        var str = ""
                        for (i = 0; i < data.length; i++) {
                            str += " <div class='layui-col-md12'>" +
                                " <div class='layui-card' style='width: 100%;height:175px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                                "  <div class='layui-card-body'>" +
                                " <h1><a href='toDetailQues?question_id=" + data[i][0] + "'</a>" + data[i][1] + "</h1><br>" +
                                " <p>" + data[i][2] + "人回答·" + data[i][3] + "人收藏</p>" +

                                "  <a class='layui-icon layui-icon-username' href='#'>" + data[i][4] + "</a><br>" +
                                data[i][5] + "<br><br>" +
                                "  <span style='float: left;width:30%;'>" + data[i][6] + "人评论</span>" +
                                " <span style='float:initial;width:30%'>" + data[i][7] + "人点赞</span>" +
                                " <a class='layui-icon layui-icon-share' style='float: right;cursor: pointer'>分享</a>    </div>  </div>  </div>   <hr>"
                          
                        }
                        $("#answerlist").html(str)
                      
                    }
                })
            })


            $("#1").on("click", function (e) {
                $.ajax({
                    async: false,
                    url: "showMessage",
                    data: { user_id: "${current_user_id}" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        var str = ""
                        for (i = 0; i < data.length; i++) {
                            console.log(data[i]);
                            str += "<div class='layui-col-md12'>" +
                                "<div class='layui-card' style='width: 100%;height:100px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>"
                                + "   <div class='layui-card-body'>" +
                                "   <h1  >" + " <a href='toDetailQues?question_id=" + data[i][0] + "'</a>" + data[i][1] + "评论了你</h1><br>" +
                                " <p>" + data[i][2] + "</p>" +
                                " <div class='datetime'>" + data[i][3] + "</div>" + "</div>   </div> </div>  <hr>"
                           

                        }
                        $("#testlist").html(str)
                      
                    }
                })
            }
            )










            //……
            //你的代码都应该写在这里面
        });</script>
</head>


<body>
    <%
	    List<Integer> list = (List<Integer>) request.getSession().getAttribute("List");
    
		
    %>

    <div class="header">
        <div class="main">
            <a class="title" href="index.jsp" target="_parent" title="睿道QA">

                <img src="images/logo.png" height="60" width="80" />

                <i class="iconfont icon-jiaoliu layui-hide-xs" style="font-size: 22px;"></i>
                &nbsp;&nbsp;睿道QA</a>

            <form action="searchQues" class="fly-search">
                <input class="layui-input" autocomplete="off" placeholder="搜索你感兴趣的内容" type="text" name="q">
                <i class="iconfont icon-sousuo"></i>
            </form>

            <div class="fly-tab" style="margin-top:20px">
                <a id="ask" target="_parent" class="layui-btn jie-add">发布问题</a>
            </div>

            <i class="layui-icon icon-jiaoliu layui-hide-xs" style="font-size: 22px;"></i>


            <div class="nav">
                <a class="nav-this" href="index.jsp">
                    <i class="iconfont icon-wenda"></i>欢迎使用</a>
            </div>

            <div class="nav-user">
                <a class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;">
                </a>
                <div class="nav" style="font-size:14px;color: white;margin-top: -5px;margin-left: 1px; ">
                    <a href="login.html" target="_parent">登录</a>
                    <a href="register.html" target="_parent">注册</a>
                </div>
            </div>
            <div class="nav-user" hidden="hidden">
                <a class="avatar" href="">
                    <img src="images/头像1.JPG">
                    <cite>老汉</cite>
                </a>
                <div class="nav">
                    <a href="index.jsp" target="_parent"><i class="iconfont icon-tuichu"
                            style="top: 0; font-size: 22px;"></i>退出</a>
                </div>
            </div>
        </div>
    </div>
    <div clsss="layui-row" style="margin-top:65px" >



        <div class="layui-col-md2 layui-col-md-offset2"
            style="padding: 30px;background-color: #F2F2F2; display: inline-block;
            vertical-align: middle;position:relative;"
            >
            <!--这个地方用来显示用户的个人头像，个人介绍，关注，粉丝，以及分享界面-->

          


                <div class="layui-col-md12;margin:0 auto; position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%,-50%);">
                    <div class="layui-card"
                        style="padding: 30px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">

                        <div class="layui-card-body">



                            <%-- <img class="layui-nav-img" src="<%=path %>" /> --%>

                            <img style="width: 100px;
                                height: 100px;
                                border-radius: 50px;" id="selectImg" src="${CurrentUser.getHead_photo()}"><br>
                            <form action="UploadServlet" method="post" enctype="multipart/form-data">

                                <input type="file"   id="pic" name="pic" style="display: none"><br>
                                <input style="text-align:center" type="submit" class="layui-btn" value="上传" />
                            </form>
                            <i class="layui-icon layui-icon-username" style="height: 20px;"></i>
                            <span style="font-size: 22">${CurrentUser.getNick_name()}</span><hr>
                            <i class="layui-icon layui-icon-list" style="height: 20px;"></i> <span>${CurrentUser.getIntroduce()}</span><hr>
                            <a class="layui-icon layui-icon-edit" id="showUserMessage" style="height: 20px; ">编辑个人信息</a>

                        </div>

                    </div>
                </div>
                <div class="layui-col-md12"><br><br><br></div>
                <div class="layui-col-md4">

                    <div class="layui-card" style="padding: 30px;background-color: #F2F2F2; display: inline-block;  
                        vertical-align: middle;">
                        <div class="layui-card-body">

                            <a id="focus">关注</a><br>
                            <i id="follow" name="follow"><%=list.get(0)%></i> </div>
                    </div>

                </div>

                <div class="layui-col-md4 layui-col-md-offset4">

                    <div class="layui-card" style="padding: 30px;background-color: #F2F2F2; display: inline-block;
                        vertical-align: middle;">
                        <div class="layui-card-body"><a id="fans">粉丝</a><br>
                            <i id="fan" name="fan"><%=list.get(1)%></i></div>
                    </div>
                </div>
                <div class="layui-col-md12"><br><br><br></div>
                <div class="layui-col-md12">
                    <i class="layui-icon layui-icon-share"
                        style="height: 20px;cursor: pointer;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                        class="layui-icon layui-icon-login-wechat"
                        style="height: 20px;cursor: pointer;"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                        class="layui-icon layui-icon-login-qq" style="height: 20px;cursor: pointer;"></a>
                </div>
            
        </div>



        <div class="layui-col-md4 layui-col-md-offset1" style="width: 30%">
            <!--这个地方用来显示回答提问收藏等可以切换的界面-->
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li class="layui-this" id="1">通知</li>
                    <li id="2">回答</li>
                    <li id="3">提问</li>
                    <li id="4">收藏</li>

                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-row" id="testlist">
                        </div>

                    </div>



                    <div class="layui-tab-item">

                        <div class="layui-row" id="answerlist">
                        </div>
                    </div>

                    <div class="layui-tab-item">
                        <div class="layui-row" id="questionlist">



                        </div>


                    </div>

                    <div class="layui-tab-item">
                        <div clsss="layui-row" id="collectlist">
                        </div>
                    </div>

                </div>



            </div>
        </div>

    </div>









</body>

</html>