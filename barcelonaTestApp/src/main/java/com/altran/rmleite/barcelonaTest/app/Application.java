package com.altran.rmleite.barcelonaTest.app;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.altran.rmleite.barcelonaTest.bean.ApiReturn;
import com.altran.rmleite.barcelonaTest.util.WsUtil;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.autran.rmleite.*"})
public class Application extends SpringBootServletInitializer {	
	
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    @Bean(name="wsutil")
    public WsUtil wsutil() {
    	return new WsUtil();
    }
	
    @Bean(name="consume")
    String consume() throws IllegalArgumentException, UriBuilderException, Exception {
    	String url= "https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search";
//    	RestTemplate restTemplate = new RestTemplate();
//		ApiReturn apiReturn = restTemplate.getForObject(url , ApiReturn.class);
//		String apiReturn = restTemplate.getForObject(url , String.class);
    	String apiReturn = wsutil().chamarWSRestTokenJson(UriBuilder.fromUri(url).build(), "");
		wsutil().objectFromJSon(apiReturn, ApiReturn.class);
    	log.info(apiReturn.toString());
		
		return apiReturn;

	}
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		 
    }
    
}