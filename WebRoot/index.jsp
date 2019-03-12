<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"7789",secure:"7794"},
  	c={nonSecure:"http://",secure:"https://"},
  	r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},
  	n="https:"===window.location.protocol?"secure":"nonSecure";
  	script=e.createElement("script"),
  	script.type="text/javascript",
  	script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",
  	e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <style type="text/css" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/WebBankDemo/WebRoot/login.jsp">
	body{
		background-image:url(G.jpg);
		background-size:cove;
	}
</style>
  <body >
  <br><br><br>
     <center><font color=blue>
    	 <h1>欢迎来到网上银行</h1>
    	 </font>
     </center> <br><br>
     <center>
     <a href="login.html"><h3><font color=green>点击进入</h3></font><br>
     </center>
  </body>
</html>


