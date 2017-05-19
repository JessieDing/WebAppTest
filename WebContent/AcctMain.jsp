<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号管理</title>
</head>
<body>
	<%
		String currPage = "1";
	%>
	<%
		//检查是否登录，未登录时一律跳转至登录页面。
		Object o = session.getAttribute("isLogin");
		String isLogin = "";
		if (o != null) {
			isLogin = (String) o;
		}

		if (isLogin == null || (!isLogin.equals("true"))) {
			response.sendRedirect("Login.jsp");//跳转到登录页面
		}
	%>

	<form action="acctManager?oper=query&pageFlag=1&currPage=<%=currPage%>"
		method="post">
		账号：<input type="text" name="acctNo" /><br> 户名：<input type="text"
			name="acctName" /><br> 状态：<input type="text" name="acctStatus" /><br>
		<input type="reset" value="重置"> <input type="submit"
			value="查询"> <a href="AcctNew.jsp">添加</a> <br> <br>
		<input type="button"
			onclick="javascript:window.location.href='Login.jsp';" value="登录" />

		<%
			Cookie[] cs = request.getCookies();
			String acctNum = "";
			String loginName = "";
			if (cs != null) {
				for (Cookie c : cs) {
					if (c.getName().equals("acct_num")) {
						acctNum = c.getValue();
					}
					if (c.getName().equals("user_name")) {
						/* loginName = c.getValue(); */
						loginName = URLDecoder.decode(c.getValue(), "UTF-8");
					}
				}
			}
		%>
		<%-- <h3>
			用户名：<%=loginName%></h3>
		<h3>
			查询数：<%=acctNum%></h3> --%>

	</form>
	<%
		List<String> accts = (ArrayList<String>) request.getAttribute("accts");
		if (accts != null) {
	%>
	<table width="800px" border="1px" cellspacing="0">
		<tr>
			<th>AcctNo</th>
			<th>AcctName</th>
			<th>AcctStatus</th>
			<th>AcctBalance</th>
			<th>IdType</th>
			<th>IdNo</th>
			<th>Email</th>
			<th>Operation</th>
		</tr>


		<%
			for (String acctInfo : accts) {
					String[] tmp = acctInfo.split(",");
					String tAcctNo = tmp[0];
					String tAcctName = tmp[1];
					String tAcctStatus = tmp[2];
					String tAcctBalance = tmp[3];
					String tIdType = tmp[4];
					String tIdNo = tmp[5];
					String tEmail = tmp[6];
		%>
		<tr>
			<td><%=tAcctNo%></td>
			<td><%=tAcctName%></td>
			<td><%=tAcctStatus%></td>
			<td><%=tAcctBalance%></td>
			<td><%=tIdType%></td>
			<td><%=tIdNo%></td>
			<td><%=tEmail%></td>

			<%
				StringBuffer strBuf = new StringBuffer();
						strBuf.append("acctno=").append(tAcctNo);
						strBuf.append("&acctname=").append(tAcctName);
						strBuf.append("&acctstatus=").append(tAcctStatus);
						strBuf.append("&balance=").append(tAcctBalance);
						strBuf.append("&idtype=").append(tIdType);
						strBuf.append("&idno=").append(tIdNo);
						strBuf.append("&email=").append(tEmail);
			%>
			<td><a href="acctManager?oper=delete&acctno=<%=tAcctNo%>">Delete</a>
				<a href="AcctEdit.jsp?<%=strBuf.toString()%>">Edit</a></td>

		</tr>
		<%
			}
			} else {
				System.out.println("accts is null.");
			}
		%>
		<tr>
			<td colspan=8>共${requestScope.pageNum}页
				当前第${requestScope.currPage}页 <c:set var="pages"
					value="${requestScope.pageNum == null ? 1 : requestScope.pageNum }" />
				<c:forEach var="x" begin="1" end="${pages}" step="1">
					<c:if test="${requestScope.currPage == x}">
						<c:out value="${requestScope.currPage}" />
					</c:if>

					<c:if test="${requestScope.currPage != x}">
						<a href="acctManager?oper=query&pageFlag=1&currPage=${x}">${x}</a>
					</c:if>
				</c:forEach>
			</td>
		</tr>

	</table>
</body>
</html>