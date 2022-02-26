package com.thesis.vaccines.repository;

import com.thesis.vaccines.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository <Patient, Integer> {
}
