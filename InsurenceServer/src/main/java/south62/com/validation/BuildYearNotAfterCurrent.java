package south62.com.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = BuildYearNotAfterCurrentValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BuildYearNotAfterCurrent {

	  String message() default "Build year mustnot be after current and length must be 4 digits!";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
}

