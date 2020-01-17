package south62.com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import south62.com.InsurenceServerApplication;
import south62.com.entity.Address;
import south62.com.entity.Agreement;
import south62.com.entity.Client;
import south62.com.entity.Estate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InsurenceServerApplication.class)
@Transactional
public class DAOAgreementTest {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Test
	@Rollback(false)
	public void dbPuttAgreementsTest() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		
		//Client client = new Client("Ivan", "Ivanovich", "Ivanov", LocalDate.of(1980, 3, 28), "1111", "111111");
		//Address adrr = new Address("123123", "state", "province", "region", "city", "street", "1", "2", "3", "4");
		//Estate estate = new Estate("Flat", 2014, new BigDecimal(55.0), adrr, "");
		//Agreement agrr = new Agreement("000001", LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), LocalDate.now().plus(100, ChronoUnit.DAYS), estate, client, new BigDecimal(1000.0));
		
		//Session session = sessionFactory.getCurrentSession();
		//session.persist(client);
		//session.persist(estate);
		//session.persist(agrr);
		//session.flush();
		
		Client client = new Client("Petrov", "Petr", "Petrovich", LocalDate.of(1985, 3, 20), "2222", "222222");
		Address adrr = new Address("123123", "state2", "province2", "region2", "city2", "street2", "1", "2", "3", "4");
		Estate estate = new Estate("House", 2010, new BigDecimal(200.0), adrr, "");
		Agreement agrr = new Agreement("000002", LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), LocalDate.now().plus(100, ChronoUnit.DAYS), estate, client, new BigDecimal(2500.0));
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(client);
		session.persist(estate);
		session.persist(agrr);
		session.flush();
	
	}
	
}
