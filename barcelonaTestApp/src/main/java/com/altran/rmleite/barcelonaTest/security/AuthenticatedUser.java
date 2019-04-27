package com.altran.rmleite.barcelonaTest.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthenticatedUser implements UserDetails {

	private static final long serialVersionUID = -9220112730066108357L;

    private final String username;
    private final String token;
    private final Collection<? extends GrantedAuthority> authorities;
    
    public AuthenticatedUser(String username, String token, Collection<? extends GrantedAuthority> authorities) {     
        this.username = username;
        this.token = token;
        this.authorities = authorities;     
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return null;
    }
    
}
