package com.altran.rmleite.barcelonaTest.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.altran.rmleite.barcelonaTest.bean.ServiceReturnApplication;
import com.altran.rmleite.barcelonaTest.exception.BusinessException;

@WebService
public interface BlankSoap {

	@WebMethod
	public ServiceReturnApplication someMethod(@WebParam(name="chassi") String str) throws BusinessException;
}
