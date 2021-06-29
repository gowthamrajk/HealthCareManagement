package com.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.application.model.User;
import com.application.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService implements UserDetailsService
{
	@Autowired
	private UserRegistrationRepository userRegistrationRepo;
	
	public User saveUser(User user)
	{
		return userRegistrationRepo.save(user);
	}
	
	public User updateUserProfile(User user)
	{
		return userRegistrationRepo.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return (List<User>)userRegistrationRepo.findAll();
	}
	
	public User fetchUserByEmail(String email)
	{
		return userRegistrationRepo.findByEmail(email);
	}
	
	public User fetchUserByUsername(String username)
	{
		return userRegistrationRepo.findByUsername(username);
	}
	
	public User fetchUserByEmailAndPassword(String email, String password)
	{
		return userRegistrationRepo.findByEmailAndPassword(email, password);
	}
	
	public List<User> fetchProfileByEmail(String email)
	{
		return (List<User>)userRegistrationRepo.findProfileByEmail(email);
	}
	
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException
	{
		User user = userRegistrationRepo.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{		
		User user = userRegistrationRepo.findByUsername(username);
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
}