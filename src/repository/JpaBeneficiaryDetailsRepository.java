package repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import entity.*;
import exception.CustException;

public class JpaBeneficiaryDetailsRepository implements BeneficiaryDetailsRepository{

	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;
    
	
	
	@Transactional
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails beneficiary)  
	{
		entityManager.persist(beneficiary);
		return beneficiary;
	
	}

	@Override
	@Transactional
	public BeneficiaryDetails getBeneficiary(int beneficiary) {
		
		BeneficiaryDetails existingBen = entityManager.find(BeneficiaryDetails.class, beneficiary);
		return existingBen;
		
	}
		
		
		
	/*	
		Query q=entityManager.createQuery("From BeneficiaryDetails where BENACCNO=BENACCNO");
		q.setParameter("BENACCNO", beneficiary.getBenAccNo());
		BeneficiaryDetails rs=(BeneficiaryDetails) q.getSingleResult();
		System.out.println(rs.getBenAccNo());
		Query q1=entityManager.createQuery("from BeneficiaryDetails where custid=beneficiary.getCustDetails().getCustId()");
		
		if(q!=null && q1!=null) {
			System.out.println("hello");
		}else {System.out.println("hatt bc");}
		System.out.println(q);
		
		
		BeneficiaryDetails bd= entityManager.find(BeneficiaryDetails.class, beneficiary.getCustDetails().getCustId());
		System.out.println(bd+"bd");
		
		if(bd!=null)
		if(beneficiary.getCustDetails().getCustId()==bd.getCustDetails().getCustId()) {
			
			System.out.println(bd.getCustDetails().getCustId());
			bd.setBenAccNo(beneficiary.getBenAccNo());
			
			if(beneficiary.getBenAccNo()==bd.getBenAccNo())
			{
				return bd;
			}
			else 
			{
			
			return null;
			}
		}
		else 
		{
			return null;
		}*/
		
		
	

	@Override
	public BeneficiaryDetails removeBeneficiary(BeneficiaryDetails beneficiary) {
		
        BeneficiaryDetails bd= entityManager.find(BeneficiaryDetails.class, beneficiary.getCustDetails());
	    
		/*bd.setBenAccNo(beneficiary.getBenAccNo());*/
		
		if(beneficiary.getBenAccNo()==bd.getBenAccNo())
		{
			entityManager.remove(beneficiary);
			return beneficiary;
			
		}else {
		
		return null;
		}
	}

	@Override
	public Set<BeneficiaryDetails> getBeneficiaries() 
	{	
		BeneficiaryDetails bd = null;
		
		bd=entityManager.find(BeneficiaryDetails.class, bd.getBenAccNo());;
		
		Set<BeneficiaryDetails> list = new HashSet<BeneficiaryDetails>();
		
		list.add(bd);
//		bd=entityManager.find(BeneficiaryDetails.class, bd.getBenAccNo());
//		
//		List <BeneficiaryDetails> list= list.newArrayList();
		
		return list;
	}

}

