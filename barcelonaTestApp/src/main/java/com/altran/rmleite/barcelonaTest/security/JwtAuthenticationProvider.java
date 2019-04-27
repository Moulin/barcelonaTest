package com.altran.rmleite.barcelonaTest.security;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
  
    @Autowired
    private JwtTokenValidator jwtTokenValidator;

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

	@Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    	    	
    	JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;;

        String tokenJwt = jwtAuthenticationToken.getToken();        
        String tokenHmac = jwtAuthenticationToken.getTokenHmac();
        String timestampHmac = jwtAuthenticationToken.getTimestampClient();
        String accessKey = jwtAuthenticationToken.getAccessKey();
        String url = jwtAuthenticationToken.getUrl();
        int httpStatus = jwtAuthenticationToken.getHttpStatus();
        
        int indexProtocolo = url.indexOf("//");
        url = url.substring(indexProtocolo + 2);
        
        JwtUserDto parsedUser = jwtTokenValidator.validaToken(tokenJwt,tokenHmac,timestampHmac,accessKey,url);
           	
        if (parsedUser == null) {
           	if (httpStatus != 200) {
           		if (httpStatus == 401 || httpStatus == 500) {
                	LOGGER.debug(" AUTENTICATION - Invalid Token.");
                	throw new JwtTokenMalformedException("AUTENTICATION - Invalid Token.");
                } else {
                	LOGGER.debug("Error in request - HTTP Status: {}", httpStatus);
                	throw new JwtTokenMalformedException("Error in request - HTTP Status: " + httpStatus);
                }
           	} else {
           		throw new JwtTokenMalformedException("AUTENTICATION - Invalid Token.");
           	}
       	}
        
        List<GrantedAuthority> authorityList = null;
        if (tokenJwt != null) {
	        authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());
        } 
	
	    return new AuthenticatedUser(parsedUser.getUser(), tokenJwt, authorityList);
       
    }

}
