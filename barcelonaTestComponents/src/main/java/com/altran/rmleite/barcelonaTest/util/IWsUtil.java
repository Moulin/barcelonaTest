package com.altran.rmleite.barcelonaTest.util;

import java.io.IOException;
import java.net.URI;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface IWsUtil {

	String jSonFromObject(Object objeto) throws JsonGenerationException, JsonMappingException, IOException;

	Object objectFromJSon(String jSon, Class<? extends Object> classe)
			throws JsonParseException, JsonMappingException, IOException;

	String chamarWSRestTokenJson(URI uri, String json) throws Exception;

}