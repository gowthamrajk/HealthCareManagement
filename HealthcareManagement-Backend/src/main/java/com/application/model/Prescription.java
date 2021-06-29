package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prescription 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientid;
	private String patientname;
	private String doctorname;
	private String disease;
	private String gender;
	private String age;
	private String date;
	private String prescription;
	private String admissionstatus;
	
	public Prescription() 
	{
		super();
	}

	public Prescription(int id, String patientid, String patientname, String doctorname, String disease, String gender, String age, String date, String prescription, String admissionstatus) 
	{
		super();
		this.id = id;
		this.patientid = patientid;
		this.patientname = patientname;
		this.doctorname = doctorname;
		this.disease = disease;
		this.gender = gender;
		this.age = age;
		this.date = date;
		this.prescription = prescription;
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
	
	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getAdmissionstatus() {
		return admissionstatus;
	}

	public void setAdmissionstatus(String admissionstatus) {
		this.admissionstatus = admissionstatus;
	}

}
