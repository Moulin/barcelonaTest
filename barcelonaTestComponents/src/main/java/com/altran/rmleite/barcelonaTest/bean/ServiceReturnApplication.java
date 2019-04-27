package com.altran.rmleite.barcelonaTest.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="ServicesReturn")
@XmlAccessorType(XmlAccessType.FIELD)
@Component("ServiceReturnApplication")
public class ServiceReturnApplication implements Serializable {
	
	private static final long serialVersionUID = -6376460406638624913L;

	private boolean operationOK;	
	private long numReturn;
	private int codError;
	private String dscError;
	
	public ServiceReturnApplication() {
		super();
		this.operationOK = false;
		this.numReturn = 0;
		this.codError = 0;
		this.dscError = "";
	}

	public ServiceReturnApplication(boolean operationOK, long numReturn, int codError, String dscError) {
		super();
		this.operationOK = operationOK;
		this.numReturn = numReturn;
		this.codError = codError;
		this.dscError = dscError;
	}

	public int getCodError() {
		return codError;
	}

	public String getDscError() {
		return dscError;
	}

	public long getNumReturn() {
		return numReturn;
	}

	public boolean isOperationOK() {
		return operationOK;
	}

	public void setCodError(int i) {
		codError = i;
	}

	public void setDscError(String string) {
		dscError = string;
	}

	public void setNumReturn(long l) {
		numReturn = l;
	}

	public void setOperationOK(boolean b) {
		operationOK = b;
	}

}