package south62.com.validation;

import java.beans.PropertyEditorSupport;

public class IntegerEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
       
    	Integer iData = Integer.parseInt(text);
		setValue(iData);
    }
}