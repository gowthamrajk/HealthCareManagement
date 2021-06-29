package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientid;
	private String patientname;
	private String email;
	private String doctorname;
	private String specialization;
	private String date;
	private String age;
	private String gender;
	private String problem;
	private String slot;
	private String appointmentstatus;
	private String admissionstatus;
	
	public Appointments() 
	{
		super();
	}

	public Appointments(int id,String patientid, String patientname, String email, String doctorname, String specialization, String date, String age, String gender, String problem, String slot, String appointmentstatus, String admissionstatus) 
	{
		super();
		this.id = id;
		this.patientid = patientid;
		this.patientname = patientname;
		this.email = email;
		this.doctorname = doctorname;
		this.specialization = specialization;
		this.date = date;
		this.age = age;
		this.gender = gender;
		this.problem = problem;
		this.slot = slot;
		this.appointmentstatus = appointmentstatus;
		this.admissionstatus = admissionstatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getAppointmentstatus() {
		return appointmentstatus;
	}

	public void setAppointmentstatus(String appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}

	public String getAdmissionstatus() {
		return admissionstatus;
	}

	public void setAdmissionstatus(String admissionstatus) {
		this.admissionstatus = admissionstatus;
	}

}
