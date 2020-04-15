package entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "register")
public class CustomerDetails {

	@Id
	private int custId;

	private String custName;

	private String mobileNo;

	private String gender;

	private String aadharNo;

	private String emailId;

	private String panNo;

	private String dateOfBirth;

	private String password;

	private String address;

	private String city;

	private String country;

	private String pincode;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "CustomerBeneficiaryLink1", joinColumns = { @JoinColumn(name = "custId") }, inverseJoinColumns = {
			@JoinColumn(name = "benAccNo") })
	private Set<BeneficiaryDetails> beneficiaryDetails;

	@OneToOne(mappedBy = "custDetails", fetch = FetchType.EAGER, cascade = { javax.persistence.CascadeType.ALL })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AccountDetails accountDetails;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "customerTransaction", joinColumns = { @JoinColumn(name = "custId") }, inverseJoinColumns = {
			@JoinColumn(name = "transId") })
	private Set<TransactionDetails> transactionDetails;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId2) {
		this.custId = custId2;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Set<BeneficiaryDetails> getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(Set<BeneficiaryDetails> beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		accountDetails = accountDetails;
	}

	public Set<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(Set<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
