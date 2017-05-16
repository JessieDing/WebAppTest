package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBOper;

/**
 * Servlet implementation class DBDemo
 */
@WebServlet("/DBDemo")
public class DBDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");// 设置http输出格式
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		// 取参数
		String sysNo = request.getParameter("sysno");
		if (sysNo == null) {
			sysNo = "";
		}

		// 使用DBOper对象
		DBOper db = new DBOper();

		String sql = "select Sys_no, Sys_name from sys_info";
		if (!sysNo.equals("")) {
			sql += " where Sys_no='" + sysNo + "'";
		}

		ResultSet rs;
		try {
			rs = db.doQuery(sql);
			try {
				PrintWriter pw = response.getWriter();
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<table border='1' width='400px'>");

				pw.println("<tr>");
				pw.println("<th>" + "系统编号" + "</th>");
				pw.println("<th>" + "系统名称" + "</th>");
				pw.println("</tr>");
				while (rs.next()) {
					pw.println("<tr>");
					String acctno = rs.getString("Sys_no");
					String acctname = rs.getString("Sys_name");
					pw.println("<td>" + acctno + "</td>");
					pw.println("<td>" + acctname + "</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
