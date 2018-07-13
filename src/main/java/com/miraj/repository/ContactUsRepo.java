package com.miraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraj.entity.ContactUsFeedback;

@Repository
public interface ContactUsRepo extends CrudRepository<ContactUsFeedback, Integer>{

}
