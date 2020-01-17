package south62.com.validation;

import java.time.temporal.ChronoUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import south62.com.entity.Agreement;

public class AgreementDatesCorrectRangeValidator implements ConstraintValidator<AgreementDatesCorrectRange, Agreement> {

	@Override
	public boolean isValid(Agreement value, ConstraintValidatorContext context) {
		if (value.getBegDate().isBefore(value.getEndDate())
				&& ChronoUnit.DAYS.between(value.getBegDate(), value.getEndDate()) <= 366) 
			return true;
		else
		    return false;	
	}

}
