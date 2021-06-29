package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.AuthRequest;
import com.application.model.Doctor;
import com.application.model.User;
import com.application.service.DoctorRegistrationService;
import com.application.service.UserRegistrationService;
import com.application.util.JwtUtils;

@RestController
public class LoginController 
{
	
	@Autowired
	private UserRegistrationService userRegisterService;
	
	@Autowired
    private JwtUtils jwtUtil;
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private DoctorRegistrationService doctorRegisterService;
	
	@GetMapping("/")
    public String welcomeMessage()
    {
    	return "Welcome to HealthCare Management system !!!";
    }
    
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) throws Exception 
    {
        try 
        {
        	System.out.println(authRequest.getEmail());
        	System.out.println(authRequest.getPassword());
        	List<User> users = userRegisterService.getAllUsers();
        	String currentEmail = "";
    		for(User obj:users)
    		{
    			if(obj.getEmail().equalsIgnoreCase(authRequest.getEmail()))
    			{
    				currentEmail = obj.getUsername();
    			}
    		}
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(currentEmail, authRequest.getPassword()));
        } 
        catch (Exception ex) 
        {
            throw new Exception("Invalid Username/password");
        }
        return new ResponseEntity<String>(jwtUtil.generateToken(authRequest.getEmail()), HttpStatus.OK);
    }
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String currEmail = user.getEmail();
		String currPassword = user.getPassword();
		
		User userObj = null;
		if(currEmail != null && currPassword != null)
		{
			userObj = userRegisterService.fetchUserByEmailAndPassword(currEmail, currPassword);
		}
		if(userObj == null)
		{
			throw new Exception("User does not exists!!! Please enter valid credentials...");
		}		
		return userObj;
	}
	
	@PostMapping("/logindoctor")
	@CrossOrigin(origins = "http://localhost:4200")
	public Doctor loginDoctor(@RequestBody Doctor doctor) throws Exception
	{
		String currEmail = doctor.getEmail();
		String currPassword = doctor.getPassword();

		Doctor doctorObj = null;
		if(currEmail != null && currPassword != null)
		{
			doctorObj = doctorRegisterService.fetchDoctorByEmailAndPassword(currEmail, currPassword);
		}
		if(doctorObj == null)
		{
			throw new Exception("User does not exists!!! Please enter valid credentials...");
		}		
		return doctorObj;
	}

}
