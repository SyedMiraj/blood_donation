package com.miraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraj.entity.TransferHistory;

@Repository
public interface TransferHistoryRepo extends CrudRepository<TransferHistory, Integer>{

}
