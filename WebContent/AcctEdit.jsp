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
		String isLogin = (String) session.getAttribute("isLogin");
		if (isLogin == null || (!isLogin.equals("true"))) {
			response.sendRedirect("Login.jsp");//跳转到登录页面
		}
	%>
	<%!String acctNo = "";
	String acctName = "";
	String acctStatus = "";
	String acctBalance = "";
	String idType = "";
	String idNo = "";
	String email = "";

	public String isSelected(String id_type) {
		if (id_type.equals(idType)) {
			return "selected=selected";
		}
		return "";
	}%>
	<%
		//1.取请求页面传来的参数
		acctNo = request.getParameter("acctno");
		acctName = request.getParameter("acctname");
		acctStatus = request.getParameter("acctstatus");
		acctBalance = request.getParameter("balance");
		idType = request.getParameter("idtype");
		idNo = request.getParameter("idno");
		email = request.getParameter("email");
	%>
	<form action="acctManager?oper=edit" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input type="text" name="acctno" value="<%=acctNo%>" /></td>
			</tr>
			<tr>
				<td>账户名称</td>
				<td><input type="text" name="acctname" value="<%=acctName%>" /></td>
			</tr>
			<tr>
				<td>账户状态</td>
				<td><input type="text" name="acctstatus"
					value="<%=acctStatus%>" /></td>
			</tr>
			<tr>
				<td>余额</td>
				<td><input type="text" name="balance" value="<%=acctBalance%>" /></td>
			</tr>
			<tr>
				<td>证件类型</td>
				<td><select name="idtype" value="<%=idType%>">
						<option value="111" <%=isSelected("111")%>>身份证</option>
						<option value="222" <%=isSelected("222")%>>学生证</option>
						<option value="333" <%=isSelected("333")%>>军官证</option>
				</select></td>
			</tr>
			<tr>
				<td>证件编号</td>
				<td><input type="text" name="idno" value="<%=idNo%>" /></td>
			</tr>
			<tr>
				<td>电子邮件</td>
				<td><input type="text" name="email" value="<%=email%>" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置" /></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
		<a href="AcctMain.jsp">返回</a>
	</form>
</body>
</html>