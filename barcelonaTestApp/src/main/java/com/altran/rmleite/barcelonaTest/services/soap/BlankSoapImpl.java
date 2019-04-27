package com.altran.rmleite.barcelonaTest.services.soap;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.altran.rmleite.barcelonaTest.bean.ServiceReturnApplication;
import com.altran.rmleite.barcelonaTest.exception.BusinessException;

@WebService
public class BlankSoapImpl extends SpringBeanAutowiringSupport implements BlankSoap {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlankSoapImpl.class);
	
	public ServiceReturnApplication someMethod(String str) throws BusinessException {
		
		LOGGER.debug("# Begin BlankSoap - Method: someMethodBlank");
		
		ServiceReturnApplication serviceReturn = new ServiceReturnApplication();
		
		try {
			serviceReturn.setOperationOK(true);
		} catch (Exception e) {
			LOGGER.error(e.toString(),e);
			serviceReturn.setCodError(1);
			serviceReturn.setDscError(e.getMessage());
			serviceReturn.setOperationOK(false);
		} 	
		
		LOGGER.debug("# End BlankSoap - Method: someMethodBlank");
		return serviceReturn;  
	}
}
