package com.miraj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miraj.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT us ,(((ACOS(SIN((:latitude*3.1416/180)) * SIN((us.latitude*pi()/180))+COS((:latitude*3.1416/180))"
     +"* COS((us.latitude*3.1416/180)) * COS(((:longitude - us.longitude)*3.1416/180))))*180/3.1416)*60*1.1515*1.609344)" 
     +"as distance FROM User us")  
	List<User> findDonarsAtFixedRange(@Param ("latitude") double latitude, @Param ("longitude") double longitude);

	@Query("SELECT user FROM User user where user.bloodInformation.bloodInformationId = :bloodGroup")
	List<User> findDonarsAtFixedRangeByBloodGroup(@Param ("bloodGroup") int bloodInformationId);

	@Query("SELECT user FROM User user")
	List<User> findAllUser();

	
}
