package com.example.microservicevaldes.dao;

import com.example.microservicevaldes.model.Animaux;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimauxRepository extends MongoRepository<Animaux,String> {
}
