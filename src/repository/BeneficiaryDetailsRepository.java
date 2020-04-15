package repository;
import java.util.List;
import java.util.Set;

import entity.*;
import exception.CustException;


public interface BeneficiaryDetailsRepository {

	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails Beneficiary);
	
	public BeneficiaryDetails getBeneficiary(int benAccountNumber);
	
	public BeneficiaryDetails removeBeneficiary(BeneficiaryDetails Beneficiary);
	
	//public List<BeneficiaryDetails> getBeneficiaries();
	
	//public List<BeneficiaryDetails> getBeneficiaries(CustomerDetails cd);
	
	public Set<BeneficiaryDetails> getBeneficiaries();
	
}
