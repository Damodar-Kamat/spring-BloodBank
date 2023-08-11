package com.bloodbank.service;

import java.util.List;

import com.bloodbank.exceptions.BloodNotFoundException;
import com.bloodbank.model.BloodBank;
import com.bloodbank.model.BloodBankDTO;

public interface IBloodBankService {
	void addBloodBank(BloodBankDTO bloodBankDTO);
	BloodBankDTO updateBloodBank(BloodBankDTO bookDTO);
	void deleteBloodBank(int bloodBankId);
	BloodBankDTO findById(int bloodBankId) throws BloodNotFoundException;
	List<BloodBankDTO> getAll() throws BloodNotFoundException;
	List<BloodBankDTO> findAPostGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findANegGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findBPostGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findBNegGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findOPostGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findONegGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findABPostGreaterThan(int bloodUnit) throws BloodNotFoundException;
	List<BloodBankDTO> findABNegGreaterThan(int bloodUnit) throws BloodNotFoundException;
}
