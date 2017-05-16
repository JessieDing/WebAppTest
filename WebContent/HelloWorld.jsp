<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="pub_header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
</head>
<body>
	<form action="hello" method="get">
		UserName:<input type="text" name="username" /> <br>
		PassWord:&nbsp;<input type="password" name="password" /> <br>
		Favorite: <label><input type="checkbox" name="fav"
			value="basketball" />Basketball</label>&nbsp;&nbsp; <label><input
			type="checkbox" name="fav" value="music" />Music</label>&nbsp;&nbsp; <label><input
			type="checkbox" name="fav" value="read" />Read</label><br> <input
			type="submit" value="submit" /><br>
	</form>
</body>
</html>