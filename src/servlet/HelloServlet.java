package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @classname:HelloServlet
 * @Description:TODO
 * @author admin
 * @Date:2017年5月4日下午3:24:29
 */

public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 设置编码，要放在service方法最前
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String userName = request.getParameter("username");
		if (userName == null) {
			userName = "";
		}
		String passWord = request.getParameter("password");
		if (passWord == null) {
			passWord = "";
		}

		String[] favs = request.getParameterValues("fav");
		if (favs != null) {
			for (String s : favs) {
				System.out.println(s);
			}
		}
		System.out.println(userName + "," + passWord);

		if (userName.equalsIgnoreCase("admin") && passWord.equals("123456")) {
			try {
				PrintWriter pw = response.getWriter();
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<h1>This is Servlet Demo.</h1>");
				pw.println("<h3>Welcome," + userName + "</h3>");
				pw.println("</body>");
				pw.println("</html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 回到登陆页面
			try {
				request.getRequestDispatcher("HelloWorld.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
