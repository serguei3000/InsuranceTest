package south62.com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import south62.com.dao.DAOClient;
import south62.com.entity.Client;

@Component
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private  DAOClient clientDao;

	@Override
	public List<Client> getClients() {
		return clientDao.dbGetClients();
	}

	@Override
	public boolean addClient(Client client) {
		try {
			return clientDao.dbAddClient(client);
        } catch (Exception e) {  //org.hibernate.StaleObjectStateException которое выбрасывает saveOrUpdate если попытка вставить запись с несуществующим id
        	return false;
        }
		
	}

	@Override
	public Client getClient(Long id) {
		return clientDao.dbGetClient(id);
	}

}
