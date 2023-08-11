package com.bloodbank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("BloodBank")
public class BloodBank {
	@Id
	private Integer bloodBankId;
	private String bloodBankName;
	private String email;
	private String phoneNumber;
	private Integer a_Post;
	private Integer a_Neg;
	private Integer b_Post;
	private Integer b_Neg;
	private Integer o_Post;
	private Integer o_Neg;
	private Integer ab_Post;
	private Integer ab_Neg;
	public BloodBank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BloodBank(Integer bloodBankId, String bloodBankName, String email, String phoneNumber, Integer a_Post,
			Integer a_Neg, Integer b_Post, Integer b_Neg, Integer o_Post, Integer o_Neg, Integer ab_Post,
			Integer ab_Neg) {
		super();
		this.bloodBankId = bloodBankId;
		this.bloodBankName = bloodBankName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.a_Post = a_Post;
		this.a_Neg = a_Neg;
		this.b_Post = b_Post;
		this.b_Neg = b_Neg;
		this.o_Post = o_Post;
		this.o_Neg = o_Neg;
		this.ab_Post = ab_Post;
		this.ab_Neg = ab_Neg;
	}
	public Integer getBloodBankId() {
		return bloodBankId;
	}
	public void setBloodBankId(Integer bloodBankId) {
		this.bloodBankId = bloodBankId;
	}
	public String getBloodBankName() {
		return bloodBankName;
	}
	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getA_Post() {
		return a_Post;
	}
	public void setA_Post(Integer a_Post) {
		this.a_Post = a_Post;
	}
	public Integer getA_Neg() {
		return a_Neg;
	}
	public void setA_Neg(Integer a_Neg) {
		this.a_Neg = a_Neg;
	}
	public Integer getB_Post() {
		return b_Post;
	}
	public void setB_Post(Integer b_Post) {
		this.b_Post = b_Post;
	}
	public Integer getB_Neg() {
		return b_Neg;
	}
	public void setB_Neg(Integer b_Neg) {
		this.b_Neg = b_Neg;
	}
	public Integer getO_Post() {
		return o_Post;
	}
	public void setO_Post(Integer o_Post) {
		this.o_Post = o_Post;
	}
	public Integer getO_Neg() {
		return o_Neg;
	}
	public void setO_Neg(Integer o_Neg) {
		this.o_Neg = o_Neg;
	}
	public Integer getAb_Post() {
		return ab_Post;
	}
	public void setAb_Post(Integer ab_Post) {
		this.ab_Post = ab_Post;
	}
	public Integer getAb_Neg() {
		return ab_Neg;
	}
	public void setAb_Neg(Integer ab_Neg) {
		this.ab_Neg = ab_Neg;
	}
	@Override
	public String toString() {
		return "BloodBank [bloodBankId=" + bloodBankId + ", bloodBankName=" + bloodBankName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", a_Post=" + a_Post + ", a_Neg=" + a_Neg + ", b_Post=" + b_Post
				+ ", b_Neg=" + b_Neg + ", o_Post=" + o_Post + ", o_Neg=" + o_Neg + ", ab_Post=" + ab_Post + ", ab_Neg="
				+ ab_Neg + "]";
	}
	
	

	
}
