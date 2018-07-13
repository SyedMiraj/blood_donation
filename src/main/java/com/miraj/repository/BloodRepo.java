package com.miraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraj.entity.BloodInformation;

@Repository
public interface BloodRepo extends CrudRepository<BloodInformation, Integer>{

}
