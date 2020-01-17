package south62.com.validation;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
    	
    	DateTimeFormatter formatter =
    		DateTimeFormatter
    		    .ofPattern("dd.MM.yyyy");

       
    	LocalDate lDate = LocalDate.parse(text, formatter);
		setValue(lDate);
    }
}