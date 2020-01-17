package south62.com.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=AgreementDatesCorrectRangeValidator.class)
public @interface AgreementDatesCorrectRange {
	
	 String message() default "Date end must be after start date and difference must be less then 1 year!";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};

}
