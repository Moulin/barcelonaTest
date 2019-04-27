package com.altran.rmleite.barcelonaTest.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Component(value="wsutil")
public class WsUtil implements IWsUtil {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7991358066298420270L;
		
	/* (non-Javadoc)
	 * @see com.altran.rmleite.barcelonaTest.util.IWsUtil#jSonFromObject(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("deprecation")
	public String jSonFromObject(Object objeto) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector ai = new JaxbAnnotationIntrospector();
		mapper.getDeserializationConfig().setAnnotationIntrospector(ai);
	    mapper.getSerializationConfig().setAnnotationIntrospector(ai);
		return mapper.writeValueAsString(objeto);
	}
	
	/* (non-Javadoc)
	 * @see com.altran.rmleite.barcelonaTest.util.IWsUtil#objectFromJSon(java.lang.String, java.lang.Class)
	 */
	@Override
	@SuppressWarnings("deprecation")
	public Object objectFromJSon(String jSon, Class<? extends Object> classe) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector ai = new JaxbAnnotationIntrospector();
		mapper.getDeserializationConfig().setAnnotationIntrospector(ai);
	    mapper.getSerializationConfig().setAnnotationIntrospector(ai);
		return mapper.readValue(jSon, classe);
	}
	
	/* (non-Javadoc)
	 * @see com.altran.rmleite.barcelonaTest.util.IWsUtil#chamarWSRestTokenJson(java.net.URI, java.lang.String)
	 */
	@Override
	public String chamarWSRestTokenJson(URI uri, String json) throws Exception {
		
		ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);		
        Client client = Client.create(config);
		
        
		client.setReadTimeout(Integer.valueOf(5000));
		client.setConnectTimeout(Integer.valueOf(1000));
 
		WebResource resource = client.resource(uri);		
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		int httpStatus = response.getStatus();
		
		if(httpStatus != 200){
			throw new Exception("Failed. HTTP error code: " + httpStatus);
		}
		return response.getEntity(String.class);
		
	}
	
}
