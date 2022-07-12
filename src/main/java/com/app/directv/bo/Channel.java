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
@Document(collection = "channel")
public class Channel {
	
	private String resourceType;
    private String itemType;
    private int majorChannelNumber;
    private String name;
    private String description;
    private int ccId;
    private int marketId;
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
	public int getMajorChannelNumber() {
		return majorChannelNumber;
	}
	public void setMajorChannelNumber(int majorChannelNumber) {
		this.majorChannelNumber = majorChannelNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCcId() {
		return ccId;
	}
	public void setCcId(int ccId) {
		this.ccId = ccId;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
    


}
