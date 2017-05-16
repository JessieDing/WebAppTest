<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="pub_header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="redirectFwdTest?oper=redirect">Redirect Test</a>
	<br>
	<a href="redirectFwdTest?oper=forward">forward Test</a>
	<br>
	<a href="redirectFwdTest?oper=fwd2">forward Test 2</a>

	<form action="redirectFwdTest" method="post">
		<input type="submit" value="submit">
	</form>

</body>
</html>
