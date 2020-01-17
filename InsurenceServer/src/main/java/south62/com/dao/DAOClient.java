package south62.com.dao;

import java.util.List;
import south62.com.entity.Client;

public interface DAOClient {
	
	 List<Client> dbGetClients();
	 boolean dbAddClient(Client client);
	 Client dbGetClient(Long id);
	 
}
