package com.miraj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
	private String password;

	@Column(name = "date_of_birth")
	private Timestamp dateOfBirth;

	@Column(name = "creation_date", nullable = false)
        @CreationTimestamp
	private Timestamp creationDate;
	
	@Column(name = "updated_at")
        @CreationTimestamp
	private Timestamp updateDate;
        
    @Column(name = "last_donate_date")
    private Timestamp lastBloodDonateDate;

	// bi-directional many-to-one association to blood_inforamtion table
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "blood_information")
	private BloodInformation bloodInformation;

	// bi directional relation with transfer_history table
	@OneToMany(mappedBy = "collector")
	private List<TransferHistory> transferHistoryCollector;

	// bi directional relation with transfer_history table
	@OneToMany(mappedBy = "donator")
	private List<TransferHistory> transferHistoryDonator;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getLastBloodDonateDate() {
		return lastBloodDonateDate;
	}

	public void setLastBloodDonateDate(Timestamp lastBloodDonateDate) {
		this.lastBloodDonateDate = lastBloodDonateDate;
	}

	public BloodInformation getBloodInformation() {
		return bloodInformation;
	}

	public void setBloodInformation(BloodInformation bloodInformation) {
		this.bloodInformation = bloodInformation;
	}

	public List<TransferHistory> getTransferHistoryCollector() {
		return transferHistoryCollector;
	}

	public void setTransferHistoryCollector(List<TransferHistory> transferHistoryCollector) {
		this.transferHistoryCollector = transferHistoryCollector;
	}

	public List<TransferHistory> getTransferHistoryDonator() {
		return transferHistoryDonator;
	}

	public void setTransferHistoryDonator(List<TransferHistory> transferHistoryDonator) {
		this.transferHistoryDonator = transferHistoryDonator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
