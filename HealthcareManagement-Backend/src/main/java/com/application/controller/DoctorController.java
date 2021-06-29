package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.model.Appointments;
import com.application.model.Doctor;
import com.application.model.Prescription;
import com.application.model.Slots;
import com.application.service.AppointmentBookingService;
import com.application.service.DoctorRegistrationService;
import com.application.service.PrescriptionService;

@RestController
public class DoctorController 
{
	@Autowired
	private DoctorRegistrationService doctorRegisterService;
	
	@Autowired
	private AppointmentBookingService appointmentBookingService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@GetMapping("/doctorlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Doctor>> getDoctors() throws Exception
	{
		List<Doctor> doctors = doctorRegisterService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
	
	@GetMapping("/gettotaldoctors")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalDoctors() throws Exception
	{
		List<Doctor> doctors = doctorRegisterService.getAllDoctors();
		List<Integer> al = new ArrayList<>();
		al.add(doctors.size());
		return new ResponseEntity<List<Integer>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalslots")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalSlots() throws Exception
	{
		List<Slots> slots = appointmentBookingService.getSlotList();
		List<Integer> al = new ArrayList<>();
		al.add(slots.size());
		return new ResponseEntity<List<Integer>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/acceptstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> updateStatus(@PathVariable String email) throws Exception
	{
		doctorRegisterService.updateStatus(email);
		List<String> al=new ArrayList<>();
		al.add("accepted");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/rejectstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> rejectStatus(@PathVariable String email) throws Exception
	{
		doctorRegisterService.rejectStatus(email);
		List<String> al=new ArrayList<>();
		al.add("rejected");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/acceptpatient/{slot}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> updatePatientStatus(@PathVariable String slot) throws Exception
	{
		List<Appointments> patient = appointmentBookingService.findPatientBySlot(slot);
		String doctorName = "";
		for(Appointments obj:patient)
		{
			if(obj.getSlot().equals(slot))
				doctorName = obj.getDoctorname();
		}
		doctorRegisterService.updatePatientStatus(slot, doctorName);
		List<String> al=new ArrayList<>();
		al.add("accepted");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/rejectpatient/{slot}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> rejectPatientStatus(@PathVariable String slot) throws Exception
	{
		List<Appointments> patient = appointmentBookingService.findPatientBySlot(slot);
		String doctorName = "";
		for(Appointments obj:patient)
		{
			if(obj.getSlot().equals(slot))
				doctorName = obj.getDoctorname();
		}
		doctorRegisterService.rejectPatientStatus(slot, doctorName);
		List<String> al=new ArrayList<>();
		al.add("rejected");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@PostMapping("/addBookingSlots")
	@CrossOrigin(origins = "http://localhost:4200")
	public String addNewSlot(@RequestBody Slots slots) throws Exception
	{
		appointmentBookingService.saveSlots(slots);
		return "modified successfully !!!";
	}
	
	@GetMapping("/doctorlistbyemail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Doctor>> getRequestHistoryByEmail(@PathVariable String email) throws Exception
	{
		System.out.print("requesting");
		List<Doctor> history = doctorRegisterService.getDoctorListByEmail(email);
		return new ResponseEntity<List<Doctor>>(history, HttpStatus.OK);
	}
	
	@GetMapping("/slotDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Slots>> getSlotDetails(@PathVariable String email) throws Exception
	{
		List<Slots> slots = appointmentBookingService.getSlotDetails(email);
		return new ResponseEntity<List<Slots>>(slots, HttpStatus.OK);
	}
	
	@GetMapping("/slotDetails")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Slots>> getSlotList() throws Exception
	{
		List<Slots> slots = appointmentBookingService.getSlotList();
		return new ResponseEntity<List<Slots>>(slots, HttpStatus.OK);
	}

	@GetMapping("/slotDetailsWithUniqueDoctors")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Set<String>> getSlotDetailsWithUniqueDoctors() throws Exception
	{
		List<Slots> slots = appointmentBookingService.getSlotDetailsWithUniqueDoctors();
		Set<String> set = new LinkedHashSet<>();
		for(Slots obj:slots)
		{
			set.add(obj.getDoctorname());
		}
		return new ResponseEntity<Set<String>>(set, HttpStatus.OK);
	}
	
	@GetMapping("/slotDetailsWithUniqueSpecializations")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Set<String>> getSlotDetailsWithUniqueSpecializations() throws Exception
	{
		List<Slots> slots = appointmentBookingService.getSlotDetailsWithUniqueSpecializations();
		Set<String> set = new LinkedHashSet<>();
		for(Slots obj:slots)
		{
			set.add(obj.getSpecialization());
		}
		return new ResponseEntity<Set<String>>(set, HttpStatus.OK);
	}
	
	@GetMapping("/patientlistbydoctoremail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Appointments>> getPatientDetails(@PathVariable String email) throws Exception
	{
		List<Doctor> history = doctorRegisterService.getDoctorListByEmail(email);
		String doctorname = "";
		for(Doctor obj : history)
		{
			if(obj.getEmail().equals(email))
			{
				doctorname = obj.getDoctorname();
				break;
			}
		}
		List<Appointments> patients = appointmentBookingService.findPatientByDoctorName(doctorname);
		return new ResponseEntity<List<Appointments>>(patients, HttpStatus.OK);
	}
	
	@PostMapping("/addPrescription")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Prescription> addNewPrescription(@RequestBody Prescription prescription) throws Exception
	{
		List<Appointments> patients = appointmentBookingService.getAllPatients();
		String patientID = "";
		OUTER:for(Appointments obj : patients)
		{
			if(obj.getPatientname().equals(prescription.getPatientname()))
			{
				patientID = obj.getPatientid();
				break OUTER;
			}
		}
		prescription.setPatientid(patientID);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        String todayDate = formatter.format(date);
        prescription.setDate(todayDate);
        
		Prescription prescriptions = prescriptionService.savePrescriptions(prescription);
		return new ResponseEntity<Prescription>(prescriptions, HttpStatus.OK);
	}
	
	@GetMapping("/doctorProfileDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Doctor>> getDoctorProfileDetails(@PathVariable String email) throws Exception
	{
		List<Doctor> doctors = doctorRegisterService.fetchProfileByEmail(email);
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
	
	@PutMapping("/updatedoctor")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Doctor> updateDoctorProfile(@RequestBody Doctor doctor) throws Exception
	{
		Doctor doctorobj = doctorRegisterService.updateDoctorProfile(doctor);
		return new ResponseEntity<Doctor>(doctorobj, HttpStatus.OK);
	}
	
	@GetMapping("/patientlistbydoctoremailanddate/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Appointments>> getPatientDetailsAndDate(@PathVariable String email) throws Exception
	{
		List<Appointments> patients = appointmentBookingService.getAllPatients();
		List<Doctor> history = doctorRegisterService.getDoctorListByEmail(email);
		String doctorname = "";
		OUTER:for(Doctor obj : history)
		{
			if(obj.getEmail().equals(email))
			{
				doctorname = obj.getDoctorname();
				break OUTER;
			}
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        String todayDate = formatter.format(date);
        List<Appointments> appointmentsList = new ArrayList<>();
		OUTER:for(Appointments obj : patients)
		{
			if(obj.getDoctorname().equals(doctorname) && obj.getDate().equals(todayDate))
			{
				doctorname = obj.getDoctorname();
				appointmentsList.add(obj);
				break OUTER;
			}
		}
		return new ResponseEntity<List<Appointments>>(appointmentsList, HttpStatus.OK);
	}
	
}