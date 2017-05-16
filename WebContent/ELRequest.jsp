<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ELDemo.jsp" method="get">
		<!-- 提交后，本页面的参数打包发送，用EL表达式直接取参数 -->
		p1: <input type="text" name="p1" /> 
		    <br> 
		p2: <input type="text" name="p2" />  
		    <br> 
		empId: <input type="text" name="p_empId" />
		<br> 
		tel_no: <input type="text" name="tel_no" value="req_tel_no" />
		    <br> 
		    <input type="submit" value="submit" />
	</form>
</body>
</html>