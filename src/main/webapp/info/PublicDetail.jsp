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
    <title>深入课堂，走进学生身边开展支教活动</title>
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
        #container { width:80%; margin:30px auto; text-align:center; padding:10px; border:1px solid #ffffff; height:3200px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color: #000000; text-align:left;}
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
    <h1 align="center">深入课堂，走进学生身边开展支教活动</h1>

    <div id="container">
        <p>上午八时，实践队从驻地出发，步行前往喻河小学。抵达喻河小学后，受到了乡党委副书记，人大主席魏平桥，乡团委书记宁理国，喻河村党支部书记喻遵坤，以及喻河小学校长邓广州的热情接待。
            实践队师生对喻河小学进行了参观，乡党委魏书记介绍了高店乡的经济教育发展现状。他说，目前高店乡的经济结构较为单一，工业基础薄弱，人民生活水平有待提高。
            下月，郑州至武汉高速铁路高店火车站将在本乡开工建设，这将会给高店乡的经济发展带来新的契机。</p>
        <div align="center">
            <img src="images/public1.jpg">
        </div>
        <p>随后，实践队对喻河小学的捐赠仪式开始。魏平桥书记代表乡党委，政府对实践队的到来表示热烈的欢迎，
            他表示，大学生走出学校到乡村进行实践，既有利于拓展视野，把所学专业知识应用到实践中来，也对乡镇的经济发展和教育水平的提高有较好的促进作用。
            随后，乡团委书记宁理国发言，他感谢三院实践队来到大悟进行实践并预祝本次实践活动圆满成功。
            熊娜老师和屈媛媛代表实践队师生进行发言。最后，高尚老师和熊娜老师代表实践队向学校捐赠了图书，笔记本，文具袋等学习用品。在队员们热烈的掌声中，捐赠仪式圆满结束。</p>
        <div align="center">
            <img src="images/public2.jpg">
        </div>
        <p>下午两点半，实践队员分组行动。教育学院队员在喻河小学进行支教活动。
            2015级刘孟卓和2016级的罗猜分别为当地学生讲授英语和数学课。
            刘孟卓从十二个月份的英语单词到组织三人英语小对话，加强了孩子们的英文基础和口语能力，授课风趣幽默，
            学生兴趣浓厚，课堂气氛活跃。社会学院和政治学研究院的队员则继续就农村青少年信息获取途径及农村社区文化建设在高店乡居民中深入开展访谈。
            通过访谈，队员们对当地的风俗习惯，宗教信仰，文化生活等方面有了进一步了解。</p>

        <p>晚饭过后，实践队在乡政府会议室召开总结大会。本次大会由高尚老师主持，分为两个部分。
            首先，三院学生代表对今天的实践活动进行了简短的小结。他们谈到，学生们的个体差异很大，课外知识匮乏，城乡教育发展差距依然较大。
            接着，实践队员依次发言，对三天以来的实践感受进行交流。大家纷纷表示时间虽短，但收获良多，回到学校后将努力学习专业知识，
            以更好地服务社会。最后，高尚老师对队员们的发言进行总结。他表示，暑期实践对大家来说，是一次非常好的锻炼机会，
            希望大家回去后能认真总结，深刻思考，将实践内容转化为今后专业研究的方向，努力成为一名研究型的大学生。</p>
        <div align="center">
            <img src="images/public3.jpg">
        </div>
        <p>八点三十分，总结大会结束。本次实践活动将于7月11日上午结束，返回学校。</p>

        <div align="right">
            <p>（供稿/阳光公益社 摄影/徐彦贝、学生记者：寇振东 编辑/霍晨光）</p>
            <p> 发布机构：阳光公益社 | 责任编辑： | 发布时间：2019-05-21 09:43 | 浏览人次818</p>
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