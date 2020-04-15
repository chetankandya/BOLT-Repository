package entity;

//import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;*/
import javax.persistence.Table;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="admin")
public class AdminDetails {

	
	@Id
	private String adminId;
	
	private  String adminName;
	
	private String mobileNo;

	private String emailId;
	
	private String password;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}