package com.altran.rmleite.barcelonaTest.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"code",
	"display_name",
	"description",
	"created",
	"package_count",
	"image_display_url",
	"description_translated",
	"name",
	"is_organization",
	"state",
	"image_url",
	"groups",
	"type",
	"title",
	"revision_id",
	"title_translated",
	"num_followers",
	"id",
	"approval_status"
})
public class Parent {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("display_name")
	private String displayName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("package_count")
	private Integer packageCount;
	
	@JsonProperty("image_display_url")
	private String imageDisplayUrl;
	
	@JsonProperty("description_translated")
	private DescriptionTranslated descriptionTranslated;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("is_organization")
	private Boolean isOrganization;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	@JsonProperty("groups")
	private List<Object> groups = null;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("revision_id")
	private String revisionId;
	
	@JsonProperty("title_translated")
	private TitleTranslated_ titleTranslated;
	
	@JsonProperty("num_followers")
	private Integer numFollowers;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("approval_status")
	private String approvalStatus;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Parent() {
	}
	
	/**
	* 
	* @param numFollowers
	* @param isOrganization
	* @param titleTranslated
	* @param imageUrl
	* @param imageDisplayUrl
	* @param packageCount
	* @param state
	* @param descriptionTranslated
	* @param code
	* @param type
	* @param revisionId
	* @param id
	* @param title
	* @param created
	* @param description
	* @param approvalStatus
	* @param name
	* @param displayName
	* @param groups
	*/
	public Parent(String code, String displayName, String description, String created, Integer packageCount, String imageDisplayUrl, DescriptionTranslated descriptionTranslated, String name, Boolean isOrganization, String state, String imageUrl, List<Object> groups, String type, String title, String revisionId, TitleTranslated_ titleTranslated, Integer numFollowers, String id, String approvalStatus) {
		super();
		this.code = code;
		this.displayName = displayName;
		this.description = description;
		this.created = created;
		this.packageCount = packageCount;
		this.imageDisplayUrl = imageDisplayUrl;
		this.descriptionTranslated = descriptionTranslated;
		this.name = name;
		this.isOrganization = isOrganization;
		this.state = state;
		this.imageUrl = imageUrl;
		this.groups = groups;
		this.type = type;
		this.title = title;
		this.revisionId = revisionId;
		this.titleTranslated = titleTranslated;
		this.numFollowers = numFollowers;
		this.id = id;
		this.approvalStatus = approvalStatus;
	}
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	
	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonProperty("display_name")
	public String getDisplayName() {
		return displayName;
	}
	
	@JsonProperty("display_name")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("created")
	public String getCreated() {
		return created;
	}
	
	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}
	
	@JsonProperty("package_count")
	public Integer getPackageCount() {
		return packageCount;
	}
	
	@JsonProperty("package_count")
	public void setPackageCount(Integer packageCount) {
		this.packageCount = packageCount;
	}
	
	@JsonProperty("image_display_url")
	public String getImageDisplayUrl() {
		return imageDisplayUrl;
	}
	
	@JsonProperty("image_display_url")
	public void setImageDisplayUrl(String imageDisplayUrl) {
		this.imageDisplayUrl = imageDisplayUrl;
	}
	
	@JsonProperty("description_translated")
	public DescriptionTranslated getDescriptionTranslated() {
		return descriptionTranslated;
	}
	
	@JsonProperty("description_translated")
	public void setDescriptionTranslated(DescriptionTranslated descriptionTranslated) {
		this.descriptionTranslated = descriptionTranslated;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("is_organization")
	public Boolean getIsOrganization() {
		return isOrganization;
	}
	
	@JsonProperty("is_organization")
	public void setIsOrganization(Boolean isOrganization) {
		this.isOrganization = isOrganization;
	}
	
	@JsonProperty("state")
	public String getState() {
		return state;
	}
	
	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}
	
	@JsonProperty("image_url")
	public String getImageUrl() {
		return imageUrl;
	}
	
	@JsonProperty("image_url")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@JsonProperty("groups")
	public List<Object> getGroups() {
		return groups;
	}
	
	@JsonProperty("groups")
	public void setGroups(List<Object> groups) {
		this.groups = groups;
	}
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonProperty("revision_id")
	public String getRevisionId() {
		return revisionId;
	}
	
	@JsonProperty("revision_id")
	public void setRevisionId(String revisionId) {
		this.revisionId = revisionId;
	}
	
	@JsonProperty("title_translated")
	public TitleTranslated_ getTitleTranslated() {
		return titleTranslated;
	}
	
	@JsonProperty("title_translated")
	public void setTitleTranslated(TitleTranslated_ titleTranslated) {
		this.titleTranslated = titleTranslated;
	}
	
	@JsonProperty("num_followers")
	public Integer getNumFollowers() {
		return numFollowers;
	}
	
	@JsonProperty("num_followers")
	public void setNumFollowers(Integer numFollowers) {
		this.numFollowers = numFollowers;
	}
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("approval_status")
	public String getApprovalStatus() {
		return approvalStatus;
	}
	
	@JsonProperty("approval_status")
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
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