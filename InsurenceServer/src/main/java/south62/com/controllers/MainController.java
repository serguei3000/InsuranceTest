package south62.com.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import south62.com.entity.Agreement;
import south62.com.entity.Client;
import south62.com.entity.Estate;
import south62.com.services.AgreementService;
import south62.com.services.ClientService;
import south62.com.services.CoefficientService;
import south62.com.validation.BigDecimalEditor;
import south62.com.validation.DateEditor;
import south62.com.validation.IntegerEditor;

@RestController

public class MainController {
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	binder.registerCustomEditor(LocalDate.class, new DateEditor());
	binder.registerCustomEditor(Integer.class, new IntegerEditor());
    }
	
    @Autowired
    private  AgreementService agreements;
	
    @Autowired
    private  ClientService clients;
	
    @Autowired
    private  CoefficientService coefficientService;
	
	
    @RequestMapping(value = "api/getAgreements", 
                       method = RequestMethod.GET, 
                       produces = {MediaType.APPLICATION_JSON_VALUE })
    
    public List<Agreement> getAgreements() {
        List<Agreement> list = agreements.getAgreements();
        return list;
	}
	
    @RequestMapping(value = "api/getClients", 
                       method = RequestMethod.GET, 
                       produces = {MediaType.APPLICATION_JSON_VALUE })
    
    public List<Client> getClients() {
        List<Client> list = clients.getClients();
        return list;
	}
	
    @RequestMapping(value = "api/getEstates", 
            method = RequestMethod.GET, 
            produces = {MediaType.APPLICATION_JSON_VALUE })
    
    public List<Estate> getEstates() {
        List<Estate> list = agreements.getEstates();
        return list;
    }
	
    //Возвращает результат расчета, округленный до 2 знаков
    //Test string
    //http://localhost:8080//api/culculate?amount=1000&dateBeg=01.11.2011&dateEnd=01.11.2012&type=Flat&year=2014&square=45
    @RequestMapping(value = "api/culculate", 
            method = RequestMethod.GET, 
            produces = {MediaType.APPLICATION_JSON_VALUE })
    
    public BigDecimal Culculate( @RequestParam("amount") BigDecimal amount,
    		                       @RequestParam("dateBeg") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate dateBeg, 
    		                       @RequestParam("dateEnd") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate dateEnd, 
    		                       @RequestParam("type") String type, 
    		                       @RequestParam("year") Integer year,
    		                       @RequestParam("square") Integer square) {   		
		
	    return coefficientService.Culculate(amount, dateBeg, dateEnd, type, year, square);        
   }
	
    @RequestMapping(value = "api/addClient", 
	                    method = RequestMethod.POST, 
	                    produces = { MediaType.APPLICATION_JSON_VALUE, 
	                    MediaType.APPLICATION_XML_VALUE })
	
    public Long addClient (@RequestBody Client client) {
	if (clients.addClient(client))
	    return client.getId();
	else	   
	    return null;
	 }
	 
    @RequestMapping(value = "api/addEstate", 
             method = RequestMethod.POST, 
             produces = { MediaType.APPLICATION_JSON_VALUE, 
             MediaType.APPLICATION_XML_VALUE })
    
    public Long addEstate (@RequestBody Estate estate) {
        if (agreements.addEstate(estate))
	    return estate.getId();
        else	   
            return null;
    }
	
    @RequestMapping(value = "api/addAgreement", 
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE, 
            MediaType.APPLICATION_XML_VALUE })
    
    public Long addAgreement (@RequestBody Agreement agreement) {
		
	if (agreements.addAgreement(agreement))
	    return agreement.getId();
        else	   
            return null;
    }

}
