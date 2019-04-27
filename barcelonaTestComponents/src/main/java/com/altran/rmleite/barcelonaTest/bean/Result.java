package com.altran.rmleite.barcelonaTest.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
	"count",
	"sort",
	"facets",
	"results",
	"search_facets"
})
public class Result {
	
	@JsonProperty("count")
	private Integer count;
	
	@JsonProperty("sort")
	private String sort;
	
	@JsonProperty("facets")
	private Facets facets;
	
	@JsonProperty("results")
	private List<Result_> results = null;
	
	@JsonProperty("search_facets")
	private SearchFacets searchFacets;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Result() {
	}
	
	/**
	* 
	* @param searchFacets
	* @param sort
	* @param results
	* @param count
	* @param facets
	*/
	public Result(Integer count, String sort, Facets facets, List<Result_> results, SearchFacets searchFacets) {
		super();
		this.count = count;
		this.sort = sort;
		this.facets = facets;
		this.results = results;
		this.searchFacets = searchFacets;
	}
	
	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}
	
	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty("sort")
	public String getSort() {
		return sort;
	}
	
	@JsonProperty("sort")
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@JsonProperty("facets")
	public Facets getFacets() {
		return facets;
	}
	
	@JsonProperty("facets")
	public void setFacets(Facets facets) {
		this.facets = facets;
	}
	
	@JsonProperty("results")
	public List<Result_> getResults() {
		return results;
	}
	
	@JsonProperty("results")
	public void setResults(List<Result_> results) {
		this.results = results;
	}
	
	@JsonProperty("search_facets")
	public SearchFacets getSearchFacets() {
		return searchFacets;
	}
	
	@JsonProperty("search_facets")
	public void setSearchFacets(SearchFacets searchFacets) {
		this.searchFacets = searchFacets;
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