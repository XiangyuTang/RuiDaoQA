<html>
<%@ page  language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<head>

    <title>Insert title here</title>
    <link rel="stylesheet" href="./layui/css/layui.css" type="text/css" media="all">
    <script src="./layui/layui.js" charset="utf-8" type="text/javascript"></script>
    <style>
    .datetime {
    font-size: 14px;
    color: #999;
    margin-top: 4px;
    line-height: 22px;
    }
    </style>

    <script>

        layui.use(['layer', 'form', 'element', 'flow'], function () {
            var layer = layui.layer
                , form = layui.form
                , element = layui.element


            $ = layui.$
            layer.msg('hello');

            $("#ask").on("click", function (e) {
                layer.open({
                    type: 2,
                    offset: 'auto',
                    area: ['50%', '50%'],
                    content: 'toAsk?user_id=2',//这里content是一个普通的String,


                }
                );
            });
            $.ajax({
                async: false,
                url: "showUsersQuestionListServlet",
                data: { user_id: "2" },
                dataType: "json",
                type: "post",
                success: function (data) {
                    for (i = 0; i < data.length; i++) {
                        $("#questionlist").append("<div class='layui-row'> <div class='layui-col-md12'>" +
                            "  <div class='layui-card' style='width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                            " <div class='layui-card-body'>" +
                            "<h1><a href='toDetailQues?question_id="+data[i].question_id+"'</a>"+ data[i].ques_title + "</h1><br>" +
                            "<p>" + data[i].answer_num + "人回答" + "·" + data[i].collect_num + "人收藏" + "</p>" +

                            " <a class='layui-icon layui-icon-edit ' style='color:#01AAED;font-size: 18' href='#'>回答</a> " +
                            "</div></div></div> <hr>")

                    }

                }
            })


          
                $.ajax({
                    async: false,
                    url: "showFavoriteQuestions",
                    data: { user_id: "1" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        for (i = 0; i < data.length; i++) {
                            
                                $("#collectlist").append("<div class='layui-col-md12'>" +
                                    "  <div class='layui-card' style='width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                                    " <div class='layui-card-body'>" +
                                    "<h1><a href='toDetailQues?question_id="+data[i].question_id+"'</a>" + data[i].ques_title + "</h1><br>" +
                                    "<p>" + data[i].answer_num + "人回答" + "·" + data[i].collect_num + "人收藏" + "</p>" +

                                    " <a class='layui-icon layui-icon-edit ' style='color:#01AAED;font-size: 18' href='#'>回答</a> " +
                                    "</div></div></div> <hr>")

                   

                        }
                    }
                })

            




          
                $.ajax({
                    async: false,
                    url: "showUsersAnswerList",
                    data: { user_id: "2" },
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        for (i = 0; i < data.length; i++) {
                            $("#answerlist").append(" <div class='layui-col-md12'>" +
                                " <div class='layui-card' style='width: 100%;height:175px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>" +
                                "  <div class='layui-card-body'>" +
                                " <h1><a href='toDetailQues?question_id="+data[i][0]+"'</a>" + data[i][1] + "</h1><br>" +
                                " <p>" + data[i][2] + "人回答·" + data[i][3] + "人收藏</p>" +

                                "  <a class='layui-icon layui-icon-username' href='#'>" + data[i][4] + "</a><br>" +
                                data[i][5] + "<br><br>" +
                                "  <span style='float: left;width:30%;'>" + data[i][6] + "人评论</span>" +
                                " <span style='float:initial;width:30%'>" + data[i][7] + "人点赞</span>" +
                                " <a class='layui-icon layui-icon-share' style='float: right;cursor: pointer'>分享</a>    </div>  </div>  </div>   <hr>")

                        }
                    }
                })

                $.ajax({
                async: false,
                url: "showMessage",
                data: { user_id: "1" },
                dataType: "json",
                type: "post",
                success: function (data) {
                    for (i = 0; i < data.length; i++) {
                      console.log(data[i]);
                      $("#testlist").append("<div class='layui-col-md12'>"+
                                "<div class='layui-card' style='width: 100%;height:100px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;'>"
                                 +"   <div class='layui-card-body'>"+
                                     "   <h1  >"+" <a href='toDetailQues?question_id="+data[i][0]+"'</a>"+data[i][1]+"评论了你</h1><br>"+
                                       " <p>"+data[i][2]+"</p>"+
                                        " <div class='datetime'>"+ data[i][3]+"</div>"+   "</div>   </div> </div>  <hr>");

                    }

                }
            })



            /* flow.load({
                   elem: '#answerlist',//指定列表容器
                   isAuto: true,
                   end:'牛逼啊',
                   done: function (page, next) { //执行下一页的回调
   
                       //模拟数据插入
                       setTimeout(function () {
                           var lis = [];
                           for (var i = 0; i < 3; i++) {
                               lis.push(`   <hr>
                               <div class="layui-col-md12">
                                   <div class="layui-card"
                                       style="width: 100%;height:175px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">
                                       <div class="layui-card-body">
                                           <h1>你说你帅吗</h1><br>
                                           <p>暂无回答·&{num}人收藏</p>
   
                                           <a class="layui-icon layui-icon-username" href="#">nickname</a><br>
                                           &{commentcontent}<br><br>
                                           <span style="float: left;width:30%">&{cnumber}评论</span>
                                           <span style="float:initial;width:30%">&{fnumber}点赞</span>
                                           <a class="layui-icon layui-icon-share"
                                               style="float: right;cursor: pointer">分享</a>
   
                                       </div>
                                   </div>
                               </div>`)
                           }
   
                           //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                           //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                           next(lis.join(''), page <5); //假设总页数为 10
                       }, 500);
                   }
   

   
               });*//*
         flow.load({
             elem: '#questionlist',//指定列表容器
             isAuto: true,
             end:'牛逼啊',
             done: function (page, next) { //执行下一页的回调

                 //模拟数据插入
                 setTimeout(function () {
                     var lis = [];
                     for (var i = 0; i < 3; i++) {
                         lis.push(`  <hr> <div class="layui-col-md12">
                             <div class="layui-card"
                                 style="width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">
                                 <div class="layui-card-body">
                                     <h1>你说你帅吗</h1><br>
                                     <p>暂无回答·&{num}人收藏</p>
                             
                                     <a class="layui-icon layui-icon-edit " style="color:#01AAED;font-size: 18" href="#">回答</a>

                                 </div>
                             </div>

                         </div>`)
                     }

                     //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                     //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                     next(lis.join(''), page < 5); //假设总页数为 10
                 }, 500);
             }

         }
         );

         flow.load({
             elem: '#collectlist',//指定列表容器
             isAuto: true,
             end:'牛逼啊',

             done: function (page, next) { //执行下一页的回调

                 //模拟数据插入
                 setTimeout(function () {
                     var lis = [];
                     for (var i = 0; i < 3; i++) {
                         lis.push(`  <hr> <div class="layui-col-md12">
                             <div class="layui-card"
                                 style="width: 100%;height:125px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">
                                 <div class="layui-card-body">
                                     <h1>你说你帅吗</h1><br>
                                     <p>暂无回答·&{num}人收藏</p>
                             
                                     <a class="layui-icon layui-icon-edit " style="color:#01AAED;font-size: 18" href="#">回答</a>

                                 </div>
                             </div>

                         </div>`)
                     }

                     //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                     //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                     next(lis.join(''), page < 5); //假设总页数为 10
                 }, 500);
             }

         }
         );*/




            //……
            //你的代码都应该写在这里面
        });</script>
