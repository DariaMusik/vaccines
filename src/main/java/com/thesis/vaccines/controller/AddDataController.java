package com.thesis.vaccines.controller;

import com.sun.xml.bind.v2.TODO;
import com.thesis.vaccines.Parser;
import com.thesis.vaccines.model.*;
import com.thesis.vaccines.repository.NotificationRepository;
import com.thesis.vaccines.repository.PatientRepository;
import com.thesis.vaccines.repository.SymptomRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map;

@Controller
public class AddDataController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SymptomRepository symptomRepository;

    @PostMapping("addNewNotificationEN")
    public String addDataEN(@RequestParam String age,
                            @RequestParam String sex,
                            @RequestParam String state,
                            @RequestParam String description_of_symptoms,
                            @RequestParam String type_of_vaccines,
                            Map<String,Object> model){
        String message = "";
        boolean error = false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Patient patient = new Patient();
        Symptom symptom = new Symptom();
        Notification notification = new Notification();

        int ageToDB = 0;
        char sexToDB = ' ';
        if(age != null && !age.isEmpty()) {
            ageToDB = Integer.parseInt(age);
        }
        else {
            error = true;
            message += "\nPlease fill in the age field.";
        }

        if(sex != null && !sex.isEmpty()) {
            sexToDB = sex.charAt(0);
        }
        else {
            error = true;
            message += "\nPlease fill in the gender field.";
        }

        if(description_of_symptoms != null && !description_of_symptoms.isEmpty()) {
            symptom = Parser.parsSymptomDataFromWeb(description_of_symptoms);
        }
        else {
            error = true;
            message += "\nPlease fill in the field. \"Description of side effects.\"";
        }

        if(state == null || state.isEmpty()) {
            error = true;
            message += "\nPlease fill in the place of residence field.";
        }

        if (error){
            model.put("message",message);
            return "adddata";
        }

        patient = new Patient(ageToDB,sexToDB);
        notification = new Notification(date, patient, state, symptom,'N', type_of_vaccines);

        patientRepository.save(patient);
        symptomRepository.save(symptom);
        notificationRepository.save(notification);
        message = "The data has been written correctly.";
        model.put("message", message);
        return "adddata";
    }

    @PostMapping("addNewNotificationPL")
    public String addDataPL(@RequestParam String age,
                            @RequestParam String sex,
                            @RequestParam String state,
                            @RequestParam String description_of_symptoms,
                            @RequestParam String type_of_vaccines,
                            Map<String,Object> model){
        System.out.println("Dodanie danych po polsku");
        String message = "";
        boolean error = false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Patient patient = new Patient();
        Symptom symptom = new Symptom();
        Notification notification = new Notification();

        int ageToDB = 0;
        char sexToDB = ' ';
        if(age != null && !age.isEmpty()) {
            ageToDB = Integer.parseInt(age);
        }
        else {
            error = true;
            message += "\nProszę wypełnić pole wiek.";
        }

        if(sex != null && !sex.isEmpty()) {
            sexToDB = sex.charAt(0);
        }
        else {
            error = true;
            message += "\nProszę wypełnić pole płeć.";
        }
        patient = new Patient(ageToDB,sexToDB);

        if(description_of_symptoms != null && !description_of_symptoms.isEmpty()) {
            symptom = Parser.parsSymptomDataFromWebPL(description_of_symptoms);
            System.out.println("From form: " + description_of_symptoms + "\nSymptom: " + symptom);
        }
        else {
            error = true;
            message += "\nProszę wypełnić pole \"Opis działań niepożądanych.\"";
        }

        if(state == null || state.isEmpty()) {
            error = true;
            message += "\nProszę wypełnić pole miejsce zamieszkania.";
        }

        notification = new Notification(date, patient, state, symptom,'N', type_of_vaccines);

        if (error){
            model.put("message",message);
            return "dodaniedanych";
        }

        patientRepository.save(patient);
        symptomRepository.save(symptom);
        notificationRepository.save(notification);
        message = "Poprawnie zapisano dane.";
        model.put("message", message);
        return "dodaniedanych";
    }
}

