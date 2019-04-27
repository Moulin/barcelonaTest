package com.altran.rmleite.barcelonaTest.bean;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"capacity",
	"name"
})
public class Group {

	@JsonProperty("capacity")
	private String capacity;
	
	@JsonProperty("name")
	private String name;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Group() {
	}
	
	/**
	* 
	* @param name
	* @param capacity
	*/
	public Group(String capacity, String name) {
		super();
		this.capacity = capacity;
		this.name = name;
	}
	
	@JsonProperty("capacity")
	public String getCapacity() {
		return capacity;
	}
	
	@JsonProperty("capacity")
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}