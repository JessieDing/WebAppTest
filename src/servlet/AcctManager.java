package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBOper;

/**
 * Servlet implementation class AcctManager
 */
@WebServlet("/AcctManager")
public class AcctManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcctManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void acctQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("start query method...");
		String acctNo = request.getParameter("acctNo");
		String acctName = request.getParameter("acctName");
		String acctStatus = request.getParameter("acctStatus");

		// 参数有效性检查
		if (acctNo == null) {
			acctNo = "";
		}
		if (acctName == null) {
			acctNo = "";
		}
		if (acctStatus == null) {
			acctNo = "";
		}
		// System.out.println(acctNo + "," + acctName + "," + acctStatus);

		// 2.拼SQL
		int paraNum = 0;
		String sql = "select * from acct ";
		String condition = "where ";

		if (acctNo != null && !acctNo.equals("")) {
			condition += "acctNo='" + acctNo + "'";
			paraNum++;
		}

		if (acctName != null && !acctName.equals("")) {
			if (paraNum > 0)
				condition += " and acctName ='" + acctName + "' ";
			else
				condition += " acctName ='" + acctName + "' ";
			paraNum++;
		}
		if (acctStatus != null && !acctStatus.equals("")) {
			if (paraNum > 0)
				condition += " and acctStatus ='" + acctStatus + "' ";
			else
				condition += " acctStatus ='" + acctStatus + "' ";
			paraNum++;
		}

		if (paraNum > 0) {
			sql += condition;
		}

		System.out.println("sql[" + sql + "]");

		// 3.执行查询，并将查询结果返回（把结果放到response对象里）
		List<String> accts = new ArrayList<String>();
		DBOper dbOper = new DBOper();
		ResultSet resultSet;
		try {
			resultSet = dbOper.doQuery(sql);
			try {
				while (resultSet.next()) {
					String no = resultSet.getString("acctNo");
					String name = resultSet.getString("acctName");
					String status = resultSet.getString("acctStatus");
					String balance = resultSet.getString("balance");
					String idType = resultSet.getString("IdType");
					String idNo = resultSet.getString("IdNo");
					String email = resultSet.getString("Email");
					String acctInfo = no + "," + name + "," + status + "," + balance + "," + idType + "," + idNo + ","
							+ email;
					accts.add(acctInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// dbOper.closeConnection();

		request.setAttribute("accts", accts);// 将账户集合放入accts参数
		for (String tmp : accts) {
			System.out.println(tmp);
		}

		// 添加Cookie项
		String acctNum = accts.size() + "";
		Cookie c1 = new Cookie("acct_num", acctNum);
		c1.setMaxAge(24 * 60 * 60);
		Cookie c2 = new Cookie("user_name", URLEncoder.encode("赵四", "UTF-8"));
		c2.setMaxAge(24 * 60 * 60);
		response.addCookie(c1);
		response.addCookie(c2);

		// 4.转发至前台，取结果
		request.getRequestDispatcher("AcctMain.jsp").forward(request, response);
	}

	protected void acctDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("start delete method...");

		String acctNo = request.getParameter("acctno");
		if (acctNo == null) {
			request.getRequestDispatcher("AcctMain.jsp").forward(request, response);
		}

		// 拼SQL
		String sql = "delete from acct where acctNo = '" + acctNo + "'";
		System.out.println(sql);
		DBOper dbOper = new DBOper();
		int result = dbOper.doUpdate(sql);
		if (result > 0) {
			// 显示删除后结果
			List<String> accts = new ArrayList<String>();
			String s = "select * from acct";
			ResultSet resultSet;
			try {
				resultSet = dbOper.doQuery(s);
				try {
					while (resultSet.next()) {
						String no = resultSet.getString("acctNo");
						String name = resultSet.getString("acctName");
						String status = resultSet.getString("acctStatus");
						String balance = resultSet.getString("balance");
						String idType = resultSet.getString("IdType");
						String idNo = resultSet.getString("IdNo");
						String email = resultSet.getString("Email");
						String acctInfo = no + "," + name + "," + status + "," + balance + "," + idType + "," + idNo
								+ "," + email;
						accts.add(acctInfo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// dbOper.closeConnection();

			request.setAttribute("accts", accts);// 将账户集合放入accts参数
			for (String tmp : accts) {
				System.out.println(tmp);
			}

			// 4.转发至前台，取结果
			request.getRequestDispatcher("AcctMain.jsp").forward(request, response);

		} else {
			request.setAttribute("errmsg", "Delete error.");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

	protected void acctAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("start add method...");

		String acctNo = request.getParameter("acctno");
		String acctName = request.getParameter("acctname");
		String acctStatus = request.getParameter("acctstatus");
		String acctBalance = request.getParameter("balance");
		String idType = request.getParameter("idtype");
		String idNo = request.getParameter("idno");
		String email = request.getParameter("email");

		if (acctNo == null) {
			acctNo = "";
		}
		if (acctName == null) {
			acctName = "";
		}
		if (acctStatus == null) {
			acctStatus = "";
		}
		if (acctBalance == null) {
			acctBalance = "";
		}
		if (idType == null) {
			idType = "";
		}
		if (idNo == null) {
			idNo = "";
		}
		if (email == null) {
			email = "";
		}
		// System.out.println(acctNo);
		// System.out.println(acctName);
		// System.out.println(acctStatus);
		// System.out.println(acctBalance);
		// System.out.println(idType);
		// System.out.println(idNo);
		// System.out.println(email);

		// 拼sql
		StringBuffer sql = new StringBuffer();
		sql.append("insert into acct values(");
		sql.append("'").append(acctNo).append("',");
		sql.append("'").append(acctName).append("',");
		sql.append("'").append(acctStatus).append("'");
		sql.append(",").append(Double.parseDouble(acctBalance));
		sql.append(",'").append(idType).append("'");
		sql.append(",'").append(idNo).append("'");
		sql.append(",'").append(email).append("')");

		System.out.println("[" + sql + "]");

		DBOper dbOper = new DBOper();
		int result = dbOper.doUpdate(sql.toString());
		if (result > 0) {
			request.getRequestDispatcher("AcctNew.jsp").forward(request, response);
			System.out.println("Successfully added.");
		} else {
			request.setAttribute("errmsg", "Add error.");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

	protected void acctEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("start edit method...");

		String acctNo = request.getParameter("acctno");
		String acctName = request.getParameter("acctname");
		String acctStatus = request.getParameter("acctstatus");
		String acctBalance = request.getParameter("balance");
		String idType = request.getParameter("idtype");
		String idNo = request.getParameter("idno");
		String email = request.getParameter("email");

		if (acctNo == null) {
			acctNo = "";
		}
		if (acctName == null) {
			acctName = "";
		}
		if (acctStatus == null) {
			acctStatus = "";
		}
		if (acctBalance == null) {
			acctBalance = "";
		}
		if (idType == null) {
			idType = "";
		}
		if (idNo == null) {
			idNo = "";
		}
		if (email == null) {
			email = "";
		}

		// 拼sql
		StringBuffer sql = new StringBuffer();
		sql.append("update acct set ");
		sql.append("acctName='").append(acctName).append("',");
		sql.append("acctStatus='").append(acctStatus).append("',");
		sql.append("balance=").append(acctBalance).append(",");
		sql.append("IdType='").append(idType).append("',");
		sql.append("IdNo='").append(idNo).append("',");
		sql.append("Email='").append(email).append("'");
		sql.append("where acctNo='").append(acctNo).append("'");

		System.out.println("[" + sql + "]");

		DBOper dbOper = new DBOper();
		int result = dbOper.doUpdate(sql.toString());
		if (result > 0) {
			request.setAttribute("success", "Edit successfully.");
			request.getRequestDispatcher("Success.jsp").forward(request, response);
			System.out.println("Successfully Edit.");
		} else {
			request.setAttribute("errmsg", "Edit error.");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		// 1.取参数
		String oper = request.getParameter("oper");
		if (oper == null) {
			System.out.println("it's null");
		} else {
			System.out.println(oper);
		}
		if (oper.equals("query")) {
			acctQuery(request, response);
			System.out.println("out query method...");
		} else if (oper.equals("delete")) {
			acctDelete(request, response);
			System.out.println("out delete method...");
		} else if (oper.equals("add")) {
			acctAdd(request, response);
			System.out.println("out add method...");
		} else if (oper.equals("edit")) {
			acctEdit(request, response);
			System.out.println("out edit method...");
		} else {
			System.out.println("Invalid operation.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
