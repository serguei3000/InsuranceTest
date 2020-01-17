package south62.com.validation;

import java.time.LocalDate;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import south62.com.entity.Client;

public class ClientsValidationTest {
	
	private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void ClientsValidationViolationTest() {
    	
        Client client = new Client("Ivan", "Ivanovich", "Ivanov", LocalDate.of(1980, 3, 28), "1111", "1111111111");
        Set<ConstraintViolation<Client>> validates = validator.validate(client);
        assertTrue(validates.size() > 0);
        validates.stream().map(v -> v.getMessage())
                .forEach(System.out::println);
    }

}
