package com.miraj.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="blood_transfer_history")
public class TransferHistory implements Serializable{
	
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transfer_id")
	private int transferId;
	
	@Column(name="collection_date")
	private Timestamp collectionDate;
	
//	bi-directional one-to-one association to blood_inforamtion table
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "blood_inforamtion")
	private BloodInformation bloodInformation;
	
//	bi-directional one-to-one association to user table
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "collector")
	private User collector;
	
//	bi-directional one-to-one association to blood_inforamtion table
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "donator")
	private User donator;

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
	}

	public BloodInformation getBloodInformation() {
		return bloodInformation;
	}

	public void setBloodInformation(BloodInformation bloodInformation) {
		this.bloodInformation = bloodInformation;
	}

	public User getCollector() {
		return collector;
	}

	public void setCollector(User collector) {
		this.collector = collector;
	}

	public User getDonator() {
		return donator;
	}

	public void setDonator(User donator) {
		this.donator = donator;
	}

}
