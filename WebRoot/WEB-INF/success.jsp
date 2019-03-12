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

<title>My JSP 'success.jsp' starting page</title>

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
	
	<script language="javascript">
		function withdrawals() {
			var f = document.qukuan;
			 var re = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/; //判断字符串是否为数字  //判断正整数 /^[[1-9]+[0-9]*]*$/
			 if(!re.test(f.money.value)) {
			 	alert("无效的取款金额");
			 	return false;
			 }
			 else if(f.money.value >=10000) {
			 	alert("单次操作不能取多余1万！");
			 	return false;
			 }
			  f.submit(); 
		}
		function deposit() {
			var f = document.cunkuan;
			var re = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
			if(!re.test(f.money.value)) {
				alert("无效的取款金额");
				return false;
			}
			if(f.money.value < 0) {
				alert("取款金额必须大于0");
				return false;
			}
			f.submit();
		}
		
		function transfer() {
			var f = document.zhuanzhang;
			if(f.name.value=="") {
				alert("请输入转账用户");
				return false;
			}
			var re =  /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
			if(!re.test(f.money.value)) {
				alert("无效的转账的金额");
				return false;
			}
			if(f.money.value < 0) {
				alert("无效的转账金额");
				return false;
			}
			f.submit();
		}
	</script>
	<!-- 改变背景 -->
	<style type="text/css" >
	body{
		background-image:url(yy.jpg);
		background-size:cove;
	}
</style>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-6" data-genuitec-path="/WebBankDemo/WebRoot/success.jsp">

	
	<center>
		<h1>请选择您的操作</h1>
	</center>
	<hr>

	<h2>
		<form action="bank.inquiry" method="post">
		查看余额：
			<input type="submit" value="查询">
		</form>
	</h2>
	${sessionScope.get("Inquire")}
	<!-- 异常信息 /-->
	<h3><font color=red>
	${ex}
	</font>
	</h3>

	<hr>
	<h2>
		<form action="bank.withdrawals" name="qukuan" method="post">
			取款：<input type="text" name="money"> <input
				type="button" value="取款" onClick="withdrawals()">
		</form>
	</h2>  
	<hr>

	<h2>
		<form action="bank.deposit" name="cunkuan" method="post">
			存款：<input type="text" name="money"> <input type="button"
				value="存款" onClick="deposit()">
		</form>
		
		<body>
	</h2>
	<hr>
	<!-- 转账 -->
	<h2>
		<form action="bank.transfer" name="zhuanzhang" method="post">转账用户 ：<input
			type="text" name="name"> 转账：<input type="text" name="money">
		<input type="button" value="转账" onClick="transfer()"> </form>
	</h2>
	
	<hr>
		<!-- 消费记录 -->
		<h2>
		<form action ="record.do" method="post">
		消费记录：
			<input type ="submit" value="查看消费">
		</form>
		</h2>	
	<hr>
		<!-- 退出。。。 -->
		<h2>
		<form action ="bank.exitSystem" method="post">
	                           退出系统<input type="submit" value="退出">
		</form>
		</h2>
	<hr>
</body>
</html>
