package com.application.controller;

import java.util.List;
import java.util.ArrayList;
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
import com.application.model.Prescription;
import com.application.model.Slots;
import com.application.model.User;
import com.application.service.AppointmentBookingService;
import com.application.service.PrescriptionService;
import com.application.service.UserRegistrationService;

@RestController
public class UserController 
{
	@Autowired
	private UserRegistrationService userRegisterService;
	
	@Autowired
	private AppointmentBookingService appointmentBookingService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@GetMapping("/userlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<User>> getUsers() throws Exception
	{
		List<User> users = userRegisterService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getprescriptionbyname/{patientname}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Prescription>> getPrescriptionByPatientname(@PathVariable String patientname) throws Exception
	{
		List<Prescription> prescription = prescriptionService.getPrescriptionByPatientname(patientname);
		return new ResponseEntity<List<Prescription>>(prescription, HttpStatus.OK);
	}
	
	@GetMapping("/patientlistbyemail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Appointments>> getPatientList(@PathVariable String email) throws Exception
	{
		List<Appointments> patients = appointmentBookingService.findPatientByEmail(email);
		return new ResponseEntity<List<Appointments>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/patientlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Appointments>> getPatients() throws Exception
	{
		List<Appointments> patients = appointmentBookingService.getAllPatients();
		return new ResponseEntity<List<Appointments>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalpatients")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalPatients() throws Exception
	{
		List<Appointments> patients = appointmentBookingService.getAllPatients();
		List<Integer> al = new ArrayList<>();
		al.add(patients.size());
		return new ResponseEntity<List<Integer>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalappointments")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalAppointments() throws Exception
	{
		List<Appointments> patients = appointmentBookingService.getAllPatients();
		List<Integer> al = new ArrayList<>();
		al.add(patients.size());
		return new ResponseEntity<List<Integer>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalprescriptions")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalPrescriptions() throws Exception
	{
		List<Prescription> patients = prescriptionService.getAllPrescriptions();
		List<Integer> al = new ArrayList<>();
		al.add(patients.size());
		return new ResponseEntity<List<Integer>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/profileDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<User>> getProfileDetails(@PathVariable String email) throws Exception
	{
		List<User> users = userRegisterService.fetchProfileByEmail(email);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> updateUserProfile(@RequestBody User user) throws Exception
	{
		User userobj = userRegisterService.updateUserProfile(user);
		return new ResponseEntity<User>(userobj, HttpStatus.OK);
	}
	
	@PostMapping("/bookNewAppointment")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Appointments> addNewAppointment(@RequestBody Appointments appointment) throws Exception
	{
		String[] dateArr = appointment.getDate().split("-");
		appointment.setDate(""+dateArr[0]+"-"+dateArr[1]+"-"+dateArr[2]);
		System.out.println(appointment.getDate());
		Appointments appointments = appointment;
		
		List<Slots> availableSLots = appointmentBookingService.getSlotList();
		List<String> dates = new ArrayList<>();
		String message = "No slots available !!! Please check the slot availability and book again.";
		for(Slots obj : availableSLots)
		{
			dates.add(obj.getDate());
		}
		if(!dates.contains(appointments.getDate()))
		{
			throw new Exception("No slots available for this date !!! Please check the slot availability and book again.");
		}
		Slots obj = new Slots();
		for(Slots obj1 : availableSLots)
		{
			if(obj1.getDoctorname().equals(appointments.getDoctorname()) && obj1.getDate().equals(appointments.getDate()))
			{
				obj = obj1;
				break;
			}
		}
			if(obj.getDoctorname().equals(appointments.getDoctorname()) && obj.getDate().equals(appointments.getDate()))
			{
				if(appointments.getSlot().equalsIgnoreCase("AM slot") && obj.getAmstatus().equalsIgnoreCase("booked"))
				{
					throw new Exception(message);
				}
				if(appointments.getSlot().equalsIgnoreCase("Pm slot") && obj.getPmslot().equalsIgnoreCase("booked"))
				{
					throw new Exception(message);
				}
				if(appointments.getSlot().equalsIgnoreCase("Noon slot") && obj.getNoonslot().equalsIgnoreCase("booked"))
				{
					throw new Exception(message);
				}
			}
			else
			{
				throw new Exception("The Doctor have no slots on that date !!! Please check the slot availability and book again.");
			}
		appointments = appointmentBookingService.addNewAppointment(appointment);
		
		String patientID = getPatientID();
		appointmentBookingService.updatePatientId(patientID,appointment.getDoctorname(),appointment.getPatientname(),appointment.getDate());
		
		if(appointment.getSlot().equalsIgnoreCase("Pm slot") && obj.getPmstatus().equalsIgnoreCase("unbooked"))
		{
			appointmentBookingService.bookPMSlot(appointment.getDoctorname(),appointment.getDate());
		}
		if(appointment.getSlot().equalsIgnoreCase("Am slot") && obj.getAmstatus().equalsIgnoreCase("unbooked"))
		{
			appointmentBookingService.bookAMSlot(appointment.getDoctorname(),appointment.getDate());
		}
		if(appointment.getSlot().equalsIgnoreCase("Noon slot") && obj.getNoonstatus().equalsIgnoreCase("unbooked"))
		{
			appointmentBookingService.bookNoonSlot(appointment.getDoctorname(),appointment.getDate());
		}
		return new ResponseEntity<Appointments>(appointments, HttpStatus.OK);
	}
	
	public String getPatientID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}

}
