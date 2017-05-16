package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @classname:DBOper
 * @Description:TODO
 * @author admin
 * @Date:2017年5月4日下午5:49:19
 */

public class DBOper {
	private String driver;
	private String url;
	private String acct;
	private String pwd;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DBOper() {
		try {
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost/test";
			acct = "root";
			pwd = "123456";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, acct, pwd);
			if (connection == null) {
				System.err.println("connection failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet doQuery(String strSQL) throws SQLException {
		statement = connection.createStatement();// 创建一个表单
		resultSet = statement.executeQuery(strSQL);// 执行查询语句
		return resultSet;
	}

	public int doUpdate(String sql) {
		int ret = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ret = preparedStatement.executeUpdate();// 执行sql语句，并返回结果
			// System.out.println("Executed "+ret+" sql commands.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAcct() {
		return acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
