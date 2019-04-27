package com.altran.rmleite.barcelonaTest.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SuppressWarnings("deprecation")
public class Util {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	public static String chamarWSRest(String url) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<MediaType> lista = new ArrayList<MediaType>();
		lista.add(MediaType.APPLICATION_JSON);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(lista);
		
		String json = ""; //Util.gerarJSonfromObject(voRest);		
		
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	    requestFactory.setReadTimeout(5000);
	    requestFactory.setConnectTimeout(1000);
	    	    
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		 
		HttpEntity<String> request = new HttpEntity<String>(json,header);
		String result = restTemplate.postForObject(url, request, String.class);

		return result;
	}

}