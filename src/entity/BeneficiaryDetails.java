package entity;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="BeneficiaryDetails")
public class BeneficiaryDetails {

	@Id
	
	private int benAccNo;
	
/*	@ManyToOne
	@JoinColumn(name="custId")
	private CustomerDetails custDetails; */
	
	@ManyToMany
	@JoinTable(name="CustomerBeneficiaryLink1", 
			joinColumns={@JoinColumn(name="benAccNo")},
			inverseJoinColumns={@JoinColumn(name="custId")})
	private List<CustomerDetails> custDetails;
	
	@Column
	private String benName;
	@Column 
	private String benPhone;
	@Column
	private String benBank;
	@Column
	private String benIfsc;
	@Column
	private String benDesc;
	
	
	public int getBenAccNo() {
		return benAccNo;
	}
	public void setBenAccNo(int benAccNo) {
		this.benAccNo = benAccNo;
	}
	
	public String getBenBank() {
		return benBank;
	}
	public List<CustomerDetails> getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(List<CustomerDetails> custDetails) {
		this.custDetails = custDetails;
	}
	public void setBenBank(String benBank) {
		this.benBank = benBank;
	}
	public String getBenIfsc() {
		return benIfsc;
	}
	public void setBenIfsc(String benIfsc) {
		this.benIfsc = benIfsc;
	}
	public String getBenName() {
		return benName;
	}
	public void setBenName(String benName) {
		this.benName = benName;
	}
	public String getBenPhone() {
		return benPhone;
	}
	public void setBenPhone(String benPhone) {
		this.benPhone = benPhone;
	}
	public String getBenDesc() {
		return benDesc;
	}
	public void setBenDesc(String benDesc) {
		this.benDesc = benDesc;
	}	
	
}
