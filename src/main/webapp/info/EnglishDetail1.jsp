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
    <title>“新生杯”英语演讲比赛海选赛</title>
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
        #container { width:80%; margin:30px auto; text-align:center; padding:10px; border:1px solid #ffffff; height:2600px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color: #000000; text-align:left;}
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
    <h1 align="center">“新生杯”英语演讲比赛海选赛</h1>

    <div id="container">
        <p>11月16日晚六点半，由英语协会主办的哈工大深圳研究生院首届“新生杯”英语演讲比赛决赛在F楼国际报告厅顺利举行。
            本次演讲比赛旨在给每一个热爱英语和演讲的同学提供一个展示自我的舞台，提高同学学习英语的积极性和主动性。英语教研组组长梁秋茹与徐嗣群、朱冬生、李卓、陈曦、胡玉秀等六位英语老师作为评委出席活动。
            经过初赛的激烈角逐，10名选手从近40名报名者中脱颖而出，他们分别是：张斯然、程楹楹、戴杰、胡海啸、孔维刚、梁浩明、李玲、王帅英、张碧仑和曹放。
            决赛分为定题演讲、即兴演讲和评委提问三个环节，其中定题演讲题目为“The Power of Walking”——行走的力量.</p>
        <div align="center">
            <img src="images/english1.jpg">
        </div>
        <p>1号选手张斯然第一个登场，丝毫看不出紧张，顺利完成三个环节，流利的口语、敏捷的反应得到了现场观众热烈的掌声。
            2号选手程楹楹讲述了自己作为志愿者去山村支教的经历，用实际行动诠释了“行走的力量”。她的爱心也得到了评委老师的赞扬。
            来自材料学院的3号选手戴杰一上台就展现出了强大的气场。他流利清楚的发音、抑扬顿挫的语调引发现场观众一片赞叹，强大的舞台表现力更是引发观众一阵阵欢呼。
            尤其是现场唱的几句英文歌，更是将演讲比赛带向了高潮。戴杰的演讲也收获了全场最热烈的掌声。梁老师、徐老师等几个评委老师无不赞叹，并争相在第三个环节向其提问。
            三个环节之后，戴杰优异的表现也得到了老师们充分的肯定。之后出场的四号选手，来自土木与环境学院的胡海啸带来了包括学院老师在内的强大的后援团。
            他用出色的英文发音以及机智幽默的语言征服了现场观众，成为本场比赛最受关注的选手。无论是即兴演讲还是评委提问环节，他都能以自己为例子把问题讲清楚，讲的每一个故事都能调动现场的气氛。
            其制作精美的ppt，更是令人印象深刻。5号选手孔维刚精心制作的ppt很有条理，将“The Power of Walking”诠释得十分到位。
            6号选手梁浩铭同样准备了ppt，他声情并茂的演讲，引起了现场观众的共鸣，也引发了评委们的广泛关注，徐、朱、胡三位老师相继提问。
            8号选手李玲富有表现力的演讲将比赛推向了第二次高潮。她温和的语气、舒缓的节奏，让观众觉得似乎在听英文朗诵，与梁老师的互动更是引发现场掌声不断。9号选手王帅英初赛时就已经展现出强大的实力。
            轻松自如的演讲风格获得评委老师的一致好评。10号选手张碧仑观点新颖，语言流畅，以Dream Vs Reality开始陈述，“Not to escape，just to try”成为现场比赛的最强音。
            最后出场的11号选手曹放顶住了压力，用洪亮的嗓音和清晰自如的口语表达让在场的评委老师和同学记住了他。十位选手发挥出了各自的特点，顺利完成了比赛。</p>
        <div align="center">
            <img src="images/english2.jpg">
        </div>
        <p>经过5个小时的激烈角逐，共有42支代表队获得三等奖，26支代表队获得二等奖，15支代表队获得一等奖，哈尔滨工业大学代表队获得了本次竞赛的冠军。我校代表队凭借扎实的理论知识和较强的实践能力，取得了突破性成绩，获得一等奖1项、二等奖2项、三等奖1项，体现了学校的人才培养质量和大学生的综合能力与素质。
            5月20日晚，大赛颁奖晚会在学校图书馆一楼会议厅举行。艺术学院、电气与信息学院的学生为晚会献上了精彩的文艺演出。黑龙江省计算机学会常务副理事长印桂生，黑龙江省计算机学会竞赛工作委员会主任张国印，ACM/ICPC东北地区赛事指导俞经善，东北农业大学副校长秦智伟、张长利，电气与信息学院党委书记许海峰、院长苏中滨等出席颁奖晚会。
            印桂生在闭幕式上讲话，俞经善对竞赛进行了总结，我校副校长张长利致闭幕词。与会领导嘉宾为获奖团队和个人以及优秀志愿者颁发了奖杯和证书。</p>

        <p>十位选手完成演讲比赛后，英语教研组组长梁秋茹老师对参赛选手进行了点评。
            梁老师高度评价了十位选手优异的表现，她说“Everyone is a winner”，今晚没有失败者，每个参赛选手都是独一无二的。
            我们哈工大的同学不比任何高校的学生差，“We are the best”。梁老师表示，希望能在今年的圣诞Party上再次见到大家。
            最后，梁老师表达了对英语协会工作人员的感谢。</p>
        <div align="center">
            <img src="images/english3.jpg">
        </div>
        <p>据悉，本届英语演讲比赛为哈工大深研院首次举办，由英语协会举办，得到了学院和英语教研组全体老师的鼎力支持，初赛选手的踊跃报名体现出了哈工大深研院研究生们学习英语的浓厚热情和良好的精神风貌，决赛选手标准的发音、流利的口语、清晰自如的表达也充分展现了我院学子较高的英语水平，得到了英语教研组老师们和广大同学的充分认可。</p>

        <div align="right">
            <p>（供稿/English.net协会 摄影/徐彦贝、学生记者：寇振东 编辑/霍晨光）</p>
            <p> 发布机构：English.net协会 | 责任编辑： | 发布时间：2019-05-21 09:43 | 浏览人次818</p>
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
