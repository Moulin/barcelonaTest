package com.altran.rmleite.barcelonaTest.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Value("${jwt.header}")
    private String tokenHeader;
    
    @Value("${hmac.header.token}")
    private String tokenHmac;
    
    @Value("${hmac.header.accessKey}")
    private String accessKey;
    
    @Value("${hmac.header.timestamp}")
    private String timestampHmac;

    public JwtAuthenticationTokenFilter() {
        super("/*ws/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

    	// Header for JWT
        String header = request.getHeader(this.tokenHeader);
        
        // Header for HMAC
        String url = request.getRequestURL().toString();
		String tokenClient = request.getHeader(this.tokenHmac);
		String accessKey = request.getHeader(this.accessKey);
		String timestampClient = request.getHeader(this.timestampHmac);
		int httpStatus = response.getStatus();

        if (header == null || !header.startsWith("Bearer ")) {        	
        	if ( StringUtils.isEmpty(url) ||
        			StringUtils.isEmpty(timestampClient) || 
        			StringUtils.isEmpty(accessKey) ||
        			StringUtils.isEmpty(tokenClient)  ) {
        		LOGGER.debug(" AUTENTICATION - Token information not found in the header of the request.");
                throw new JwtTokenMissingException("AUTENTICATION - Token information not found in the header of the request.");
        	}          	
        } 

        String authToken = null;
        if (header != null) {
        	authToken = header.substring(7);  
        }      
        
        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken,tokenClient,accessKey,url,timestampClient,httpStatus);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
    	
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}