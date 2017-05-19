package beans;

/**
 * @classname:Acct
 * @Description:TODO
 * @author admin
 * @Date:2017年5月19日上午10:18:44
 */

public class Acct {
	private String acctNo;
	private String acctName;
	private String acctStatus;
	private double balance;
	private String idType;
	private String idNo;
	private String email;

	public Acct(String acctNo, String acctName, String acctStatus, double balance, String idType, String idNo,
			String email) {
		super();
		this.acctNo = acctNo;
		this.acctName = acctName;
		this.acctStatus = acctStatus;
		this.balance = balance;
		this.idType = idType;
		this.idNo = idNo;
		this.email = email;
	}

	public Acct() {
		super();
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
