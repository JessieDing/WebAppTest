<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String errMsg = (String)request.getAttribute("errmsg");
		if (errMsg == null) {
			errMsg = "Error, check program please.";
		}
	%>
	<h1><%=errMsg %></h1>
	<a href="AcctMain.jsp">返回</a>
</body>
</html>