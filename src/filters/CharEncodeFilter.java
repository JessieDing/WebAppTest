package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilter
 */
@WebFilter("/SetCharacterEncodingFilter")
public class CharEncodeFilter implements Filter {
	/* private String encoding; */

	public void destroy() {
		/* this.encoding = null; */
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CharEncodeFilter.doFilter...");
		/*
		 * HttpServletRequest req; req = (HttpServletRequest) request;
		 * 
		 * HttpServletResponse res; res = (HttpServletResponse) response;
		 * 
		 * req.setCharacterEncoding(encoding);
		 * res.setCharacterEncoding(encoding);
		 */
		try {
			request.setCharacterEncoding("utf-8");// 解决输入乱码
			response.setContentType("textml;charset=utf-8");// 解决输出乱码
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Encoding before chain.doFilter... ");
		chain.doFilter(request, response);
		System.out.println(" Encoding after chain.doFilter... ");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		/* this.encoding = fConfig.getInitParameter("charSet"); */
	}

}