</head>


<body>
    <ul class="layui-nav layui-bg-blue">
        <li class="layui-nav-item">
            <a href="#">控制台<span class="layui-badge">9</span></a>
        </li>
        <li class="layui-nav-item">
            <a id="ask" href="#">提问<span class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item">
            <a href="#"><img src="./images/ceshi.png" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="#">修改信息</a></dd>
                <dd><a href="#">安全管理</a></dd>
                <dd><a href="#">退了</a></dd>
            </dl>
        </li>
    </ul>


    <div clsss="layui-row">

        <div class="layui-col-md3 layui-col-md-offset1"
            style="padding: 30px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">
            <!--这个地方用来显示用户的个人头像，个人介绍，关注，粉丝，以及分享界面-->
            <div class="layui-row">
                <div class="layui-col-md12">
                    <div class="layui-card"
                        style="padding: 30px;background-color: #F2F2F2; display: inline-block; vertical-align: middle;">

                        <div class="layui-card-body">
                            <img src='./images/ceshi.png'><br>
                            <i class="layui-icon layui-icon-username" style="height: 20px;"></i> <span>liubin</span><br>
                            <i class="layui-icon layui-icon-list" style="height: 20px;"></i> <span>我很懒</span><br>
                            <a class="layui-icon layui-icon-edit" style="height: 20px; " href="#">编辑个人信息</a>



                        </div>

                    </div>
                </div>
                <div class="layui-col-md12"><br><br><br></div>
                <div class="layui-col-md4">

                    <div class="layui-card" style="padding: 30px;background-color: #F2F2F2; display: inline-block;
                        vertical-align: middle;">
                        <div class="layui-card-body">

                            关注<br>
                            <i id="follow" name="follow">34</i> </div>
                    </div>

                </div>

                <div class="layui-col-md4 layui-col-md-offset4">

                    <div class="layui-card" style="padding: 30px;background-color: #F2F2F2; display: inline-block;
                        vertical-align: middle;">
                        <div class="layui-card-body">粉丝<br>
                            <i id="fan" name="fan">34</i></div>
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
        </div>


        <div class="layui-col-md4 layui-col-md-offset1" style="width: 30%">
            <!--这个地方用来显示回答提问收藏等可以切换的界面-->
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li class="layui-this">通知</li>
                    <li>回答</li>
                    <li>提问</li>
                    <li>收藏</li>
                    
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show" id="testlist">
                        
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


    </div>


    </div>






</body>

</html>