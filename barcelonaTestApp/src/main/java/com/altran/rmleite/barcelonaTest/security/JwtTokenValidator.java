package com.altran.rmleite.barcelonaTest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Validation of the token. Performs validation and reading of the sent token. 
 * If it is validated correctly (secret OK and expiration time OK), it generates 
 * an object of type JwtUserDto with the information extracted from the token.
 */

@Component("jwtTokenUtil")
public class JwtTokenValidator implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenValidator.class);

	private static final long serialVersionUID = -3301605591108950415L;

	@Value("${jwt.secret}")
	private String secret;

	public JwtUserDto validaToken(String tokenJwt, String tokenHmac, String timestampHmac, String accessKeyCripto,
			String url) {

		JwtUserDto u = null;

		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(tokenJwt).getBody();

			u = new JwtUserDto();
			u.setUser(body.getSubject());
			long hourCreationToken = (Long) body.get("created");
			Date dtCreationToken = new Date(hourCreationToken);
			u.setDateCriation(dtCreationToken);
			u.setExpiration(body.getExpiration());
			u.setRole((String) body.get("role"));

			} catch (JwtException e) {
				logger.error(e.getMessage(), e);
				String resp = e.toString();
				String findExpired = "expired";
				String findInvalid = "unable to read";
				if (resp.toLowerCase().contains(findExpired)) {
					logger.debug(" AUTENTICATION - Expired JWT Token.");
				}
				if (resp.toLowerCase().contains(findInvalid)) {
					logger.debug(" AUTENTICATION - Invalid JWT Token.");
				}
			}
		return u;
	}

}