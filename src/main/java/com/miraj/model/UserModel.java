package com.miraj.model;

import io.swagger.annotations.ApiModelProperty;

public class UserModel {

	@ApiModelProperty("User's ID")
	private String id;
	
	@ApiModelProperty("User's name")
	private String name;
	
	@ApiModelProperty("User's date of birth")
	private String dateOfBith;
	
	@ApiModelProperty("User's mobile number")
	private String mobileNumber;
	
	@ApiModelProperty("User's password")
	private String password;
	
	@ApiModelProperty("User's email address")
	private String emailAddress;
	
	@ApiModelProperty("User's home address latitude")
	private String latitude;
	
	@ApiModelProperty("User's home address longitude")
	private String longitude;
	
	@ApiModelProperty("Distance from a certain point")
	private String distance;
	
	@ApiModelProperty("User's blood group ID")
	private String bloodGroupId;
	
	@ApiModelProperty("User's blood group")
	private String bloodGroup;
        
	@ApiModelProperty("User's last blood donation date")
	private String lastBloodDonate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBith() {
		return dateOfBith;
	}

	public void setDateOfBith(String dateOfBith) {
		this.dateOfBith = dateOfBith;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(String bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

    public String getLastBloodDonate() {
        return lastBloodDonate;
    }

    public void setLastBloodDonate(String lastBloodDonate) {
        this.lastBloodDonate = lastBloodDonate;
    }
	
	
}
