<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="pande.png">
    <title>社团管理</title>
</head>
<link href="css/regist.css" type="text/css" rel="stylesheet" />
<!-- js files -->
	<script src="js/regist.js"></script>
<!-- /js files -->
</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>注册</h1><br>
            <c:if test="${param.rs =='success' }"><font color="blue">&nbsp;&nbsp;&nbsp;<b font size = "4px" color=blue>注册成功，请登录</b></font></c:if>
            <c:if test="${param.rs =='fail' }"><font color="red">&nbsp;&nbsp;&nbsp;<b size="4px" color=red>注册失败，请重新尝试</b></font></c:if>
            <c:if test="${param.rs =='exist' }"><font color="red">&nbsp;&nbsp;&nbsp;<b size="4px" color=red>登录名已存在</b></font></c:if>
   
            <form action="Regist" method="post" name="myfor">
                <input id="name"  name="username" type="text" placeholder="用户名" onblur="checkName();"/>
                <input id="realname" name="userrealname" type="text" placeholder="真实姓名" onblur="checkRealName();" />
                <input id="password" name="userpass" type="password" placeholder="密码" onblur="checkPassword();"/>
                <input id="passwordAgain" name="repass" type="password" placeholder="确认密码" onblur="checkPassword();"/>
                <input id="gender" name="usergender" type="text" placeholder="性别" onblur="checkGender();" />
                <input id="address" name="email" type="text" placeholder="邮箱" onblur="checkAddress"/>
                <input id="tel" name="phone" type="text" placeholder="电话" onblur="checkTel();"/>
                <input id="grade" name="usergrade" type="text" placeholder="年级(大一/大二/大三/大四)" onblur="checkGrade();" />
                <input id="institute" name="userinstitute" type="text" placeholder="所属学院" onblur="checkInstitute();" />
                <input id="dormitory" name="useradd" type="text" placeholder="宿舍地址(xxx栋xxx)" onblur="checkDormitory()" />
                <input type="submit" value="注 册" onclick="registCheck(this)"/>
            	<input name="ope" type="hidden"  value="index"/>
            </form>
            <div id="regst">
                如果您已有账号，请点击这里<a href="login.jsp" class="link">登录</a>
            </div>
        </div>
    </div>

</body>
</html>