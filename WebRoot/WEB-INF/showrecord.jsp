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
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
		function Previouspage() {
			var f = document.rrrrr;
			var pags =  '${page-1}';
			console.info(pags);
			if(pags<1) {
				alert("已经是首页了！");
				return false;
			}else {
				with(f) {
					action="record.do?pags="+pags;
					method="post";
					submit();
				}
			}
		}
		function nextPage() {
			var f = document.rrrrr;
			var totalPages ='${totalPages}';
			var pags ='${page+1}';
			console.info(pags);
			
			if(Number(pags)>Number(totalPages)) {
				alert("最后一页了！");
				return false;
			}else {
				with(f) {
					action="record.do?pags="+pags;
					method="post";
					submit();
				}
			}
		}
		
		function back() {
			with(document.rrrrr) {
				action="bank.inquiry";
				submit();
			}
		}
	</script>
	<!-- 背景 -->
	<style type="text/css" >
	body{
		background-image:url(qing.jpg);
		background-size:cove;
	}
</style>  
  <body> 
   		<form name="rrrrr" >
   			<table border="1" height="22" >
   				<tr>
   				<td width="10%">序号</td>
   				<td width="10%">信息</td>
   				<td width="10%">金额</td>
   				<td width="10%">时间</td>
   				
   				</tr>
   				<c:forEach var="s" items="${list}">
   				<tr>
   				<td>${s.id}</td>
   				<td>${s.mes}</td>
   				<td>${s.money}</td>
   				<td>${s.time}</td> 
   				</tr>
   				</c:forEach>
   			</table>
   				${page}/${totalPages}页	
   				<input type="button" name="bto" value="上一页" onClick="Previouspage()">
   				<input type="button" name="btto" value="下一页" onClick="nextPage()">
   				<input type="button" onClick="back()" value="返回">
   		</form>
  </body>
  
</html>
