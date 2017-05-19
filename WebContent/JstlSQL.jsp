<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- sql示例 --> 
<sql:setDataSource 
	driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8"
	user="root" password="123456" var="conn" scope="session"/>

<!-- 查询示例 -->	
<sql:query dataSource="${conn}" var="result">
	select * from acct;
</sql:query>

<h3>JSTL查询示例</h3>
<h3>查询结果行数:<c:out value="${result.rowCount}"/></h3>
<table border="1" width="400px">
	<tr>
		<th>账号</th>
		<th>户名</th>
		<th>状态</th>
		<th>余额</th>
	</tr>
	<c:forEach var="row" items="${result.rows}">	
	<tr>
		<td><c:out value="${row.acct_no}"/></td>
		<td><c:out value="${row.acct_name}"/></td>
		<td><c:out value="${row.acct_status }" /></td>
		<td><c:out value="${row.balance }" /></td>
	</tr>
	</c:forEach>
</table>

<!-- 添加示例 -->	
<h3>JSTL Update操作示例</h3>
<sql:update dataSource="${datasource}" var="result" scope="page">
	update acct set balance = (balance * 1.01) where acct_no in('0001', '0002');
</sql:update>
	<h3>修改行数:<c:out value="${result}"/></h3>

<!-- SQL操作Param使用 -->
<h3>JSTL Update操作Param使用</h3>
<sql:update dataSource="${datasource}" var="result" scope="page">
	update acct set balance = ? where acct_no = ?;
	<sql:param value="${param['balance']}" />
	<sql:param value="${param['acct_no']}" />
</sql:update>
<h3>修改行数:<c:out value="${result}"/></h3>

</body>
</html>