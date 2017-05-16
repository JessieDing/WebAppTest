<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="pub_header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PrintTable</title>
</head>
<body>
	<table border="1px" width="400px">
		<tr>
			<th>Name</th>
			<th>No.</th>
		</tr>

		<%!public class Student {
		String studentName;
		String studentNo;

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public void setStudentNo(String studentNo) {
			this.studentNo = studentNo;
		}
	}%>

		<%
			Map<String, String> m = new HashMap<String, String>();
			m.put("Dekei", "20010001");
			m.put("Tom", "20010002");
			m.put("Jerry", "20010003");

			Set<String> keys = m.keySet();
			for (String s : keys) {
				String val = m.get(s);
		%>
		<tr>
			<td><%=s%></td>
			<td><%=val%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>