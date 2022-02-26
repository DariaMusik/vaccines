package com.thesis.vaccines.repository;

import com.thesis.vaccines.model.Symptom;
import org.springframework.data.repository.CrudRepository;

public interface SymptomRepository extends CrudRepository <Symptom,Integer> {
}
