package com.app.directv.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.directv.bo.Channel;

public interface IDirecTvRepositoryChannel extends MongoRepository<Channel,String>{

}
