package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBOper;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * try { request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html;charset=utf-8"); } catch
		 * (UnsupportedEncodingException el) { el.printStackTrace(); }
		 */

		// 1.取得登录参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName == null) {
			userName = "";
		}
		if (password == null) {
			password = "";
		}
		// 2.处理登录
		String sql = "select count(*) from t_user where " + "user_name = '" + userName + "'"
				+ "and pass_word = PASSWORD('" + password + "')";
		System.out.println("[" + sql + "]");
		try {
			DBOper dbOper = new DBOper();
			ResultSet rs = dbOper.doQuery(sql);
			HttpSession session = request.getSession();
			System.out.println("session id:" + session.getId());
			if (rs.next()) {// 返回的永远只有一行一列，所以不用while
				int num = rs.getInt(1);
				if (num > 0) {
					// 成功，跳转到主页面
					session.setAttribute("userName", userName);
					session.setAttribute("isLogin", "true");
					request.getRequestDispatcher("AcctMain.jsp").forward(request, response);
					System.out.println("登录成功");
				} else {// 失败，返回登录页面
					session.setAttribute("isLogin", "false");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					System.out.println("登录失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
