package com.bloodbank.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.bloodbank.model.AppUser;
import com.bloodbank.model.AppUserMapper;
import com.bloodbank.model.BloodBank;
import com.bloodbank.repository.IAppUserRepository;


@Service
public class AppUserServiceImpl implements UserDetailsManager,IAppUserService {

	@Autowired
	IAppUserRepository userRepository;
	
	@Autowired
	AppUserMapper appUserMapper;
	
	// from backend -> controller to save to DB
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);
		return  appUserMapper.convertToUserDetails(this.userRepository.findAll().stream().filter(i-> i.getUsername().equals(username)).toList().get(0));
	}

	// from frontend -> controller to save to DB
	@Override
	public void createUser(UserDetails user) {
		AppUser appUser = this.appUserMapper.convertToAppUser(user);
		this.userRepository.insert(appUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		System.out.println(username);
		return true;
	}
	@Override
	public
	List<AppUser> getAll()
	{
		return userRepository.findAll();
		
	}
	


}
