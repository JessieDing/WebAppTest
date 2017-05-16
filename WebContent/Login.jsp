<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户登录</h1>
	<hr>
	<%-- <%
		Cookie[] cs = request.getCookies();
		String userName = "";
		String password = "";
		if (cs != null) {
			for (Cookie c : cs) {
				if (c.getName().equals("userName")) {
					userName = URLDecoder.decode(c.getValue(), "utf-8");
				}
				if (c.getName().equals("password")) {
					password = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
	%> --%>
	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>密 码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置" /></td>
				<td><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
</body>
</html>