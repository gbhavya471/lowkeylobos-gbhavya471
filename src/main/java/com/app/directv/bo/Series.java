package com.app.directv.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "series")
public class Series {
	private String resourceType;
    private String itemType;
    private String title;
    private String description;
    private String metadataLanguage;
    private List<String> genres;
    private List<Map<String, Object>> seasons;
    private String parentalRating;
    private Map<String,Object> augmentation;
    private List<String> categories;
    private String programAttribution;
    @Id
    private String resourceId;
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMetadataLanguage() {
		return metadataLanguage;
	}
	public void setMetadataLanguage(String metadataLanguage) {
		this.metadataLanguage = metadataLanguage;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	
	public List<Map<String, Object>> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<Map<String, Object>> seasons) {
		this.seasons = seasons;
	}
	public Map<String, Object> getAugmentation() {
		return augmentation;
	}
	public void setAugmentation(Map<String, Object> augmentation) {
		this.augmentation = augmentation;
	}
	public String getParentalRating() {
		return parentalRating;
	}
	public void setParentalRating(String parentalRating) {
		this.parentalRating = parentalRating;
	}
	
	
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getProgramAttribution() {
		return programAttribution;
	}
	public void setProgramAttribution(String programAttribution) {
		this.programAttribution = programAttribution;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	@Override
	public String toString() {
		return "Series [resourceType=" + resourceType + ", itemType=" + itemType + ", title=" + title + ", description="
				+ description + ", metadataLanguage=" + metadataLanguage + ", genres=" + genres + ", seasons=" + seasons
				+ ", parentalRating=" + parentalRating + ", augmentation=" + augmentation + ", categories=" + categories
				+ ", programAttribution=" + programAttribution + ", resourceId=" + resourceId + "]";
	}
    
	

}
