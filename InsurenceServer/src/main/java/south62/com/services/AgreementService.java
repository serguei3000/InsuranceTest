package south62.com.services;

import java.util.List;
import south62.com.entity.Agreement;
import south62.com.entity.Estate;

public interface AgreementService {
	
	List<Agreement> getAgreements();
	List<Estate> getEstates();
	boolean addAgreement(Agreement agreement);
	boolean addEstate(Estate estate);
	Estate getEstate(Long id);

}
