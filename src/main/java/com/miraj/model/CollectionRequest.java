package com.miraj.model;

import io.swagger.annotations.ApiModelProperty;

public class CollectionRequest {

	@ApiModelProperty("Request position latitude")
	private String latitude;
	@ApiModelProperty("Request position longitude")
	private String longitude;
	@ApiModelProperty("Request distance from poistion")
	private String range;
	@ApiModelProperty("Request distance unit")
	private String unit;
	@ApiModelProperty("Request blood group")
	private String bloodGroup;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
}
