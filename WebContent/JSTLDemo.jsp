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
		<c:out value="success2222" />
		<br>
	</c:if>

	<!-- 多重条件标签 -->
	<c:choose>
		<c:when test="${student.age>=60 }">
			<c:out value="老年人" />
		</c:when>
		<c:when test="${student.age>=35 }">
			<c:out value="中年人" />
		</c:when>
		<c:when test="${student.age>=18 }">
			<c:out value="成年人" />
		</c:when>
		<c:otherwise>
			<c:out value="未成年人" />
		</c:otherwise>
	</c:choose>
	<!-- 迭代标签 -->
	<br>
	<c:forEach var="x" begin="1" end="10" step="1">
	${x*x }<br>
	</c:forEach>
	
	<!-- for(String s: student.getFav()){} -->
	<!-- varStatus.count等为每一次循环的内置状态信息 -->
	<!-- varStatus.first是否为第一个元素 -->
	<c:forEach var="favs" items="${student.fav }" varStatus="varStatus">
	${varStatus.count },${varStatus.index },${varStatus.first }
	${varStatus.last },${favs }<br>
	</c:forEach>

</body>
</html>