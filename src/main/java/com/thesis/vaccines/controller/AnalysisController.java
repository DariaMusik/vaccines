package com.thesis.vaccines.controller;

import com.opencsv.exceptions.CsvException;
import com.thesis.vaccines.Parser;
import com.thesis.vaccines.model.*;
import com.thesis.vaccines.repository.NotificationRepository;
import com.thesis.vaccines.repository.PatientRepository;
import com.thesis.vaccines.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;

@Controller
public class AnalysisController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SymptomRepository symptomRepository;

    @GetMapping("/saveData")
    public String save(Map<String, Object> model) throws IOException, CsvException {
        List<Patient> patients = Parser.parsPatientData("2021VAERSDATA.csv");
        List<Symptom> symptoms = Parser.parsSymptomData("2021VAERSSYMPTOMS.csv");
        List<Notification> notifications = Parser.parsNotificationData("2021VAERSDATA.csv","2021VAERSVAX.csv");

        for (Patient patient: patients) {
            int index = patients.indexOf(patient);
            Symptom symptom = symptoms.get(index);
            Notification notification = notifications.get(index);

            notification.setPatient(patient);
            notification.setSymptom(symptom);

        }
        model.put("patients",patients);
        model.put("symptoms",symptoms);
        model.put("notifications",notifications);

        return "data";
    }

    @GetMapping("/showAll")
    public String showAllData(Map<String, Object> model){
        Iterable<Patient> patients = patientRepository.findAll();
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Iterable<Notification> notifications = notificationRepository.findAll();

        model.put("patients",patients);
        model.put("symptoms",symptoms);
        model.put("notifications",notifications);
        return "data";
    }

    @GetMapping("/symptom-en") //analysis
    public String frequencySymptom(Map<String, Object> model){
        //take data from DB
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Map <String, Integer> symptomCounter = new HashMap<String, Integer>();
        symptomCounter.put("RESPIRATORY_SYSTEM_DISEASES",0);
        symptomCounter.put("APPENDICITIS",0);
        symptomCounter.put("DYSPHAGIA",0);
        symptomCounter.put("THROAT_TIGHTNESS",0);
        symptomCounter.put("THROAT_IRRITATION",0);
        symptomCounter.put("DYSPNOEA",0);
        symptomCounter.put("COUGH",0);
        symptomCounter.put("CHEST_DISCOMFORT",0);
        symptomCounter.put("RESPIRATORY_DISTRESS",0);
        symptomCounter.put("ANOEA",0);
        symptomCounter.put("STRIDOR",0);
        symptomCounter.put("WHEEZING",0);
        symptomCounter.put("TACHYPNOE",0);
        symptomCounter.put("SHORTNESS_OF_BREATH",0);
        symptomCounter.put("NAUSEA",0);
        symptomCounter.put("VOMITING",0);
        symptomCounter.put("DIARRHOEA",0);
        symptomCounter.put("CHILLS",0);
        symptomCounter.put("TREMOR",0);
        symptomCounter.put("FATIGUE",0);
        symptomCounter.put("FEELING_ABNORMAL",0);
        symptomCounter.put("MYALGIA",0);
        symptomCounter.put("BODY_ACHE",0);
        symptomCounter.put("SWELLING",0);
        symptomCounter.put("BLOOD_PRESSURE_INCREASED",0);
        symptomCounter.put("BLOOD_PRESSURE_DECREASED",0);
        symptomCounter.put("LOSS_OF_CONSCIOUSNESS",0);
        symptomCounter.put("MUSCULOSKELETAL_DISORDER",0);
        symptomCounter.put("IMPAIRED_WORK_ABILITY",0);
        symptomCounter.put("ARTHRITIS_BACTERIAL",0);
        symptomCounter.put("STROKE",0);
        symptomCounter.put("CARDIOVASCULAR_FAILURE",0);
        symptomCounter.put("HEART_RATE_INCREASED",0);
        symptomCounter.put("CORONARY_ARTERY_DISEASE",0);
        symptomCounter.put("TACHYCARDIA",0);
        symptomCounter.put("SUDDEN_CARDIAC_ARREST",0);
        symptomCounter.put("PALPITATIONS",0);
        symptomCounter.put("MYOCARDIAL_INFRACTION",0);
        symptomCounter.put("ANAPHYLACTIC_SHOCK",0);
        symptomCounter.put("ANAPHYLACTIC_REACTION",0);
        symptomCounter.put("APHASIA",0);
        symptomCounter.put("HEADACHE",0);
        symptomCounter.put("DIZZINESS",0);
        symptomCounter.put("HYPERHIDROSIS",0);
        symptomCounter.put("BLEPHAROSPASM",0);
        symptomCounter.put("PARAESTHESIA",0);
        symptomCounter.put("EPISTAXIS",0);
        symptomCounter.put("SARS_CoV_2_TEST_POSITIVE",0);
        symptomCounter.put("PYREXIA",0);
        symptomCounter.put("BODY_TEMPERATURE_INCREASED",0);
        symptomCounter.put("FEBRILE_CONVULSION",0);
        symptomCounter.put("HOT_FLUSH",0);
        symptomCounter.put("BODY_TEMPERATURE_DECREASED",0);
        symptomCounter.put("PARALYSIS",0);
        symptomCounter.put("PALLOR",0);
        symptomCounter.put("STILLBIRTH",0);
        symptomCounter.put("FOETAL_DEATH",0);
        symptomCounter.put("DEATH",0);
        symptomCounter.put("LYMPHADENOPATHY",0);
        symptomCounter.put("SEIZURE",0);
        symptomCounter.put("HERPES_ZOSTER",0);
        symptomCounter.put("SLEEP_DISORDER",0);
        symptomCounter.put("HIPERSOMNIA",0);
        symptomCounter.put("ANXIETY",0);
        symptomCounter.put("INFLUENZA",0);
        symptomCounter.put("BLURRED_VISION",0);
        symptomCounter.put("BLINDNESS",0);
        symptomCounter.put("DYSPHONIA",0);
        symptomCounter.put("SPASM",0);
        symptomCounter.put("HAEMORRHAGE",0);
        symptomCounter.put("HEARING_IMPAIRMENT",0);
        symptomCounter.put("DEAFNESS",0);
        symptomCounter.put("SEPSIS",0);
        symptomCounter.put("VARICELLA",0);
        symptomCounter.put("PERICARDITIS",0);
        symptomCounter.put("AMYOTROPHY",0);
        symptomCounter.put("SENSORY_LOSS",0);
        symptomCounter.put("DECREASED_APPETITE",0);
        symptomCounter.put("CHANGE_IN_BLOOD_COUNT",0);
        symptomCounter.put("OXYGEN_SATURATION_DECREASED",0);

        //count symptoms
        for (Symptom symptom: symptoms) {
            if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                symptomCounter.replace("RESPIRATORY_SYSTEM_DISEASES", symptomCounter.get("RESPIRATORY_SYSTEM_DISEASES") + 1);
            }
            if (symptom.isAPPENDICITIS()){
                symptomCounter.replace("APPENDICITIS", symptomCounter.get("APPENDICITIS") + 1);
            }
            if (symptom.isDYSPHAGIA()){
                symptomCounter.replace("DYSPHAGIA", symptomCounter.get("DYSPHAGIA") + 1);
            }
            if (symptom.isTHROAT_TIGHTNESS()){
                symptomCounter.replace("THROAT_TIGHTNESS", symptomCounter.get("THROAT_TIGHTNESS") + 1);
            }
            if (symptom.isTHROAT_IRRITATION()){
                symptomCounter.replace("THROAT_IRRITATION", symptomCounter.get("THROAT_IRRITATION") + 1);
            }
            if (symptom.isDYSPNOEA()){
                symptomCounter.replace("DYSPNOEA", symptomCounter.get("DYSPNOEA") + 1);
            }
            if (symptom.isCOUGH()){
                symptomCounter.replace("COUGH", symptomCounter.get("COUGH") + 1);
            }
            if (symptom.isCHEST_DISCOMFORT()){
                symptomCounter.replace("CHEST_DISCOMFORT", symptomCounter.get("CHEST_DISCOMFORT") + 1);
            }
            if (symptom.isRESPIRATORY_DISTRESS()){
                symptomCounter.replace("RESPIRATORY_DISTRESS", symptomCounter.get("RESPIRATORY_DISTRESS") + 1);
            }
            if (symptom.isANOEA()){
                symptomCounter.replace("ANOEA", symptomCounter.get("ANOEA") + 1);
            }
            if (symptom.isSTRIDOR()){
                symptomCounter.replace("STRIDOR", symptomCounter.get("STRIDOR") + 1);
            }
            if (symptom.isWHEEZING()){
                symptomCounter.replace("WHEEZING", symptomCounter.get("WHEEZING") + 1);
            }
            if (symptom.isTACHYPNOE()){
                symptomCounter.replace("TACHYPNOE", symptomCounter.get("TACHYPNOE") + 1);
            }
            if (symptom.isSHORTNESS_OF_BREATH()){
                symptomCounter.replace("SHORTNESS_OF_BREATH", symptomCounter.get("SHORTNESS_OF_BREATH") + 1);
            }
            if (symptom.isNAUSEA()){
                symptomCounter.replace("NAUSEA", symptomCounter.get("NAUSEA") + 1);
            }
            if (symptom.isVOMITING()){
                symptomCounter.replace("VOMITING", symptomCounter.get("VOMITING") + 1);
            }
            if (symptom.isDIARRHOEA()){
                symptomCounter.replace("DIARRHOEA", symptomCounter.get("DIARRHOEA") + 1);
            }
            if (symptom.isCHILLS()){
                symptomCounter.replace("CHILLS", symptomCounter.get("CHILLS") + 1);
            }
            if (symptom.isTREMOR()){
                symptomCounter.replace("TREMOR", symptomCounter.get("TREMOR") + 1);
            }
            if (symptom.isFATIGUE()){
                symptomCounter.replace("FATIGUE", symptomCounter.get("FATIGUE") + 1);
            }
            if (symptom.isFEELING_ABNORMAL()){
                symptomCounter.replace("FEELING_ABNORMAL", symptomCounter.get("FEELING_ABNORMAL") + 1);
            }
            if (symptom.isMYALGIA()){
                symptomCounter.replace("MYALGIA", symptomCounter.get("MYALGIA") + 1);
            }
            if (symptom.isBODY_ACHE()){
                symptomCounter.replace("BODY_ACHE", symptomCounter.get("BODY_ACHE") + 1);
            }
            if (symptom.isSWELLING()){
                symptomCounter.replace("SWELLING", symptomCounter.get("SWELLING") + 1);
            }
            if (symptom.isBLOOD_PRESSURE_INCREASED()){
                symptomCounter.replace("BLOOD_PRESSURE_INCREASED", symptomCounter.get("BLOOD_PRESSURE_INCREASED") + 1);
            }
            if (symptom.isBLOOD_PRESSURE_DECREASED()){
                symptomCounter.replace("BLOOD_PRESSURE_DECREASED", symptomCounter.get("BLOOD_PRESSURE_DECREASED") + 1);
            }
            if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                symptomCounter.replace("LOSS_OF_CONSCIOUSNESS", symptomCounter.get("LOSS_OF_CONSCIOUSNESS") + 1);
            }
            if (symptom.isMUSCULOSKELETAL_DISORDER()){
                symptomCounter.replace("MUSCULOSKELETAL_DISORDER", symptomCounter.get("MUSCULOSKELETAL_DISORDER") + 1);
            }
            if (symptom.isIMPAIRED_WORK_ABILITY()){
                symptomCounter.replace("IMPAIRED_WORK_ABILITY", symptomCounter.get("IMPAIRED_WORK_ABILITY") + 1);
            }
            if (symptom.isARTHRITIS_BACTERIAL()){
                symptomCounter.replace("ARTHRITIS_BACTERIAL", symptomCounter.get("ARTHRITIS_BACTERIAL") + 1);
            }
            if (symptom.isSTROKE()){
                symptomCounter.replace("STROKE", symptomCounter.get("STROKE") + 1);
            }
            if (symptom.isCARDIOVASCULAR_FAILURE()){
                symptomCounter.replace("CARDIOVASCULAR_FAILURE", symptomCounter.get("CARDIOVASCULAR_FAILURE") + 1);
            }
            if (symptom.isHEART_RATE_INCREASED()){
                symptomCounter.replace("HEART_RATE_INCREASED", symptomCounter.get("HEART_RATE_INCREASED") + 1);
            }
            if (symptom.isCORONARY_ARTERY_DISEASE()){
                symptomCounter.replace("CORONARY_ARTERY_DISEASE", symptomCounter.get("CORONARY_ARTERY_DISEASE") + 1);
            }
            if (symptom.isTACHYCARDIA()){
                symptomCounter.replace("TACHYCARDIA", symptomCounter.get("TACHYCARDIA") + 1);
            }
            if (symptom.isSUDDEN_CARDIAC_ARREST()){
                symptomCounter.replace("SUDDEN_CARDIAC_ARREST", symptomCounter.get("SUDDEN_CARDIAC_ARREST") + 1);
            }
            if (symptom.isPALPITATIONS()){
                symptomCounter.replace("PALPITATIONS", symptomCounter.get("PALPITATIONS") + 1);
            }
            if (symptom.isMYOCARDIAL_INFRACTION()){
                symptomCounter.replace("MYOCARDIAL_INFRACTION", symptomCounter.get("MYOCARDIAL_INFRACTION") + 1);
            }
            if (symptom.isANAPHYLACTIC_SHOCK()){
                symptomCounter.replace("ANAPHYLACTIC_SHOCK", symptomCounter.get("ANAPHYLACTIC_SHOCK") + 1);
            }
            if (symptom.isANAPHYLACTIC_REACTION()){
                symptomCounter.replace("ANAPHYLACTIC_REACTION", symptomCounter.get("ANAPHYLACTIC_REACTION") + 1);
            }
            if (symptom.isAPHASIA()){
                symptomCounter.replace("APHASIA", symptomCounter.get("APHASIA") + 1);
            }
            if (symptom.isHEADACHE()){
                symptomCounter.replace("HEADACHE", symptomCounter.get("HEADACHE") + 1);
            }
            if (symptom.isDIZZINESS()){
                symptomCounter.replace("DIZZINESS", symptomCounter.get("DIZZINESS") + 1);
            }
            if (symptom.isHYPERHIDROSIS()){
                symptomCounter.replace("HYPERHIDROSIS", symptomCounter.get("HYPERHIDROSIS") + 1);
            }
            if (symptom.isBLEPHAROSPASM()){
                symptomCounter.replace("BLEPHAROSPASM", symptomCounter.get("BLEPHAROSPASM") + 1);
            }
            if (symptom.isPARAESTHESIA()){
                symptomCounter.replace("PARAESTHESIA", symptomCounter.get("PARAESTHESIA") + 1);
            }
            if (symptom.isEPISTAXIS()){
                symptomCounter.replace("EPISTAXIS", symptomCounter.get("EPISTAXIS") + 1);
            }
            if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                symptomCounter.replace("SARS_CoV_2_TEST_POSITIVE", symptomCounter.get("SARS_CoV_2_TEST_POSITIVE") + 1);
            }
            if (symptom.isPYREXIA()){
                symptomCounter.replace("PYREXIA", symptomCounter.get("PYREXIA") + 1);
            }
            if (symptom.isBODY_TEMPERATURE_INCREASED()){
                symptomCounter.replace("BODY_TEMPERATURE_INCREASED", symptomCounter.get("BODY_TEMPERATURE_INCREASED") + 1);
            }
            if (symptom.isFEBRILE_CONVULSION()){
                symptomCounter.replace("FEBRILE_CONVULSION", symptomCounter.get("FEBRILE_CONVULSION") + 1);
            }
            if (symptom.isHOT_FLUSH()){
                symptomCounter.replace("HOT_FLUSH", symptomCounter.get("HOT_FLUSH") + 1);
            }
            if (symptom.isBODY_TEMPERATURE_DECREASED()){
                symptomCounter.replace("BODY_TEMPERATURE_DECREASED", symptomCounter.get("BODY_TEMPERATURE_DECREASED") + 1);
            }
            if (symptom.isPARALYSIS()){
                symptomCounter.replace("PARALYSIS", symptomCounter.get("PARALYSIS") + 1);
            }
            if (symptom.isPALLOR()){
                symptomCounter.replace("PALLOR", symptomCounter.get("PALLOR") + 1);
            }
            if (symptom.isSTILLBIRTH()){
                symptomCounter.replace("STILLBIRTH", symptomCounter.get("STILLBIRTH") + 1);
            }
            if (symptom.isFOETAL_DEATH()){
                symptomCounter.replace("FOETAL_DEATH", symptomCounter.get("FOETAL_DEATH") + 1);
            }
            if (symptom.isDEATH()){
                symptomCounter.replace("DEATH", symptomCounter.get("DEATH") + 1);
            }
            if (symptom.isLYMPHADENOPATHY()){
                symptomCounter.replace("LYMPHADENOPATHY", symptomCounter.get("LYMPHADENOPATHY") + 1);
            }
            if (symptom.isSEIZURE()){
                symptomCounter.replace("SEIZURE", symptomCounter.get("SEIZURE") + 1);
            }
            if (symptom.isHERPES_ZOSTER()){
                symptomCounter.replace("HERPES_ZOSTER", symptomCounter.get("HERPES_ZOSTER") + 1);
            }
            if (symptom.isSLEEP_DISORDER()){
                symptomCounter.replace("SLEEP_DISORDER", symptomCounter.get("SLEEP_DISORDER") + 1);
            }
            if (symptom.isHIPERSOMNIA()){
                symptomCounter.replace("HIPERSOMNIA", symptomCounter.get("HIPERSOMNIA") + 1);
            }
            if (symptom.isANXIETY()){
                symptomCounter.replace("ANXIETY", symptomCounter.get("ANXIETY") + 1);
            }
            if (symptom.isINFLUENZA()){
                symptomCounter.replace("INFLUENZA", symptomCounter.get("INFLUENZA") + 1);
            }
            if (symptom.isBLURRED_VISION()){
                symptomCounter.replace("BLURRED_VISION", symptomCounter.get("BLURRED_VISION") + 1);
            }
            if (symptom.isBLINDNESS()){
                symptomCounter.replace("BLINDNESS", symptomCounter.get("BLINDNESS") + 1);
            }
            if (symptom.isDYSPHONIA()){
                symptomCounter.replace("DYSPHONIA", symptomCounter.get("DYSPHONIA") + 1);
            }
            if (symptom.isSPASM()){
                symptomCounter.replace("SPASM", symptomCounter.get("SPASM") + 1);
            }
            if (symptom.isHAEMORRHAGE()){
                symptomCounter.replace("HAEMORRHAGE", symptomCounter.get("HAEMORRHAGE") + 1);
            }
            if (symptom.isHEARING_IMPAIRMENT()){
                symptomCounter.replace("HEARING_IMPAIRMENT", symptomCounter.get("HEARING_IMPAIRMENT") + 1);
            }
            if (symptom.isDEAFNESS()){
                symptomCounter.replace("DEAFNESS", symptomCounter.get("DEAFNESS") + 1);
            }
            if (symptom.isSEPSIS()){
                symptomCounter.replace("SEPSIS", symptomCounter.get("SEPSIS") + 1);
            }
            if (symptom.isVARICELLA()){
                symptomCounter.replace("VARICELLA", symptomCounter.get("VARICELLA") + 1);
            }
            if (symptom.isPERICARDITIS()){
                symptomCounter.replace("PERICARDITIS", symptomCounter.get("PERICARDITIS") + 1);
            }
            if (symptom.isAMYOTROPHY()){
                symptomCounter.replace("AMYOTROPHY", symptomCounter.get("AMYOTROPHY") + 1);
            }
            if (symptom.isSENSORY_LOSS()){
                symptomCounter.replace("SENSORY_LOSS", symptomCounter.get("SENSORY_LOSS") + 1);
            }
            if (symptom.isDECREASED_APPETITE()){
                symptomCounter.replace("DECREASED_APPETITE", symptomCounter.get("DECREASED_APPETITE") + 1);
            }
            if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                symptomCounter.replace("CHANGE_IN_BLOOD_COUNT", symptomCounter.get("CHANGE_IN_BLOOD_COUNT") + 1);
            }
            if (symptom.isOXYGEN_SATURATION_DECREASED()){
                symptomCounter.replace("OXYGEN_SATURATION_DECREASED", symptomCounter.get("OXYGEN_SATURATION_DECREASED") + 1);
            }
        }


        //count suma
        double suma = 0.0;
        for (Map.Entry map: symptomCounter.entrySet()) {
            suma += (Integer)map.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        symptomPercent.add(new SymptomOccurrence("RESPIRATORY_SYSTEM_DISEASES", (symptomCounter.get("RESPIRATORY_SYSTEM_DISEASES")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("APPENDICITIS", (symptomCounter.get("APPENDICITIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSPHAGIA", (symptomCounter.get("DYSPHAGIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("THROAT_TIGHTNESS", (symptomCounter.get("THROAT_TIGHTNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("THROAT_IRRITATION", (symptomCounter.get("THROAT_IRRITATION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSPNOEA", (symptomCounter.get("DYSPNOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("COUGHL", (symptomCounter.get("COUGH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CHEST_DISCOMFORT", (symptomCounter.get("CHEST_DISCOMFORT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("RESPIRATORY_DISTRESS", (symptomCounter.get("RESPIRATORY_DISTRESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ANOEA", (symptomCounter.get("ANOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("STRIDOR", (symptomCounter.get("STRIDOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("WHEEZING", (symptomCounter.get("WHEEZING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("TACHYPNOE", (symptomCounter.get("TACHYPNOE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SHORTNESS_OF_BREATH", (symptomCounter.get("SHORTNESS_OF_BREATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NAUSEA", (symptomCounter.get("NAUSEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("VOMITING", (symptomCounter.get("VOMITING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DIARRHOEA", (symptomCounter.get("DIARRHOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CHILLS", (symptomCounter.get("CHILLS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("TREMOR", (symptomCounter.get("TREMOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("FATIGUE", (symptomCounter.get("FATIGUE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("FEELING_ABNORMAL", (symptomCounter.get("FEELING_ABNORMAL")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("MYALGIA", (symptomCounter.get("MYALGIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BODY_ACHE", (symptomCounter.get("BODY_ACHE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SWELLING", (symptomCounter.get("SWELLING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLOOD_PRESSURE_INCREASED", (symptomCounter.get("BLOOD_PRESSURE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLOOD_PRESSURE_DECREASED", (symptomCounter.get("BLOOD_PRESSURE_DECREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("LOSS_OF_CONSCIOUSNESS", (symptomCounter.get("LOSS_OF_CONSCIOUSNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("MUSCULOSKELETAL_DISORDER", (symptomCounter.get("MUSCULOSKELETAL_DISORDER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("IMPAIRED_WORK_ABILITY", (symptomCounter.get("IMPAIRED_WORK_ABILITY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ARTHRITIS_BACTERIAL", (symptomCounter.get("ARTHRITIS_BACTERIAL")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("STROKE", (symptomCounter.get("STROKE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CARDIOVASCULAR_FAILURE", (symptomCounter.get("CARDIOVASCULAR_FAILURE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence(" HEART_RATE_INCREASED", (symptomCounter.get("HEART_RATE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CORONARY_ARTERY_DISEASE", (symptomCounter.get("CORONARY_ARTERY_DISEASE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("TACHYCARDIA", (symptomCounter.get("TACHYCARDIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SUDDEN_CARDIAC_ARREST", (symptomCounter.get("SUDDEN_CARDIAC_ARREST")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PALPITATIONS", (symptomCounter.get("PALPITATIONS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("MYOCARDIAL_INFRACTION", (symptomCounter.get("MYOCARDIAL_INFRACTION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ANAPHYLACTIC_SHOCK", (symptomCounter.get("ANAPHYLACTIC_SHOCK")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ANAPHYLACTIC_REACTION", (symptomCounter.get("ANAPHYLACTIC_REACTION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("APHASIA", (symptomCounter.get("APHASIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HEADACHE", (symptomCounter.get("HEADACHE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DIZZINESS", (symptomCounter.get("DIZZINESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HYPERHIDROSIS", (symptomCounter.get("HYPERHIDROSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLEPHAROSPASM", (symptomCounter.get("BLEPHAROSPASM")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PARAESTHESIA", (symptomCounter.get("PARAESTHESIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("EPISTAXIS", (symptomCounter.get("EPISTAXIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SARS_CoV_2_TEST_POSITIVE", (symptomCounter.get("SARS_CoV_2_TEST_POSITIVE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PYREXIA", (symptomCounter.get("PYREXIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BODY_TEMPERATURE_INCREASED", (symptomCounter.get("BODY_TEMPERATURE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("FEBRILE_CONVULSION", (symptomCounter.get("FEBRILE_CONVULSION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HOT_FLUSH", (symptomCounter.get("HOT_FLUSH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BODY_TEMPERATURE_DECREASED", (symptomCounter.get("BODY_TEMPERATURE_DECREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PARALYSIS", (symptomCounter.get("PARALYSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PALLOR", (symptomCounter.get("PALLOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("STILLBIRTH", (symptomCounter.get("STILLBIRTH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("FOETAL_DEATH", (symptomCounter.get("FOETAL_DEATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DEATH", (symptomCounter.get("DEATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("LYMPHADENOPATHY", (symptomCounter.get("LYMPHADENOPATHY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SEIZURE", (symptomCounter.get("SEIZURE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HERPES_ZOSTER", (symptomCounter.get("HERPES_ZOSTER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SLEEP_DISORDER", (symptomCounter.get("SLEEP_DISORDER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HIPERSOMNIA", (symptomCounter.get("HIPERSOMNIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ANXIETY", (symptomCounter.get("ANXIETY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("INFLUENZA", (symptomCounter.get("INFLUENZA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLURRED_VISION", (symptomCounter.get("BLURRED_VISION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLINDNESS", (symptomCounter.get("BLINDNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSPHONIA", (symptomCounter.get("DYSPHONIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SPASM", (symptomCounter.get("SPASM")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HAEMORRHAGE", (symptomCounter.get("HAEMORRHAGE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("HEARING_IMPAIRMENT", (symptomCounter.get("HEARING_IMPAIRMENT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DEAFNESS", (symptomCounter.get("DEAFNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SEPSIS", (symptomCounter.get("SEPSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("VARICELLA", (symptomCounter.get("VARICELLA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PERICARDITIS", (symptomCounter.get("PERICARDITIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("AMYOTROPHY", (symptomCounter.get("AMYOTROPHY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SENSORY_LOSS",(symptomCounter.get("SENSORY_LOSS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DECREASED_APPETITE", (symptomCounter.get("DECREASED_APPETITE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CHANGE_IN_BLOOD_COUNT", (symptomCounter.get("CHANGE_IN_BLOOD_COUNT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("OXYGEN_SATURATION_DECREASED", (symptomCounter.get("OXYGEN_SATURATION_DECREASED")/suma)*100));

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("OTHERS" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(others);
        model.put("symptomPercent",symptomPercent);
        model.put("firstCommon",firstCommon);
        return "analysis";
    }

    @GetMapping("/symptom-pl") //analiza
    public String frequencySymptomPL(Map<String, Object> model){
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Map <String, Integer> symptomCounter = new HashMap<String, Integer>();
        symptomCounter.put("RESPIRATORY_SYSTEM_DISEASES",0);
        symptomCounter.put("APPENDICITIS",0);
        symptomCounter.put("DYSPHAGIA",0);
        symptomCounter.put("THROAT_TIGHTNESS",0);
        symptomCounter.put("THROAT_IRRITATION",0);
        symptomCounter.put("DYSPNOEA",0);
        symptomCounter.put("COUGH",0);
        symptomCounter.put("CHEST_DISCOMFORT",0);
        symptomCounter.put("RESPIRATORY_DISTRESS",0);
        symptomCounter.put("ANOEA",0);
        symptomCounter.put("STRIDOR",0);
        symptomCounter.put("WHEEZING",0);
        symptomCounter.put("TACHYPNOE",0);
        symptomCounter.put("SHORTNESS_OF_BREATH",0);
        symptomCounter.put("NAUSEA",0);
        symptomCounter.put("VOMITING",0);
        symptomCounter.put("DIARRHOEA",0);
        symptomCounter.put("CHILLS",0);
        symptomCounter.put("TREMOR",0);
        symptomCounter.put("FATIGUE",0);
        symptomCounter.put("FEELING_ABNORMAL",0);
        symptomCounter.put("MYALGIA",0);
        symptomCounter.put("BODY_ACHE",0);
        symptomCounter.put("SWELLING",0);
        symptomCounter.put("BLOOD_PRESSURE_INCREASED",0);
        symptomCounter.put("BLOOD_PRESSURE_DECREASED",0);
        symptomCounter.put("LOSS_OF_CONSCIOUSNESS",0);
        symptomCounter.put("MUSCULOSKELETAL_DISORDER",0);
        symptomCounter.put("IMPAIRED_WORK_ABILITY",0);
        symptomCounter.put("ARTHRITIS_BACTERIAL",0);
        symptomCounter.put("STROKE",0);
        symptomCounter.put("CARDIOVASCULAR_FAILURE",0);
        symptomCounter.put("HEART_RATE_INCREASED",0);
        symptomCounter.put("CORONARY_ARTERY_DISEASE",0);
        symptomCounter.put("TACHYCARDIA",0);
        symptomCounter.put("SUDDEN_CARDIAC_ARREST",0);
        symptomCounter.put("PALPITATIONS",0);
        symptomCounter.put("MYOCARDIAL_INFRACTION",0);
        symptomCounter.put("ANAPHYLACTIC_SHOCK",0);
        symptomCounter.put("ANAPHYLACTIC_REACTION",0);
        symptomCounter.put("APHASIA",0);
        symptomCounter.put("HEADACHE",0);
        symptomCounter.put("DIZZINESS",0);
        symptomCounter.put("HYPERHIDROSIS",0);
        symptomCounter.put("BLEPHAROSPASM",0);
        symptomCounter.put("PARAESTHESIA",0);
        symptomCounter.put("EPISTAXIS",0);
        symptomCounter.put("SARS_CoV_2_TEST_POSITIVE",0);
        symptomCounter.put("PYREXIA",0);
        symptomCounter.put("BODY_TEMPERATURE_INCREASED",0);
        symptomCounter.put("FEBRILE_CONVULSION",0);
        symptomCounter.put("HOT_FLUSH",0);
        symptomCounter.put("BODY_TEMPERATURE_DECREASED",0);
        symptomCounter.put("PARALYSIS",0);
        symptomCounter.put("PALLOR",0);
        symptomCounter.put("STILLBIRTH",0);
        symptomCounter.put("FOETAL_DEATH",0);
        symptomCounter.put("DEATH",0);
        symptomCounter.put("LYMPHADENOPATHY",0);
        symptomCounter.put("SEIZURE",0);
        symptomCounter.put("HERPES_ZOSTER",0);
        symptomCounter.put("SLEEP_DISORDER",0);
        symptomCounter.put("HIPERSOMNIA",0);
        symptomCounter.put("ANXIETY",0);
        symptomCounter.put("INFLUENZA",0);
        symptomCounter.put("BLURRED_VISION",0);
        symptomCounter.put("BLINDNESS",0);
        symptomCounter.put("DYSPHONIA",0);
        symptomCounter.put("SPASM",0);
        symptomCounter.put("HAEMORRHAGE",0);
        symptomCounter.put("HEARING_IMPAIRMENT",0);
        symptomCounter.put("DEAFNESS",0);
        symptomCounter.put("SEPSIS",0);
        symptomCounter.put("VARICELLA",0);
        symptomCounter.put("PERICARDITIS",0);
        symptomCounter.put("AMYOTROPHY",0);
        symptomCounter.put("SENSORY_LOSS",0);
        symptomCounter.put("DECREASED_APPETITE",0);
        symptomCounter.put("CHANGE_IN_BLOOD_COUNT",0);
        symptomCounter.put("OXYGEN_SATURATION_DECREASED",0);


        for (Symptom symptom: symptoms) {
            if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                symptomCounter.replace("RESPIRATORY_SYSTEM_DISEASES", symptomCounter.get("RESPIRATORY_SYSTEM_DISEASES") + 1);
            }
            if (symptom.isAPPENDICITIS()){
                symptomCounter.replace("APPENDICITIS", symptomCounter.get("APPENDICITIS") + 1);
            }
            if (symptom.isDYSPHAGIA()){
                symptomCounter.replace("DYSPHAGIA", symptomCounter.get("DYSPHAGIA") + 1);
            }
            if (symptom.isTHROAT_TIGHTNESS()){
                symptomCounter.replace("THROAT_TIGHTNESS", symptomCounter.get("THROAT_TIGHTNESS") + 1);
            }
            if (symptom.isTHROAT_IRRITATION()){
                symptomCounter.replace("THROAT_IRRITATION", symptomCounter.get("THROAT_IRRITATION") + 1);
            }
            if (symptom.isDYSPNOEA()){
                symptomCounter.replace("DYSPNOEA", symptomCounter.get("DYSPNOEA") + 1);
            }
            if (symptom.isCOUGH()){
                symptomCounter.replace("COUGH", symptomCounter.get("COUGH") + 1);
            }
            if (symptom.isCHEST_DISCOMFORT()){
                symptomCounter.replace("CHEST_DISCOMFORT", symptomCounter.get("CHEST_DISCOMFORT") + 1);
            }
            if (symptom.isRESPIRATORY_DISTRESS()){
                symptomCounter.replace("RESPIRATORY_DISTRESS", symptomCounter.get("RESPIRATORY_DISTRESS") + 1);
            }
            if (symptom.isANOEA()){
                symptomCounter.replace("ANOEA", symptomCounter.get("ANOEA") + 1);
            }
            if (symptom.isSTRIDOR()){
                symptomCounter.replace("STRIDOR", symptomCounter.get("STRIDOR") + 1);
            }
            if (symptom.isWHEEZING()){
                symptomCounter.replace("WHEEZING", symptomCounter.get("WHEEZING") + 1);
            }
            if (symptom.isTACHYPNOE()){
                symptomCounter.replace("TACHYPNOE", symptomCounter.get("TACHYPNOE") + 1);
            }
            if (symptom.isSHORTNESS_OF_BREATH()){
                symptomCounter.replace("SHORTNESS_OF_BREATH", symptomCounter.get("SHORTNESS_OF_BREATH") + 1);
            }
            if (symptom.isNAUSEA()){
                symptomCounter.replace("NAUSEA", symptomCounter.get("NAUSEA") + 1);
            }
            if (symptom.isVOMITING()){
                symptomCounter.replace("VOMITING", symptomCounter.get("VOMITING") + 1);
            }
            if (symptom.isDIARRHOEA()){
                symptomCounter.replace("DIARRHOEA", symptomCounter.get("DIARRHOEA") + 1);
            }
            if (symptom.isCHILLS()){
                symptomCounter.replace("CHILLS", symptomCounter.get("CHILLS") + 1);
            }
            if (symptom.isTREMOR()){
                symptomCounter.replace("TREMOR", symptomCounter.get("TREMOR") + 1);
            }
            if (symptom.isFATIGUE()){
                symptomCounter.replace("FATIGUE", symptomCounter.get("FATIGUE") + 1);
            }
            if (symptom.isFEELING_ABNORMAL()){
                symptomCounter.replace("FEELING_ABNORMAL", symptomCounter.get("FEELING_ABNORMAL") + 1);
            }
            if (symptom.isMYALGIA()){
                symptomCounter.replace("MYALGIA", symptomCounter.get("MYALGIA") + 1);
            }
            if (symptom.isBODY_ACHE()){
                symptomCounter.replace("BODY_ACHE", symptomCounter.get("BODY_ACHE") + 1);
            }
            if (symptom.isSWELLING()){
                symptomCounter.replace("SWELLING", symptomCounter.get("SWELLING") + 1);
            }
            if (symptom.isBLOOD_PRESSURE_INCREASED()){
                symptomCounter.replace("BLOOD_PRESSURE_INCREASED", symptomCounter.get("BLOOD_PRESSURE_INCREASED") + 1);
            }
            if (symptom.isBLOOD_PRESSURE_DECREASED()){
                symptomCounter.replace("BLOOD_PRESSURE_DECREASED", symptomCounter.get("BLOOD_PRESSURE_DECREASED") + 1);
            }
            if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                symptomCounter.replace("LOSS_OF_CONSCIOUSNESS", symptomCounter.get("LOSS_OF_CONSCIOUSNESS") + 1);
            }
            if (symptom.isMUSCULOSKELETAL_DISORDER()){
                symptomCounter.replace("MUSCULOSKELETAL_DISORDER", symptomCounter.get("MUSCULOSKELETAL_DISORDER") + 1);
            }
            if (symptom.isIMPAIRED_WORK_ABILITY()){
                symptomCounter.replace("IMPAIRED_WORK_ABILITY", symptomCounter.get("IMPAIRED_WORK_ABILITY") + 1);
            }
            if (symptom.isARTHRITIS_BACTERIAL()){
                symptomCounter.replace("ARTHRITIS_BACTERIAL", symptomCounter.get("ARTHRITIS_BACTERIAL") + 1);
            }
            if (symptom.isSTROKE()){
                symptomCounter.replace("STROKE", symptomCounter.get("STROKE") + 1);
            }
            if (symptom.isCARDIOVASCULAR_FAILURE()){
                symptomCounter.replace("CARDIOVASCULAR_FAILURE", symptomCounter.get("CARDIOVASCULAR_FAILURE") + 1);
            }
            if (symptom.isHEART_RATE_INCREASED()){
                symptomCounter.replace("HEART_RATE_INCREASED", symptomCounter.get("HEART_RATE_INCREASED") + 1);
            }
            if (symptom.isCORONARY_ARTERY_DISEASE()){
                symptomCounter.replace("CORONARY_ARTERY_DISEASE", symptomCounter.get("CORONARY_ARTERY_DISEASE") + 1);
            }
            if (symptom.isTACHYCARDIA()){
                symptomCounter.replace("TACHYCARDIA", symptomCounter.get("TACHYCARDIA") + 1);
            }
            if (symptom.isSUDDEN_CARDIAC_ARREST()){
                symptomCounter.replace("SUDDEN_CARDIAC_ARREST", symptomCounter.get("SUDDEN_CARDIAC_ARREST") + 1);
            }
            if (symptom.isPALPITATIONS()){
                symptomCounter.replace("PALPITATIONS", symptomCounter.get("PALPITATIONS") + 1);
            }
            if (symptom.isMYOCARDIAL_INFRACTION()){
                symptomCounter.replace("MYOCARDIAL_INFRACTION", symptomCounter.get("MYOCARDIAL_INFRACTION") + 1);
            }
            if (symptom.isANAPHYLACTIC_SHOCK()){
                symptomCounter.replace("ANAPHYLACTIC_SHOCK", symptomCounter.get("ANAPHYLACTIC_SHOCK") + 1);
            }
            if (symptom.isANAPHYLACTIC_REACTION()){
                symptomCounter.replace("ANAPHYLACTIC_REACTION", symptomCounter.get("ANAPHYLACTIC_REACTION") + 1);
            }
            if (symptom.isAPHASIA()){
                symptomCounter.replace("APHASIA", symptomCounter.get("APHASIA") + 1);
            }
            if (symptom.isHEADACHE()){
                symptomCounter.replace("HEADACHE", symptomCounter.get("HEADACHE") + 1);
            }
            if (symptom.isDIZZINESS()){
                symptomCounter.replace("DIZZINESS", symptomCounter.get("DIZZINESS") + 1);
            }
            if (symptom.isHYPERHIDROSIS()){
                symptomCounter.replace("HYPERHIDROSIS", symptomCounter.get("HYPERHIDROSIS") + 1);
            }
            if (symptom.isBLEPHAROSPASM()){
                symptomCounter.replace("BLEPHAROSPASM", symptomCounter.get("BLEPHAROSPASM") + 1);
            }
            if (symptom.isPARAESTHESIA()){
                symptomCounter.replace("PARAESTHESIA", symptomCounter.get("PARAESTHESIA") + 1);
            }
            if (symptom.isEPISTAXIS()){
                symptomCounter.replace("EPISTAXIS", symptomCounter.get("EPISTAXIS") + 1);
            }
            if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                symptomCounter.replace("SARS_CoV_2_TEST_POSITIVE", symptomCounter.get("SARS_CoV_2_TEST_POSITIVE") + 1);
            }
            if (symptom.isPYREXIA()){
                symptomCounter.replace("PYREXIA", symptomCounter.get("PYREXIA") + 1);
            }
            if (symptom.isBODY_TEMPERATURE_INCREASED()){
                symptomCounter.replace("BODY_TEMPERATURE_INCREASED", symptomCounter.get("BODY_TEMPERATURE_INCREASED") + 1);
            }
            if (symptom.isFEBRILE_CONVULSION()){
                symptomCounter.replace("FEBRILE_CONVULSION", symptomCounter.get("FEBRILE_CONVULSION") + 1);
            }
            if (symptom.isHOT_FLUSH()){
                symptomCounter.replace("HOT_FLUSH", symptomCounter.get("HOT_FLUSH") + 1);
            }
            if (symptom.isBODY_TEMPERATURE_DECREASED()){
                symptomCounter.replace("BODY_TEMPERATURE_DECREASED", symptomCounter.get("BODY_TEMPERATURE_DECREASED") + 1);
            }
            if (symptom.isPARALYSIS()){
                symptomCounter.replace("PARALYSIS", symptomCounter.get("PARALYSIS") + 1);
            }
            if (symptom.isPALLOR()){
                symptomCounter.replace("PALLOR", symptomCounter.get("PALLOR") + 1);
            }
            if (symptom.isSTILLBIRTH()){
                symptomCounter.replace("STILLBIRTH", symptomCounter.get("STILLBIRTH") + 1);
            }
            if (symptom.isFOETAL_DEATH()){
                symptomCounter.replace("FOETAL_DEATH", symptomCounter.get("FOETAL_DEATH") + 1);
            }
            if (symptom.isDEATH()){
                symptomCounter.replace("DEATH", symptomCounter.get("DEATH") + 1);
            }
            if (symptom.isLYMPHADENOPATHY()){
                symptomCounter.replace("LYMPHADENOPATHY", symptomCounter.get("LYMPHADENOPATHY") + 1);
            }
            if (symptom.isSEIZURE()){
                symptomCounter.replace("SEIZURE", symptomCounter.get("SEIZURE") + 1);
            }
            if (symptom.isHERPES_ZOSTER()){
                symptomCounter.replace("HERPES_ZOSTER", symptomCounter.get("HERPES_ZOSTER") + 1);
            }
            if (symptom.isSLEEP_DISORDER()){
                symptomCounter.replace("SLEEP_DISORDER", symptomCounter.get("SLEEP_DISORDER") + 1);
            }
            if (symptom.isHIPERSOMNIA()){
                symptomCounter.replace("HIPERSOMNIA", symptomCounter.get("HIPERSOMNIA") + 1);
            }
            if (symptom.isANXIETY()){
                symptomCounter.replace("ANXIETY", symptomCounter.get("ANXIETY") + 1);
            }
            if (symptom.isINFLUENZA()){
                symptomCounter.replace("INFLUENZA", symptomCounter.get("INFLUENZA") + 1);
            }
            if (symptom.isBLURRED_VISION()){
                symptomCounter.replace("BLURRED_VISION", symptomCounter.get("BLURRED_VISION") + 1);
            }
            if (symptom.isBLINDNESS()){
                symptomCounter.replace("BLINDNESS", symptomCounter.get("BLINDNESS") + 1);
            }
            if (symptom.isDYSPHONIA()){
                symptomCounter.replace("DYSPHONIA", symptomCounter.get("DYSPHONIA") + 1);
            }
            if (symptom.isSPASM()){
                symptomCounter.replace("SPASM", symptomCounter.get("SPASM") + 1);
            }
            if (symptom.isHAEMORRHAGE()){
                symptomCounter.replace("HAEMORRHAGE", symptomCounter.get("HAEMORRHAGE") + 1);
            }
            if (symptom.isHEARING_IMPAIRMENT()){
                symptomCounter.replace("HEARING_IMPAIRMENT", symptomCounter.get("HEARING_IMPAIRMENT") + 1);
            }
            if (symptom.isDEAFNESS()){
                symptomCounter.replace("DEAFNESS", symptomCounter.get("DEAFNESS") + 1);
            }
            if (symptom.isSEPSIS()){
                symptomCounter.replace("SEPSIS", symptomCounter.get("SEPSIS") + 1);
            }
            if (symptom.isVARICELLA()){
                symptomCounter.replace("VARICELLA", symptomCounter.get("VARICELLA") + 1);
            }
            if (symptom.isPERICARDITIS()){
                symptomCounter.replace("PERICARDITIS", symptomCounter.get("PERICARDITIS") + 1);
            }
            if (symptom.isAMYOTROPHY()){
                symptomCounter.replace("AMYOTROPHY", symptomCounter.get("AMYOTROPHY") + 1);
            }
            if (symptom.isSENSORY_LOSS()){
                symptomCounter.replace("SENSORY LOSS", symptomCounter.get("SENSORY LOSS") + 1);
            }
            if (symptom.isDECREASED_APPETITE()){
                symptomCounter.replace("DECREASED_APPETITE", symptomCounter.get("DECREASED_APPETITE") + 1);
            }
            if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                symptomCounter.replace("CHANGE_IN_BLOOD_COUNT", symptomCounter.get("CHANGE_IN_BLOOD_COUNT") + 1);
            }
            if (symptom.isOXYGEN_SATURATION_DECREASED()){
                symptomCounter.replace("OXYGEN_SATURATION_DECREASED", symptomCounter.get("OXYGEN_SATURATION_DECREASED") + 1);
            }
        }

        double suma = 0.0;
        for (Map.Entry map: symptomCounter.entrySet()) {
            suma += (Integer)map.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        symptomPercent.add(new SymptomOccurrence("CHOROBY UKŁADU ODDECHOWEGO", (symptomCounter.get("RESPIRATORY_SYSTEM_DISEASES")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZAPALENIE WYROSTKA ROBACZKOWEGO", (symptomCounter.get("APPENDICITIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSFAGIA", (symptomCounter.get("DYSPHAGIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UCISK W GARDLE", (symptomCounter.get("THROAT_TIGHTNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PODRAŻNIENIE GARDŁA", (symptomCounter.get("THROAT_IRRITATION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DUSZNOŚĆ", (symptomCounter.get("DYSPNOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("KASZEL", (symptomCounter.get("COUGH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSKOMFORT W KLATCE", (symptomCounter.get("CHEST_DISCOMFORT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NIEWYDOLNOŚĆ ODDECHOWA", (symptomCounter.get("RESPIRATORY_DISTRESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BEZDECH", (symptomCounter.get("ANOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ŚWIST WDECHOWY", (symptomCounter.get("STRIDOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ŚWIST WYDECHOWY", (symptomCounter.get("WHEEZING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZWIĘKSZONA CZĘSTOŚĆ ODDECHÓW", (symptomCounter.get("TACHYPNOE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("KRÓTKI ODDECH", (symptomCounter.get("SHORTNESS_OF_BREATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NUDNOŚCI", (symptomCounter.get("NAUSEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("WYMIOTY", (symptomCounter.get("VOMITING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BIEGUNKA", (symptomCounter.get("DIARRHOEA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DRESZCZE", (symptomCounter.get("CHILLS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DRŻENIE", (symptomCounter.get("TREMOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZMĘCZENIE", (symptomCounter.get("FATIGUE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NIENORMALNE UCZUCIE", (symptomCounter.get("FEELING_ABNORMAL")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("MIALGIA, BÓL MIĘŚNIOWY", (symptomCounter.get("MYALGIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BÓL CIAŁA", (symptomCounter.get("BODY_ACHE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("OBRZĘK", (symptomCounter.get("SWELLING")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("WZROST CIŚNIENIA KRWI", (symptomCounter.get("BLOOD_PRESSURE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SPADEK CIŚNIENIA KRWI", (symptomCounter.get("BLOOD_PRESSURE_DECREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UTRATA PRZYTOMNOŚCI", (symptomCounter.get("LOSS_OF_CONSCIOUSNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZABURZENIA MIĘŚNIOWO-SZKIELETOWE", (symptomCounter.get("MUSCULOSKELETAL_DISORDER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NIEZDOLNOŚĆ DO PRACY", (symptomCounter.get("IMPAIRED_WORK_ABILITY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BAKTERYJNE ZAPALENIE STAWÓW", (symptomCounter.get("ARTHRITIS_BACTERIAL")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UDAR", (symptomCounter.get("STROKE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NIEWYDOLNOŚĆ KRĄŻENIA", (symptomCounter.get("CARDIOVASCULAR_FAILURE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZWIĘKSZONE TĘTNO", (symptomCounter.get("HEART_RATE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("CHOROBA WIEŃCOWA", (symptomCounter.get("CORONARY_ARTERY_DISEASE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("TACHYKARDIA", (symptomCounter.get("TACHYCARDIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NAGŁE ZATRZYMANIE KRĄŻENIA", (symptomCounter.get("SUDDEN_CARDIAC_ARREST")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PALPITACJA", (symptomCounter.get("PALPITATIONS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZAWAŁ MIĘŚNIA SERCOWEGO", (symptomCounter.get("MYOCARDIAL_INFRACTION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("WSTRZĄS ANAFILAKTYCZNY", (symptomCounter.get("ANAPHYLACTIC_SHOCK")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("REAKCJA ANAFILAKTYCZNA", (symptomCounter.get("ANAPHYLACTIC_REACTION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UTRATA ZDOLNOŚCI MOWY", (symptomCounter.get("APHASIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BÓL GŁOWY", (symptomCounter.get("HEADACHE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZAWROTY GŁOWY", (symptomCounter.get("DIZZINESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NADMIERNA POTLIWOŚĆ", (symptomCounter.get("HYPERHIDROSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("KURCZ POWIEK", (symptomCounter.get("BLEPHAROSPASM")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PARESTEZIA, CZUCIE OPACZNE", (symptomCounter.get("PARAESTHESIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("KRWAWIENIE Z NOSA", (symptomCounter.get("EPISTAXIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("POZYTYWNY TEST NA COVID-19", (symptomCounter.get("SARS_CoV_2_TEST_POSITIVE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("GORĄCZKA", (symptomCounter.get("PYREXIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZWIĘKSZENIE TEMPERATURY CIAŁA", (symptomCounter.get("BODY_TEMPERATURE_INCREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DRGAWKI GORĄCZKOWE", (symptomCounter.get("FEBRILE_CONVULSION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UDERZENIE GORĄCA", (symptomCounter.get("HOT_FLUSH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SPADEK TEMPERATURY CIAŁA", (symptomCounter.get("BODY_TEMPERATURE_DECREASED")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PARALIŻ", (symptomCounter.get("PARALYSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("BLADOŚĆ", (symptomCounter.get("PALLOR")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PORONIENIE", (symptomCounter.get("STILLBIRTH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ŚMIERĆ PŁODU", (symptomCounter.get("FOETAL_DEATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ŚMIERĆ", (symptomCounter.get("DEATH")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("POWIĘKSZENIE WĘZŁÓW CHŁONNYCH", (symptomCounter.get("LYMPHADENOPATHY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NAPAD", (symptomCounter.get("SEIZURE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("PÓŁPASIEC", (symptomCounter.get("HERPES_ZOSTER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZABURZENIA SNU", (symptomCounter.get("SLEEP_DISORDER")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("NADMIERNA SENNOŚĆ", (symptomCounter.get("HIPERSOMNIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("LĘK", (symptomCounter.get("ANXIETY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("GRYPA", (symptomCounter.get("INFLUENZA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZABURZENIA WIDZENIA", (symptomCounter.get("BLURRED_VISION")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ŚLEPOTA", (symptomCounter.get("BLINDNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("DYSFONIA, ZABURZENIA GŁOSU", (symptomCounter.get("DYSPHONIA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SKURCZE", (symptomCounter.get("SPASM")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("KRWOTOK", (symptomCounter.get("HAEMORRHAGE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZABURZENIA SŁUCHU", (symptomCounter.get("HEARING_IMPAIRMENT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("GŁUCHOTA", (symptomCounter.get("DEAFNESS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("POSOCZNICA", (symptomCounter.get("SEPSIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("OSPA WIETRZNA", (symptomCounter.get("VARICELLA")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZAPALENIE OSIERDZIA", (symptomCounter.get("PERICARDITIS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("AMIOTROFIA", (symptomCounter.get("AMYOTROPHY")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("UTRATA ZMYSŁÓW",(symptomCounter.get("SENSORY_LOSS")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SPADEK APETYTU", (symptomCounter.get("DECREASED_APPETITE")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("ZMIANA MORFOLOGII KRWI", (symptomCounter.get("CHANGE_IN_BLOOD_COUNT")/suma)*100));
        symptomPercent.add(new SymptomOccurrence("SPADEK SATURACJI", (symptomCounter.get("OXYGEN_SATURATION_DECREASED")/suma)*100));

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("INNE" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(others);
        model.put("symptomPercent",symptomPercent);
        model.put("firstCommon",firstCommon);
        return "analiza";
    }

    List <AgeGroup> ageAnalisis(){
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Iterable<Patient> patients = patientRepository.findAll();

        List<AgeGroup> ageGroups = new ArrayList<>();
        ageGroups.add(new AgeGroup(0,10));
        ageGroups.add(new AgeGroup(10,20));
        ageGroups.add(new AgeGroup(20,30));
        ageGroups.add(new AgeGroup(30,40));
        ageGroups.add(new AgeGroup(40,50));
        ageGroups.add(new AgeGroup(50,60));
        ageGroups.add(new AgeGroup(60,70));
        ageGroups.add(new AgeGroup(70,80));
        ageGroups.add(new AgeGroup(80,90));
        ageGroups.add(new AgeGroup(90,100));

        Iterator<Patient> patientIterator = patients.iterator();
        Iterator<Symptom> symptomIterator = symptoms.iterator();
        while (patientIterator.hasNext()){
            Patient patient = patientIterator.next();
            Symptom symptom = symptomIterator.next();
            for (AgeGroup ageGroup: ageGroups) {
                if (patient.getAGE_YRS() >= ageGroup.getAgeMin() && patient.getAGE_YRS() <= ageGroup.getAgeMax()){
                    if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                        ageGroup.getSymptomCounter().replace("RESPIRATORY_SYSTEM_DISEASES", ageGroup.getSymptomCounter().get("RESPIRATORY_SYSTEM_DISEASES") + 1);
                    }
                    if (symptom.isAPPENDICITIS()){
                        ageGroup.getSymptomCounter().replace("APPENDICITIS", ageGroup.getSymptomCounter().get("APPENDICITIS") + 1);
                    }
                    if (symptom.isDYSPHAGIA()){
                        ageGroup.getSymptomCounter().replace("DYSPHAGIA", ageGroup.getSymptomCounter().get("DYSPHAGIA") + 1);
                    }
                    if (symptom.isTHROAT_TIGHTNESS()){
                        ageGroup.getSymptomCounter().replace("THROAT_TIGHTNESS", ageGroup.getSymptomCounter().get("THROAT_TIGHTNESS") + 1);
                    }
                    if (symptom.isTHROAT_IRRITATION()){
                        ageGroup.getSymptomCounter().replace("THROAT_IRRITATION", ageGroup.getSymptomCounter().get("THROAT_IRRITATION") + 1);
                    }
                    if (symptom.isDYSPNOEA()){
                        ageGroup.getSymptomCounter().replace("DYSPNOEA", ageGroup.getSymptomCounter().get("DYSPNOEA") + 1);
                    }
                    if (symptom.isCOUGH()){
                        ageGroup.getSymptomCounter().replace("COUGH", ageGroup.getSymptomCounter().get("COUGH") + 1);
                    }
                    if (symptom.isCHEST_DISCOMFORT()){
                        ageGroup.getSymptomCounter().replace("CHEST_DISCOMFORT", ageGroup.getSymptomCounter().get("CHEST_DISCOMFORT") + 1);
                    }
                    if (symptom.isANOEA()){
                        ageGroup.getSymptomCounter().replace("ANOEA", ageGroup.getSymptomCounter().get("ANOEA") + 1);
                    }
                    if (symptom.isSTRIDOR()){
                        ageGroup.getSymptomCounter().replace("STRIDOR", ageGroup.getSymptomCounter().get("STRIDOR") + 1);
                    }
                    if (symptom.isWHEEZING()){
                        ageGroup.getSymptomCounter().replace("WHEEZING", ageGroup.getSymptomCounter().get("WHEEZING") + 1);
                    }
                    if (symptom.isTACHYPNOE()){
                        ageGroup.getSymptomCounter().replace("TACHYPNOE", ageGroup.getSymptomCounter().get("TACHYPNOE") + 1);
                    }
                    if (symptom.isSHORTNESS_OF_BREATH()){
                        ageGroup.getSymptomCounter().replace("SHORTNESS_OF_BREATH", ageGroup.getSymptomCounter().get("SHORTNESS_OF_BREATH") + 1);
                    }
                    if (symptom.isRESPIRATORY_DISTRESS()){
                        ageGroup.getSymptomCounter().replace("RESPIRATORY_DISTRESS", ageGroup.getSymptomCounter().get("RESPIRATORY_DISTRESS") + 1);
                    }
                    if (symptom.isNAUSEA()){
                        ageGroup.getSymptomCounter().replace("NAUSEA", ageGroup.getSymptomCounter().get("NAUSEA") + 1);
                    }
                    if (symptom.isVOMITING()){
                        ageGroup.getSymptomCounter().replace("VOMITING", ageGroup.getSymptomCounter().get("VOMITING") + 1);
                    }
                    if (symptom.isDIARRHOEA()){
                        ageGroup.getSymptomCounter().replace("DIARRHOEA", ageGroup.getSymptomCounter().get("DIARRHOEA") + 1);
                    }
                    if (symptom.isCHILLS()){
                        ageGroup.getSymptomCounter().replace("CHILLS", ageGroup.getSymptomCounter().get("CHILLS") + 1);
                    }
                    if (symptom.isTREMOR()){
                        ageGroup.getSymptomCounter().replace("TREMOR", ageGroup.getSymptomCounter().get("TREMOR") + 1);
                    }
                    if (symptom.isFATIGUE()){
                        ageGroup.getSymptomCounter().replace("FATIGUE", ageGroup.getSymptomCounter().get("FATIGUE") + 1);
                    }
                    if (symptom.isFEELING_ABNORMAL()){
                        ageGroup.getSymptomCounter().replace("FEELING_ABNORMAL", ageGroup.getSymptomCounter().get("FEELING_ABNORMAL") + 1);
                    }
                    if (symptom.isMYALGIA()){
                        ageGroup.getSymptomCounter().replace("MYALGIA", ageGroup.getSymptomCounter().get("MYALGIA") + 1);
                    }
                    if (symptom.isBODY_ACHE()){
                        ageGroup.getSymptomCounter().replace("BODY_ACHE", ageGroup.getSymptomCounter().get("BODY_ACHE") + 1);
                    }
                    if (symptom.isSWELLING()){
                        ageGroup.getSymptomCounter().replace("SWELLING", ageGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_INCREASED()){
                        ageGroup.getSymptomCounter().replace("BLOOD_PRESSURE_INCREASED", ageGroup.getSymptomCounter().get("BLOOD_PRESSURE_INCREASED") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_DECREASED()){
                        ageGroup.getSymptomCounter().replace("BLOOD_PRESSURE_DECREASED", ageGroup.getSymptomCounter().get("BLOOD_PRESSURE_DECREASED") + 1);
                    }
                    if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                        ageGroup.getSymptomCounter().replace("LOSS_OF_CONSCIOUSNESS", ageGroup.getSymptomCounter().get("LOSS_OF_CONSCIOUSNESS") + 1);
                    }
                    if (symptom.isMUSCULOSKELETAL_DISORDER()){
                        ageGroup.getSymptomCounter().replace("MUSCULOSKELETAL_DISORDER", ageGroup.getSymptomCounter().get("MUSCULOSKELETAL_DISORDER") + 1);
                    }
                    if (symptom.isIMPAIRED_WORK_ABILITY()){
                        ageGroup.getSymptomCounter().replace("IMPAIRED_WORK_ABILITY", ageGroup.getSymptomCounter().get("IMPAIRED_WORK_ABILITY") + 1);
                    }
                    if (symptom.isARTHRITIS_BACTERIAL()){
                        ageGroup.getSymptomCounter().replace("ARTHRITIS_BACTERIAL", ageGroup.getSymptomCounter().get("ARTHRITIS_BACTERIAL") + 1);
                    }
                    if (symptom.isSTROKE()){
                        ageGroup.getSymptomCounter().replace("STROKE", ageGroup.getSymptomCounter().get("STROKE") + 1);
                    }
                    if (symptom.isCARDIOVASCULAR_FAILURE()){
                        ageGroup.getSymptomCounter().replace("CARDIOVASCULAR_FAILURE", ageGroup.getSymptomCounter().get("CARDIOVASCULAR_FAILURE") + 1);
                    }
                    if (symptom.isHEART_RATE_INCREASED()){
                        ageGroup.getSymptomCounter().replace("HEART_RATE_INCREASED", ageGroup.getSymptomCounter().get("HEART_RATE_INCREASED") + 1);
                    }
                    if (symptom.isCORONARY_ARTERY_DISEASE()){
                        ageGroup.getSymptomCounter().replace("CORONARY_ARTERY_DISEASE", ageGroup.getSymptomCounter().get("CORONARY_ARTERY_DISEASE") + 1);
                    }
                    if (symptom.isTACHYCARDIA()){
                        ageGroup.getSymptomCounter().replace("TACHYCARDIA", ageGroup.getSymptomCounter().get("TACHYCARDIA") + 1);
                    }
                    if (symptom.isSUDDEN_CARDIAC_ARREST()){
                        ageGroup.getSymptomCounter().replace("SUDDEN_CARDIAC_ARREST", ageGroup.getSymptomCounter().get("SUDDEN_CARDIAC_ARREST") + 1);
                    }
                    if (symptom.isPALPITATIONS()){
                        ageGroup.getSymptomCounter().replace("PALPITATIONS", ageGroup.getSymptomCounter().get("PALPITATIONS") + 1);
                    }
                    if (symptom.isMYOCARDIAL_INFRACTION()){
                        ageGroup.getSymptomCounter().replace("MYOCARDIAL_INFRACTION", ageGroup.getSymptomCounter().get("MYOCARDIAL_INFRACTION") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_SHOCK()){
                        ageGroup.getSymptomCounter().replace("ANAPHYLACTIC_SHOCK", ageGroup.getSymptomCounter().get("ANAPHYLACTIC_SHOCK") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_REACTION()){
                        ageGroup.getSymptomCounter().replace("ANAPHYLACTIC_REACTION", ageGroup.getSymptomCounter().get("ANAPHYLACTIC_REACTION") + 1);
                    }
                    if (symptom.isAPHASIA()){
                        ageGroup.getSymptomCounter().replace("APHASIA", ageGroup.getSymptomCounter().get("APHASIA") + 1);
                    }
                    if (symptom.isHEADACHE()){
                        ageGroup.getSymptomCounter().replace("HEADACHE", ageGroup.getSymptomCounter().get("HEADACHE") + 1);
                    }
                    if (symptom.isDIZZINESS()){
                        ageGroup.getSymptomCounter().replace("DIZZINESS", ageGroup.getSymptomCounter().get("DIZZINESS") + 1);
                    }
                    if (symptom.isHYPERHIDROSIS()){
                        ageGroup.getSymptomCounter().replace("HYPERHIDROSIS", ageGroup.getSymptomCounter().get("HYPERHIDROSIS") + 1);
                    }
                    if (symptom.isBLEPHAROSPASM()){
                        ageGroup.getSymptomCounter().replace("BLEPHAROSPASM", ageGroup.getSymptomCounter().get("BLEPHAROSPASM") + 1);
                    }
                    if (symptom.isPARAESTHESIA()){
                        ageGroup.getSymptomCounter().replace("PARAESTHESIA", ageGroup.getSymptomCounter().get("PARAESTHESIA") + 1);
                    }
                    if (symptom.isEPISTAXIS()){
                        ageGroup.getSymptomCounter().replace("EPISTAXIS", ageGroup.getSymptomCounter().get("EPISTAXIS") + 1);
                    }
                    if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                        ageGroup.getSymptomCounter().replace("SARS_CoV_2_TEST_POSITIVE", ageGroup.getSymptomCounter().get("SARS_CoV_2_TEST_POSITIVE") + 1);
                    }
                    if (symptom.isPYREXIA()){
                        ageGroup.getSymptomCounter().replace("PYREXIA", ageGroup.getSymptomCounter().get("PYREXIA") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_INCREASED()){
                        ageGroup.getSymptomCounter().replace("BODY_TEMPERATURE_INCREASED", ageGroup.getSymptomCounter().get("BODY_TEMPERATURE_INCREASED") + 1);
                    }
                    if (symptom.isFEBRILE_CONVULSION()){
                        ageGroup.getSymptomCounter().replace("FEBRILE_CONVULSION", ageGroup.getSymptomCounter().get("FEBRILE_CONVULSION") + 1);
                    }
                    if (symptom.isHOT_FLUSH()){
                        ageGroup.getSymptomCounter().replace("HOT_FLUSH", ageGroup.getSymptomCounter().get("HOT_FLUSH") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_DECREASED()){
                        ageGroup.getSymptomCounter().replace("BODY_TEMPERATURE_DECREASED", ageGroup.getSymptomCounter().get("BODY_TEMPERATURE_DECREASED") + 1);
                    }
                    if (symptom.isPARALYSIS()){
                        ageGroup.getSymptomCounter().replace("PARALYSIS", ageGroup.getSymptomCounter().get("PARALYSIS") + 1);
                    }
                    if (symptom.isPALLOR()){
                        ageGroup.getSymptomCounter().replace("PALLOR", ageGroup.getSymptomCounter().get("PALLOR") + 1);
                    }
                    if (symptom.isSTILLBIRTH()){
                        ageGroup.getSymptomCounter().replace("STILLBIRTH", ageGroup.getSymptomCounter().get("STILLBIRTH") + 1);
                    }
                    if (symptom.isFOETAL_DEATH()){
                        ageGroup.getSymptomCounter().replace("FOETAL_DEATH", ageGroup.getSymptomCounter().get("FOETAL_DEATH") + 1);
                    }
                    if (symptom.isDEATH()){
                        ageGroup.getSymptomCounter().replace("DEATH", ageGroup.getSymptomCounter().get("DEATH") + 1);
                    }
                    if (symptom.isLYMPHADENOPATHY()){
                        ageGroup.getSymptomCounter().replace("LYMPHADENOPATHY", ageGroup.getSymptomCounter().get("LYMPHADENOPATHY") + 1);
                    }
                    if (symptom.isSEIZURE()){
                        ageGroup.getSymptomCounter().replace("SEIZURE", ageGroup.getSymptomCounter().get("SEIZURE") + 1);
                    }
                    if (symptom.isHERPES_ZOSTER()){
                        ageGroup.getSymptomCounter().replace("HERPES_ZOSTER", ageGroup.getSymptomCounter().get("HERPES_ZOSTER") + 1);
                    }
                    if (symptom.isSLEEP_DISORDER()){
                        ageGroup.getSymptomCounter().replace("SLEEP_DISORDER", ageGroup.getSymptomCounter().get("SLEEP_DISORDER") + 1);
                    }
                    if (symptom.isHIPERSOMNIA()){
                        ageGroup.getSymptomCounter().replace("HIPERSOMNIA", ageGroup.getSymptomCounter().get("HIPERSOMNIA") + 1);
                    }
                    if (symptom.isANXIETY()){
                        ageGroup.getSymptomCounter().replace("ANXIETY", ageGroup.getSymptomCounter().get("ANXIETY") + 1);
                    }
                    if (symptom.isINFLUENZA()){
                        ageGroup.getSymptomCounter().replace("INFLUENZA", ageGroup.getSymptomCounter().get("INFLUENZA") + 1);
                    }
                    if (symptom.isBLURRED_VISION()){
                        ageGroup.getSymptomCounter().replace("BLURRED_VISION", ageGroup.getSymptomCounter().get("BLURRED_VISION") + 1);
                    }
                    if (symptom.isBLINDNESS()){
                        ageGroup.getSymptomCounter().replace("BLINDNESS", ageGroup.getSymptomCounter().get("BLINDNESS") + 1);
                    }
                    if (symptom.isDYSPHONIA()){
                        ageGroup.getSymptomCounter().replace("DYSPHONIA", ageGroup.getSymptomCounter().get("DYSPHONIA") + 1);
                    }
                    if (symptom.isSPASM()){
                        ageGroup.getSymptomCounter().replace("SPASM", ageGroup.getSymptomCounter().get("SPASM") + 1);
                    }
                    if (symptom.isHAEMORRHAGE()){
                        ageGroup.getSymptomCounter().replace("HAEMORRHAGE", ageGroup.getSymptomCounter().get("HAEMORRHAGE") + 1);
                    }
                    if (symptom.isHEARING_IMPAIRMENT()){
                        ageGroup.getSymptomCounter().replace("HEARING_IMPAIRMENT", ageGroup.getSymptomCounter().get("HEARING_IMPAIRMENT") + 1);
                    }
                    if (symptom.isDEAFNESS()){
                        ageGroup.getSymptomCounter().replace("DEAFNESS", ageGroup.getSymptomCounter().get("DEAFNESS") + 1);
                    }
                    if (symptom.isSEPSIS()){
                        ageGroup.getSymptomCounter().replace("SEPSIS", ageGroup.getSymptomCounter().get("SEPSIS") + 1);
                    }
                    if (symptom.isVARICELLA()){
                        ageGroup.getSymptomCounter().replace("VARICELLA", ageGroup.getSymptomCounter().get("VARICELLA") + 1);
                    }
                    if (symptom.isPERICARDITIS()){
                        ageGroup.getSymptomCounter().replace("PERICARDITIS", ageGroup.getSymptomCounter().get("PERICARDITIS") + 1);
                    }
                    if (symptom.isAMYOTROPHY()){
                        ageGroup.getSymptomCounter().replace("AMYOTROPHY", ageGroup.getSymptomCounter().get("AMYOTROPHY") + 1);
                    }
                    if (symptom.isSENSORY_LOSS()){
                        ageGroup.getSymptomCounter().replace("SENSORY LOSS", ageGroup.getSymptomCounter().get("SENSORY LOSS") + 1);
                    }
                    if (symptom.isDECREASED_APPETITE()){
                        ageGroup.getSymptomCounter().replace("DECREASED_APPETITE", ageGroup.getSymptomCounter().get("DECREASED_APPETITE") + 1);
                    }
                    if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                        ageGroup.getSymptomCounter().replace("CHANGE_IN_BLOOD_COUNT", ageGroup.getSymptomCounter().get("CHANGE_IN_BLOOD_COUNT") + 1);
                    }
                    if (symptom.isOXYGEN_SATURATION_DECREASED()){
                        ageGroup.getSymptomCounter().replace("OXYGEN_SATURATION_DECREASED", ageGroup.getSymptomCounter().get("OXYGEN_SATURATION_DECREASED") + 1);
                    }
                }
            }
        }

        for (AgeGroup ageGroup: ageGroups) {
            ageGroup.mostCommonSymptom();
        }
        return ageGroups;
    }

    @GetMapping("/symptomAge-en") //ageAnalysis tabela EN
    public String analysisAgeSymptoms(@RequestParam(required = false, defaultValue = "") String ageFrom,
                                      @RequestParam(required = false, defaultValue = "") String ageTo,
                                      Map<String, Object> model){
        List <AgeGroup> ageGroups = ageAnalisis();
        model.put("ageGroups",ageGroups);
        return "ageAnalysis";
    }

    List <AgeGroup> traslAgeGroup(List<AgeGroup> inputList){
        List <AgeGroup> ageGroupsPL = new ArrayList<>();

        for (AgeGroup ageGroup: inputList) {
            switch (ageGroup.getCommonSymptom()){
                case "RESPIRATORY_SYSTEM_DISEASES": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "CHOROBY UKŁADU ODDECHOWEGO"));
                    break;
                }
                case "APPENDICITIS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZAPALENIE WYROSTKA ROBACZKOWEGO"));
                    break;
                }
                case "DYSPHAGIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DYSFAGIA"));
                    break;
                }
                case "THROAT_TIGHTNESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UCISK W GARDLE"));
                    break;
                }
                case "THROAT_IRRITATION": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PODRAŻNIENIE GARDŁA"));
                    break;
                }
                case "DYSPNOEA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DUSZNOŚĆ"));
                    break;
                }
                case "COUGH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "KASZEL"));
                    break;
                }
                case "CHEST_DISCOMFORT": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DYSKOMFORT W KLATCE"));
                    break;
                }
                case "RESPIRATORY_DISTRESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NIEWYDOLNOŚĆ ODDECHOWA"));
                    break;
                }
                case "ANOEA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BEZDECH"));
                    break;
                }
                case "STRIDOR": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ŚWIST WDECHOWY"));
                    break;
                }
                case "WHEEZING": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ŚWIST WYDECHOWY"));
                    break;
                }
                case "TACHYPNOE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZWIĘKSZONA CZĘSTOŚĆ ODDECHÓW"));
                    break;
                }
                case "SHORTNESS_OF_BREATH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "KRÓTKI ODDECH"));
                    break;
                }
                case "NAUSEA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NUDNOŚCI"));
                    break;
                }
                case "VOMITING": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "WYMIOTY"));
                    break;
                }
                case "DIARRHOEA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BIEGUNKA"));
                    break;
                }
                case "CHILLS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DRESZCZE"));
                    break;
                }
                case "TREMOR": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DRŻENIE"));
                    break;
                }
                case "FATIGUE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZMĘCZENIE"));
                    break;
                }
                case "FEELING_ABNORMAL": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NIENORMALNE UCZUCIE"));
                    break;
                }
                case "MYALGIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "MIALGIA"));
                    break;
                }
                case "BODY_ACHE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BÓL CIAŁA"));
                    break;
                }
                case "SWELLING": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "OBRZĘK"));
                    break;
                }
                case "BLOOD_PRESSURE_INCREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "WZROST CIŚNIENIA KRWI"));
                    break;
                }
                case "BLOOD_PRESSURE_DECREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "SPADEK CIŚNIENIA KRWI"));
                    break;
                }
                case "LOSS_OF_CONSCIOUSNESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UTRATA PRZYTOMNOŚCI"));
                    break;
                }
                case "MUSCULOSKELETAL_DISORDER": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZABURZENIA MIĘŚNIOWO-SZKIELETOWE"));
                    break;
                }
                case "IMPAIRED_WORK_ABILITY": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NIEZDOLNOŚĆ DO PRACY"));
                    break;
                }
                case "ARTHRITIS_BACTERIAL": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BAKTERYJNE ZAPALENIE STAWÓW"));
                    break;
                }
                case "STROKE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UDAR"));
                    break;
                }
                case "CARDIOVASCULAR_FAILURE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NIEWYDOLNOŚĆ KRĄŻENIA"));
                    break;
                }
                case "HEART_RATE_INCREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZWIĘKSZONE TĘTNO"));
                    break;
                }
                case "CORONARY_ARTERY_DISEASE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "CHOROBA WIEŃCOWA"));
                    break;
                }
                case "TACHYCARDIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "TACHYKARDIA"));
                    break;
                }
                case "SUDDEN_CARDIAC_ARREST": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NAGŁE ZATRZYMANIE KRĄŻENIA"));
                    break;
                }
                case "PALPITATIONS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PALPITACJA"));
                    break;
                }
                case "MYOCARDIAL_INFRACTION": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZAWAŁ MIĘŚNIA SERCOWEGO"));
                    break;
                }
                case "ANAPHYLACTIC_SHOCK": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "WSTRZĄS ANAFILAKTYCZNY"));
                    break;
                }
                case "ANAPHYLACTIC_REACTION": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "REAKCJA ANAFILAKTYCZNA"));
                    break;
                }
                case "APHASIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UTRATA ZDOLNOŚCI MOWY"));
                    break;
                }
                case "HEADACHE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BÓL GŁOWY"));
                    break;
                }
                case "DIZZINESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZAWROTY GŁOWY"));
                    break;
                }
                case "HYPERHIDROSIS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NADMIERNA POTLIWOŚĆ"));
                    break;
                }
                case "BLEPHAROSPASM": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "KURCZ POWIEK"));
                    break;
                }
                case "PARAESTHESIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PARESTEZIA"));
                    break;
                }
                case "EPISTAXIS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "KRWAWIENIE Z NOSA"));
                    break;
                }
                case "SARS_CoV_2_TEST_POSITIVE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "POZYTYWNY TEST NA CoV-2"));
                    break;
                }
                case "PYREXIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "GORĄCZKA"));
                    break;
                }
                case "BODY_TEMPERATURE_INCREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZWIĘKSZENIE TEMPERATURY CIAŁA"));
                    break;
                }
                case "FEBRILE_CONVULSION": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DRGAWKI GORĄCZKOWE"));
                    break;
                }
                case "HOT_FLUSH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UDERZENIE GORĄCA"));
                    break;
                }
                case "BODY_TEMPERATURE_DECREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "SPADEK TEMPERATURY CIAŁA"));
                    break;
                }
                case "PARALYSIS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PARALIŻ"));
                    break;
                }
                case "PALLOR": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "BLADOŚĆ"));
                    break;
                }
                case "STILLBIRTH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PORONIENIE"));
                    break;
                }
                case "FOETAL_DEATH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ŚMIERĆ PŁODU"));
                    break;
                }
                case "DEATH": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ŚMIERĆ"));
                    break;
                }
                case "LYMPHADENOPATHY": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "POWIĘKSZENIE WĘZŁÓW CHŁONNYCH"));
                    break;
                }
                case "SEIZURE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NAPAD"));
                    break;
                }
                case "HERPES_ZOSTER": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "PÓŁPASIEC"));
                    break;
                }
                case "SLEEP_DISORDER": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZABURZENIA SNU"));
                    break;
                }
                case "HIPERSOMNIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "NADMIERNA SENNOŚĆ"));
                    break;
                }
                case "ANXIETY": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "LĘK"));
                    break;
                }
                case "INFLUENZA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "GRYPA"));
                    break;
                }
                case "BLURRED_VISION": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZABURZENIA WIDZENIA"));
                    break;
                }
                case "BLINDNESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ŚLEPOTA"));
                    break;
                }
                case "DYSPHONIA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "DYSFONIA"));
                    break;
                }
                case "SPASM": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "SKURCZE"));
                    break;
                }
                case "HAEMORRHAGE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "KRWOTOK"));
                    break;
                }
                case "HEARING_IMPAIRMENT": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZABURZENIA SŁUCHU"));
                    break;
                }
                case "DEAFNESS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "GŁUCHOTA"));
                    break;
                }
                case "SEPSIS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "POSOCZNICA"));
                    break;
                }
                case "VARICELLA": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "OSPA WIETRZNA"));
                    break;
                }
                case "PERICARDITI": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZAPALENIE OSIERDZIA"));
                    break;
                }
                case "AMYOTROPHY": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "AMIOTROFIA"));
                    break;
                }
                case "SENSORY LOSS": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "UTRATA ZMYSŁÓW"));
                    break;
                }
                case "DECREASED_APPETITE": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "SPADEK APETYTU"));
                    break;
                }
                case "CHANGE_IN_BLOOD_COUNT": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "ZMIANA MORFOLOGII KRWI"));
                    break;
                }
                case "OXYGEN_SATURATION_DECREASED": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "SPADEK SATURACJI"));
                    break;
                }
                case "lack": {
                    ageGroupsPL.add(new AgeGroup(ageGroup.getAgeMin(), ageGroup.getAgeMax(), "brak"));
                    break;
                }
            }
        }

        return ageGroupsPL;
    }

    @GetMapping("/symptomAge-pl") //analizaWieku tabela PL
    public String analysisAgeSymptomsPL(@RequestParam(required = false, defaultValue = "") String ageFrom,
                                      @RequestParam(required = false, defaultValue = "") String ageTo,
                                      Map<String, Object> model){
        List <AgeGroup> ageGroups = traslAgeGroup(ageAnalisis());
        model.put("ageGroups",ageGroups);
        return "analizaWieku";
    }

    @GetMapping("/symptomGroupAge-en")
    public String analysisGroupAgeEN(@RequestParam(required = false, defaultValue = "50") String ageFrom,
                                     @RequestParam(required = false, defaultValue = "60") String ageTo,
                                     Map<String, Object> model){
        List <AgeGroup> ageGroups = ageAnalisis();
        AgeGroup ageGroup = new AgeGroup(Integer.parseInt(ageFrom),Integer.parseInt(ageTo));

        for (AgeGroup age: ageGroups) {
            if(age.getAgeMin() == Integer.parseInt(ageFrom))
                ageGroup.setSymptomCounter(age.getSymptomCounter());
        }

        double suma = 0.0;
        for (Map.Entry<String, Integer> entry: ageGroup.getSymptomCounter().entrySet()) {
            suma += (Integer)entry.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: ageGroup.getSymptomCounter().entrySet()) {
            symptomPercent.add(new SymptomOccurrence(entry.getKey(),(Math.floor(((Double.valueOf(entry.getValue())/suma)*100)*100))/100));
        }

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("OTHERS" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(new SymptomOccurrence(others.getName(), Math.floor(others.getPercent() * 100)/100));

        model.put("ageFrom", ageFrom);
        model.put("ageTo", ageTo);
        model.put("symptomPercent", formatDataFromList(firstCommon));
        return "ageGroupAnalysis1";
    }

    @GetMapping("/symptomGroupAge-pl")
    public String analysisGroupAgePL(@RequestParam(required = false, defaultValue = "50") String ageFrom,
                                     @RequestParam(required = false, defaultValue = "60") String ageTo,
                                     Map<String, Object> model){
        List <AgeGroup> ageGroups = ageAnalisis();
        AgeGroup ageGroup = new AgeGroup(Integer.parseInt(ageFrom),Integer.parseInt(ageTo));

        for (AgeGroup age: ageGroups) {
            if(age.getAgeMin() == Integer.parseInt(ageFrom))
                ageGroup.setSymptomCounter(age.getSymptomCounter());
        }

        double suma = 0.0;
        for (Map.Entry<String, Integer> entry: ageGroup.getSymptomCounter().entrySet()) {
            suma += (Integer)entry.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: ageGroup.getSymptomCounter().entrySet()) {
            symptomPercent.add(new SymptomOccurrence(entry.getKey(),(Math.floor(((Double.valueOf(entry.getValue())/suma)*100)*100))/100));
        }

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("INNE" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(new SymptomOccurrence(others.getName(), Math.floor(others.getPercent() * 100)/100));

        model.put("ageFrom", ageFrom);
        model.put("ageTo", ageTo);
        model.put("symptomPercent", formatDataFromList(translListSymptom(firstCommon)));
        return "analizaWiekuWGrupach";
    }

    Map<String, Double> formatDataFromList(List<SymptomOccurrence> inputList){
        Map<String, Double> formatMap = new LinkedHashMap<String, Double>();

        for (SymptomOccurrence o: inputList) {
            formatMap.put(o.getName(), o.getPercent());
        }
        return formatMap;
    }

    List <SymptomOccurrence> translListSymptom(List<SymptomOccurrence> inputList){
        List<SymptomOccurrence> translList = new ArrayList<>();

        for (SymptomOccurrence o: inputList) {
            switch (o.getName()){
                case "RESPIRATORY_SYSTEM_DISEASES": {
                    translList.add(new SymptomOccurrence( "CHOROBY UKŁADU ODDECHOWEGO", o.getPercent()));
                    break;
                }
                case "APPENDICITIS": {
                    translList.add(new SymptomOccurrence("ZAPALENIE WYROSTKA ROBACZKOWEGO", o.getPercent()));
                    break;
                }
                case "DYSPHAGIA": {
                    translList.add(new SymptomOccurrence("DYSFAGIA", o.getPercent()));
                    break;
                }
                case "THROAT_TIGHTNESS": {
                    translList.add(new SymptomOccurrence("UCISK W GARDLE", o.getPercent()));
                    break;
                }
                case "THROAT_IRRITATION": {
                    translList.add(new SymptomOccurrence("PODRAŻNIENIE GARDŁA", o.getPercent()));
                    break;
                }
                case "DYSPNOEA": {
                    translList.add(new SymptomOccurrence("DUSZNOŚĆ", o.getPercent()));
                    break;
                }
                case "COUGH": {
                    translList.add(new SymptomOccurrence("KASZEL", o.getPercent()));
                    break;
                }
                case "CHEST_DISCOMFORT": {
                    translList.add(new SymptomOccurrence("DYSKOMFORT W KLATCE", o.getPercent()));
                    break;
                }
                case "RESPIRATORY_DISTRESS": {
                    translList.add(new SymptomOccurrence("NIEWYDOLNOŚĆ ODDECHOWA", o.getPercent()));
                    break;
                }
                case "ANOEA": {
                    translList.add(new SymptomOccurrence("BEZDECH", o.getPercent()));
                    break;
                }
                case "STRIDOR": {
                    translList.add(new SymptomOccurrence("ŚWIST WDECHOWY", o.getPercent()));
                    break;
                }
                case "WHEEZING": {
                    translList.add(new SymptomOccurrence("ŚWIST WYDECHOWY", o.getPercent()));
                    break;
                }
                case "TACHYPNOE": {
                    translList.add(new SymptomOccurrence("ZWIĘKSZONA CZĘSTOŚĆ ODDECHÓW", o.getPercent()));
                    break;
                }
                case "SHORTNESS_OF_BREATH": {
                    translList.add(new SymptomOccurrence("KRÓTKI ODDECH", o.getPercent()));
                    break;
                }
                case "NAUSEA": {
                    translList.add(new SymptomOccurrence("NUDNOŚCI", o.getPercent()));
                    break;
                }
                case "VOMITING": {
                    translList.add(new SymptomOccurrence("WYMIOTY", o.getPercent()));
                    break;
                }
                case "DIARRHOEA": {
                    translList.add(new SymptomOccurrence("BIEGUNKA", o.getPercent()));
                    break;
                }
                case "CHILLS": {
                    translList.add(new SymptomOccurrence("DRESZCZE", o.getPercent()));
                    break;
                }
                case "TREMOR": {
                    translList.add(new SymptomOccurrence("DRŻENIE", o.getPercent()));
                    break;
                }
                case "FATIGUE": {
                    translList.add(new SymptomOccurrence("ZMĘCZENIE", o.getPercent()));
                    break;
                }
                case "FEELING_ABNORMAL": {
                    translList.add(new SymptomOccurrence("NIENORMALNE UCZUCIE", o.getPercent()));
                    break;
                }
                case "MYALGIA": {
                    translList.add(new SymptomOccurrence("MIALGIA", o.getPercent()));
                    break;
                }
                case "BODY_ACHE": {
                    translList.add(new SymptomOccurrence("BÓL CIAŁA", o.getPercent()));
                    break;
                }
                case "SWELLING": {
                    translList.add(new SymptomOccurrence("OBRZĘK", o.getPercent()));
                    break;
                }
                case "BLOOD_PRESSURE_INCREASED": {
                    translList.add(new SymptomOccurrence("WZROST CIŚNIENIA KRWI", o.getPercent()));
                    break;
                }
                case "BLOOD_PRESSURE_DECREASED": {
                    translList.add(new SymptomOccurrence("SPADEK CIŚNIENIA KRWI", o.getPercent()));
                    break;
                }
                case "LOSS_OF_CONSCIOUSNESS": {
                    translList.add(new SymptomOccurrence("UTRATA PRZYTOMNOŚCI", o.getPercent()));
                    break;
                }
                case "MUSCULOSKELETAL_DISORDER": {
                    translList.add(new SymptomOccurrence("ZABURZENIA MIĘŚNIOWO-SZKIELETOWE", o.getPercent()));
                    break;
                }
                case "IMPAIRED_WORK_ABILITY": {
                    translList.add(new SymptomOccurrence("NIEZDOLNOŚĆ DO PRACY", o.getPercent()));
                    break;
                }
                case "ARTHRITIS_BACTERIAL": {
                    translList.add(new SymptomOccurrence("BAKTERYJNE ZAPALENIE STAWÓW", o.getPercent()));
                    break;
                }
                case "STROKE": {
                    translList.add(new SymptomOccurrence("UDAR", o.getPercent()));
                    break;
                }
                case "CARDIOVASCULAR_FAILURE": {
                    translList.add(new SymptomOccurrence("NIEWYDOLNOŚĆ KRĄŻENIA", o.getPercent()));
                    break;
                }
                case "HEART_RATE_INCREASED": {
                    translList.add(new SymptomOccurrence("ZWIĘKSZONE TĘTNO", o.getPercent()));
                    break;
                }
                case "CORONARY_ARTERY_DISEASE": {
                    translList.add(new SymptomOccurrence("CHOROBA WIEŃCOWA", o.getPercent()));
                    break;
                }
                case "TACHYCARDIA": {
                    translList.add(new SymptomOccurrence("TACHYKARDIA", o.getPercent()));
                    break;
                }
                case "SUDDEN_CARDIAC_ARREST": {
                    translList.add(new SymptomOccurrence("NAGŁE ZATRZYMANIE KRĄŻENIA", o.getPercent()));
                    break;
                }
                case "PALPITATIONS": {
                    translList.add(new SymptomOccurrence("PALPITACJA", o.getPercent()));
                    break;
                }
                case "MYOCARDIAL_INFRACTION": {
                    translList.add(new SymptomOccurrence("ZAWAŁ MIĘŚNIA SERCOWEGO", o.getPercent()));
                    break;
                }
                case "ANAPHYLACTIC_SHOCK": {
                    translList.add(new SymptomOccurrence("WSTRZĄS ANAFILAKTYCZNY", o.getPercent()));
                    break;
                }
                case "ANAPHYLACTIC_REACTION": {
                    translList.add(new SymptomOccurrence("REAKCJA ANAFILAKTYCZNA", o.getPercent()));
                    break;
                }
                case "APHASIA": {
                    translList.add(new SymptomOccurrence("UTRATA ZDOLNOŚCI MOWY", o.getPercent()));
                    break;
                }
                case "HEADACHE": {
                    translList.add(new SymptomOccurrence("BÓL GŁOWY", o.getPercent()));
                    break;
                }
                case "DIZZINESS": {
                    translList.add(new SymptomOccurrence("ZAWROTY GŁOWY", o.getPercent()));
                    break;
                }
                case "HYPERHIDROSIS": {
                    translList.add(new SymptomOccurrence("NADMIERNA POTLIWOŚĆ", o.getPercent()));
                    break;
                }
                case "BLEPHAROSPASM": {
                    translList.add(new SymptomOccurrence("KURCZ POWIEK", o.getPercent()));
                    break;
                }
                case "PARAESTHESIA": {
                    translList.add(new SymptomOccurrence("PARESTEZIA", o.getPercent()));
                    break;
                }
                case "EPISTAXIS": {
                    translList.add(new SymptomOccurrence("KRWAWIENIE Z NOSA", o.getPercent()));
                    break;
                }
                case "SARS_CoV_2_TEST_POSITIVE": {
                    translList.add(new SymptomOccurrence("POZYTYWNY TEST NA CoV-2", o.getPercent()));
                    break;
                }
                case "PYREXIA": {
                    translList.add(new SymptomOccurrence("GORĄCZKA", o.getPercent()));
                    break;
                }
                case "BODY_TEMPERATURE_INCREASED": {
                    translList.add(new SymptomOccurrence("ZWIĘKSZENIE TEMPERATURY CIAŁA", o.getPercent()));
                    break;
                }
                case "FEBRILE_CONVULSION": {
                    translList.add(new SymptomOccurrence("DRGAWKI GORĄCZKOWE", o.getPercent()));
                    break;
                }
                case "HOT_FLUSH": {
                    translList.add(new SymptomOccurrence("UDERZENIE GORĄCA", o.getPercent()));
                    break;
                }
                case "BODY_TEMPERATURE_DECREASED": {
                    translList.add(new SymptomOccurrence("SPADEK TEMPERATURY CIAŁA", o.getPercent()));
                    break;
                }
                case "PARALYSIS": {
                    translList.add(new SymptomOccurrence("PARALIŻ", o.getPercent()));
                    break;
                }
                case "PALLOR": {
                    translList.add(new SymptomOccurrence("BLADOŚĆ", o.getPercent()));
                    break;
                }
                case "STILLBIRTH": {
                    translList.add(new SymptomOccurrence("PORONIENIE", o.getPercent()));
                    break;
                }
                case "FOETAL_DEATH": {
                    translList.add(new SymptomOccurrence("ŚMIERĆ PŁODU", o.getPercent()));
                    break;
                }
                case "DEATH": {
                    translList.add(new SymptomOccurrence("ŚMIERĆ", o.getPercent()));
                    break;
                }
                case "LYMPHADENOPATHY": {
                    translList.add(new SymptomOccurrence("POWIĘKSZENIE WĘZŁÓW CHŁONNYCH", o.getPercent()));
                    break;
                }
                case "SEIZURE": {
                    translList.add(new SymptomOccurrence("NAPAD", o.getPercent()));
                    break;
                }
                case "HERPES_ZOSTER": {
                    translList.add(new SymptomOccurrence("PÓŁPASIEC", o.getPercent()));
                    break;
                }
                case "SLEEP_DISORDER": {
                    translList.add(new SymptomOccurrence("ZABURZENIA SNU", o.getPercent()));
                    break;
                }
                case "HIPERSOMNIA": {
                    translList.add(new SymptomOccurrence("NADMIERNA SENNOŚĆ", o.getPercent()));
                    break;
                }
                case "ANXIETY": {
                    translList.add(new SymptomOccurrence("LĘK", o.getPercent()));
                    break;
                }
                case "INFLUENZA": {
                    translList.add(new SymptomOccurrence("GRYPA", o.getPercent()));
                    break;
                }
                case "BLURRED_VISION": {
                    translList.add(new SymptomOccurrence("ZABURZENIA WIDZENIA", o.getPercent()));
                    break;
                }
                case "BLINDNESS": {
                    translList.add(new SymptomOccurrence("ŚLEPOTA", o.getPercent()));
                    break;
                }
                case "DYSPHONIA": {
                    translList.add(new SymptomOccurrence("DYSFONIA", o.getPercent()));
                    break;
                }
                case "SPASM": {
                    translList.add(new SymptomOccurrence("SKURCZE", o.getPercent()));
                    break;
                }
                case "HAEMORRHAGE": {
                    translList.add(new SymptomOccurrence("KRWOTOK", o.getPercent()));
                    break;
                }
                case "HEARING_IMPAIRMENT": {
                    translList.add(new SymptomOccurrence("ZABURZENIA SŁUCHU", o.getPercent()));
                    break;
                }
                case "DEAFNESS": {
                    translList.add(new SymptomOccurrence("GŁUCHOTA", o.getPercent()));
                    break;
                }
                case "SEPSIS": {
                    translList.add(new SymptomOccurrence("POSOCZNICA", o.getPercent()));
                    break;
                }
                case "VARICELLA": {
                    translList.add(new SymptomOccurrence("OSPA WIETRZNA", o.getPercent()));
                    break;
                }
                case "PERICARDITI": {
                    translList.add(new SymptomOccurrence("ZAPALENIE OSIERDZIA", o.getPercent()));
                    break;
                }
                case "AMYOTROPHY": {
                    translList.add(new SymptomOccurrence("AMIOTROFIA", o.getPercent()));
                    break;
                }
                case "SENSORY LOSS": {
                    translList.add(new SymptomOccurrence("UTRATA ZMYSŁÓW", o.getPercent()));
                    break;
                }
                case "DECREASED_APPETITE": {
                    translList.add(new SymptomOccurrence("SPADEK APETYTU", o.getPercent()));
                    break;
                }
                case "CHANGE_IN_BLOOD_COUNT": {
                    translList.add(new SymptomOccurrence("ZMIANA MORFOLOGII KRWI", o.getPercent()));
                    break;
                }
                case "OXYGEN_SATURATION_DECREASED": {
                    translList.add(new SymptomOccurrence("SPADEK SATURACJI", o.getPercent()));
                    break;
                }
                case "lack": {
                    translList.add(new SymptomOccurrence("brak", o.getPercent()));
                    break;
                }
            }
        }
        return translList;
    }


    List <VaxGroup> vaccineAnalisis(){
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Iterable<Patient> patients = patientRepository.findAll();
        Iterable<Notification> notifications = notificationRepository.findAll();

        List<VaxGroup> vaxGroups = new ArrayList<>();
        vaxGroups.add(new VaxGroup("PFIZER\\BIONTECH"));
        vaxGroups.add(new VaxGroup("MODERNA"));
        vaxGroups.add(new VaxGroup("ASTRAZENEKA"));
        vaxGroups.add(new VaxGroup("JOHNSON&JOHNSON"));

        Iterator<Patient> patientIterator = patients.iterator();
        Iterator<Symptom> symptomIterator = symptoms.iterator();
        Iterator<Notification> notificationIterator = notifications.iterator();
        while (patientIterator.hasNext()){
            Patient patient = patientIterator.next();
            Symptom symptom = symptomIterator.next();
            Notification notification = notificationIterator.next();
            for (VaxGroup vaxGroup: vaxGroups) {
                if (notification.getTYPE_OF_VACCINE().equals(vaxGroup.getType())){
                    if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                        vaxGroup.getSymptomCounter().replace("RESPIRATORY_SYSTEM_DISEASES", vaxGroup.getSymptomCounter().get("RESPIRATORY_SYSTEM_DISEASES") + 1);
                    }
                    if (symptom.isAPPENDICITIS()){
                        vaxGroup.getSymptomCounter().replace("APPENDICITIS", vaxGroup.getSymptomCounter().get("APPENDICITIS") + 1);
                    }
                    if (symptom.isDYSPHAGIA()){
                        //vaxGroup.getSymptomCounter().replace("DYSPHAGIA", vaxGroup.getSymptomCounter().get("DYSPHAGIA") + 1);
                    }
                    if (symptom.isTHROAT_TIGHTNESS()){
                        vaxGroup.getSymptomCounter().replace("THROAT_TIGHTNESS", vaxGroup.getSymptomCounter().get("THROAT_TIGHTNESS") + 1);
                    }
                    if (symptom.isTHROAT_IRRITATION()){
                        vaxGroup.getSymptomCounter().replace("THROAT_IRRITATION", vaxGroup.getSymptomCounter().get("THROAT_IRRITATION") + 1);
                    }
                    if (symptom.isDYSPNOEA()){
                        vaxGroup.getSymptomCounter().replace("DYSPNOEA", vaxGroup.getSymptomCounter().get("DYSPNOEA") + 1);
                    }
                    if (symptom.isCOUGH()){
                        vaxGroup.getSymptomCounter().replace("COUGH", vaxGroup.getSymptomCounter().get("COUGH") + 1);
                    }
                    if (symptom.isCHEST_DISCOMFORT()){
                        vaxGroup.getSymptomCounter().replace("CHEST_DISCOMFORT", vaxGroup.getSymptomCounter().get("CHEST_DISCOMFORT") + 1);
                    }
                    if (symptom.isANOEA()){
                        vaxGroup.getSymptomCounter().replace("ANOEA", vaxGroup.getSymptomCounter().get("ANOEA") + 1);
                    }
                    if (symptom.isSTRIDOR()){
                        vaxGroup.getSymptomCounter().replace("STRIDOR", vaxGroup.getSymptomCounter().get("STRIDOR") + 1);
                    }
                    if (symptom.isWHEEZING()){
                        vaxGroup.getSymptomCounter().replace("WHEEZING", vaxGroup.getSymptomCounter().get("WHEEZING") + 1);
                    }
                    if (symptom.isTACHYPNOE()){
                        vaxGroup.getSymptomCounter().replace("TACHYPNOE", vaxGroup.getSymptomCounter().get("TACHYPNOE") + 1);
                    }
                    if (symptom.isSHORTNESS_OF_BREATH()){
                        vaxGroup.getSymptomCounter().replace("SHORTNESS_OF_BREATH", vaxGroup.getSymptomCounter().get("SHORTNESS_OF_BREATH") + 1);
                    }
                    if (symptom.isRESPIRATORY_DISTRESS()){
                        vaxGroup.getSymptomCounter().replace("RESPIRATORY_DISTRESS", vaxGroup.getSymptomCounter().get("RESPIRATORY_DISTRESS") + 1);
                    }
                    if (symptom.isNAUSEA()){
                        vaxGroup.getSymptomCounter().replace("NAUSEA", vaxGroup.getSymptomCounter().get("NAUSEA") + 1);
                    }
                    if (symptom.isVOMITING()){
                        vaxGroup.getSymptomCounter().replace("VOMITING", vaxGroup.getSymptomCounter().get("VOMITING") + 1);
                    }
                    if (symptom.isDIARRHOEA()){
                        vaxGroup.getSymptomCounter().replace("DIARRHOEA", vaxGroup.getSymptomCounter().get("DIARRHOEA") + 1);
                    }
                    if (symptom.isCHILLS()){
                        vaxGroup.getSymptomCounter().replace("CHILLS", vaxGroup.getSymptomCounter().get("CHILLS") + 1);
                    }
                    if (symptom.isTREMOR()){
                        vaxGroup.getSymptomCounter().replace("TREMOR", vaxGroup.getSymptomCounter().get("TREMOR") + 1);
                    }
                    if (symptom.isFATIGUE()){
                        vaxGroup.getSymptomCounter().replace("FATIGUE", vaxGroup.getSymptomCounter().get("FATIGUE") + 1);
                    }
                    if (symptom.isFEELING_ABNORMAL()){
                        vaxGroup.getSymptomCounter().replace("FEELING_ABNORMAL", vaxGroup.getSymptomCounter().get("FEELING_ABNORMAL") + 1);
                    }
                    if (symptom.isMYALGIA()){
                        vaxGroup.getSymptomCounter().replace("MYALGIA", vaxGroup.getSymptomCounter().get("MYALGIA") + 1);
                    }
                    if (symptom.isBODY_ACHE()){
                        vaxGroup.getSymptomCounter().replace("BODY_ACHE", vaxGroup.getSymptomCounter().get("BODY_ACHE") + 1);
                    }
                    if (symptom.isSWELLING()){
                        vaxGroup.getSymptomCounter().replace("SWELLING", vaxGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isSWELLING()){
                        vaxGroup.getSymptomCounter().replace("SWELLING", vaxGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_INCREASED()){
                        vaxGroup.getSymptomCounter().replace("BLOOD_PRESSURE_INCREASED", vaxGroup.getSymptomCounter().get("BLOOD_PRESSURE_INCREASED") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_DECREASED()){
                        vaxGroup.getSymptomCounter().replace("BLOOD_PRESSURE_DECREASED", vaxGroup.getSymptomCounter().get("BLOOD_PRESSURE_DECREASED") + 1);
                    }
                    if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                        vaxGroup.getSymptomCounter().replace("LOSS_OF_CONSCIOUSNESS", vaxGroup.getSymptomCounter().get("LOSS_OF_CONSCIOUSNESS") + 1);
                    }
                    if (symptom.isMUSCULOSKELETAL_DISORDER()){
                        vaxGroup.getSymptomCounter().replace("MUSCULOSKELETAL_DISORDER", vaxGroup.getSymptomCounter().get("MUSCULOSKELETAL_DISORDER") + 1);
                    }
                    if (symptom.isIMPAIRED_WORK_ABILITY()){
                        vaxGroup.getSymptomCounter().replace("IMPAIRED_WORK_ABILITY", vaxGroup.getSymptomCounter().get("IMPAIRED_WORK_ABILITY") + 1);
                    }
                    if (symptom.isARTHRITIS_BACTERIAL()){
                        vaxGroup.getSymptomCounter().replace("ARTHRITIS_BACTERIAL", vaxGroup.getSymptomCounter().get("ARTHRITIS_BACTERIAL") + 1);
                    }
                    if (symptom.isSTROKE()){
                        vaxGroup.getSymptomCounter().replace("STROKE", vaxGroup.getSymptomCounter().get("STROKE") + 1);
                    }
                    if (symptom.isCARDIOVASCULAR_FAILURE()){
                        vaxGroup.getSymptomCounter().replace("CARDIOVASCULAR_FAILURE", vaxGroup.getSymptomCounter().get("CARDIOVASCULAR_FAILURE") + 1);
                    }
                    if (symptom.isHEART_RATE_INCREASED()){
                        vaxGroup.getSymptomCounter().replace("HEART_RATE_INCREASED", vaxGroup.getSymptomCounter().get("HEART_RATE_INCREASED") + 1);
                    }
                    if (symptom.isCORONARY_ARTERY_DISEASE()){
                        vaxGroup.getSymptomCounter().replace("CORONARY_ARTERY_DISEASE", vaxGroup.getSymptomCounter().get("CORONARY_ARTERY_DISEASE") + 1);
                    }
                    if (symptom.isTACHYCARDIA()){
                        vaxGroup.getSymptomCounter().replace("TACHYCARDIA", vaxGroup.getSymptomCounter().get("TACHYCARDIA") + 1);
                    }
                    if (symptom.isSUDDEN_CARDIAC_ARREST()){
                        vaxGroup.getSymptomCounter().replace("SUDDEN_CARDIAC_ARREST", vaxGroup.getSymptomCounter().get("SUDDEN_CARDIAC_ARREST") + 1);
                    }
                    if (symptom.isPALPITATIONS()){
                        vaxGroup.getSymptomCounter().replace("PALPITATIONS", vaxGroup.getSymptomCounter().get("PALPITATIONS") + 1);
                    }
                    if (symptom.isMYOCARDIAL_INFRACTION()){
                        vaxGroup.getSymptomCounter().replace("MYOCARDIAL_INFRACTION", vaxGroup.getSymptomCounter().get("MYOCARDIAL_INFRACTION") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_SHOCK()){
                        vaxGroup.getSymptomCounter().replace("ANAPHYLACTIC_SHOCK", vaxGroup.getSymptomCounter().get("ANAPHYLACTIC_SHOCK") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_REACTION()){
                        vaxGroup.getSymptomCounter().replace("ANAPHYLACTIC_REACTION", vaxGroup.getSymptomCounter().get("ANAPHYLACTIC_REACTION") + 1);
                    }
                    if (symptom.isAPHASIA()){
                        vaxGroup.getSymptomCounter().replace("APHASIA", vaxGroup.getSymptomCounter().get("APHASIA") + 1);
                    }
                    if (symptom.isHEADACHE()){
                        vaxGroup.getSymptomCounter().replace("HEADACHE", vaxGroup.getSymptomCounter().get("HEADACHE") + 1);
                    }
                    if (symptom.isDIZZINESS()){
                        vaxGroup.getSymptomCounter().replace("DIZZINESS", vaxGroup.getSymptomCounter().get("DIZZINESS") + 1);
                    }
                    if (symptom.isHYPERHIDROSIS()){
                        vaxGroup.getSymptomCounter().replace("HYPERHIDROSIS", vaxGroup.getSymptomCounter().get("HYPERHIDROSIS") + 1);
                    }
                    if (symptom.isBLEPHAROSPASM()){
                        vaxGroup.getSymptomCounter().replace("BLEPHAROSPASM", vaxGroup.getSymptomCounter().get("BLEPHAROSPASM") + 1);
                    }
                    if (symptom.isPARAESTHESIA()){
                        vaxGroup.getSymptomCounter().replace("PARAESTHESIA", vaxGroup.getSymptomCounter().get("PARAESTHESIA") + 1);
                    }
                    if (symptom.isEPISTAXIS()){
                        vaxGroup.getSymptomCounter().replace("EPISTAXIS", vaxGroup.getSymptomCounter().get("EPISTAXIS") + 1);
                    }
                    if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                        vaxGroup.getSymptomCounter().replace("SARS_CoV_2_TEST_POSITIVE", vaxGroup.getSymptomCounter().get("SARS_CoV_2_TEST_POSITIVE") + 1);
                    }
                    if (symptom.isPYREXIA()){
                        vaxGroup.getSymptomCounter().replace("PYREXIA", vaxGroup.getSymptomCounter().get("PYREXIA") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_INCREASED()){
                        vaxGroup.getSymptomCounter().replace("BODY_TEMPERATURE_INCREASED", vaxGroup.getSymptomCounter().get("BODY_TEMPERATURE_INCREASED") + 1);
                    }
                    if (symptom.isFEBRILE_CONVULSION()){
                        vaxGroup.getSymptomCounter().replace("FEBRILE_CONVULSION", vaxGroup.getSymptomCounter().get("FEBRILE_CONVULSION") + 1);
                    }
                    if (symptom.isHOT_FLUSH()){
                        vaxGroup.getSymptomCounter().replace("HOT_FLUSH", vaxGroup.getSymptomCounter().get("HOT_FLUSH") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_DECREASED()){
                        vaxGroup.getSymptomCounter().replace("BODY_TEMPERATURE_DECREASED", vaxGroup.getSymptomCounter().get("BODY_TEMPERATURE_DECREASED") + 1);
                    }
                    if (symptom.isPARALYSIS()){
                        vaxGroup.getSymptomCounter().replace("PARALYSIS", vaxGroup.getSymptomCounter().get("PARALYSIS") + 1);
                    }
                    if (symptom.isPALLOR()){
                        vaxGroup.getSymptomCounter().replace("PALLOR", vaxGroup.getSymptomCounter().get("PALLOR") + 1);
                    }
                    if (symptom.isSTILLBIRTH()){
                        vaxGroup.getSymptomCounter().replace("STILLBIRTH", vaxGroup.getSymptomCounter().get("STILLBIRTH") + 1);
                    }
                    if (symptom.isFOETAL_DEATH()){
                        vaxGroup.getSymptomCounter().replace("FOETAL_DEATH", vaxGroup.getSymptomCounter().get("FOETAL_DEATH") + 1);
                    }
                    if (symptom.isDEATH()){
                        vaxGroup.getSymptomCounter().replace("DEATH", vaxGroup.getSymptomCounter().get("DEATH") + 1);
                    }
                    if (symptom.isLYMPHADENOPATHY()){
                        vaxGroup.getSymptomCounter().replace("LYMPHADENOPATHY", vaxGroup.getSymptomCounter().get("LYMPHADENOPATHY") + 1);
                    }
                    if (symptom.isSEIZURE()){
                        vaxGroup.getSymptomCounter().replace("SEIZURE", vaxGroup.getSymptomCounter().get("SEIZURE") + 1);
                    }
                    if (symptom.isHERPES_ZOSTER()){
                        vaxGroup.getSymptomCounter().replace("HERPES_ZOSTER", vaxGroup.getSymptomCounter().get("HERPES_ZOSTER") + 1);
                    }
                    if (symptom.isSLEEP_DISORDER()){
                        vaxGroup.getSymptomCounter().replace("SLEEP_DISORDER", vaxGroup.getSymptomCounter().get("SLEEP_DISORDER") + 1);
                    }
                    if (symptom.isHIPERSOMNIA()){
                        vaxGroup.getSymptomCounter().replace("HIPERSOMNIA", vaxGroup.getSymptomCounter().get("HIPERSOMNIA") + 1);
                    }
                    if (symptom.isANXIETY()){
                        vaxGroup.getSymptomCounter().replace("ANXIETY", vaxGroup.getSymptomCounter().get("ANXIETY") + 1);
                    }
                    if (symptom.isINFLUENZA()){
                        vaxGroup.getSymptomCounter().replace("INFLUENZA", vaxGroup.getSymptomCounter().get("INFLUENZA") + 1);
                    }
                    if (symptom.isBLURRED_VISION()){
                        vaxGroup.getSymptomCounter().replace("BLURRED_VISION", vaxGroup.getSymptomCounter().get("BLURRED_VISION") + 1);
                    }
                    if (symptom.isBLINDNESS()){
                        vaxGroup.getSymptomCounter().replace("BLINDNESS", vaxGroup.getSymptomCounter().get("BLINDNESS") + 1);
                    }
                    if (symptom.isDYSPHONIA()){
                        vaxGroup.getSymptomCounter().replace("DYSPHONIA", vaxGroup.getSymptomCounter().get("DYSPHONIA") + 1);
                    }
                    if (symptom.isSPASM()){
                        vaxGroup.getSymptomCounter().replace("SPASM", vaxGroup.getSymptomCounter().get("SPASM") + 1);
                    }
                    if (symptom.isHAEMORRHAGE()){
                        vaxGroup.getSymptomCounter().replace("HAEMORRHAGE", vaxGroup.getSymptomCounter().get("HAEMORRHAGE") + 1);
                    }
                    if (symptom.isHEARING_IMPAIRMENT()){
                        vaxGroup.getSymptomCounter().replace("HEARING_IMPAIRMENT", vaxGroup.getSymptomCounter().get("HEARING_IMPAIRMENT") + 1);
                    }
                    if (symptom.isDEAFNESS()){
                        vaxGroup.getSymptomCounter().replace("DEAFNESS", vaxGroup.getSymptomCounter().get("DEAFNESS") + 1);
                    }
                    if (symptom.isSEPSIS()){
                        vaxGroup.getSymptomCounter().replace("SEPSIS", vaxGroup.getSymptomCounter().get("SEPSIS") + 1);
                    }
                    if (symptom.isVARICELLA()){
                        vaxGroup.getSymptomCounter().replace("VARICELLA", vaxGroup.getSymptomCounter().get("VARICELLA") + 1);
                    }
                    if (symptom.isPERICARDITIS()){
                        vaxGroup.getSymptomCounter().replace("PERICARDITIS", vaxGroup.getSymptomCounter().get("PERICARDITIS") + 1);
                    }
                    if (symptom.isAMYOTROPHY()){
                        vaxGroup.getSymptomCounter().replace("AMYOTROPHY", vaxGroup.getSymptomCounter().get("AMYOTROPHY") + 1);
                    }
                    if (symptom.isSENSORY_LOSS()){
                        vaxGroup.getSymptomCounter().replace("SENSORY LOSS", vaxGroup.getSymptomCounter().get("SENSORY LOSS") + 1);
                    }
                    if (symptom.isDECREASED_APPETITE()){
                        vaxGroup.getSymptomCounter().replace("DECREASED_APPETITE", vaxGroup.getSymptomCounter().get("DECREASED_APPETITE") + 1);
                    }
                    if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                        vaxGroup.getSymptomCounter().replace("CHANGE_IN_BLOOD_COUNT", vaxGroup.getSymptomCounter().get("CHANGE_IN_BLOOD_COUNT") + 1);
                    }
                    if (symptom.isOXYGEN_SATURATION_DECREASED()){
                        vaxGroup.getSymptomCounter().replace("OXYGEN_SATURATION_DECREASED", vaxGroup.getSymptomCounter().get("OXYGEN_SATURATION_DECREASED") + 1);
                    }
                }
            }
        }

        for (VaxGroup vaxGroup: vaxGroups) {
            vaxGroup.mostCommonSymptom();
        }
        return vaxGroups;
    }

    @GetMapping("/symptomVaccines-en") //vaccinesAnalysis tabelka EN
    public String analysisVaccineSymptoms(@RequestParam(required = false, defaultValue = "") String typeVAX,
                                          Map<String, Object> model){
        List<VaxGroup> vaxGroups = vaccineAnalisis();
        model.put("vaxGroups",vaxGroups);
        return "vaccinesAnalysis";
    }

    List <VaxGroup> traslVaxGroup(List<VaxGroup> inputList){
        List <VaxGroup> vaxGroupsPL = new ArrayList<>();


        for (VaxGroup vaxGroup: inputList) {
            switch (vaxGroup.getCommonSymptom()){
                case "RESPIRATORY_SYSTEM_DISEASES": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "CHOROBY UKŁADU ODDECHOWEGO"));
                    break;
                }
                case "APPENDICITIS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZAPALENIE WYROSTKA ROBACZKOWEGO"));
                    break;
                }
                case "DYSPHAGIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DYSFAGIA"));
                    break;
                }
                case "THROAT_TIGHTNESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UCISK W GARDLE"));
                    break;
                }
                case "THROAT_IRRITATION": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PODRAŻNIENIE GARDŁA"));
                    break;
                }
                case "DYSPNOEA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DUSZNOŚĆ"));
                    break;
                }
                case "COUGH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "KASZEL"));
                    break;
                }
                case "CHEST_DISCOMFORT": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DYSKOMFORT W KLATCE"));
                    break;
                }
                case "RESPIRATORY_DISTRESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NIEWYDOLNOŚĆ ODDECHOWA"));
                    break;
                }
                case "ANOEA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BEZDECH"));
                    break;
                }
                case "STRIDOR": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ŚWIST WDECHOWY"));
                    break;
                }
                case "WHEEZING": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ŚWIST WYDECHOWY"));
                    break;
                }
                case "TACHYPNOE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZWIĘKSZONA CZĘSTOŚĆ ODDECHÓW"));
                    break;
                }
                case "SHORTNESS_OF_BREATH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "KRÓTKI ODDECH"));
                    break;
                }
                case "NAUSEA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NUDNOŚCI"));
                    break;
                }
                case "VOMITING": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "WYMIOTY"));
                    break;
                }
                case "DIARRHOEA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BIEGUNKA"));
                    break;
                }
                case "CHILLS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DRESZCZE"));
                    break;
                }
                case "TREMOR": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DRŻENIE"));
                    break;
                }
                case "FATIGUE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZMĘCZENIE"));
                    break;
                }
                case "FEELING_ABNORMAL": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NIENORMALNE UCZUCIE"));
                    break;
                }
                case "MYALGIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "MIALGIA"));
                    break;
                }
                case "BODY_ACHE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BÓL CIAŁA"));
                    break;
                }
                case "SWELLING": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "OBRZĘK"));
                    break;
                }
                case "BLOOD_PRESSURE_INCREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "WZROST CIŚNIENIA KRWI"));
                    break;
                }
                case "BLOOD_PRESSURE_DECREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "SPADEK CIŚNIENIA KRWI"));
                    break;
                }
                case "LOSS_OF_CONSCIOUSNESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UTRATA PRZYTOMNOŚCI"));
                    break;
                }
                case "MUSCULOSKELETAL_DISORDER": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZABURZENIA MIĘŚNIOWO-SZKIELETOWE"));
                    break;
                }
                case "IMPAIRED_WORK_ABILITY": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NIEZDOLNOŚĆ DO PRACY"));
                    break;
                }
                case "ARTHRITIS_BACTERIAL": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BAKTERYJNE ZAPALENIE STAWÓW"));
                    break;
                }
                case "STROKE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UDAR"));
                    break;
                }
                case "CARDIOVASCULAR_FAILURE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NIEWYDOLNOŚĆ KRĄŻENIA"));
                    break;
                }
                case "HEART_RATE_INCREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZWIĘKSZONE TĘTNO"));
                    break;
                }
                case "CORONARY_ARTERY_DISEASE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "CHOROBA WIEŃCOWA"));
                    break;
                }
                case "TACHYCARDIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "TACHYKARDIA"));
                    break;
                }
                case "SUDDEN_CARDIAC_ARREST": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NAGŁE ZATRZYMANIE KRĄŻENIA"));
                    break;
                }
                case "PALPITATIONS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PALPITACJA"));
                    break;
                }
                case "MYOCARDIAL_INFRACTION": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZAWAŁ MIĘŚNIA SERCOWEGO"));
                    break;
                }
                case "ANAPHYLACTIC_SHOCK": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "WSTRZĄS ANAFILAKTYCZNY"));
                    break;
                }
                case "ANAPHYLACTIC_REACTION": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "REAKCJA ANAFILAKTYCZNA"));
                    break;
                }
                case "APHASIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UTRATA ZDOLNOŚCI MOWY"));
                    break;
                }
                case "HEADACHE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BÓL GŁOWY"));
                    break;
                }
                case "DIZZINESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZAWROTY GŁOWY"));
                    break;
                }
                case "HYPERHIDROSIS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NADMIERNA POTLIWOŚĆ"));
                    break;
                }
                case "BLEPHAROSPASM": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "KURCZ POWIEK"));
                    break;
                }
                case "PARAESTHESIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PARESTEZIA"));
                    break;
                }
                case "EPISTAXIS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "KRWAWIENIE Z NOSA"));
                    break;
                }
                case "SARS_CoV_2_TEST_POSITIVE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "POZYTYWNY TEST NA CoV-2"));
                    break;
                }
                case "PYREXIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "GORĄCZKA"));
                    break;
                }
                case "BODY_TEMPERATURE_INCREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZWIĘKSZENIE TEMPERATURY CIAŁA"));
                    break;
                }
                case "FEBRILE_CONVULSION": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DRGAWKI GORĄCZKOWE"));
                    break;
                }
                case "HOT_FLUSH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UDERZENIE GORĄCA"));
                    break;
                }
                case "BODY_TEMPERATURE_DECREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "SPADEK TEMPERATURY CIAŁA"));
                    break;
                }
                case "PARALYSIS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PARALIŻ"));
                    break;
                }
                case "PALLOR": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "BLADOŚĆ"));
                    break;
                }
                case "STILLBIRTH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PORONIENIE"));
                    break;
                }
                case "FOETAL_DEATH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ŚMIERĆ PŁODU"));
                    break;
                }
                case "DEATH": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ŚMIERĆ"));
                    break;
                }
                case "LYMPHADENOPATHY": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "POWIĘKSZENIE WĘZŁÓW CHŁONNYCH"));
                    break;
                }
                case "SEIZURE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NAPAD"));
                    break;
                }
                case "HERPES_ZOSTER": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "PÓŁPASIEC"));
                    break;
                }
                case "SLEEP_DISORDER": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZABURZENIA SNU"));
                    break;
                }
                case "HIPERSOMNIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "NADMIERNA SENNOŚĆ"));
                    break;
                }
                case "ANXIETY": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "LĘK"));
                    break;
                }
                case "INFLUENZA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "GRYPA"));
                    break;
                }
                case "BLURRED_VISION": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZABURZENIA WIDZENIA"));
                    break;
                }
                case "BLINDNESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ŚLEPOTA"));
                    break;
                }
                case "DYSPHONIA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "DYSFONIA"));
                    break;
                }
                case "SPASM": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "SKURCZE"));
                    break;
                }
                case "HAEMORRHAGE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "KRWOTOK"));
                    break;
                }
                case "HEARING_IMPAIRMENT": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZABURZENIA SŁUCHU"));
                    break;
                }
                case "DEAFNESS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "GŁUCHOTA"));
                    break;
                }
                case "SEPSIS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "POSOCZNICA"));
                    break;
                }
                case "VARICELLA": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "OSPA WIETRZNA"));
                    break;
                }
                case "PERICARDITI": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZAPALENIE OSIERDZIA"));
                    break;
                }
                case "AMYOTROPHY": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "AMIOTROFIA"));
                    break;
                }
                case "SENSORY LOSS": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "UTRATA ZMYSŁÓW"));
                    break;
                }
                case "DECREASED_APPETITE": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "SPADEK APETYTU"));
                    break;
                }
                case "CHANGE_IN_BLOOD_COUNT": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "ZMIANA MORFOLOGII KRWI"));
                    break;
                }
                case "OXYGEN_SATURATION_DECREASED": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "SPADEK SATURACJI"));
                    break;
                }
                case "lack": {
                    vaxGroupsPL.add(new VaxGroup(vaxGroup.getType(), "brak"));
                    break;
                }
            }
        }

        return vaxGroupsPL;
    }

    @GetMapping("/symptomVaccines-pl") //analizaSzczepionki tabelka PL
    public String analysisVaccineSymptomsPL(@RequestParam(required = false, defaultValue = "") String typeVAX,
                                          Map<String, Object> model){
        List<VaxGroup> vaxGroups = traslVaxGroup(vaccineAnalisis());

        model.put("i", createCounter(vaxGroups.size()));
        model.put("vaxGroups",vaxGroups);
        return "analizaSzczepionki";
    }

    @GetMapping("/symptomVaxGroup-en")
    public String analysisVaxGroupEN(@RequestParam(required = false, defaultValue = "PFIZER-BIONTECH") String vaxType,
                                     Map<String, Object> model){
        List <VaxGroup> vaxGroups = vaccineAnalisis();
        VaxGroup vaxGroup = new VaxGroup(vaxType);

        for (VaxGroup vax: vaxGroups) {
            if(vax.getType().equals(vaxType))
                vaxGroup.setSymptomCounter(vax.getSymptomCounter());
        }

        double suma = 0.0;
        for (Map.Entry<String, Integer> entry: vaxGroup.getSymptomCounter().entrySet()) {
            suma += (Integer)entry.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: vaxGroup.getSymptomCounter().entrySet()) {
            symptomPercent.add(new SymptomOccurrence(entry.getKey(),(Math.floor(((Double.valueOf(entry.getValue())/suma)*100)*100))/100));
        }

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("OTHERS" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(new SymptomOccurrence(others.getName(), Math.floor(others.getPercent() * 100)/100));

        model.put("vaxType", vaxType);
        model.put("symptomPercent", formatDataFromList(firstCommon));
        return "vaxGroupAnalysis";
    }

    @GetMapping("/symptomVaxGroup-pl")
    public String analysisVaxGroupPL(@RequestParam(required = false, defaultValue = "PFIZER-BIONTECH") String vaxType,
                                     Map<String, Object> model){
        List <VaxGroup> vaxGroups = vaccineAnalisis();
        VaxGroup vaxGroup = new VaxGroup(vaxType);

        for (VaxGroup vax: vaxGroups) {
            if(vax.getType().equals(vaxType))
                vaxGroup.setSymptomCounter(vax.getSymptomCounter());
        }

        double suma = 0.0;
        for (Map.Entry<String, Integer> entry: vaxGroup.getSymptomCounter().entrySet()) {
            suma += (Integer)entry.getValue();
        }

        List<SymptomOccurrence> symptomPercent = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: vaxGroup.getSymptomCounter().entrySet()) {
            symptomPercent.add(new SymptomOccurrence(entry.getKey(),(Math.floor(((Double.valueOf(entry.getValue())/suma)*100)*100))/100));
        }

        Collections.sort(symptomPercent, Collections.reverseOrder());

        List<SymptomOccurrence> firstCommon = new ArrayList<>();
        SymptomOccurrence others = new SymptomOccurrence("INNE" , 0.0);
        int countCommon = 9;
        for (SymptomOccurrence o: symptomPercent) {
            if (countCommon > 0) {
                firstCommon.add(o);
                countCommon--;
            }
            else {
                others.setPercent(others.getPercent() + o.getPercent());
            }
        }
        firstCommon.add(new SymptomOccurrence(others.getName(), Math.floor(others.getPercent() * 100)/100));

        model.put("vaxType", vaxType);
        model.put("symptomPercent", formatDataFromList(translListSymptom(firstCommon)));
        return "analizaSzczepionkiWGrupach";
    }

    @GetMapping("/symptomAgeDeath-en")
    public String analysisDeathEN(Map<String, Object> model){
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Iterable<Patient> patients = patientRepository.findAll();
        Iterable<Notification> notifications = notificationRepository.findAll();

        List<AgeDeathGroup> ageDeathGroups = new ArrayList<>();
        ageDeathGroups.add(new AgeDeathGroup(0,10));
        ageDeathGroups.add(new AgeDeathGroup(10,20));
        ageDeathGroups.add(new AgeDeathGroup(20,30));
        ageDeathGroups.add(new AgeDeathGroup(30,40));
        ageDeathGroups.add(new AgeDeathGroup(40,50));
        ageDeathGroups.add(new AgeDeathGroup(50,60));
        ageDeathGroups.add(new AgeDeathGroup(60,70));
        ageDeathGroups.add(new AgeDeathGroup(70,80));
        ageDeathGroups.add(new AgeDeathGroup(80,90));
        ageDeathGroups.add(new AgeDeathGroup(90,100));

        Iterator<Patient> patientIterator = patients.iterator();
        Iterator<Symptom> symptomIterator = symptoms.iterator();
        Iterator<Notification> notificationIterator = notifications.iterator();
        while (patientIterator.hasNext()){
            Patient patient = patientIterator.next();
            Symptom symptom = symptomIterator.next();
            Notification notification = notificationIterator.next();
            for (AgeDeathGroup ageDeathGroup: ageDeathGroups) {
                if (patient.getAGE_YRS() >= ageDeathGroup.getAgeMin() && patient.getAGE_YRS() <= ageDeathGroup.getAgeMax()){
                    ageDeathGroup.countPatient();
                    if (notification.getDIED() == 'Y'){
                        ageDeathGroup.setDeathCount(ageDeathGroup.getDeathCount() + 1);
                    }
                    if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                        ageDeathGroup.getSymptomCounter().replace("RESPIRATORY_SYSTEM_DISEASES", ageDeathGroup.getSymptomCounter().get("RESPIRATORY_SYSTEM_DISEASES") + 1);
                    }
                    if (symptom.isAPPENDICITIS()){
                        ageDeathGroup.getSymptomCounter().replace("APPENDICITIS", ageDeathGroup.getSymptomCounter().get("APPENDICITIS") + 1);
                    }
                    if (symptom.isDYSPHAGIA()){
                        ageDeathGroup.getSymptomCounter().replace("DYSPHAGIA", ageDeathGroup.getSymptomCounter().get("DYSPHAGIA") + 1);
                    }
                    if (symptom.isTHROAT_TIGHTNESS()){
                        ageDeathGroup.getSymptomCounter().replace("THROAT_TIGHTNESS", ageDeathGroup.getSymptomCounter().get("THROAT_TIGHTNESS") + 1);
                    }
                    if (symptom.isTHROAT_IRRITATION()){
                        ageDeathGroup.getSymptomCounter().replace("THROAT_IRRITATION", ageDeathGroup.getSymptomCounter().get("THROAT_IRRITATION") + 1);
                    }
                    if (symptom.isDYSPNOEA()){
                        ageDeathGroup.getSymptomCounter().replace("DYSPNOEA", ageDeathGroup.getSymptomCounter().get("DYSPNOEA") + 1);
                    }
                    if (symptom.isCOUGH()){
                        ageDeathGroup.getSymptomCounter().replace("COUGH", ageDeathGroup.getSymptomCounter().get("COUGH") + 1);
                    }
                    if (symptom.isCHEST_DISCOMFORT()){
                        ageDeathGroup.getSymptomCounter().replace("CHEST_DISCOMFORT", ageDeathGroup.getSymptomCounter().get("CHEST_DISCOMFORT") + 1);
                    }
                    if (symptom.isANOEA()){
                        ageDeathGroup.getSymptomCounter().replace("ANOEA", ageDeathGroup.getSymptomCounter().get("ANOEA") + 1);
                    }
                    if (symptom.isSTRIDOR()){
                        ageDeathGroup.getSymptomCounter().replace("STRIDOR", ageDeathGroup.getSymptomCounter().get("STRIDOR") + 1);
                    }
                    if (symptom.isWHEEZING()){
                        ageDeathGroup.getSymptomCounter().replace("WHEEZING", ageDeathGroup.getSymptomCounter().get("WHEEZING") + 1);
                    }
                    if (symptom.isTACHYPNOE()){
                        ageDeathGroup.getSymptomCounter().replace("TACHYPNOE", ageDeathGroup.getSymptomCounter().get("TACHYPNOE") + 1);
                    }
                    if (symptom.isSHORTNESS_OF_BREATH()){
                        ageDeathGroup.getSymptomCounter().replace("SHORTNESS_OF_BREATH", ageDeathGroup.getSymptomCounter().get("SHORTNESS_OF_BREATH") + 1);
                    }
                    if (symptom.isRESPIRATORY_DISTRESS()){
                        ageDeathGroup.getSymptomCounter().replace("RESPIRATORY_DISTRESS", ageDeathGroup.getSymptomCounter().get("RESPIRATORY_DISTRESS") + 1);
                    }
                    if (symptom.isNAUSEA()){
                        ageDeathGroup.getSymptomCounter().replace("NAUSEA", ageDeathGroup.getSymptomCounter().get("NAUSEA") + 1);
                    }
                    if (symptom.isVOMITING()){
                        ageDeathGroup.getSymptomCounter().replace("VOMITING", ageDeathGroup.getSymptomCounter().get("VOMITING") + 1);
                    }
                    if (symptom.isDIARRHOEA()){
                        ageDeathGroup.getSymptomCounter().replace("DIARRHOEA", ageDeathGroup.getSymptomCounter().get("DIARRHOEA") + 1);
                    }
                    if (symptom.isCHILLS()){
                        ageDeathGroup.getSymptomCounter().replace("CHILLS", ageDeathGroup.getSymptomCounter().get("CHILLS") + 1);
                    }
                    if (symptom.isTREMOR()){
                        ageDeathGroup.getSymptomCounter().replace("TREMOR", ageDeathGroup.getSymptomCounter().get("TREMOR") + 1);
                    }
                    if (symptom.isFATIGUE()){
                        ageDeathGroup.getSymptomCounter().replace("FATIGUE", ageDeathGroup.getSymptomCounter().get("FATIGUE") + 1);
                    }
                    if (symptom.isFEELING_ABNORMAL()){
                        ageDeathGroup.getSymptomCounter().replace("FEELING_ABNORMAL", ageDeathGroup.getSymptomCounter().get("FEELING_ABNORMAL") + 1);
                    }
                    if (symptom.isMYALGIA()){
                        ageDeathGroup.getSymptomCounter().replace("MYALGIA", ageDeathGroup.getSymptomCounter().get("MYALGIA") + 1);
                    }
                    if (symptom.isBODY_ACHE()){
                        ageDeathGroup.getSymptomCounter().replace("BODY_ACHE", ageDeathGroup.getSymptomCounter().get("BODY_ACHE") + 1);
                    }
                    if (symptom.isSWELLING()){
                        ageDeathGroup.getSymptomCounter().replace("SWELLING", ageDeathGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isSWELLING()){
                        ageDeathGroup.getSymptomCounter().replace("SWELLING", ageDeathGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("BLOOD_PRESSURE_INCREASED", ageDeathGroup.getSymptomCounter().get("BLOOD_PRESSURE_INCREASED") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("BLOOD_PRESSURE_DECREASED", ageDeathGroup.getSymptomCounter().get("BLOOD_PRESSURE_DECREASED") + 1);
                    }
                    if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                        ageDeathGroup.getSymptomCounter().replace("LOSS_OF_CONSCIOUSNESS", ageDeathGroup.getSymptomCounter().get("LOSS_OF_CONSCIOUSNESS") + 1);
                    }
                    if (symptom.isMUSCULOSKELETAL_DISORDER()){
                        ageDeathGroup.getSymptomCounter().replace("MUSCULOSKELETAL_DISORDER", ageDeathGroup.getSymptomCounter().get("MUSCULOSKELETAL_DISORDER") + 1);
                    }
                    if (symptom.isIMPAIRED_WORK_ABILITY()){
                        ageDeathGroup.getSymptomCounter().replace("IMPAIRED_WORK_ABILITY", ageDeathGroup.getSymptomCounter().get("IMPAIRED_WORK_ABILITY") + 1);
                    }
                    if (symptom.isARTHRITIS_BACTERIAL()){
                        ageDeathGroup.getSymptomCounter().replace("ARTHRITIS_BACTERIAL", ageDeathGroup.getSymptomCounter().get("ARTHRITIS_BACTERIAL") + 1);
                    }
                    if (symptom.isSTROKE()){
                        ageDeathGroup.getSymptomCounter().replace("STROKE", ageDeathGroup.getSymptomCounter().get("STROKE") + 1);
                    }
                    if (symptom.isCARDIOVASCULAR_FAILURE()){
                        ageDeathGroup.getSymptomCounter().replace("CARDIOVASCULAR_FAILURE", ageDeathGroup.getSymptomCounter().get("CARDIOVASCULAR_FAILURE") + 1);
                    }
                    if (symptom.isHEART_RATE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("HEART_RATE_INCREASED", ageDeathGroup.getSymptomCounter().get("HEART_RATE_INCREASED") + 1);
                    }
                    if (symptom.isCORONARY_ARTERY_DISEASE()){
                        ageDeathGroup.getSymptomCounter().replace("CORONARY_ARTERY_DISEASE", ageDeathGroup.getSymptomCounter().get("CORONARY_ARTERY_DISEASE") + 1);
                    }
                    if (symptom.isTACHYCARDIA()){
                        ageDeathGroup.getSymptomCounter().replace("TACHYCARDIA", ageDeathGroup.getSymptomCounter().get("TACHYCARDIA") + 1);
                    }
                    if (symptom.isSUDDEN_CARDIAC_ARREST()){
                        ageDeathGroup.getSymptomCounter().replace("SUDDEN_CARDIAC_ARREST", ageDeathGroup.getSymptomCounter().get("SUDDEN_CARDIAC_ARREST") + 1);
                    }
                    if (symptom.isPALPITATIONS()){
                        ageDeathGroup.getSymptomCounter().replace("PALPITATIONS", ageDeathGroup.getSymptomCounter().get("PALPITATIONS") + 1);
                    }
                    if (symptom.isMYOCARDIAL_INFRACTION()){
                        ageDeathGroup.getSymptomCounter().replace("MYOCARDIAL_INFRACTION", ageDeathGroup.getSymptomCounter().get("MYOCARDIAL_INFRACTION") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_SHOCK()){
                        ageDeathGroup.getSymptomCounter().replace("ANAPHYLACTIC_SHOCK", ageDeathGroup.getSymptomCounter().get("ANAPHYLACTIC_SHOCK") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_REACTION()){
                        ageDeathGroup.getSymptomCounter().replace("ANAPHYLACTIC_REACTION", ageDeathGroup.getSymptomCounter().get("ANAPHYLACTIC_REACTION") + 1);
                    }
                    if (symptom.isAPHASIA()){
                        ageDeathGroup.getSymptomCounter().replace("APHASIA", ageDeathGroup.getSymptomCounter().get("APHASIA") + 1);
                    }
                    if (symptom.isHEADACHE()){
                        ageDeathGroup.getSymptomCounter().replace("HEADACHE", ageDeathGroup.getSymptomCounter().get("HEADACHE") + 1);
                    }
                    if (symptom.isDIZZINESS()){
                        ageDeathGroup.getSymptomCounter().replace("DIZZINESS", ageDeathGroup.getSymptomCounter().get("DIZZINESS") + 1);
                    }
                    if (symptom.isHYPERHIDROSIS()){
                        ageDeathGroup.getSymptomCounter().replace("HYPERHIDROSIS", ageDeathGroup.getSymptomCounter().get("HYPERHIDROSIS") + 1);
                    }
                    if (symptom.isBLEPHAROSPASM()){
                        ageDeathGroup.getSymptomCounter().replace("BLEPHAROSPASM", ageDeathGroup.getSymptomCounter().get("BLEPHAROSPASM") + 1);
                    }
                    if (symptom.isPARAESTHESIA()){
                        ageDeathGroup.getSymptomCounter().replace("PARAESTHESIA", ageDeathGroup.getSymptomCounter().get("PARAESTHESIA") + 1);
                    }
                    if (symptom.isEPISTAXIS()){
                        ageDeathGroup.getSymptomCounter().replace("EPISTAXIS", ageDeathGroup.getSymptomCounter().get("EPISTAXIS") + 1);
                    }
                    if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                        ageDeathGroup.getSymptomCounter().replace("SARS_CoV_2_TEST_POSITIVE", ageDeathGroup.getSymptomCounter().get("SARS_CoV_2_TEST_POSITIVE") + 1);
                    }
                    if (symptom.isPYREXIA()){
                        ageDeathGroup.getSymptomCounter().replace("PYREXIA", ageDeathGroup.getSymptomCounter().get("PYREXIA") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("BODY_TEMPERATURE_INCREASED", ageDeathGroup.getSymptomCounter().get("BODY_TEMPERATURE_INCREASED") + 1);
                    }
                    if (symptom.isFEBRILE_CONVULSION()){
                        ageDeathGroup.getSymptomCounter().replace("FEBRILE_CONVULSION", ageDeathGroup.getSymptomCounter().get("FEBRILE_CONVULSION") + 1);
                    }
                    if (symptom.isHOT_FLUSH()){
                        ageDeathGroup.getSymptomCounter().replace("HOT_FLUSH", ageDeathGroup.getSymptomCounter().get("HOT_FLUSH") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("BODY_TEMPERATURE_DECREASED", ageDeathGroup.getSymptomCounter().get("BODY_TEMPERATURE_DECREASED") + 1);
                    }
                    if (symptom.isPARALYSIS()){
                        ageDeathGroup.getSymptomCounter().replace("PARALYSIS", ageDeathGroup.getSymptomCounter().get("PARALYSIS") + 1);
                    }
                    if (symptom.isPALLOR()){
                        ageDeathGroup.getSymptomCounter().replace("PALLOR", ageDeathGroup.getSymptomCounter().get("PALLOR") + 1);
                    }
                    if (symptom.isSTILLBIRTH()){
                        ageDeathGroup.getSymptomCounter().replace("STILLBIRTH", ageDeathGroup.getSymptomCounter().get("STILLBIRTH") + 1);
                    }
                    if (symptom.isFOETAL_DEATH()){
                        ageDeathGroup.getSymptomCounter().replace("FOETAL_DEATH", ageDeathGroup.getSymptomCounter().get("FOETAL_DEATH") + 1);
                    }
                    if (symptom.isDEATH()){
                        ageDeathGroup.getSymptomCounter().replace("DEATH", ageDeathGroup.getSymptomCounter().get("DEATH") + 1);
                    }
                    if (symptom.isLYMPHADENOPATHY()){
                        ageDeathGroup.getSymptomCounter().replace("LYMPHADENOPATHY", ageDeathGroup.getSymptomCounter().get("LYMPHADENOPATHY") + 1);
                    }
                    if (symptom.isSEIZURE()){
                        ageDeathGroup.getSymptomCounter().replace("SEIZURE", ageDeathGroup.getSymptomCounter().get("SEIZURE") + 1);
                    }
                    if (symptom.isHERPES_ZOSTER()){
                        ageDeathGroup.getSymptomCounter().replace("HERPES_ZOSTER", ageDeathGroup.getSymptomCounter().get("HERPES_ZOSTER") + 1);
                    }
                    if (symptom.isSLEEP_DISORDER()){
                        ageDeathGroup.getSymptomCounter().replace("SLEEP_DISORDER", ageDeathGroup.getSymptomCounter().get("SLEEP_DISORDER") + 1);
                    }
                    if (symptom.isHIPERSOMNIA()){
                        ageDeathGroup.getSymptomCounter().replace("HIPERSOMNIA", ageDeathGroup.getSymptomCounter().get("HIPERSOMNIA") + 1);
                    }
                    if (symptom.isANXIETY()){
                        ageDeathGroup.getSymptomCounter().replace("ANXIETY", ageDeathGroup.getSymptomCounter().get("ANXIETY") + 1);
                    }
                    if (symptom.isINFLUENZA()){
                        ageDeathGroup.getSymptomCounter().replace("INFLUENZA", ageDeathGroup.getSymptomCounter().get("INFLUENZA") + 1);
                    }
                    if (symptom.isBLURRED_VISION()){
                        ageDeathGroup.getSymptomCounter().replace("BLURRED_VISION", ageDeathGroup.getSymptomCounter().get("BLURRED_VISION") + 1);
                    }
                    if (symptom.isBLINDNESS()){
                        ageDeathGroup.getSymptomCounter().replace("BLINDNESS", ageDeathGroup.getSymptomCounter().get("BLINDNESS") + 1);
                    }
                    if (symptom.isDYSPHONIA()){
                        ageDeathGroup.getSymptomCounter().replace("DYSPHONIA", ageDeathGroup.getSymptomCounter().get("DYSPHONIA") + 1);
                    }
                    if (symptom.isSPASM()){
                        ageDeathGroup.getSymptomCounter().replace("SPASM", ageDeathGroup.getSymptomCounter().get("SPASM") + 1);
                    }
                    if (symptom.isHAEMORRHAGE()){
                        ageDeathGroup.getSymptomCounter().replace("HAEMORRHAGE", ageDeathGroup.getSymptomCounter().get("HAEMORRHAGE") + 1);
                    }
                    if (symptom.isHEARING_IMPAIRMENT()){
                        ageDeathGroup.getSymptomCounter().replace("HEARING_IMPAIRMENT", ageDeathGroup.getSymptomCounter().get("HEARING_IMPAIRMENT") + 1);
                    }
                    if (symptom.isDEAFNESS()){
                        ageDeathGroup.getSymptomCounter().replace("DEAFNESS", ageDeathGroup.getSymptomCounter().get("DEAFNESS") + 1);
                    }
                    if (symptom.isSEPSIS()){
                        ageDeathGroup.getSymptomCounter().replace("SEPSIS", ageDeathGroup.getSymptomCounter().get("SEPSIS") + 1);
                    }
                    if (symptom.isVARICELLA()){
                        ageDeathGroup.getSymptomCounter().replace("VARICELLA", ageDeathGroup.getSymptomCounter().get("VARICELLA") + 1);
                    }
                    if (symptom.isPERICARDITIS()){
                        ageDeathGroup.getSymptomCounter().replace("PERICARDITIS", ageDeathGroup.getSymptomCounter().get("PERICARDITIS") + 1);
                    }
                    if (symptom.isAMYOTROPHY()){
                        ageDeathGroup.getSymptomCounter().replace("AMYOTROPHY", ageDeathGroup.getSymptomCounter().get("AMYOTROPHY") + 1);
                    }
                    if (symptom.isSENSORY_LOSS()){
                        ageDeathGroup.getSymptomCounter().replace("SENSORY LOSS", ageDeathGroup.getSymptomCounter().get("SENSORY LOSS") + 1);
                    }
                    if (symptom.isDECREASED_APPETITE()){
                        ageDeathGroup.getSymptomCounter().replace("DECREASED_APPETITE", ageDeathGroup.getSymptomCounter().get("DECREASED_APPETITE") + 1);
                    }
                    if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                        ageDeathGroup.getSymptomCounter().replace("CHANGE_IN_BLOOD_COUNT", ageDeathGroup.getSymptomCounter().get("CHANGE_IN_BLOOD_COUNT") + 1);
                    }
                    if (symptom.isOXYGEN_SATURATION_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("OXYGEN_SATURATION_DECREASED", ageDeathGroup.getSymptomCounter().get("OXYGEN_SATURATION_DECREASED") + 1);
                    }
                }
            }
        }

        for (AgeDeathGroup ageDeathGroup: ageDeathGroups) {
            ageDeathGroup.mostCommonSymptom();
            System.out.println(ageDeathGroup.getAgeMin() + " - " + ageDeathGroup.getAgeMax() + ": ");
            System.out.println("death: " + ageDeathGroup.getDeathCount());
            System.out.println("patients: " + ageDeathGroup.getPatientCount());
            System.out.println("procent: " + (Double.valueOf(ageDeathGroup.getDeathCount())/Double.valueOf(ageDeathGroup.getPatientCount())) * 100);
            ageDeathGroup.countDeathProcent();
        }
        model.put("ageDeathGroups",ageDeathGroups);
        return "mortalityAnalysis";
    }

    @GetMapping("/symptomAgeDeath-pl")
    public String analysisDeathPL(Map<String, Object> model){
        Iterable<Symptom> symptoms = symptomRepository.findAll();
        Iterable<Patient> patients = patientRepository.findAll();
        Iterable<Notification> notifications = notificationRepository.findAll();

        List<AgeDeathGroup> ageDeathGroups = new ArrayList<>();
        ageDeathGroups.add(new AgeDeathGroup(0,10));
        ageDeathGroups.add(new AgeDeathGroup(10,20));
        ageDeathGroups.add(new AgeDeathGroup(20,30));
        ageDeathGroups.add(new AgeDeathGroup(30,40));
        ageDeathGroups.add(new AgeDeathGroup(40,50));
        ageDeathGroups.add(new AgeDeathGroup(50,60));
        ageDeathGroups.add(new AgeDeathGroup(60,70));
        ageDeathGroups.add(new AgeDeathGroup(70,80));
        ageDeathGroups.add(new AgeDeathGroup(80,90));
        ageDeathGroups.add(new AgeDeathGroup(90,100));

        Iterator<Patient> patientIterator = patients.iterator();
        Iterator<Symptom> symptomIterator = symptoms.iterator();
        Iterator<Notification> notificationIterator = notifications.iterator();
        while (patientIterator.hasNext()){
            Patient patient = patientIterator.next();
            Symptom symptom = symptomIterator.next();
            Notification notification = notificationIterator.next();
            for (AgeDeathGroup ageDeathGroup: ageDeathGroups) {
                if (patient.getAGE_YRS() >= ageDeathGroup.getAgeMin() && patient.getAGE_YRS() <= ageDeathGroup.getAgeMax()){
                    ageDeathGroup.countPatient();
                    if (notification.getDIED() == 'Y'){
                        ageDeathGroup.setDeathCount(ageDeathGroup.getDeathCount() + 1);
                    }
                    if (symptom.isRESPIRATORY_SYSTEM_DISEASES()){
                        ageDeathGroup.getSymptomCounter().replace("CHOROBY UKŁADU ODDECHOWEGO", ageDeathGroup.getSymptomCounter().get("RESPIRATORY_SYSTEM_DISEASES") + 1);
                    }
                    if (symptom.isAPPENDICITIS()){
                        ageDeathGroup.getSymptomCounter().replace("ZAPALENIE WYROSTKA ROBACZKOWEGO", ageDeathGroup.getSymptomCounter().get("APPENDICITIS") + 1);
                    }
                    if (symptom.isDYSPHAGIA()){
                        ageDeathGroup.getSymptomCounter().replace("DYSFAGIA", ageDeathGroup.getSymptomCounter().get("DYSPHAGIA") + 1);
                    }
                    if (symptom.isTHROAT_TIGHTNESS()){
                        ageDeathGroup.getSymptomCounter().replace("UCISK W GARDLE", ageDeathGroup.getSymptomCounter().get("THROAT_TIGHTNESS") + 1);
                    }
                    if (symptom.isTHROAT_IRRITATION()){
                        ageDeathGroup.getSymptomCounter().replace("PODRAŻNIENIE GARDŁA", ageDeathGroup.getSymptomCounter().get("THROAT_IRRITATION") + 1);
                    }
                    if (symptom.isDYSPNOEA()){
                        ageDeathGroup.getSymptomCounter().replace("DUSZNOŚĆ", ageDeathGroup.getSymptomCounter().get("DYSPNOEA") + 1);
                    }
                    if (symptom.isCOUGH()){
                        ageDeathGroup.getSymptomCounter().replace("KASZEL", ageDeathGroup.getSymptomCounter().get("COUGH") + 1);
                    }
                    if (symptom.isCHEST_DISCOMFORT()){
                        ageDeathGroup.getSymptomCounter().replace("DYSKOMFORT W KLATCE", ageDeathGroup.getSymptomCounter().get("CHEST_DISCOMFORT") + 1);
                    }
                    if (symptom.isRESPIRATORY_DISTRESS()){
                        ageDeathGroup.getSymptomCounter().replace("NIEWYDOLNOŚĆ ODDECHOWA", ageDeathGroup.getSymptomCounter().get("RESPIRATORY_DISTRESS") + 1);
                    }
                    if (symptom.isANOEA()){
                        ageDeathGroup.getSymptomCounter().replace("BEZDECH", ageDeathGroup.getSymptomCounter().get("ANOEA") + 1);
                    }
                    if (symptom.isSTRIDOR()){
                        ageDeathGroup.getSymptomCounter().replace("ŚWIST WDECHOWY", ageDeathGroup.getSymptomCounter().get("STRIDOR") + 1);
                    }
                    if (symptom.isWHEEZING()){
                        ageDeathGroup.getSymptomCounter().replace("ŚWIST WYDECHOWY", ageDeathGroup.getSymptomCounter().get("WHEEZING") + 1);
                    }
                    if (symptom.isTACHYPNOE()){
                        ageDeathGroup.getSymptomCounter().replace("ZWIĘKSZONA CZĘSTOŚĆ ODDECHÓW", ageDeathGroup.getSymptomCounter().get("TACHYPNOE") + 1);
                    }
                    if (symptom.isSHORTNESS_OF_BREATH()){
                        ageDeathGroup.getSymptomCounter().replace("KRÓTKI ODDECH", ageDeathGroup.getSymptomCounter().get("SHORTNESS_OF_BREATH") + 1);
                    }
                    if (symptom.isNAUSEA()){
                        ageDeathGroup.getSymptomCounter().replace("NUDNOŚCI", ageDeathGroup.getSymptomCounter().get("NAUSEA") + 1);
                    }
                    if (symptom.isVOMITING()){
                        ageDeathGroup.getSymptomCounter().replace("WYMIOTY", ageDeathGroup.getSymptomCounter().get("VOMITING") + 1);
                    }
                    if (symptom.isDIARRHOEA()){
                        ageDeathGroup.getSymptomCounter().replace("BIEGUNKA", ageDeathGroup.getSymptomCounter().get("DIARRHOEA") + 1);
                    }
                    if (symptom.isCHILLS()){
                        ageDeathGroup.getSymptomCounter().replace("DRESZCZE", ageDeathGroup.getSymptomCounter().get("CHILLS") + 1);
                    }
                    if (symptom.isTREMOR()){
                        ageDeathGroup.getSymptomCounter().replace("DRŻENIE", ageDeathGroup.getSymptomCounter().get("TREMOR") + 1);
                    }
                    if (symptom.isFATIGUE()){
                        ageDeathGroup.getSymptomCounter().replace("ZMĘCZENIE", ageDeathGroup.getSymptomCounter().get("FATIGUE") + 1);
                    }
                    if (symptom.isFEELING_ABNORMAL()){
                        ageDeathGroup.getSymptomCounter().replace("NIENORMALNE UCZUCIE", ageDeathGroup.getSymptomCounter().get("FEELING_ABNORMAL") + 1);
                    }
                    if (symptom.isMYALGIA()){
                        ageDeathGroup.getSymptomCounter().replace("MIALGIA", ageDeathGroup.getSymptomCounter().get("MYALGIA") + 1);
                    }
                    if (symptom.isBODY_ACHE()){
                        ageDeathGroup.getSymptomCounter().replace("BÓL CIAŁA", ageDeathGroup.getSymptomCounter().get("BODY_ACHE") + 1);
                    }
                    if (symptom.isSWELLING()){
                        ageDeathGroup.getSymptomCounter().replace("OBRZĘK", ageDeathGroup.getSymptomCounter().get("SWELLING") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("WZROST CIŚNIENIA KRWI", ageDeathGroup.getSymptomCounter().get("BLOOD_PRESSURE_INCREASED") + 1);
                    }
                    if (symptom.isBLOOD_PRESSURE_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("SPADEK CIŚNIENIA KRWI", ageDeathGroup.getSymptomCounter().get("BLOOD_PRESSURE_DECREASED") + 1);
                    }
                    if (symptom.isLOSS_OF_CONSCIOUSNESS()){
                        ageDeathGroup.getSymptomCounter().replace("UTRATA PRZYTOMNOŚCI", ageDeathGroup.getSymptomCounter().get("LOSS_OF_CONSCIOUSNESS") + 1);
                    }
                    if (symptom.isMUSCULOSKELETAL_DISORDER()){
                        ageDeathGroup.getSymptomCounter().replace("ZABURZENIA MIĘŚNIOWO-SZKIELETOWE", ageDeathGroup.getSymptomCounter().get("MUSCULOSKELETAL_DISORDER") + 1);
                    }
                    if (symptom.isIMPAIRED_WORK_ABILITY()){
                        ageDeathGroup.getSymptomCounter().replace("NIEZDOLNOŚĆ DO PRACY", ageDeathGroup.getSymptomCounter().get("IMPAIRED_WORK_ABILITY") + 1);
                    }
                    if (symptom.isARTHRITIS_BACTERIAL()){
                        ageDeathGroup.getSymptomCounter().replace("BAKTERYJNE ZAPALENIE STAWÓW", ageDeathGroup.getSymptomCounter().get("ARTHRITIS_BACTERIAL") + 1);
                    }
                    if (symptom.isSTROKE()){
                        ageDeathGroup.getSymptomCounter().replace("UDAR", ageDeathGroup.getSymptomCounter().get("STROKE") + 1);
                    }
                    if (symptom.isCARDIOVASCULAR_FAILURE()){
                        ageDeathGroup.getSymptomCounter().replace("NIEWYDOLNOŚĆ KRĄŻENIA", ageDeathGroup.getSymptomCounter().get("CARDIOVASCULAR_FAILURE") + 1);
                    }
                    if (symptom.isHEART_RATE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("ZWIĘKSZONE TĘTNO", ageDeathGroup.getSymptomCounter().get("HEART_RATE_INCREASED") + 1);
                    }
                    if (symptom.isCORONARY_ARTERY_DISEASE()){
                        ageDeathGroup.getSymptomCounter().replace("CHOROBA WIEŃCOWA", ageDeathGroup.getSymptomCounter().get("CORONARY_ARTERY_DISEASE") + 1);
                    }
                    if (symptom.isTACHYCARDIA()){
                        ageDeathGroup.getSymptomCounter().replace("TACHYKARDIA", ageDeathGroup.getSymptomCounter().get("TACHYCARDIA") + 1);
                    }
                    if (symptom.isSUDDEN_CARDIAC_ARREST()){
                        ageDeathGroup.getSymptomCounter().replace("NAGŁE ZATRZYMANIE KRĄŻENIA", ageDeathGroup.getSymptomCounter().get("SUDDEN_CARDIAC_ARREST") + 1);
                    }
                    if (symptom.isPALPITATIONS()){
                        ageDeathGroup.getSymptomCounter().replace("PALPITACJA", ageDeathGroup.getSymptomCounter().get("PALPITATIONS") + 1);
                    }
                    if (symptom.isMYOCARDIAL_INFRACTION()){
                        ageDeathGroup.getSymptomCounter().replace("ZAWAŁ MIĘŚNIA SERCOWEGO", ageDeathGroup.getSymptomCounter().get("MYOCARDIAL_INFRACTION") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_SHOCK()){
                        ageDeathGroup.getSymptomCounter().replace("WSTRZĄS ANAFILAKTYCZNY", ageDeathGroup.getSymptomCounter().get("ANAPHYLACTIC_SHOCK") + 1);
                    }
                    if (symptom.isANAPHYLACTIC_REACTION()){
                        ageDeathGroup.getSymptomCounter().replace("REAKCJA ANAFILAKTYCZNA", ageDeathGroup.getSymptomCounter().get("ANAPHYLACTIC_REACTION") + 1);
                    }
                    if (symptom.isAPHASIA()){
                        ageDeathGroup.getSymptomCounter().replace("UTRATA ZDOLNOŚCI MOWY", ageDeathGroup.getSymptomCounter().get("APHASIA") + 1);
                    }
                    if (symptom.isHEADACHE()){
                        ageDeathGroup.getSymptomCounter().replace("BÓL GŁOWY", ageDeathGroup.getSymptomCounter().get("HEADACHE") + 1);
                    }
                    if (symptom.isDIZZINESS()){
                        ageDeathGroup.getSymptomCounter().replace("ZAWROTY GŁOWY", ageDeathGroup.getSymptomCounter().get("DIZZINESS") + 1);
                    }
                    if (symptom.isHYPERHIDROSIS()){
                        ageDeathGroup.getSymptomCounter().replace("NADMIERNA POTLIWOŚĆ", ageDeathGroup.getSymptomCounter().get("HYPERHIDROSIS") + 1);
                    }
                    if (symptom.isBLEPHAROSPASM()){
                        ageDeathGroup.getSymptomCounter().replace("KURCZ POWIEK", ageDeathGroup.getSymptomCounter().get("BLEPHAROSPASM") + 1);
                    }
                    if (symptom.isPARAESTHESIA()){
                        ageDeathGroup.getSymptomCounter().replace("PARESTEZIA", ageDeathGroup.getSymptomCounter().get("PARAESTHESIA") + 1);
                    }
                    if (symptom.isEPISTAXIS()){
                        ageDeathGroup.getSymptomCounter().replace("KRWAWIENIE Z NOSA", ageDeathGroup.getSymptomCounter().get("EPISTAXIS") + 1);
                    }
                    if (symptom.isSARS_CoV_2_TEST_POSITIVE()){
                        ageDeathGroup.getSymptomCounter().replace("POZYTYWNY TEST NA CoV-2", ageDeathGroup.getSymptomCounter().get("SARS_CoV_2_TEST_POSITIVE") + 1);
                    }
                    if (symptom.isPYREXIA()){
                        ageDeathGroup.getSymptomCounter().replace("GORĄCZKA", ageDeathGroup.getSymptomCounter().get("PYREXIA") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_INCREASED()){
                        ageDeathGroup.getSymptomCounter().replace("ZWIĘKSZENIE TEMPERATURY CIAŁA", ageDeathGroup.getSymptomCounter().get("BODY_TEMPERATURE_INCREASED") + 1);
                    }
                    if (symptom.isFEBRILE_CONVULSION()){
                        ageDeathGroup.getSymptomCounter().replace("DRGAWKI GORĄCZKOWE", ageDeathGroup.getSymptomCounter().get("FEBRILE_CONVULSION") + 1);
                    }
                    if (symptom.isHOT_FLUSH()){
                        ageDeathGroup.getSymptomCounter().replace("UDERZENIE GORĄCA", ageDeathGroup.getSymptomCounter().get("HOT_FLUSH") + 1);
                    }
                    if (symptom.isBODY_TEMPERATURE_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("SPADEK TEMPERATURY CIAŁA", ageDeathGroup.getSymptomCounter().get("BODY_TEMPERATURE_DECREASED") + 1);
                    }
                    if (symptom.isPARALYSIS()){
                        ageDeathGroup.getSymptomCounter().replace("PARALIŻ", ageDeathGroup.getSymptomCounter().get("PARALYSIS") + 1);
                    }
                    if (symptom.isPALLOR()){
                        ageDeathGroup.getSymptomCounter().replace("BLADOŚĆ", ageDeathGroup.getSymptomCounter().get("PALLOR") + 1);
                    }
                    if (symptom.isSTILLBIRTH()){
                        ageDeathGroup.getSymptomCounter().replace("PORONIENIE", ageDeathGroup.getSymptomCounter().get("STILLBIRTH") + 1);
                    }
                    if (symptom.isFOETAL_DEATH()){
                        ageDeathGroup.getSymptomCounter().replace("ŚMIERĆ PŁODU", ageDeathGroup.getSymptomCounter().get("FOETAL_DEATH") + 1);
                    }
                    if (symptom.isDEATH()){
                        ageDeathGroup.getSymptomCounter().replace("ŚMIERĆ", ageDeathGroup.getSymptomCounter().get("DEATH") + 1);
                    }
                    if (symptom.isLYMPHADENOPATHY()){
                        ageDeathGroup.getSymptomCounter().replace("POWIĘKSZENIE WĘZŁÓW CHŁONNYCH", ageDeathGroup.getSymptomCounter().get("LYMPHADENOPATHY") + 1);
                    }
                    if (symptom.isSEIZURE()){
                        ageDeathGroup.getSymptomCounter().replace("NAPAD", ageDeathGroup.getSymptomCounter().get("SEIZURE") + 1);
                    }
                    if (symptom.isHERPES_ZOSTER()){
                        ageDeathGroup.getSymptomCounter().replace("PÓŁPASIEC", ageDeathGroup.getSymptomCounter().get("HERPES_ZOSTER") + 1);
                    }
                    if (symptom.isSLEEP_DISORDER()){
                        ageDeathGroup.getSymptomCounter().replace("ZABURZENIA SNU", ageDeathGroup.getSymptomCounter().get("SLEEP_DISORDER") + 1);
                    }
                    if (symptom.isHIPERSOMNIA()){
                        ageDeathGroup.getSymptomCounter().replace("NADMIERNA SENNOŚĆ", ageDeathGroup.getSymptomCounter().get("HIPERSOMNIA") + 1);
                    }
                    if (symptom.isANXIETY()){
                        ageDeathGroup.getSymptomCounter().replace("LĘK", ageDeathGroup.getSymptomCounter().get("ANXIETY") + 1);
                    }
                    if (symptom.isINFLUENZA()){
                        ageDeathGroup.getSymptomCounter().replace("GRYPA", ageDeathGroup.getSymptomCounter().get("INFLUENZA") + 1);
                    }
                    if (symptom.isBLURRED_VISION()){
                        ageDeathGroup.getSymptomCounter().replace("ZABURZENIA WIDZENIA", ageDeathGroup.getSymptomCounter().get("BLURRED_VISION") + 1);
                    }
                    if (symptom.isBLINDNESS()){
                        ageDeathGroup.getSymptomCounter().replace("ŚLEPOTA", ageDeathGroup.getSymptomCounter().get("BLINDNESS") + 1);
                    }
                    if (symptom.isDYSPHONIA()){
                        ageDeathGroup.getSymptomCounter().replace("DYSFONIA", ageDeathGroup.getSymptomCounter().get("DYSPHONIA") + 1);
                    }
                    if (symptom.isSPASM()){
                        ageDeathGroup.getSymptomCounter().replace("SKURCZE", ageDeathGroup.getSymptomCounter().get("SPASM") + 1);
                    }
                    if (symptom.isHAEMORRHAGE()){
                        ageDeathGroup.getSymptomCounter().replace("KRWOTOK", ageDeathGroup.getSymptomCounter().get("HAEMORRHAGE") + 1);
                    }
                    if (symptom.isHEARING_IMPAIRMENT()){
                        ageDeathGroup.getSymptomCounter().replace("ZABURZENIA SŁUCHU", ageDeathGroup.getSymptomCounter().get("HEARING_IMPAIRMENT") + 1);
                    }
                    if (symptom.isDEAFNESS()){
                        ageDeathGroup.getSymptomCounter().replace("GŁUCHOTA", ageDeathGroup.getSymptomCounter().get("DEAFNESS") + 1);
                    }
                    if (symptom.isSEPSIS()){
                        ageDeathGroup.getSymptomCounter().replace("POSOCZNICA", ageDeathGroup.getSymptomCounter().get("SEPSIS") + 1);
                    }
                    if (symptom.isVARICELLA()){
                        ageDeathGroup.getSymptomCounter().replace("OSPA WIETRZNA", ageDeathGroup.getSymptomCounter().get("VARICELLA") + 1);
                    }
                    if (symptom.isPERICARDITIS()){
                        ageDeathGroup.getSymptomCounter().replace("ZAPALENIE OSIERDZIA", ageDeathGroup.getSymptomCounter().get("PERICARDITIS") + 1);
                    }
                    if (symptom.isAMYOTROPHY()){
                        ageDeathGroup.getSymptomCounter().replace("AMIOTROFIA", ageDeathGroup.getSymptomCounter().get("AMYOTROPHY") + 1);
                    }
                    if (symptom.isSENSORY_LOSS()){
                        ageDeathGroup.getSymptomCounter().replace("UTRATA ZMYSŁÓW", ageDeathGroup.getSymptomCounter().get("SENSORY LOSS") + 1);
                    }
                    if (symptom.isDECREASED_APPETITE()){
                        ageDeathGroup.getSymptomCounter().replace("SPADEK APETYTU", ageDeathGroup.getSymptomCounter().get("DECREASED_APPETITE") + 1);
                    }
                    if (symptom.isCHANGE_IN_BLOOD_COUNT()){
                        ageDeathGroup.getSymptomCounter().replace("ZMIANA MORFOLOGII KRWI", ageDeathGroup.getSymptomCounter().get("CHANGE_IN_BLOOD_COUNT") + 1);
                    }
                    if (symptom.isOXYGEN_SATURATION_DECREASED()){
                        ageDeathGroup.getSymptomCounter().replace("SPADEK SATURACJI", ageDeathGroup.getSymptomCounter().get("OXYGEN_SATURATION_DECREASED") + 1);
                    }
                }
            }
        }

        for (AgeDeathGroup ageDeathGroup: ageDeathGroups) {
            ageDeathGroup.mostCommonSymptom();
            System.out.println(ageDeathGroup.getAgeMin() + " - " + ageDeathGroup.getAgeMax() + ": ");
            System.out.println("death: " + ageDeathGroup.getDeathCount());
            System.out.println("patients: " + ageDeathGroup.getPatientCount());
            System.out.println("procent: " + (Double.valueOf(ageDeathGroup.getDeathCount())/Double.valueOf(ageDeathGroup.getPatientCount())) * 100);
            ageDeathGroup.countDeathProcent();
        }
        model.put("ageDeathGroups",ageDeathGroups);
        return "analizaSmiertelnosci";
    }

    int[] createCounter(int n){
        int[] counter = new int[n];
        for (int i = 0; i < n; i++) {
            counter[i] = i+1;
        }
        return counter;
    }
}