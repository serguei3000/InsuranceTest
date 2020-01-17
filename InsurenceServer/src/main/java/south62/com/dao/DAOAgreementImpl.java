package south62.com.dao;

import java.util.List;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import south62.com.entity.Agreement;
import south62.com.entity.Estate;

@Component
@Transactional
public class DAOAgreementImpl implements DAOAgreement {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Agreement> dbGetAgreements() {
		try {
	        String sql = "Select a from " + Agreement.class.getName() + " a ";
	        Session session = sessionFactory.getCurrentSession();
	        Query<Agreement> query = session.createQuery(sql, Agreement.class);
	        List<Agreement> list = query.getResultList();
	        return list;
	    } catch (NoResultException e) {
	            return null;
	    }
	}

	@Override
	public boolean dbAddAgreement(Agreement agreement) {
		try {
			Session session = sessionFactory.getCurrentSession();
			if (agreement.getClient().getId() == null)
				session.persist(agreement.getClient());
			if (agreement.getEstate().getId() == null)
				session.persist(agreement.getEstate());
			session.saveOrUpdate(agreement);
			return true;
        } catch (NoResultException e) {
            return false;
        }
	}
	
	@Override
	public boolean dbAddEstate(Estate estate) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(estate);
			return true;
        } catch (NoResultException e) {
            return false;
        }
	}

	@Override
	public List<Estate> dbGetEstates() {
		try {
            String sql = "Select e from " + Estate.class.getName() + " e ";
            Session session = sessionFactory.getCurrentSession();
            Query<Estate> query = session.createQuery(sql, Estate.class);
            List<Estate> list = query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
	public Estate dbGetEstate(Long id) {
		try {
		    Session session = sessionFactory.getCurrentSession();
		    if (id != null)
		        return session.get(Estate.class, id);
		    else
			    return null;
		} catch (NoResultException e) {
	        return null;
	    }
	}
	
}
