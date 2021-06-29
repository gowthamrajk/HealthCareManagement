package com.application.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import javax.transaction.Transactional;

import com.application.model.Slots;

public interface SlotBookingRepository extends CrudRepository<Slots,Integer>
{
	@Transactional
	@Modifying
	@Query(value = "insert into slots (id, email, doctorname, specialization, amslot, amstatus, noonslot, noonstatus, pmslot, pmstatus, date, patienttype) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12);",nativeQuery = true)
	public void saveSlots(int val, String email, String doctorname, String specialization, String amslot, String amstatus, String noonslot, String noonstatus, String pmslot, String pmstatus, String date, String patienttype);
	
	public List<Slots> findByEmail(String email);
}