package com.altran.rmleite.barcelonaTest.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -8636362946947010438L;
	
	private String token;
	private String tokenHmac;
	private String accessKey;
	private String url;
	private String timestampClient;
	private int httpStatus;

	public JwtAuthenticationToken(String token, String tokenHmac, String accessKey, String url, String timestampClient, int httpStatus) {
	        super(null, null);
	        this.token = token;
	        this.tokenHmac = tokenHmac;
	        this.accessKey = accessKey;
	        this.url = url;
	        this.timestampClient = timestampClient;
	        this.httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return httpStatus;
	}   

    public String getToken() {
        return token;
    }

    public String getTokenHmac() {
		return tokenHmac;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getUrl() {
		return url;
	}

	public String getTimestampClient() {
		return timestampClient;
	}

	@Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
    
}