package com.application.repository;

import com.application.model.Appointments;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentsRepository extends CrudRepository<Appointments,Integer>
{
	
	public List<Appointments> findByEmail(String email);
	
	public List<Appointments> findBySlot(String slot);
	
	public List<Appointments> findByDoctorname(String doctorname);
	
	@Transactional
	@Modifying
	@Query(value = "update slots set amstatus = 'booked' where doctorname = ?1 and date = ?2", nativeQuery = true)
	public void updateAmstatus(String doctorname, String date);
	
	@Transactional
	@Modifying
	@Query(value = "update slots set noonstatus = 'booked' where doctorname = ?1 and date = ?2", nativeQuery = true)
	public void updateNoonstatus(String doctorname, String date);
	
	@Transactional
	@Modifying
	@Query(value = "update slots set pmstatus = 'booked' where doctorname = ?1 and date = ?2", nativeQuery = true)
	public void updatePmstatus(String doctorname, String date);

	@Transactional
	@Modifying
	@Query(value = "update appointments set patientid = ?1 where doctorname = ?2 and patientname = ?3 and date = ?4", nativeQuery = true)
	public void UpdatePatientid(String patientID, String doctorname, String patientname, String date);
	
}