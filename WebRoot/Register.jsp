<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Register.jsp' starting page</title>

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
		e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);
		</script>
		</head>
	<script type="text/javascript">
		var xmlHttp;     					//Ajax  核心对象名称
  		function createXMLHttp() {   		//创建XMLHttpRequest核心对象
  			if(window.XMLHttpRequest) {   //判断当前使用的浏览器的类型
  				xmlHttp = new XMLHttpRequest();   //表示使用的是FireFox内核的浏览器
  			}else{								  //表示使用的是IE内核的浏览器
  				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  			}
  		}
  		
     /*
      *焦点验证邮箱是否被注册  
      */
  		function checkEmail() {
  			var email = document.zhuce.email.value;
  			//邮箱格式
  			var myReg =/^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;  
  			if(email=="") {
  				alert("请输入邮箱！");
  				return ;
  			}
  			if(!myReg.test(email)) {
  				alert("请输入正确的邮箱");
  				return ;
  			}
  			createXMLHttp();                          //建立xmlHttp核心对象
  			//设置一个请求，通过地址重写的方式将mail传递到JSP中
  			xmlHttp.open("POST","CheckEmail.html?email="+email);
  			//设置请求完成之后处理的回调函数
  			xmlHttp.onreadystatechange = checkMailCallback;
  			xmlHttp.send(null);             //发送请求，不传递任何参数
  			document.getElementById("msg").innerHTML="正在验证....";
  		}
  		function checkMailCallback() {    //定义回调函数
  			if(xmlHttp.readyState==4) {     //数据返回完毕
  				if(xmlHttp.status==200) {   //Http操作正常
  					var text = xmlHttp.responseText; //接收返回的内容
  					if(text=="true"){   
  						document.getElementById("msg").innerHTML="<font color='#A52A2A'>该邮箱已被注册</font>";
  					}else{
  		//			console.log(text); //F12页面控制台输出
  						document.getElementById("msg").innerHTML="<font color='#7FFF00'>该邮箱可以使用</font>";
  					}
  				}
  			}
  		}
  		
  		/*
  		 *异步发送邮箱验证码
  		 */
  		function checkCode() {
  		    var email = document.zhuce.email.value;
  		    if(email=="") {
  		    	alert("请输入邮箱!");
  		    	return false;
  		    }
  			createXMLHttp();                          //建立xmlHttp核心对象
  			//设置一个请求，通过地址重写的方式将userid传递到JSP中
  			xmlHttp.open("POST","CheckCode.html?email="+email);
  			//设置请求完成之后处理的回调函数
  			xmlHttp.onreadystatechange = checkCodeCallback;
  			xmlHttp.send(null);             //发送请求，不传递任何参数
  			document.getElementById("msg1").innerHTML="正在发送验证....";
  		}
  		function checkCodeCallback() {    //定义回调函数
  			if(xmlHttp.readyState==4) {     //数据返回完毕
  				if(xmlHttp.status==200) {   //Http操作正常
  					var text = xmlHttp.responseText; //接收返回的内容
  					if(text=="true"){   
  						document.getElementById("msg1").innerHTML="<font color='#7FFF00'>发送成功</font>";
  					}else{
  					console.log(text); //F12页面控制台输出
  						document.getElementById("msg1").innerHTML="<font color='#A52A2A'>发送失败</font>";
  					}
  				}
  			}
  		}
  		/*
  		 *异步判断验证码是否正确
  		 */ 
  		function checkverification1() {
  			var yanzheng = document.zhuce.verification1.value;
  			if(yanzheng=="") {
  				alert("验证码不能为空");
  				return false;
  			}
  			createXMLHttp();                          //建立xmlHttp核心对象
  			//设置一个请求，通过地址重写的方式将userid传递到JSP中
  			xmlHttp.open("POST","Checkverification1.html?yanzheng="+yanzheng);
  			//设置请求完成之后处理的回调函数
  			xmlHttp.onreadystatechange = checkverification1Callback;
  			xmlHttp.send(null);             //发送请求，不传递任何参数
  			document.getElementById("msg2").innerHTML="正在验证....";
  		}
  		function checkverification1Callback() {
  			if(xmlHttp.readyState==4) {     //数据返回完毕
  				if(xmlHttp.status==200) {   //Http操作正常
  					var text = xmlHttp.responseText; //接收返回的内容
  					if(text=="false"){   
  						document.getElementById("msg2").innerHTML="<font color='#A52A2A'>验证码错误</font>";
  						return false;
  					}else{
  		//			console.log(text); //F12页面控制台输出
  						document.getElementById("msg2").innerHTML="<font color='#7FFF00'>验证通过</font>";
  					}
  				}
  			}
  		}
  		
  		/*
  		 *前台进行简单的验证
  		 */
		function check1() {
			var f = document.zhuce;
			if(f.userPassword.value =="" || f.userName.value=="") {
				alert("用户名或密码不能为空！");
				return false;
			}
			if(f.userPassword.value.length<6) {
				alert("密码不能少于6位！");
				return false;
			}
			if(f.userPassword.value != f.confirm.value) {
				alert("两次输入的密码不一致！");
				return false;
			}else{
			 with(f) {
					submit();
				}
			}
		}
</script>
 <!-- 背景图片 -->
  <style type="text/css" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/WebBankDemo/WebRoot/login.jsp">
	body{
		background-image:url(pao.jpg);
		background-size:cove;
	}
</style>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/WebBankDemo/WebRoot/Register.jsp">
	<br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/WebBankDemo/WebRoot/Register.jsp">
	
	<div align ="center">
     <div style = "width:450px;">
     <fieldset>
     <legend><h2 style="color:lime;">欢迎注册网上银行</h2></legend>
	<form action="register.html" name="zhuce" id="zhuce" method="post">
		
			<h3>用户名:</h3><input type="text" name="userName">
		
			<h3>密&nbsp;&nbsp;&nbsp;码:</h3><input type="userPassword" name="userPassword">

			<h3>确认密码：</h3><input type="userPassword" name="confirm">
			
			<h3>邮箱:</h3><input type="text" name="email" onblur="checkEmail()"><span id="msg"></span>
			
			<h3>验证码:</h3><input type="text" name="verification1" onblur="checkverification1()"><span id="msg2"></span>
			
			<br><input type="button" name="verification" value="获取验证码" onClick="checkCode()"><span id="msg1"></span>
			
			<br><input type="button" name="register" value="注册" onClick="check1()">
			
			<!-- 异常信息 /用户不存在/密码错误-->
			<h3><font color=red>
			${ex}
			</font>
	</h3>
	</form>
	</fieldset>
	</div>
	</div>
</body>
</html>
