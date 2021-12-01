package com.sofkau.fullstack.backend.repositories;

import com.sofkau.fullstack.backend.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Long> {
}
