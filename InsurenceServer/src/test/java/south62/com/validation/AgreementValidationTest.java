package south62.com.validation;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import south62.com.entity.Address;
import south62.com.entity.Agreement;
import south62.com.entity.Client;
import south62.com.entity.Estate;

public class AgreementValidationTest {

	private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void AgreementValidationViolationTest() {
    	
        Client client = new Client("Ivan", "Ivanovich", "Ivanov", LocalDate.of(1980, 3, 28), "1111", "111111");
        Address adrr = new Address("123123", "state", "province", "region", "city", "street", "1", "2", "3", "4");
		Estate estate = new Estate("Flat", 2014, new BigDecimal(55.0), adrr, "");
        Agreement agreement = new Agreement("000001", LocalDate.now(), LocalDate.of(2021, 12, 31), LocalDate.now(), estate, client, new BigDecimal(1000.0));
        Set<ConstraintViolation<Agreement>> validates = validator.validate(agreement);
        assertTrue(validates.size() > 0);
        validates.stream().map(v -> v.getMessage())
                .forEach(System.out::println);
    }

}
