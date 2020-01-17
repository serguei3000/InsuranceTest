package south62.com.dao;

import java.util.List;
import south62.com.entity.Agreement;
import south62.com.entity.Estate;

public interface DAOAgreement {
	
	 List<Agreement> dbGetAgreements();
	 List<Estate> dbGetEstates();
	 boolean dbAddAgreement(Agreement agreement);
	 boolean dbAddEstate(Estate estate);
	 Estate dbGetEstate(Long id);
	 
}
