package south62.com.services;

import java.util.List;
import south62.com.entity.Client;

public interface ClientService {
	
	List<Client> getClients();
	boolean addClient(Client client);
	Client getClient(Long id);
}
