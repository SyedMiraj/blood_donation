package com.miraj.serviceImpl;

import java.util.List;

import com.miraj.model.CollectionRequest;
import com.miraj.model.UserModel;
import com.miraj.model.UserModelList;

public interface CollectionServiceInterface {

	public UserModelList getFilteredData(CollectionRequest collectionRequest);
}
