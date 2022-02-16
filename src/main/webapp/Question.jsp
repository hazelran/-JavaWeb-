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
    <title>社团活动兴趣倾向调查问卷</title>
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
        #container { width:80%; margin:30px auto; text-align:center; padding:10px; border:1px solid #ffffff; height:1550px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color: #000000; text-align:left;}
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
    <h1 align="center">社团活动兴趣倾向调查问卷</h1>

    <div id="container">
        <p align="left" style="color: #4e4e4e">亲爱的同学：</p>
        <p style="color: #4e4e4e">你好！我们正在对"学生对社团活动兴趣倾向"进行调查，旨在了解我校学生对于社团活动的兴趣意向，
        调动参与社团活动的积极性，以便更好地组织开展服务员工社团活动。感谢您抽出宝贵的时间来完成本次调查问卷。
        在此向您承诺：本次调查采取匿名方式，只作为研究参考之用，不会对外公开，请您安心回答。
        进行调查问卷时，请选择相应答案，不要遗漏任何一题，衷心感谢您对我们的支持和配合！</p>

        <br/><br/>

        <form action="${pageContext.request.contextPath}/Question" method="get" id="q1">
            1. 我校目前共有四大分类13个社团，请问您对以下哪种类别的社团更感兴趣呢？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q1" type="radio" value="科技创新类" />科技创新类（如：天文地理协会）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q1" type="radio" value="理论研究类" />理论研究类（如：English.net协会）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q1" type="radio" value="社会服务类" />社会服务类（如：阳光公益社）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q1" type="radio" value="体育竞技类" />体育竞技类（如：兵乓球协会）</label><br/>

            <br/>

            2. 学生社团的活动形式一直是我们所重视的，学生需要的形式是我们要改革的方向，请问您喜欢以下哪种社团活动开展方式？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q2" type="radio" value="授课型" />授课型（如：唱歌、舞蹈、书法等）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q2" type="radio" value="实践型" />实践型（如：球类运动、趣味运动、棋类运动等）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q2" type="radio" value="歌舞型" />歌舞型（如：职业规划指导、志愿者服务、支教等）</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q2" type="radio" value="比赛型" />比赛型（如：数学竞赛、天文知识竞赛、计算机技能大赛）</label><br/>

            <br/>

            3. 您更倾向于参加多大规模人员的社团活动？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q3" type="radio" value="20以内" />20以内</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q3" type="radio" value="20-50" />20-50</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q3" type="radio" value="51-100" />51-100</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q3" type="radio" value="100以上" />100以上</label><br/>

            <br/>

            4. 您在参加社团活动时更倾向于独立进行还是合作进行？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q4" type="radio" value="独自进行" />独自进行</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q4" type="radio" value="团体进行" />团体进行</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q4" type="radio" value="均可" />均可</label><br/>

            <br/>

            5. 下列对社团的描述，您更赞同哪一点？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q5" type="radio" value="兴趣" />社团是兴趣相投的人聚在一起，对社团没什么要求</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q5" type="radio" value="能力" />相比于其他学习组织，社团更能锻炼自己的能力</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q5" type="radio" value="社会" />社团更应该提供与外面接触的机会，了解社会实际情况</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q5" type="radio" value="学校" />社团要配合学校工作，辅助对学生进行辅导，管理</label><br/>

            <br/>

            6. 您觉得一个社团怎样才算有吸引力？<br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q6" type="radio" value="实践" />实践型强</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q6" type="radio" value="创新" />创新性强可以展示学生才华</label><br/>
            &nbsp;&nbsp;<label style="font-weight: normal"><input name="q6" type="radio" value="娱乐" />纯属以娱乐、休闲为主</label>

            <br/><br/>

            <div style="align-content: center">
                <input type="submit" value="提交问卷"  />
            </div>

        </form>
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
