<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>举办大学生“Oracle"甲骨文ACM竞赛</title>
    <link rel="icon" href="images/pande.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Exchange Education a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- css files -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/chromagallery.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

    <style type="text/css">
        #container { width:80%; margin:30px auto; text-align:center; padding:10px; border:1px solid #ffffff; height:1800px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color: #000000; text-align:left;}
        .noticeList { width:80%; list-style:inside; position:absolute; top:270px; left:10px;}
        .noticeList li { padding-bottom:5px;}
        .noticeList li a { color:#606060; text-decoration:none;}
        .noticeList li a:hover { color:#09F;}
    </style>

    <!-- /css files -->
    <!-- fonts -->
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
    <!-- /fonts -->
    <!-- js files -->
    <script src="js/modernizr.custom.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/speech/jQuery.speech.js"></script>
    <script src="js/speech/jQuery.speech.min.js"></script>
    <script src="js/backtotop.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/SmoothScroll.min.js"></script>
    <!-- /js files -->
</head>

<body id="index.html" data-spy="scroll" data-target=".navbar" data-offset="60">
<!-- Top Bar -->
<section class="top-bar">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <a href="#index.html" class="logo"><h1>多彩社团生活</h1></a>
            </div>

            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <ul class="social-icons1">
                    <c:if test="${login != null}">
                        <li class="y-in"><a href="/admin/userapply.jsp">欢迎：${login.loginName }</a></li>
                        <li><a href="/admin/manager_update.jsp"> | 更新密码</a></li>
                        <li class="y-in"><a href="/MemberInfo?mname=${login.loginName}"> | 个人信息</a></li>
                        <li><a href="loginOut"> | 注销</a></li>
                    </c:if>

                </ul>
            </div>

        </div>
    </div>
</section>
<!-- /Top Bar -->
<!-- Navigation Bar -->
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top cl-effect-21">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">多彩社团</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index2.jsp">首页</a></li>
                        <li><a href="index2.jsp#tech">科技学术</a></li>
                        <li><a href="index2.jsp#services">理论研究</a></li>
                        <li><a href="index2.jsp#gallery">公益服务</a></li>
                        <li><a href="index2.jsp#contact">文艺体育</a></li>
                        <li><a href="index2.jsp#curriculum">试运行</a></li>
                        <li><a href="index2.jsp#notice">公告</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- /Navigation Bar -->
<!-- Banner Section -->
<!-- Carousel
   ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    </ol>
    <div>
        <div class="item active">
            <img class="first-slide" src="images/banner1.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                </div>
            </div>
        </div>
    </div>
</div><!-- /.carousel -->
<!-- /Banner Section -->
<section>

    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 style="color: #FFFFFF">a</h1>
    <h1 align="center">大学生“Oracle"甲骨文ACM竞赛在我校举行</h1>

    <div id="container">
        <p>5月19日上午，由ACM/ICPC中国•黑龙江省大学生程序设计竞赛组织委员会和黑龙江省计算机学会主办，东北农业大学承办的“ACM/ICPC中国•黑龙江省第八届大学生程序设计竞赛”在我校成栋楼二楼多功能厅拉开帷幕。
            黑龙江省教育厅高教处处长丁哲学，黑龙江省计算机学会副理事长李金宝，ACM/ICPC东北地区赛事指导俞经善、组委会专家委员孙大烈、朴秀峰，甲骨文黑龙江学习中心项目总监孙文弼，东北农业大学副校长秦智伟、张长利，
            教务处处长王杜春、实验室管理处处长于雷、电气与信息学院党委书记许海峰、院长苏中滨等出席了开幕式。开幕式由许海峰主持。</p>
        <div align="center">
            <img src="images/computer1.jpg">
        </div>
        <p>秦智伟在会上致开幕词，丁哲学、李金宝、孙文弼分别在开幕式上讲话。省计算机学会竞赛专委会委员唐远新、哈尔滨工程大学何云倩、东北农业大学金鑫分别代表教练、参赛选手和志愿者发言。
            电气与信息学院副院长房俊龙宣读了竞赛规程。本次竞赛共有23所省内高校、1所省外高校（北京航空航天大学）、3所高级中学（哈三中、师大附中、佳木斯一中）的143支代表队参赛，创该项赛事开展以来参赛高校最多、队伍数量最多、参赛人数最多三项纪录。</p>
        <div align="center">
            <img src="images/computer2.jpg">
        </div>
        <p>经过5个小时的激烈角逐，共有42支代表队获得三等奖，26支代表队获得二等奖，15支代表队获得一等奖，哈尔滨工业大学代表队获得了本次竞赛的冠军。我校代表队凭借扎实的理论知识和较强的实践能力，取得了突破性成绩，获得一等奖1项、二等奖2项、三等奖1项，体现了学校的人才培养质量和大学生的综合能力与素质。
            5月20日晚，大赛颁奖晚会在学校图书馆一楼会议厅举行。艺术学院、电气与信息学院的学生为晚会献上了精彩的文艺演出。黑龙江省计算机学会常务副理事长印桂生，黑龙江省计算机学会竞赛工作委员会主任张国印，ACM/ICPC东北地区赛事指导俞经善，东北农业大学副校长秦智伟、张长利，电气与信息学院党委书记许海峰、院长苏中滨等出席颁奖晚会。
            印桂生在闭幕式上讲话，俞经善对竞赛进行了总结，我校副校长张长利致闭幕词。与会领导嘉宾为获奖团队和个人以及优秀志愿者颁发了奖杯和证书。</p>
        <div align="center">
            <img src="images/computer3.jpg">
        </div>
        <p>据悉，被誉为计算机领域“奥林匹克”的ACM 国际大学生程序设计竞赛（ACM International Collegiate Programming Contest，简称ACM-ICPC），是由国际计算机界历史悠久、颇具权威性的组织 ACM(Association of Computing Machinery)主办的活动之一，是世界上公认的规模最大、水平最高的国际大学生程序设计竞赛，其目的是让大学生充分展示自己运用计算机来分析问题和解决问题的能力。
            ACM-ICPC从1970年以来已成功举办了36届，现已成为世界各国大学生最具影响力的国际级计算机赛事，是广大爱好计算机编程的大学生特别是计算机、软件类大学生展示才华的舞台。</p>

        <div align="right">
            <p>（供稿/计算机协会 摄影/徐彦贝、学生记者：寇振东 编辑/霍晨光）</p>
            <p> 发布机构：计算机协会 | 责任编辑： | 发布时间：2019-05-21 09:43 | 浏览人次818</p>
        </div>
    </div>
</section>
<!-- Footer Section -->
<section class="footer">
    <h2 class="text-center">THANKS FOR VISITING US</h2>
    <p>
        <a href="#" target="_blank">大学官网</a>|
        <a href="#" target="_blank">大学教务处</a>|
        <a href="#" target="_blank">大学网络中心</a>
    </p><br>
    <p></p>
    <div id="Result">

    </div>

</section>
<!-- /Footer Section -->
<!-- Back To Top -->
<a href="#0" class="cd-top">Top</a>
<!-- /Back To Top -->
<!-- js files -->
</body>
</html>