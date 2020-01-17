package south62.com.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public interface CoefficientService {
	
	BigDecimal getType(String key);
	BigDecimal getYear(Integer key);
	BigDecimal getSquaree(Integer key);
	BigDecimal Culculate(BigDecimal amount,
			LocalDate dateBeg, 
			LocalDate dateEnd, 
    		String type, 
    		Integer year,
    		Integer square);

}
