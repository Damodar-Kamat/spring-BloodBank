package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.exceptions.BloodNotFoundException;
import com.bloodbank.model.BloodBank;
import com.bloodbank.model.BloodBankDTO;
import com.bloodbank.model.BloodBankMapper;
import com.bloodbank.repository.IBloodBankRepository;

@Service
public class BloodBankServiceImpl implements IBloodBankService{
	@Autowired
	private IBloodBankRepository iBloodBankRepository;
	
	@Autowired
	private BloodBankMapper bloodBankMapper;

	@Override
	public void addBloodBank(BloodBankDTO bloodBankDTO) {
		BloodBank bloodBank=bloodBankMapper.convertToDocument(bloodBankDTO);
		iBloodBankRepository.insert(bloodBank);
	}

	@Override
	public BloodBankDTO updateBloodBank(BloodBankDTO bloodBankDTO) {
		BloodBank bloodBank=bloodBankMapper.convertToDocument(bloodBankDTO);
		BloodBank nBloodBank=iBloodBankRepository.save(bloodBank);
		return bloodBankMapper.convertToDTO(nBloodBank);
	}

	@Override
	public void deleteBloodBank(int bloodBankId) {
		iBloodBankRepository.deleteById(bloodBankId);
	}

	@Override
	public BloodBankDTO findById(int bloodBankId) throws BloodNotFoundException {
		BloodBank bloodBank=iBloodBankRepository.findById(bloodBankId)
				.orElseThrow(()->new BloodNotFoundException("No Blood Bank found with given id"));
		return bloodBankMapper.convertToDTO(bloodBank);
	}

	@Override
	public List<BloodBankDTO> getAll(){
		List<BloodBank> bloodBanks=iBloodBankRepository.findAll();
		List<BloodBankDTO> bloodBankDtos=bloodBanks
				.stream()
				.map(bloodBank->bloodBankMapper.convertToDTO(bloodBank))
				.toList();
		return bloodBankDtos;
	}

	@Override
	public List<BloodBankDTO> findAPostGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findAPostGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findANegGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findANegGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findBPostGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findBPostGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findBNegGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findBNegGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findOPostGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findOPostGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findONegGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findONegGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findABPostGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findABPostGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}

	@Override
	public List<BloodBankDTO> findABNegGreaterThan(int bloodUnit) throws BloodNotFoundException {
		List<BloodBank> bloodBanks=iBloodBankRepository.findABNegGreaterThan(bloodUnit);
		return convertToList(bloodBanks);
	}
	
	public List<BloodBankDTO> convertToList(List<BloodBank> bloodBanks) throws BloodNotFoundException
	{
		if(bloodBanks.isEmpty())
			throw new BloodNotFoundException("No blood found");
		List<BloodBankDTO> bloodBankDtos=bloodBanks
				.stream()
				.map(bloodBank->bloodBankMapper.convertToDTO(bloodBank))
				.toList();
		return bloodBankDtos;
	}

}
