package com.altran.rmleite.barcelonaTest.security;

import java.util.Date;

public class JwtUserDto {

    private String user;
    private Date dateCreation;
    private Date expiration;
    private String role;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDateCriation() {
        return dateCreation;
    }

    public void setDateCriation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

	public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
	
}