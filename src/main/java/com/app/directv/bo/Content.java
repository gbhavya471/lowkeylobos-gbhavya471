package com.app.directv.bo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "content")
public class Content {
	private String resourceType;
    private String itemType;
    private String contentType;
    private String title;
    private String displayTitle;
    private String description;
    private String metadataLanguage;
    private String parentalRating;
    private List<String> genres;
    private String originalAirDate;
    private String releaseYear;
    private List<String> categories;
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
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDisplayTitle() {
		return displayTitle;
	}
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
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
	public String getParentalRating() {
		return parentalRating;
	}
	public void setParentalRating(String parentalRating) {
		this.parentalRating = parentalRating;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public String getOriginalAirDate() {
		return originalAirDate;
	}
	public void setOriginalAirDate(String originalAirDate) {
		this.originalAirDate = originalAirDate;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
    

}
