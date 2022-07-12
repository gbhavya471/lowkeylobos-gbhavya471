package com.app.directv.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.directv.bo.Series;

public interface IDirecTvRepository extends MongoRepository<Series,String>{

}
