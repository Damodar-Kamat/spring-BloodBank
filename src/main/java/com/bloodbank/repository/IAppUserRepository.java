package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.AppUser;
import com.bloodbank.model.BloodBank;

@Repository
public interface IAppUserRepository extends MongoRepository<AppUser, String>{
	AppUser findByEmail(String email);
	

//	Optional<AppUser> findByEmail(String email, String username);
	
}	
