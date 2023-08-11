package com.bloodbank.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserMapper {
	private PasswordEncoder encoder;
	public AppUser convertToAppUser(UserDetails user) {
        // get data from UserDetails
        String username = user.getUsername();
        String password = user.getPassword();
        List<String>  roles = user.getAuthorities()
                            .stream()
                            .map(grantedAuthority->grantedAuthority.getAuthority())
                            .toList();
        // create appUser object
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setRoles(roles);
        return appUser;
    }
	public UserDetails convertToUserDetails(AppUser appUser) {		
		String username = appUser.getUsername();
		String password = appUser.getPassword();
		List<GrantedAuthority> roles = appUser.getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
		
		UserDetails userDetails = new User(username,password,roles);
		return userDetails;
	}
	
	
	
}
