<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url("#") left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<%--<div><img src="${pageContext.request.contextPath}/header/${member.memberHeader}" width="44" height="44" /></div>--%>
    <span>用户：${member.loginName }<br>角色：管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>用户管理</span>
        <a href="manager_add.jsp" target="mainFrame" onFocus="this.blur()">添加用户</a>
        <a href="manager_update.jsp" target="mainFrame" onFocus="this.blur()">更新密码</a>
        <a href="Query?lru=ulist" target="mainFrame" onFocus="this.blur()">用户列表</a>
      </div>
      <div>
        <span>社团管理</span>
        <a href="community_add.jsp" target="mainFrame" onFocus="this.blur()">添加社团</a>
        <a href="Query?lru=clist" target="mainFrame" onFocus="this.blur()">社团列表</a>
        <a href="activity_add.jsp" target="mainFrame" onFocus="this.blur()">增加活动</a>
        <a href="Query?lru=alist" target="mainFrame" onFocus="this.blur()">活动列表</a>
        <a href="notice_add.jsp" target="mainFrame" onFocus="this.blur()">添加公告</a>
        <a href="Query?lru=nlist" target="mainFrame" onFocus="this.blur()">社团公告</a>
      </div>
      <div>
        <span>审核管理</span>
        <a href="Query?lru=applylist" target="mainFrame" onFocus="this.blur()">社团申请审批</a>
      </div>
    </div>
</body>
</html>