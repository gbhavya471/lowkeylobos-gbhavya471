package com.app.directv.bo;

import org.springframework.stereotype.Component;

@Component
public class Seasons {
	
	private int seasonNumber;
	private String resourceType;
	public int getSeasonNumber() {
		return seasonNumber;
	}
	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	

}
