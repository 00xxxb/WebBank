<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Permission.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="javascript">
  function back() {
			with(document.rrrrr) {
				action="login.html";
				submit();
			}
		}
	</script>
	<!-- 背景 -->
	<style type="text/css" >
	body{
		background-image:url(mmm.jpg);
		background-size:cove;
	}
</style>  
  <body> 
   		<form name="rrrrr" >
   			<table border="1" height="50" >
   				<tr>
   				<td width="1%">id</td>
   				<td width="10%">姓名</td>
   				<td width="10%">权限</td>
   				<td width="10%">修改权限</td>
   				
   				</tr>
   				<c:forEach var="s" items="${list}">
   				<tr>
   				<td>${s.id}</td>
   				<td>${s.name}</td>
   				<td>${s.status}</td>
   				<td>
   					<c:choose>
   						<c:when test="${s.status}">
   							<a href="freeze.do?id=${s.id}">冻结用户</a>
   						</c:when>
   						<c:otherwise>
   							<a href="release.do?id=${s.id}">解除冻结</a>
   						</c:otherwise>
   					</c:choose>
   				</td> 
   				</tr>
   				</c:forEach>
   			</table>
   			<br>&nbsp;&nbsp;&nbsp;&nbsp;
   				<input type="button" onClick="back()" value="返回">
   		</form>
  </body>
</html>
