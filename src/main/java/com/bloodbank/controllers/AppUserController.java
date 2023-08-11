package com.bloodbank.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.exceptions.BloodNotFoundException;
import com.bloodbank.model.AppUser;
import com.bloodbank.model.AppUserMapper;
import com.bloodbank.model.BloodBankDTO;
import com.bloodbank.service.IAppUserService;


@RestController
@RequestMapping("/user-api/v1")
public class AppUserController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;

	@Autowired
	AppUserMapper appUserMapper;
	
	@Autowired
	@Qualifier("appUserServiceImpl")
	private IAppUserService iAppUserService;
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/app-users")
	public void addUser(@RequestBody AppUser appUser) {
		UserDetails userDetails = this.appUserMapper.convertToUserDetails(appUser);
		this.userDetailsManager.createUser(userDetails);
	}	
	
	@GetMapping("/app-users")
    public UserDetails loadUserByUsername(@RequestBody AppUser appUser) {
        UserDetails userDetails = userDetailsManager.loadUserByUsername(appUser.getUsername());
        if(userDetails.getPassword()==appUser.getPassword())
        	return userDetails;
        return null;
    }
	//http://localhost:8080/user-api/v1/appUser/getall
		@CrossOrigin("http://localhost:4200/")
		@GetMapping("/appUser/getall")
		ResponseEntity<List<AppUser>> getAll(){
			List<AppUser> appUsers= iAppUserService.getAll();
			HttpHeaders headers=new HttpHeaders();
			headers.add("desc","Getting the list of Users");
			headers.add("time retrieved", LocalDateTime.now().toString());
			ResponseEntity<List<AppUser>> responseEntity=new ResponseEntity<List<AppUser>>(appUsers,headers,HttpStatus.OK);
			return responseEntity;
			
		}
}	
