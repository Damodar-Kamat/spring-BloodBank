package com.bloodbank.model;

import org.springframework.stereotype.Component;

@Component
public class BloodBankMapper {
	public BloodBank convertToDocument(BloodBankDTO bloodBankDTO)
	{
		BloodBank bloodBank=new BloodBank();
		bloodBank.setBloodBankId(bloodBankDTO.getBloodBankId());
		bloodBank.setBloodBankName(bloodBankDTO.getBloodBankName());
		bloodBank.setEmail(bloodBankDTO.getEmail());
		bloodBank.setPhoneNumber(bloodBankDTO.getPhoneNumber());
		bloodBank.setA_Post(bloodBankDTO.getA_Post());
		bloodBank.setA_Neg(bloodBankDTO.getA_Neg());
		bloodBank.setB_Post(bloodBankDTO.getB_Post());
		bloodBank.setB_Neg(bloodBankDTO.getB_Neg());
		bloodBank.setO_Post(bloodBankDTO.getO_Post());
		bloodBank.setO_Neg(bloodBankDTO.getO_Neg());
		bloodBank.setAb_Post(bloodBankDTO.getAb_Post());
		bloodBank.setAb_Neg(bloodBankDTO.getAb_Neg());
		return bloodBank;
	}
	
	public BloodBankDTO convertToDTO(BloodBank bloodBank)
	{
		BloodBankDTO bloodBankDTO=new BloodBankDTO();
		bloodBankDTO.setBloodBankId(bloodBank.getBloodBankId());
		bloodBankDTO.setBloodBankName(bloodBank.getBloodBankName());
		bloodBankDTO.setEmail(bloodBank.getEmail());
		bloodBankDTO.setPhoneNumber(bloodBank.getPhoneNumber());
		bloodBankDTO.setA_Post(bloodBank.getA_Post());
		bloodBankDTO.setA_Neg(bloodBank.getA_Neg());
		bloodBankDTO.setB_Post(bloodBank.getB_Post());
		bloodBankDTO.setB_Neg(bloodBank.getB_Neg());
		bloodBankDTO.setO_Post(bloodBank.getO_Post());
		bloodBankDTO.setO_Neg(bloodBank.getO_Neg());
		bloodBankDTO.setAb_Post(bloodBank.getAb_Post());
		bloodBankDTO.setAb_Neg(bloodBank.getAb_Neg());
		return bloodBankDTO;
	}
}
