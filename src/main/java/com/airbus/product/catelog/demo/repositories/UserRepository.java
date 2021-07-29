package com.airbus.product.catelog.demo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.airbus.product.catelog.demo.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findByEmailId(String emailId);
	
	public void save(Optional<User> user);


}
