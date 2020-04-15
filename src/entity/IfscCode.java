package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

	@Embeddable
	public class IfscCode {
	@Column
	private String branchCity;
	@Column
	private String ifscCode;
	@Column
	private String branchName;
	
	
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "IfscCode [branchCity=" + branchCity + ", ifscCode=" + ifscCode + "]";
	}
	
}
