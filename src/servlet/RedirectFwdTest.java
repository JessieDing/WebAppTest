package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectFwdTest
 */
@WebServlet("/RedirectFwdTest")
public class RedirectFwdTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RedirectFwdTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		}
		if (oper.equals("redirect")) {// 重定向，可重定向到任意地址
			response.sendRedirect("http://www.baidu.com");
		} else if (oper.equals("forward")) {// 转发，只能转发到该webApp内部页面
			request.getRequestDispatcher("HelloWorld.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}
}
