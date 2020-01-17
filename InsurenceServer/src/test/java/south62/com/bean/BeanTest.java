package south62.com.bean;

import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import south62.com.InsurenceServerApplication;
import south62.com.configuration.Settings;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InsurenceServerApplication.class)
@ImportResource("classpath:app-config.xml")
public class BeanTest {
	@Autowired
	private Settings settings;
	
	@Test
	public void beanTest() {
		assertTrue(Math.abs(settings.getMapYear().get(1900).floatValue() - new BigDecimal(1.3).floatValue()) < 0.000001);
	}

}
