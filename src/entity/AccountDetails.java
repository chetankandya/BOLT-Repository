package entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class AccountDetails {
	
	
//	@Column
//	private String custId;
	@OneToOne
	@JoinColumn(name="custId")
	private CustomerDetails custDetails; 
	
	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountno")
	 @SequenceGenerator(name="accountno",sequenceName="accountno",allocationSize=1)
*/
	@GeneratedValue
	private int accNo;
	
	@Column
	private String branch;
	@Column
	private double balance;
	@Column
	private String acctype;
	@Column
	private Date dateOfOpening;
	/*@Embedded
	private IfscCode ifscCode;*/
	
	
	//public String getCustId() {
//		return custId;
//	}
	//public void setCustId(String custId) {
	//	this.custId = custId;
	//}
	public int getAccNo() {
		return accNo;
	}
	public CustomerDetails getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(CustomerDetails custDetails) {
		this.custDetails = custDetails;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double o) {
		this.balance = o;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	
/*	public IfscCode getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(IfscCode ifscCode) {
		this.ifscCode = ifscCode;
	}*/
	@Override
	public String toString() {
		return "AccountDetails [accNo=" + accNo + ", branch=" + branch + ", balance=" + balance
				+ ", acctype=" + acctype + ", dateOfOpening=" + dateOfOpening + "]";
	}
	
	
	
}
