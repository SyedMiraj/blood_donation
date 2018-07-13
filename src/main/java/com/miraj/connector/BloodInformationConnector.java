package com.miraj.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miraj.entity.BloodInformation;
import com.miraj.repository.BloodRepo;

@Component
public class BloodInformationConnector {

	@Autowired
	BloodRepo bloodRepo;
	
	public Iterable<BloodInformation> findAll(){
		return bloodRepo.findAll();
	}
	
	public BloodInformation finOne(int bloodInformationId){
		return bloodRepo.findOne(bloodInformationId);
	}
	
	public BloodInformation addOrUpdateBlood(BloodInformation bloodInformation){
		return bloodRepo.save(bloodInformation);
	}
	
}
