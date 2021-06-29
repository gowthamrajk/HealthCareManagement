package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Slots 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String doctorname;
	private String specialization;
	private String amslot;
	private String amstatus;
	private String noonslot;
	private String noonstatus;
	private String pmslot;
	private String pmstatus;
	private String date;
	private String patienttype;
	
	public Slots() 
	{
		super();
	}

	public Slots(int id, String email, String doctorname, String specialization, String amslot, String amstatus, String noonslot, String noonstatus, String pmslot, String pmstatus, String date, String patienttype) 
	{
		super();
		this.id = id;
		this.email = email;
		this.doctorname = doctorname;
		this.specialization = specialization;
		this.amslot = amslot;
		this.amstatus = amstatus;
		this.noonslot = noonslot;
		this.noonstatus = noonstatus;
		this.pmslot = pmslot;
		this.pmstatus = pmstatus;
		this.date = date;
		this.patienttype = patienttype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAmslot() {
		return amslot;
	}

	public void setAmslot(String amslot) {
		this.amslot = amslot;
	}

	public String getAmstatus() {
		return amstatus;
	}

	public void setAmstatus(String amstatus) {
		this.amstatus = amstatus;
	}

	public String getNoonslot() {
		return noonslot;
	}

	public void setNoonslot(String noonslot) {
		this.noonslot = noonslot;
	}

	public String getNoonstatus() {
		return noonstatus;
	}

	public void setNoonstatus(String noonstatus) {
		this.noonstatus = noonstatus;
	}

	public String getPmslot() {
		return pmslot;
	}

	public void setPmslot(String pmslot) {
		this.pmslot = pmslot;
	}

	public String getPmstatus() {
		return pmstatus;
	}

	public void setPmstatus(String pmstatus) {
		this.pmstatus = pmstatus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPatienttype() {
		return patienttype;
	}

	public void setPatienttype(String patienttype) {
		this.patienttype = patienttype;
	}	
	
}