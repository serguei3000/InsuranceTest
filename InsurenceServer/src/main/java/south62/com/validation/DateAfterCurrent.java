package south62.com.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = DateAfterCurrentValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAfterCurrent {
	
	  String message() default "Date must be after current";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
}
