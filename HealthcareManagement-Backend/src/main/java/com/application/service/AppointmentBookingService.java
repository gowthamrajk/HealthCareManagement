package com.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

import com.application.model.Appointments;
import com.application.model.Slots;
import com.application.repository.AppointmentsRepository;
import com.application.repository.SlotBookingRepository;

@Service
public class AppointmentBookingService 
{
	@Autowired
	private SlotBookingRepository slotBookingRepository;
	
	@Autowired
	private AppointmentsRepository appointmentsRepository;
	
	public void saveSlots(Slots slot)
	{
		Random random = new Random();   
		int val = random.nextInt(1000);  
		slotBookingRepository.saveSlots(val, slot.getEmail(),slot.getDoctorname(),slot.getSpecialization(),slot.getAmslot(),"unbooked",slot.getNoonslot(),"unbooked",slot.getPmslot(),"unbooked",slot.getDate(),slot.getPatienttype());
	}
	
	public List<Slots> getSlotDetails(String email)
	{
		return (List<Slots>)slotBookingRepository.findByEmail(email);
	}
	
	public List<Slots> getSlotList()
	{
		return (List<Slots>)slotBookingRepository.findAll();
	}
	
	public List<Slots> getSlotDetailsWithUniqueDoctors()
	{
		return (List<Slots>)slotBookingRepository.findAll();
	}
	
	public List<Slots> getSlotDetailsWithUniqueSpecializations()
	{
		return (List<Slots>)slotBookingRepository.findAll();
	}
	
	public Appointments	addNewAppointment(Appointments appointment)
	{
		return appointmentsRepository.save(appointment);
	}
	
	public int bookAMSlot(String doctorname, String date)
	{
		appointmentsRepository.updateAmstatus(doctorname, date);
		return 1;
	}
	
	public int  bookNoonSlot(String doctorname, String date)
	{
		appointmentsRepository.updateNoonstatus(doctorname, date);
		return 1;
	}
	
	public int bookPMSlot(String doctorname, String date)
	{
		appointmentsRepository.updatePmstatus(doctorname, date);
		return 1;
	}
	
	public List<Appointments> findPatientByEmail(String email)
	{
		return (List<Appointments>)appointmentsRepository.findByEmail(email);
	}
	
	public List<Appointments> findPatientBySlot(String slot)
	{
		return (List<Appointments>)appointmentsRepository.findBySlot(slot);
	}
	
	public List<Appointments> findPatientByDoctorName(String doctorname)
	{
		return (List<Appointments>)appointmentsRepository.findByDoctorname(doctorname);
	}
	
	public List<Appointments> getAllPatients()
	{
		return (List<Appointments>)appointmentsRepository.findAll();
	}

	public void updatePatientId(String patientID, String doctorname, String patientname, String date)
    {
		appointmentsRepository.UpdatePatientid(patientID, doctorname, patientname, date);
	}
}
