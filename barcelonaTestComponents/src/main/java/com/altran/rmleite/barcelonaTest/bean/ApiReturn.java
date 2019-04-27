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
	"help",
	"success",
	"result"
})
public class ApiReturn {
	
	@JsonProperty("help")
	private String help;
	
	@JsonProperty("success")
	private Boolean success;
	
	@JsonProperty("result")
	private Result result;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public ApiReturn() {
	}
	
	/**
	* 
	* @param result
	* @param help
	* @param success
	*/
	public ApiReturn(String help, Boolean success, Result result) {
		super();
		this.help = help;
		this.success = success;
		this.result = result;
	}
	
	@JsonProperty("help")
	public String getHelp() {
		return help;
	}
	
	@JsonProperty("help")
	public void setHelp(String help) {
		this.help = help;
	}
	
	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}
	
	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	@JsonProperty("result")
	public Result getResult() {
		return result;
	}
	
	@JsonProperty("result")
	public void setResult(Result result) {
		this.result = result;
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