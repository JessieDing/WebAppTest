package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleTest
 */
@WebServlet("/LifeCycleTest")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifeCycleTest() {
		super();
		System.out.println("test");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("service");

		ServletContext servletContext = this.getServletContext();
		String path = servletContext.getRealPath("LifeCycleTest.jsp");
		System.out.println(path);

		Object dbname = servletContext.getInitParameter("dbname");
		if (dbname != null) {
			System.out.println(dbname.toString());
		}
		Object password = servletContext.getInitParameter("dbusername");
		if (password != null) {
			System.out.println(password.toString());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("doPost");
	}

}
