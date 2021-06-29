package com.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor 
{
	@Id
	private String email;
	private String doctorname;
	private String mobile;
	private String gender;
	private String experience;
	private String specialization;
	private String previoushospital;
	private String address;
	private String password;
	private String status;
	
	public Doctor() 
	{
		super();
	}

	public Doctor(String email, String doctorname, String mobile, String gender, String experience, String specialization, String previoushospital, String address, String password, String status) 
	{
		super();
		this.email = email;
		this.doctorname = doctorname;
		this.mobile = mobile;
		this.gender = gender;
		this.experience = experience;
		this.specialization = specialization;
		this.previoushospital = previoushospital;
		this.address = address;
		this.password = password;
		this.status = status;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getDoctorname() 
	{
		return doctorname;
	}

	public void setDoctorname(String doctorname) 
	{
		this.doctorname = doctorname;
	}

	public String getMobile() 
	{
		return mobile;
	}

	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getExperience() 
	{
		return experience;
	}

	public void setExperience(String experience) 
	{
		this.experience = experience;
	}

	public String getSpecialization() 
	{
		return specialization;
	}

	public void setSpecialization(String specialization) 
	{
		this.specialization = specialization;
	}

	public String getPrevioushospital() 
	{
		return previoushospital;
	}

	public void setPrevioushospital(String previoushospital) 
	{
		this.previoushospital = previoushospital;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

}