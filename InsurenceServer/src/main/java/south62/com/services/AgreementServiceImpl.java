package south62.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import south62.com.dao.DAOAgreement;
import south62.com.entity.Agreement;
import south62.com.entity.Estate;

@Component
public class AgreementServiceImpl implements AgreementService {
	
	@Autowired
	private  DAOAgreement agreementDao;

	@Override
	public List<Agreement> getAgreements() {
		return agreementDao.dbGetAgreements();
	}

	@Override
	public boolean addAgreement(Agreement agreement) {
		return agreementDao.dbAddAgreement(agreement);
	}

	@Override
	public boolean addEstate(Estate estate) {
		return agreementDao.dbAddEstate(estate);
	}

	@Override
	public List<Estate> getEstates() {
		return agreementDao.dbGetEstates();
	}

	@Override
	public Estate getEstate(Long id) {
		return agreementDao.dbGetEstate(id);
	}

}
