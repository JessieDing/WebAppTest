<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 算数表达式 -->
	<c:set var="example" value="${100+1}" scope="page" />
	<h3>
		<c:out value="${example}" />
	</h3>

	<!-- 创建Bean -->
	<jsp:useBean id="student" class="beans.Student" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="student" param="name" />
	<jsp:setProperty property="age" name="student" param="age" />
	<jsp:setProperty property="fav" name="student" param="fav" />
	<!-- 条件判断标签-->
	<c:if test="${student.valid}">
		<c:out value="success" />
		<br>
	</c:if>
	<c:if test="${!student.valid }">
		<c:out value="fail" />
		<br>
	</c:if>

	<!-- 多个条件判断-->
	<c:if test="${student.valid && student.age>20 }">
	<c:out value="success2222"/>
	<br>
	</c:if>

</body>
</html>