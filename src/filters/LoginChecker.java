package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginChecker
 */
@WebFilter("/LoginChecker")
public class LoginChecker implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginChecker.doFilter...");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		/*
		 * HttpServletResponse res; res = (HttpServletResponse) response;
		 */

		String isLogin = (String) session.getAttribute("isLogin");
		if (isLogin == null || !isLogin.equals("true")) {
			/* req.getRequestDispatcher("Login").forward(request, response); */
			System.out.println("filter says: no login, no authority. ");
			req.setAttribute("errmsg", "no authority.");
			req.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		// pass the request to the filter chain
		System.out.println("Login check before chain.doFilter... ");
		chain.doFilter(request, response);
		System.out.println("Login check after chain.doFilter... ");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
