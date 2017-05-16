<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${3+2}</h3>
	<h3>${3+2!=5}</h3>
	<h3>null是否为空：${empty null}</h3>
	<h3>null是否为空串：${empty ''}</h3>
	<h3>empty a：${empty 'abc'}</h3>
	<h3>${3>2?'大于':'小于等于'}</h3>

	<!--EL取参数 -->
	<h3>param p1:${param.p1}</h3>
	<h3>param p2:${param.p2}</h3>

	<!--EL使用对象（JavaBean的方式）-->

	<!--1.创建一个名为Employer的Bean-->
	<!--2.实例化一个对象，给对象赋值-->
	<jsp:useBean id="emp" class="beans.Employer" scope="page"></jsp:useBean>
	<!-- 等价于Employer emp = new Employer() -->

	<jsp:setProperty property="empId" name="emp" param="p_empId" />
	<!--等价于emp.setEmpId(request.getParameter("p_empId"))  -->

	<!--3.利用EL表达式从Employer对象中取值-->
	<h3>emp.empId: ${emp['empId'] }</h3>

	<input type="text" name="tel_no" value="current_pg_tel_no" />
	<!--EL表达式四大作用域-->
	<%
/* 		request.setAttribute("tel_no", "req_telNo"); */
		session.setAttribute("tel_no", "session tel_no");
		application.setAttribute("tel_no", "application tel_no");
		/* pageContext.setAttribute("tel_no", "pg_tel_no"); */
	%>
	<h3>param.tel_no: ${param.tel_no}</h3>
	<h3>pgScope.tel_no: ${pageScope.tel_no}</h3>
	<h3>reqScope.tel_no: ${requestScope.tel_no}</h3>
	<h3>sessionScope.tel_no: ${sessionScope.tel_no}</h3>
	<h3>appScope.tel_no: ${applicationScope.tel_no}</h3>
	<h3>(EL作用域顺序)tel_no: ${tel_no}</h3>

	<!--等价于emp.getEmpId("empId")  -->



</body>
</html>