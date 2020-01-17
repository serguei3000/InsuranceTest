package south62.com.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateAfterCurrentValidator implements ConstraintValidator<DateAfterCurrent, LocalDate> {
	
	 @Override
	 public void initialize(DateAfterCurrent dateAfterCurrent) {
	 
	    }
	 
	 @Override
	 public boolean isValid(LocalDate date, ConstraintValidatorContext ctx) {
	     LocalDate currentDate = LocalDate.now();   
		 if (date.isAfter(currentDate)  || (date.isEqual(currentDate))) {
			 System.out.println(date);
		     return true;}
	     else
	         return false;	
	    }

}
