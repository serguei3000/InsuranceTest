package south62.com.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BuildYearNotAfterCurrentValidator implements ConstraintValidator<BuildYearNotAfterCurrent, Integer> {
	
	 @Override
	 public void initialize(BuildYearNotAfterCurrent dateAfterCurrent) {
	 
	    }
	 
	 @Override
	 public boolean isValid(Integer year, ConstraintValidatorContext ctx) {
		 if (year.toString().length() != 4)
			 return false;
	     if (year > LocalDate.now().getYear())
	    	 return false;
	     
	     return true;
	 }
	 
}
