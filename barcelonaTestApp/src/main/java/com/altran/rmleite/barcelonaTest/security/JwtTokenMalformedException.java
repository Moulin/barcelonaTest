package com.altran.rmleite.barcelonaTest.security;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {

	private static final long serialVersionUID = 770495900089030699L;

	public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
