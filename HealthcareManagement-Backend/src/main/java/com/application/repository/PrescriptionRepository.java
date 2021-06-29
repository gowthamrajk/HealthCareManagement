package com.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.application.model.Prescription;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer>
{

	List<Prescription> findByPatientname(String patientname);

}