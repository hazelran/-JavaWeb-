<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link rel="icon" href="images/pande.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/css.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url("#") no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #search a.add{ background:url("#") no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
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
        .bggray{ background:#f9f9f9}

    </style>
</head>
<script>
    function delUser(a) {
        if (confirm("您确定删除吗？")) {
            document.getElementById('del'+a).submit()
        }
    }
</script>

<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：审核管理&nbsp;&nbsp;>&nbsp;&nbsp;入团申请审核</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a  target="mainFrame"  class="">审核</a>
            <c:if test="${param.rs =='namewrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b></b></font></c:if>
            <c:if test="${param.rs =='success' }"><font -size="4px"; color=blue>&nbsp;&nbsp;&nbsp;<b>已通过</b></font></c:if>
            <c:if test="${param.rs =='fail' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>已拒绝</b></font></c:if>
            <c:if test="${param.rs =='wrong' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>操作失败</b></font></c:if>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <%--    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">--%>
            <%--  		<tr>--%>
            <%--   		 <td width="90%" align="left" valign="middle">--%>
            <%--	         <form method="post" action="Search">--%>
            <%--	         <span>成员：</span>--%>
            <%--	         <input type="text" name="name" value="" class="text-word">--%>
            <%--	         <input type="hidden" name="search" value="member"/>--%>
            <%--	         <input name="" type="submit" value="查询" class="text-but">--%>
            <%--	         </form>--%>
            <%--         </td>--%>
            <%--  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="manager_add.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增成员</a></td>--%>
            <%--  		</tr>--%>
            <%--	</table>--%>
        </td>
    </tr>

    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab" >
                <tr>
                    <th align="center" valign="middle" class="borderright">编号</th>
                    <th align="center" valign="middle" class="borderright">登录名</th>
                    <th align="center" valign="middle" class="borderright">姓名</th>
                    <th align="center" valign="middle" class="borderright">性别</th>
                    <th align="center" valign="middle" class="borderright">年级</th>
                    <th align="center" valign="middle" class="borderright">学院</th>
                    <th align="center" valign="middle" class="borderright">申请社团</th>
                    <th align="center" valign="middle">操作</th>
                </tr>

                <c:forEach items="${applys }" var="member" varStatus="status">
                    <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'" >
                        <td align="center" valign="middle" class="borderright borderbottom"> ${status.index+1 }</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.loginName }</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.member_name }</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.member_gender}</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.member_grade}</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.member_institute}</td>
                        <td align="center" valign="middle" class="borderright borderbottom">${member.community_name}</td>
                        <td align="center" valign="middle" class="borderbottom">
                            <a style="display: block;margin-top: -10px; margin-bottom: -20px" href="${pageContext.request.contextPath}/admin/Update?ope=applyagree&loginname=${member.loginName }&communityId=${member.communityId }" target="mainFrame" onFocus="this.blur()" class="add">同意</a>
                            <a style="display: block;margin-top: -10px; margin-bottom: -20px" href="${pageContext.request.contextPath}/admin/Update?ope=applydelete&loginname=${member.loginName }&communityId=${member.communityId }" target="mainFrame" onFocus="this.blur()" class="add">拒绝</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="fenye">共有${page.itemCont} 条记录，当前${page.pageCurrent}/${page.pageCont}&nbsp; &nbsp;页/分页
            &nbsp; &nbsp; &nbsp;
            <c:choose>
            <c:when test="${page.pageCurrent==1 }">
            <a href="Query?lru=applylist&cpage=${page.pageCurrent }">首页</a>
            <a href="Query?lru=applylist&cpage=${page.pageCurrent }">上一页</a>
            </c:when>
            <c:otherwise>
            <a href="Query?lru=applylist&cpage=1">首页</a>
            <a href="Query?lru=applylist&cpage=${page.pageCurrent-1}">上一页</a>
            </c:otherwise>
            </c:choose>

            <c:choose>
            <c:when test="${page.pageCurrent==page.pageCont }">
            <a href="Query?lru=applylist&cpage=${page.pageCurrent }">下一页</a>
            <a href="Query?lru=applylist&cpage=${page.pageCurrent }">尾页</a>
            </c:when>
            <c:otherwise>
            <a href="Query?lru=applylist&cpage=${page.pageCurrent+1}">下一页</a>
            <a href="Query?lru=applylist&cpage=${page.pageCont}">尾页</a></c:otherwise>
        </c:choose></tr>
</table>
</body>
</html>
