package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.BloodBank;

@Repository
public interface IBloodBankRepository extends MongoRepository<BloodBank,Integer>{
	@Query("{A_Post:{$gte:?0}}")
	List<BloodBank> findAPostGreaterThan(int bloodUnit);
	@Query("{A_Neg:{$gte:?0}}")
	List<BloodBank> findANegGreaterThan(int bloodUnit);
	@Query("{B_Post:{$gte:?0}}")
	List<BloodBank> findBPostGreaterThan(int bloodUnit);
	@Query("{B_Neg:{$gte:?0}}")
	List<BloodBank> findBNegGreaterThan(int bloodUnit);
	@Query("{O_Post:{$gte:?0}}")
	List<BloodBank> findOPostGreaterThan(int bloodUnit);
	@Query("{O_Neg:{$gte:?0}}")
	List<BloodBank> findONegGreaterThan(int bloodUnit);
	@Query("{AB_Post:{$gte:?0}}")
	List<BloodBank> findABPostGreaterThan(int bloodUnit);
	@Query("{AB_Neg:{$gte:?0}}")
	List<BloodBank> findABNegGreaterThan(int bloodUnit);
	
}
