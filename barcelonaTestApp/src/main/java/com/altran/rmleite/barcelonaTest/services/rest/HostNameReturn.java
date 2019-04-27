package com.altran.rmleite.barcelonaTest.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HostNameReturn {
	
    @RequestMapping("/")
    public String greeting() {
        return "OK";
    }	
}