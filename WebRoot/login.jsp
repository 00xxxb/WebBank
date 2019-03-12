<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script>
"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"7789",secure:"7794"},
		c={nonSecure:"http://",secure:"https://"},
		r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},
		n="https:"===window.location.protocol?"secure":"nonSecure";
		script=e.createElement("script"),
		script.type="text/javascript",
		script.async=!0,
		script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",
		e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);
</script>
</head>
	<script language="javascript">
		function check1() {
			var f = document.start;
			if(f.userName.value=="") {
				alert("请输入用户名");
				return false;
			}
			if(f.userPassword.value=="") {
				alert("密码不能为空");
				return false;
			}else {
				with(document.start) {
					action="bank.login"
					method="post"
					submit();
				}
			}
		}
		function check2() {
			var url="<%=path %>/Register.jsp";
			window.location.href=url;
		}
		function check3() {
			var f = document.start;
			if(f.userName.value=="") {
				alert("请输入管理员账号");
				return false;
			}
			if(f.userPassword.value=="") {
				alert("密码不能为空");
				return false;
			}else {
				with(document.start) {
					action="administrator.do"
					method="post"
					submit();
				}
			}		
		}
		
	</script>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/WebBankDemo/WebRoot/login.jsp">
<style type="text/css" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/WebBankDemo/WebRoot/login.jsp">
	body{
		background-image:url(timg.jpg);
		background-size:cove;
	}
</style>
<br><br><br><br><br><br>
<div align ="center">
<div style = "width:300px;">
	<fieldset>
	<legend><h2 style="color:teal;">欢迎登录网上银行</h2></legend>
	<form  name = "start" id = "start" >
			<h3 style="color:#421FFF">姓名:<input type="text" name="userName" id="userName"></h3>
			<h3 style="color:#421FFF">密码:<input type="passWord" name="userPassword" id="userPassword"></h3>
			<h3 style="color:#421FFF"><input type="button" value="登录" name="login" onClick="check1()"></h3>
			<h3 style="color:#421FFF"><input type="button" value="管理员登录" name="login1" onClick="check3()"></h3>
			<h3 style="color:#421FFF"><input type="button" value="注册" name="register" onClick="check2()"></h3>
			
	</form>
	<!-- 异常信息 /用户不存在/密码错误-->
	<h3><font color=red>
	${ex}
	</font>
	</h3>
	</fieldset>
</div>	
</div>	
</body>
</html>
