package south62.com.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import south62.com.entity.Client;
import south62.com.entity.Estate;

@Component
@Transactional
public class DAOClientImpl implements DAOClient {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Client> dbGetClients() {
		try {
            String sql = "Select a from " + Client.class.getName() + " a ";
            Session session = sessionFactory.getCurrentSession();
            Query<Client> query = session.createQuery(sql, Client.class);
            List<Client> list = query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
	}
	
	@Override
	public boolean dbAddClient(Client client) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(client);
			return true;
        } catch (NoResultException e) { 
        	return false;
        }
		
	}

	@Override
	public Client dbGetClient(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id != null) 
			return session.get(Client.class, id);
		else
			return null;
	}

}
