package beans;

/**
 * @classname:Employer
 * @Description:TODO
 * @author admin
 * @Date:2017年5月16日下午4:33:30
 */

public class Employer {
	private String empId;
	private String empName;
	private String empLevel;
	private int empAge;
	private double salary;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLevel() {
		return empLevel;
	}

	public void setEmpLevel(String empLevel) {
		this.empLevel = empLevel;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
