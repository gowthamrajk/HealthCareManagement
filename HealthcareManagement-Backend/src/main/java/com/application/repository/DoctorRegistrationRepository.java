package com.application.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.application.model.Doctor;

public interface DoctorRegistrationRepository extends CrudRepository<Doctor, Integer>
{
	
    public Doctor findByEmail(String email);
    
    public List<Doctor> findDoctorListByEmail(String email);
	
	public Doctor findByDoctorname(String doctorname);
	
	public Doctor findByEmailAndPassword(String email, String password);
	
	public List<Doctor> findProfileByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update doctor set status = 'accept' where email = ?1", nativeQuery = true)
	public void updateStatus(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update doctor set status = 'reject' where email = ?1", nativeQuery = true)
	public void rejectStatus(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update appointments set appointmentstatus = 'accept' where slot = ?1 and doctorname = ?2", nativeQuery = true)
	public void updatePatientStatus(String slot, String doctorname);
	
	@Transactional
	@Modifying
	@Query(value = "update appointments set appointmentstatus = 'reject' where slot = ?1 and doctorname = ?2", nativeQuery = true)
	public void rejectPatientStatus(String slot, String doctorname);
	
}