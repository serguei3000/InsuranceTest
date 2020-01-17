package south62.com.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import south62.com.configuration.Settings;

@ImportResource("classpath:app-config.xml")
@Component
public class CoefficientServImpl implements CoefficientService {
	
	@Autowired
	private Settings settings;

	@Override
	public BigDecimal getType(String key) {
		Map<String, BigDecimal> types = settings.getMapTypes();
		return types.get(key);
	}

	@Override
	public BigDecimal getYear(Integer key) {
		Map<Integer, BigDecimal> years = settings.getMapYear();
		BigDecimal valueYear = BigDecimal.valueOf(0.0);
		for(Map.Entry<Integer, BigDecimal> entry : years.entrySet()) {
			Integer keyYear = entry.getKey();
			if (key > keyYear)
			    valueYear = entry.getValue();
		}
		
		return valueYear;
	}

	@Override
	public BigDecimal getSquaree(Integer key) {
		Map<Integer, BigDecimal> square = settings.getMapSquare();
		BigDecimal valueSquare = BigDecimal.valueOf(0.0);
		for(Map.Entry<Integer, BigDecimal> entry : square.entrySet()) {
			Integer keySquare = entry.getKey();
			if (key > keySquare)
				valueSquare = entry.getValue();
		}
		return valueSquare;
	}

	@Override
	public BigDecimal Culculate(BigDecimal amount, LocalDate dateBeg, LocalDate dateEnd, String type, Integer year,
			Integer square) {
       	
		long resultDays = ChronoUnit.DAYS.between(dateBeg, dateEnd);
       	return amount.divide(new BigDecimal(resultDays), 2, RoundingMode.HALF_UP)
           	.multiply(getType(type))
           	    .multiply(getYear(year))
           	        .multiply(getSquaree(square))
           	            .setScale(2, RoundingMode.HALF_UP);
    }
	
	

}
