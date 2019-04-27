package com.altran.rmleite.barcelonaTest.services.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altran.rmleite.barcelonaTest.bean.BlankRestVO;
import com.altran.rmleite.barcelonaTest.bean.ServiceReturnApplication;
import com.altran.rmleite.barcelonaTest.security.AuthenticatedUser;

@RestController
@RequestMapping("/restws/blankrest")
public class BlankRest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlankRest.class);

	@RequestMapping(value = "/somemethodblank",method = RequestMethod.POST, produces = "application/json")
	public ServiceReturnApplication someMethodBlank(@RequestBody BlankRestVO blankRestVO) {
		
		LOGGER.debug("# Begin BlankRest - Method: someMethodBlank");
		
		ServiceReturnApplication serviceReturn = new ServiceReturnApplication();

		AuthenticatedUser userLogged = (AuthenticatedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user = userLogged.getUsername();		
		
		boolean userOK = true;
		String userVO = blankRestVO.getNmeUser();
		
		if (user == null) {			
			if (userVO == null || userVO.trim().length() < 5) {
				LOGGER.error("Usuario invalido");
				serviceReturn.setOperationOK(false);
				serviceReturn.setDscError("Invalid User");
				userOK = false;
			}
		}	
		
		LOGGER.debug(" # user: {}", user);	
		
		if (userOK) {
			try {			
				serviceReturn.setOperationOK(true);			
			} catch (Exception e) {
				LOGGER.error(e.toString(),e);
				serviceReturn.setCodError(1);
				serviceReturn.setDscError(e.getMessage());
				serviceReturn.setOperationOK(false);
			} 
		}
		LOGGER.debug("# End BlankRest - Method: someMethodBlank #");
		return serviceReturn;
	}
	
}
