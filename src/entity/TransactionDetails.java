package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class TransactionDetails {

	@Id
	@GeneratedValue
	private int transId;
	
	@Column
	private int custId;
	@Column
	private Date transferDate;
	@Column
	private double amount;
	@Column
	private int benAccNo;
	@Column
	private String benName;
	
	@ManyToOne
	@JoinTable(name="customerTransaction", 
			joinColumns={@JoinColumn(name="transId")},
			inverseJoinColumns={@JoinColumn(name="custId")})
	private CustomerDetails customerDetails ;
	
	
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	

	
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
		
		
	}
	@Override
	public String toString() {
		return "TransactionDetails [transId=" + transId + ", custId=" + custId + ", transferDate=" + transferDate
				+ ", amount=" + amount + ", benAccNo=" + benAccNo + ", benName=" + benName + "]";
	}
	public int getBenAccNo() {
		return benAccNo;
	}
	public void setBenAccNo(int benAccNo) {
		this.benAccNo = benAccNo;
	}
	public String getBenName() {
		return benName;
	}
	public void setBenName(String benName) {
		this.benName = benName;
	}	
}
