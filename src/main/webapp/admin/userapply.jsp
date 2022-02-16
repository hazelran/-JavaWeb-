<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>社团申请</title>
    <link rel="icon" href="images/pande.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/css.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url("#") no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #search a.add{ background:url("#") no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
        #search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url("#") repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .bordertop{ border-top:1px solid #ebebeb}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        .borderleft{ border-left:1px solid #ebebeb}
        .gray{ color:#dbdbdb;}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        #addinfo a{ font-size:14px; font-weight:bold; background:url("#") no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background:url("#") no-repeat 0 1px;}
    </style>
</head>
<body>

<!--申请社团-->

<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td align="left" valign="top">
            <a  target="mainFrame"  class="">社团申请</a>
            <c:if test="${param.rs =='successful' }"><font -size="4px"; color=blue>&nbsp;&nbsp;&nbsp;<b>申请成功</b></font></c:if>
            <c:if test="${param.rs =='mNotIn' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>请填写社团名称等信息</b></font></c:if>
            <c:if test="${param.rs =='faile' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>申请失败，请重新尝试</b></font></c:if>
            <c:if test="${param.rs =='had' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>申请失败，请勿重复申请</b></font></c:if>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <!-- 上传文件时 要改enctype="multipart/from-data-->
            <form action="${pageContext.request.contextPath}/Regist?ope=apply" method="post" <%--enctype="multipart/form-data"--%>>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" colspan="4" style="border-left:none; border-right:none;"></td>
                    </tr>

                    <tr>
                        <td align="right" valign="middle" class="borderright borderbottom bggray">登录名：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="loginName" value="${apply.loginName }" class="text-word">
                        </td>

                        <td align="right" valign="middle" class="borderright borderbottom bggray">姓名：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="member_name" value="${apply.member_name }" class="text-word">
                        </td>
                    </tr>

                    <tr>
                        <td align="right" valign="middle" class="borderright borderbottom bggray">性别：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="member_gender" value="${apply.member_gender }" class="text-word">
                        </td>

                        <td align="right" valign="middle" class="borderright borderbottom bggray">年级：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="member_grade" value="${apply.member_grade }" class="text-word">
                        </td>

                    </tr>

                    <tr>

                        <td align="right" valign="middle" class="borderright borderbottom bggray">学院：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="memberInstitute" value="${apply.memberInstitute }" class="text-word">
                        </td>

                        <td align="right" valign="middle" class="borderright borderbottom bggray">加入的社团：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                            <input type="text" name="community_name" value="${apply.community_name}" class="text-word">
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <input name="ope" type="hidden" value="regist"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="2" style="padding-left:38%; border-right:none;">
                            <input name="" type="submit" value="申请" class="text-but" >
                        </td>
                        <td align="center" valign="middle" class="borderright borderbottom main-for" colspan="3" style="padding-right:20%; border-right:none;">
                            <input name="" type="button" value="返回" class="text-but" onclick="location.href='javascript:history.go(-2);'">
                        </td>
                    </tr>

                </table>
                <%--      <c:if test="${param.msg =='ok' }"><script>alert("修改成功")</script></c:if>--%>
            </form>
        </td>
    </tr>
</table>
</body>
</html>