package south62.com.services;

import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import south62.com.InsurenceServerApplication;
import south62.com.services.CoefficientService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InsurenceServerApplication.class)
public class CoefficientServImplTest {
		
	@Autowired
	CoefficientService coefficientService;
			
	@Test
	public void getYearTest() {
		assertTrue(Math.abs(coefficientService.getYear(2010).floatValue() - new BigDecimal(1.6).floatValue()) < 0.000001);
	}
	
	/*Test string
	http://localhost:8080//api/culculate?amount=1000&dateBeg=01.11.2011&dateEnd=01.11.2012&type=Flat&year=2014&square=45
	1000.00/(ChronoUnit.DAYS.between(dateBeg, dateEnd))*1.7*1.6*1.2
	*/
	@Test
	public void culculateBonusTest() {
		BigDecimal amount = new BigDecimal("1000.00");
		LocalDate dateBeg = LocalDate.of(2011, 11, 1); 
		LocalDate dateEnd = LocalDate.of(2012, 11, 1);  
		String type = "Flat"; 
		Integer year = Integer.valueOf(2014);
		Integer square = Integer.valueOf(45);
		System.out.println(ChronoUnit.DAYS.between(dateBeg, dateEnd));
		BigDecimal culculateResult = coefficientService.Culculate(amount, dateBeg, dateEnd, type, year, square);
		assertTrue(culculateResult
			          .compareTo(new BigDecimal("8.91")) == 0);
	}
	


}