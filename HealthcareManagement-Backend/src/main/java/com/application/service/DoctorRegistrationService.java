package com.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.model.Doctor;
import com.application.repository.DoctorRegistrationRepository;

@Service
public class DoctorRegistrationService 
{
	@Autowired
	private DoctorRegistrationRepository doctorRegistrationRepo;
	
	public Doctor saveDoctor(Doctor  doctor)
	{
		return doctorRegistrationRepo.save(doctor);
	}
	
	public Doctor updateDoctorProfile(Doctor doctor)
	{
		return doctorRegistrationRepo.save(doctor);
	}
	
	public List<Doctor> getAllDoctors()
	{
		return (List<Doctor>)doctorRegistrationRepo.findAll();
	}
	
	public void updateStatus(String email)
	{
		doctorRegistrationRepo.updateStatus(email);
	}
	
	public void rejectStatus(String email)
	{
		doctorRegistrationRepo.rejectStatus(email);
		System.out.print("rejected");
	}
	
	public void updatePatientStatus(String slot, String doctorname)
	{
		doctorRegistrationRepo.updatePatientStatus(slot, doctorname);
	}
	
	public void rejectPatientStatus(String slot, String doctorname)
	{
		doctorRegistrationRepo.rejectPatientStatus(slot, doctorname);
		System.out.print("rejected");
	}
	
	public List<Doctor> getDoctorListByEmail(String email) 
	{
		return (List<Doctor>)doctorRegistrationRepo.findDoctorListByEmail(email);
	}
	
	public Doctor fetchDoctorByEmail(String email)
	{
		return doctorRegistrationRepo.findByEmail(email);
	}
	
	public Doctor fetchDoctorByDoctorname(String doctorname)
	{
		return doctorRegistrationRepo.findByDoctorname(doctorname);
	}
	
	public Doctor fetchDoctorByEmailAndPassword(String email, String password)
	{
		return doctorRegistrationRepo.findByEmailAndPassword(email, password);
	}
	
	public List<Doctor> fetchProfileByEmail(String email)
	{
		return (List<Doctor>)doctorRegistrationRepo.findProfileByEmail(email);
	}

}