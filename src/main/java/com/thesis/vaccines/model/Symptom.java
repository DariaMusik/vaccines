package com.thesis.vaccines.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Symptom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int SYMPTOM_ID;
    private boolean RESPIRATORY_SYSTEM_DISEASES;
    private boolean APPENDICITIS;
    private boolean DYSPHAGIA;
    private boolean THROAT_TIGHTNESS;
    private boolean THROAT_IRRITATION;
    private boolean DYSPNOEA;
    private boolean COUGH;
    private boolean CHEST_DISCOMFORT;
    private boolean RESPIRATORY_DISTRESS;
    private boolean ANOEA;
    private boolean STRIDOR;
    private boolean WHEEZING;
    private boolean TACHYPNOE;
    private boolean SHORTNESS_OF_BREATH;
    private boolean NAUSEA;
    private boolean VOMITING;
    private boolean DIARRHOEA;
    private boolean CHILLS;
    private boolean TREMOR;
    private boolean FATIGUE;
    private boolean FEELING_ABNORMAL;
    private boolean MYALGIA;
    private boolean BODY_ACHE;
    private boolean SWELLING;
    private boolean BLOOD_PRESSURE_INCREASED;
    private boolean BLOOD_PRESSURE_DECREASED;
    private boolean LOSS_OF_CONSCIOUSNESS;
    private boolean MUSCULOSKELETAL_DISORDER;
    private boolean IMPAIRED_WORK_ABILITY;
    private boolean ARTHRITIS_BACTERIAL;
    private boolean STROKE;
    private boolean CARDIOVASCULAR_FAILURE;
    private boolean HEART_RATE_INCREASED;
    private boolean CORONARY_ARTERY_DISEASE;
    private boolean TACHYCARDIA;
    private boolean SUDDEN_CARDIAC_ARREST;
    private boolean PALPITATIONS;
    private boolean MYOCARDIAL_INFRACTION;
    private boolean ANAPHYLACTIC_SHOCK;
    private boolean ANAPHYLACTIC_REACTION;
    private boolean APHASIA;
    private boolean HEADACHE;
    private boolean DIZZINESS;
    private boolean HYPERHIDROSIS;
    private boolean BLEPHAROSPASM;
    private boolean PARAESTHESIA;
    private boolean EPISTAXIS;
    private boolean SARS_CoV_2_TEST_POSITIVE;
    private boolean PYREXIA;
    private boolean BODY_TEMPERATURE_INCREASED;
    private boolean FEBRILE_CONVULSION;
    private boolean HOT_FLUSH;
    private boolean BODY_TEMPERATURE_DECREASED;
    private boolean PARALYSIS;
    private boolean PALLOR;
    private boolean STILLBIRTH;
    private boolean FOETAL_DEATH;
    private boolean DEATH;
    private boolean LYMPHADENOPATHY;
    private boolean SEIZURE;
    private boolean HERPES_ZOSTER;
    private boolean SLEEP_DISORDER;
    private boolean HIPERSOMNIA;
    private boolean ANXIETY;
    private boolean INFLUENZA;
    private boolean BLURRED_VISION;
    private boolean BLINDNESS;
    private boolean DYSPHONIA;
    private boolean SPASM;
    private boolean HAEMORRHAGE;
    private boolean HEARING_IMPAIRMENT;
    private boolean DEAFNESS;
    private boolean SEPSIS;
    private boolean VARICELLA;
    private boolean PERICARDITIS;
    private boolean AMYOTROPHY;
    private boolean SENSORY_LOSS;
    private boolean DECREASED_APPETITE;
    private boolean CHANGE_IN_BLOOD_COUNT;
    private boolean OXYGEN_SATURATION_DECREASED;
    private String OTHER;

    public Symptom() {

        RESPIRATORY_SYSTEM_DISEASES = false;
        APPENDICITIS = false;
        DYSPHAGIA = false;
        THROAT_TIGHTNESS = false;
        THROAT_IRRITATION = false;
        DYSPNOEA = false;
        COUGH = false;
        CHEST_DISCOMFORT = false;
        RESPIRATORY_DISTRESS = false;
        ANOEA = false;
        STRIDOR = false;
        WHEEZING = false;
        TACHYPNOE = false;
        SHORTNESS_OF_BREATH = false;
        NAUSEA = false;
        VOMITING = false;
        DIARRHOEA = false;
        CHILLS = false;
        TREMOR = false;
        FATIGUE = false;
        FEELING_ABNORMAL = false;
        MYALGIA = false;
        BODY_ACHE = false;
        SWELLING = false;
        BLOOD_PRESSURE_INCREASED = false;
        BLOOD_PRESSURE_DECREASED = false;
        LOSS_OF_CONSCIOUSNESS = false;
        MUSCULOSKELETAL_DISORDER = false;
        IMPAIRED_WORK_ABILITY = false;
        ARTHRITIS_BACTERIAL = false;
        STROKE = false;
        CARDIOVASCULAR_FAILURE = false;
        HEART_RATE_INCREASED = false;
        CORONARY_ARTERY_DISEASE = false;
        TACHYCARDIA = false;
        SUDDEN_CARDIAC_ARREST = false;
        PALPITATIONS = false;
        MYOCARDIAL_INFRACTION = false;
        ANAPHYLACTIC_SHOCK = false;
        ANAPHYLACTIC_REACTION = false;
        APHASIA = false;
        HEADACHE = false;
        DIZZINESS = false;
        HYPERHIDROSIS = false;
        BLEPHAROSPASM = false;
        PARAESTHESIA = false;
        EPISTAXIS = false;
        SARS_CoV_2_TEST_POSITIVE = false;
        PYREXIA = false;
        BODY_TEMPERATURE_INCREASED = false;
        FEBRILE_CONVULSION = false;
        HOT_FLUSH = false;
        BODY_TEMPERATURE_DECREASED = false;
        PARALYSIS = false;
        PALLOR = false;
        STILLBIRTH = false;
        FOETAL_DEATH = false;
        DEATH = false;
        LYMPHADENOPATHY = false;
        SEIZURE = false;
        HERPES_ZOSTER = false;
        SLEEP_DISORDER = false;
        HIPERSOMNIA = false;
        ANXIETY = false;
        INFLUENZA = false;
        BLURRED_VISION = false;
        BLINDNESS = false;
        DYSPHONIA = false;
        SPASM = false;
        HAEMORRHAGE = false;
        HEARING_IMPAIRMENT = false;
        DEAFNESS = false;
        SEPSIS = false;
        VARICELLA = false;
        PERICARDITIS = false;
        AMYOTROPHY = false;
        SENSORY_LOSS = false;
        DECREASED_APPETITE = false;
        CHANGE_IN_BLOOD_COUNT = false;
        OXYGEN_SATURATION_DECREASED = false;
    }

    public boolean isRESPIRATORY_SYSTEM_DISEASES() {
        return RESPIRATORY_SYSTEM_DISEASES;
    }

    public void setRESPIRATORY_SYSTEM_DISEASES(boolean RESPIRATORY_SYSTEM_DISEASES) {
        this.RESPIRATORY_SYSTEM_DISEASES = RESPIRATORY_SYSTEM_DISEASES;
    }

    public boolean isAPPENDICITIS() {
        return APPENDICITIS;
    }

    public void setAPPENDICITIS(boolean APPENDICITIS) {
        this.APPENDICITIS = APPENDICITIS;
    }

    public boolean isDYSPHAGIA() {
        return DYSPHAGIA;
    }

    public void setDYSPHAGIA(boolean DYSPHAGIA) {
        this.DYSPHAGIA = DYSPHAGIA;
    }

    public boolean isTHROAT_TIGHTNESS() {
        return THROAT_TIGHTNESS;
    }

    public void setTHROAT_TIGHTNESS(boolean THROAT_TIGHTNESS) {
        this.THROAT_TIGHTNESS = THROAT_TIGHTNESS;
    }

    public boolean isTHROAT_IRRITATION() {
        return THROAT_IRRITATION;
    }

    public void setTHROAT_IRRITATION(boolean THROAT_IRRITATION) {
        this.THROAT_IRRITATION = THROAT_IRRITATION;
    }

    public boolean isDYSPNOEA() {
        return DYSPNOEA;
    }

    public void setDYSPNOEA(boolean DYSPNOEA) {
        this.DYSPNOEA = DYSPNOEA;
    }

    public boolean isCOUGH() {
        return COUGH;
    }

    public void setCOUGH(boolean COUGH) {
        this.COUGH = COUGH;
    }

    public boolean isCHEST_DISCOMFORT() {
        return CHEST_DISCOMFORT;
    }

    public void setCHEST_DISCOMFORT(boolean CHEST_DISCOMFORT) {
        this.CHEST_DISCOMFORT = CHEST_DISCOMFORT;
    }

    public boolean isRESPIRATORY_DISTRESS() {
        return RESPIRATORY_DISTRESS;
    }

    public void setRESPIRATORY_DISTRESS(boolean RESPIRATORY_DISTRESS) {
        this.RESPIRATORY_DISTRESS = RESPIRATORY_DISTRESS;
    }

    public boolean isANOEA() {
        return ANOEA;
    }

    public void setANOEA(boolean ANOEA) { this.ANOEA = ANOEA; }

    public boolean isSTRIDOR() {
        return STRIDOR;
    }

    public void setSTRIDOR(boolean STRIDOR) { this.STRIDOR = STRIDOR; }

    public boolean isWHEEZING() {
        return WHEEZING;
    }

    public void setWHEEZING(boolean WHEEZING) { this.WHEEZING = WHEEZING; }

    public boolean isTACHYPNOE() {
        return TACHYPNOE;
    }

    public void setTACHYPNOE(boolean TACHYPNOE) { this.TACHYPNOE = TACHYPNOE; }

    public boolean isSHORTNESS_OF_BREATH() {
        return SHORTNESS_OF_BREATH;
    }

    public void setSHORTNESS_OF_BREATH(boolean SHORTNESS_OF_BREATH) { this.SHORTNESS_OF_BREATH = SHORTNESS_OF_BREATH; }

    public boolean isNAUSEA() {
        return NAUSEA;
    }

    public void setNAUSEA(boolean NAUSEA) {
        this.NAUSEA = NAUSEA;
    }

    public boolean isVOMITING() {
        return VOMITING;
    }

    public void setVOMITING(boolean VOMITING) {
        this.VOMITING = VOMITING;
    }

    public boolean isDIARRHOEA() {
        return DIARRHOEA;
    }

    public void setDIARRHOEA(boolean DIARRHOEA) {
        this.DIARRHOEA = DIARRHOEA;
    }

    public boolean isCHILLS() {
        return CHILLS;
    }

    public void setCHILLS(boolean CHILLS) {
        this.CHILLS = CHILLS;
    }

    public boolean isTREMOR() {
        return TREMOR;
    }

    public void setTREMOR(boolean TREMOR) {
        this.TREMOR = TREMOR;
    }

    public boolean isFATIGUE() {
        return FATIGUE;
    }

    public void setFATIGUE(boolean FATIGUE) {
        this.FATIGUE = FATIGUE;
    }

    public boolean isFEELING_ABNORMAL() {
        return FEELING_ABNORMAL;
    }

    public void setFEELING_ABNORMAL(boolean FEELING_ABNORMAL) {
        this.FEELING_ABNORMAL = FEELING_ABNORMAL;
    }

    public boolean isMYALGIA() {
        return MYALGIA;
    }

    public void setMYALGIA(boolean MYALGIA) {
        this.MYALGIA = MYALGIA;
    }

    public boolean isBODY_ACHE() {
        return BODY_ACHE;
    }

    public void setBODY_ACHE(boolean BODY_ACHE) {
        this.BODY_ACHE = BODY_ACHE;
    }

    public boolean isSWELLING() {
        return SWELLING;
    }

    public void setSWELLING(boolean SWELLING) {
        this.SWELLING = SWELLING;
    }

    public boolean isBLOOD_PRESSURE_INCREASED() {
        return BLOOD_PRESSURE_INCREASED;
    }

    public void setBLOOD_PRESSURE_INCREASED(boolean BLOOD_PRESSURE_INCREASED) {
        this.BLOOD_PRESSURE_INCREASED = BLOOD_PRESSURE_INCREASED;
    }

    public boolean isBLOOD_PRESSURE_DECREASED() { return BLOOD_PRESSURE_DECREASED; }

    public void setBLOOD_PRESSURE_DECREASED(boolean BLOOD_PRESSURE_DECREASED) {
        this.BLOOD_PRESSURE_DECREASED = BLOOD_PRESSURE_DECREASED;
    }

    public boolean isLOSS_OF_CONSCIOUSNESS() {
        return LOSS_OF_CONSCIOUSNESS;
    }

    public void setLOSS_OF_CONSCIOUSNESS(boolean LOSS_OF_CONSCIOUSNESS) {
        this.LOSS_OF_CONSCIOUSNESS = LOSS_OF_CONSCIOUSNESS;
    }

    public boolean isMUSCULOSKELETAL_DISORDER() {
        return MUSCULOSKELETAL_DISORDER;
    }

    public void setMUSCULOSKELETAL_DISORDER(boolean MUSCULOSKELETAL_DISORDER) {
        this.MUSCULOSKELETAL_DISORDER = MUSCULOSKELETAL_DISORDER;
    }

    public boolean isIMPAIRED_WORK_ABILITY() {
        return IMPAIRED_WORK_ABILITY;
    }

    public void setIMPAIRED_WORK_ABILITY(boolean IMPAIRED_WORK_ABILITY) {
        this.IMPAIRED_WORK_ABILITY = IMPAIRED_WORK_ABILITY;
    }

    public boolean isARTHRITIS_BACTERIAL() {
        return ARTHRITIS_BACTERIAL;
    }

    public void setARTHRITIS_BACTERIAL(boolean ARTHRITIS_BACTERIAL) {
        this.ARTHRITIS_BACTERIAL = ARTHRITIS_BACTERIAL;
    }

    public boolean isSTROKE() {
        return STROKE;
    }

    public void setSTROKE(boolean STROKE) {
        this.STROKE = STROKE;
    }

    public boolean isCARDIOVASCULAR_FAILURE() {
        return CARDIOVASCULAR_FAILURE;
    }

    public void setCARDIOVASCULAR_FAILURE(boolean CARDIOVASCULAR_FAILURE) {
        this.CARDIOVASCULAR_FAILURE = CARDIOVASCULAR_FAILURE;
    }

    public boolean isHEART_RATE_INCREASED() {
        return HEART_RATE_INCREASED;
    }

    public void setHEART_RATE_INCREASED(boolean HEART_RATE_INCREASED) {
        this.HEART_RATE_INCREASED = HEART_RATE_INCREASED;
    }

    public boolean isCORONARY_ARTERY_DISEASE() {
        return CORONARY_ARTERY_DISEASE;
    }

    public void setCORONARY_ARTERY_DISEASE(boolean CORONARY_ARTERY_DISEASE) {
        this.CORONARY_ARTERY_DISEASE = CORONARY_ARTERY_DISEASE;
    }

    public boolean isTACHYCARDIA() {
        return TACHYCARDIA;
    }

    public void setTACHYCARDIA(boolean TACHYCARDIA) {
        this.TACHYCARDIA = TACHYCARDIA;
    }

    public boolean isSUDDEN_CARDIAC_ARREST() {
        return SUDDEN_CARDIAC_ARREST;
    }

    public void setSUDDEN_CARDIAC_ARREST(boolean SUDDEN_CARDIAC_ARREST) {
        this.SUDDEN_CARDIAC_ARREST = SUDDEN_CARDIAC_ARREST;
    }

    public boolean isPALPITATIONS() {
        return PALPITATIONS;
    }

    public void setPALPITATIONS(boolean PALPITATIONS) { this.PALPITATIONS = PALPITATIONS; }

    public boolean isMYOCARDIAL_INFRACTION() {
        return MYOCARDIAL_INFRACTION;
    }

    public void setMYOCARDIAL_INFRACTION(boolean MYOCARDIAL_INFRACTION) { this.MYOCARDIAL_INFRACTION = MYOCARDIAL_INFRACTION; }

    public boolean isANAPHYLACTIC_SHOCK() {
        return ANAPHYLACTIC_SHOCK;
    }

    public void setANAPHYLACTIC_SHOCK(boolean ANAPHYLACTIC_SHOCK) { this.ANAPHYLACTIC_SHOCK = ANAPHYLACTIC_SHOCK; }

    public boolean isANAPHYLACTIC_REACTION() {
        return ANAPHYLACTIC_REACTION;
    }

    public void setANAPHYLACTIC_REACTION(boolean ANAPHYLACTIC_REACTION) {
        this.ANAPHYLACTIC_REACTION = ANAPHYLACTIC_REACTION;
    }

    public boolean isAPHASIA() {
        return APHASIA;
    }

    public void setAPHASIA(boolean APHASIA) {
        this.APHASIA = APHASIA;
    }

    public boolean isHEADACHE() {
        return HEADACHE;
    }

    public void setHEADACHE(boolean HEADACHE) {
        this.HEADACHE = HEADACHE;
    }

    public boolean isDIZZINESS() {
        return DIZZINESS;
    }

    public void setDIZZINESS(boolean DIZZINESS) {
        this.DIZZINESS = DIZZINESS;
    }

    public boolean isHYPERHIDROSIS() {
        return HYPERHIDROSIS;
    }

    public void setHYPERHIDROSIS(boolean HYPERHIDROSIS) {
        this.HYPERHIDROSIS = HYPERHIDROSIS;
    }

    public boolean isBLEPHAROSPASM() {
        return BLEPHAROSPASM;
    }

    public void setBLEPHAROSPASM(boolean BLEPHAROSPASM) {
        this.BLEPHAROSPASM = BLEPHAROSPASM;
    }

    public boolean isPARAESTHESIA() {
        return PARAESTHESIA;
    }

    public void setPARAESTHESIA(boolean PARAESTHESIA) {
        this.PARAESTHESIA = PARAESTHESIA;
    }

    public boolean isEPISTAXIS() {
        return EPISTAXIS;
    }

    public void setEPISTAXIS(boolean EPISTAXIS) {
        this.EPISTAXIS = EPISTAXIS;
    }

    public boolean isSARS_CoV_2_TEST_POSITIVE() {
        return SARS_CoV_2_TEST_POSITIVE;
    }

    public void setSARS_CoV_2_TEST_POSITIVE(boolean SARS_CoV_2_TEST_POSITIVE) {
        this.SARS_CoV_2_TEST_POSITIVE = SARS_CoV_2_TEST_POSITIVE;
    }

    public boolean isPYREXIA() {
        return PYREXIA;
    }

    public void setPYREXIA(boolean PYREXIA) {
        this.PYREXIA = PYREXIA;
    }

    public boolean isBODY_TEMPERATURE_INCREASED() {
        return BODY_TEMPERATURE_INCREASED;
    }

    public void setBODY_TEMPERATURE_INCREASED(boolean BODY_TEMPERATURE_INCREASED) {
        this.BODY_TEMPERATURE_INCREASED = BODY_TEMPERATURE_INCREASED;
    }

    public boolean isFEBRILE_CONVULSION() {
        return FEBRILE_CONVULSION;
    }

    public void setFEBRILE_CONVULSION(boolean FEBRILE_CONVULSION) {
        this.FEBRILE_CONVULSION = FEBRILE_CONVULSION;
    }

    public boolean isHOT_FLUSH() {
        return HOT_FLUSH;
    }

    public void setHOT_FLUSH(boolean HOT_FLUSH) {
        this.HOT_FLUSH = HOT_FLUSH;
    }

    public boolean isBODY_TEMPERATURE_DECREASED() {
        return BODY_TEMPERATURE_DECREASED;
    }

    public void setBODY_TEMPERATURE_DECREASED(boolean BODY_TEMPERATURE_DECREASED) {
        this.BODY_TEMPERATURE_DECREASED = BODY_TEMPERATURE_DECREASED;
    }

    public boolean isPARALYSIS() {
        return PARALYSIS;
    }

    public void setPARALYSIS(boolean PARALYSIS) {
        this.PARALYSIS = PARALYSIS;
    }

    public boolean isPALLOR() {
        return PALLOR;
    }

    public void setPALLOR(boolean PALLOR) {
        this.PALLOR = PALLOR;
    }

    public boolean isSTILLBIRTH() {
        return STILLBIRTH;
    }

    public void setSTILLBIRTH(boolean STILLBIRTH) {
        this.STILLBIRTH = STILLBIRTH;
    }

    public boolean isFOETAL_DEATH() {
        return FOETAL_DEATH;
    }

    public void setFOETAL_DEATH(boolean FOETAL_DEATH) {
        this.FOETAL_DEATH = FOETAL_DEATH;
    }

    public boolean isDEATH() {
        return DEATH;
    }

    public void setDEATH(boolean DEATH) {
        this.DEATH = DEATH;
    }

    public boolean isLYMPHADENOPATHY() {
        return LYMPHADENOPATHY;
    }

    public void setLYMPHADENOPATHY(boolean LYMPHADENOPATHY) {
        this.LYMPHADENOPATHY = LYMPHADENOPATHY;
    }

    public boolean isSEIZURE () {
        return SEIZURE ;
    }

    public void setSEIZURE (boolean SEIZURE ) {
        this.SEIZURE  = SEIZURE ;
    }

    public boolean isHERPES_ZOSTER() {
        return HERPES_ZOSTER;
    }

    public void setHERPES_ZOSTER(boolean HERPES_ZOSTER) {
        this.HERPES_ZOSTER = HERPES_ZOSTER;
    }

    public boolean isSLEEP_DISORDER() {
        return SLEEP_DISORDER;
    }

    public void setSLEEP_DISORDER(boolean SLEEP_DISORDER) {
        this.SLEEP_DISORDER = SLEEP_DISORDER;
    }

    public boolean isHIPERSOMNIA() {
        return HIPERSOMNIA;
    }

    public void setHIPERSOMNIA(boolean HIPERSOMNIA) {
        this.HIPERSOMNIA = HIPERSOMNIA;
    }

    public boolean isANXIETY() {
        return ANXIETY;
    }

    public void setANXIETY(boolean ANXIETY) {
        this.ANXIETY = ANXIETY;
    }

    public boolean isINFLUENZA() {
        return INFLUENZA;
    }

    public void setINFLUENZA(boolean INFLUENZA) {
        this.INFLUENZA = INFLUENZA;
    }

    public boolean isBLURRED_VISION() {
        return BLURRED_VISION;
    }

    public void setBLURRED_VISION(boolean BLURRED_VISION) {
        this.BLURRED_VISION = BLURRED_VISION;
    }

    public boolean isBLINDNESS() {
        return BLINDNESS;
    }

    public void setBLINDNESS(boolean BLINDNESS) {
        this.BLINDNESS = BLINDNESS;
    }

    public boolean isDYSPHONIA() {
        return DYSPHONIA;
    }

    public void setDYSPHONIA(boolean DYSPHONIA) {
        this.DYSPHONIA = DYSPHONIA;
    }

    public boolean isSPASM() {
        return SPASM;
    }

    public void setSPASM(boolean SPASM) {
        this.SPASM = SPASM;
    }

    public boolean isHAEMORRHAGE() {
        return HAEMORRHAGE;
    }

    public void setHAEMORRHAGE(boolean HAEMORRHAGE) {
        this.HAEMORRHAGE = HAEMORRHAGE;
    }

    public boolean isHEARING_IMPAIRMENT() {
        return HEARING_IMPAIRMENT;
    }

    public void setHEARING_IMPAIRMENT(boolean HEARING_IMPAIRMENT) {
        this.HEARING_IMPAIRMENT = HEARING_IMPAIRMENT;
    }

    public boolean isDEAFNESS() {
        return DEAFNESS;
    }

    public void setDEAFNESS(boolean DEAFNESS) {
        this.DEAFNESS = DEAFNESS;
    }

    public boolean isSEPSIS() {
        return SEPSIS;
    }

    public void setSEPSIS(boolean SEPSIS) {
        this.SEPSIS = SEPSIS;
    }

    public boolean isVARICELLA () {
        return VARICELLA ;
    }


    public void setVARICELLA (boolean VARICELLA ) {
        this.VARICELLA  = VARICELLA ;
    }


    public boolean isPERICARDITIS () {
        return PERICARDITIS;
    }

    public void setPERICARDITIS (boolean PERICARDITIS ) {
        this.PERICARDITIS  = PERICARDITIS;
    }

    public boolean isAMYOTROPHY () {
        return AMYOTROPHY;
    }

    public void setAMYOTROPHY (boolean AMYOTROPHY ) {
        this.AMYOTROPHY  = AMYOTROPHY;
    }

    public boolean isSENSORY_LOSS () {
        return SENSORY_LOSS;
    }

    public void setSENSORY_LOSS (boolean SENSORY_LOSS ) {
        this.SENSORY_LOSS  = SENSORY_LOSS;
    }

    public boolean isDECREASED_APPETITE () {
        return DECREASED_APPETITE;
    }

    public void setDECREASED_APPETITE (boolean DECREASED_APPETITE ) {
        this.DECREASED_APPETITE = DECREASED_APPETITE;
    }

    public boolean isCHANGE_IN_BLOOD_COUNT () {
        return CHANGE_IN_BLOOD_COUNT;
    }

    public void setCHANGE_IN_BLOOD_COUNT (boolean CHANGE_IN_BLOOD_COUNT ) {
        this.CHANGE_IN_BLOOD_COUNT  = CHANGE_IN_BLOOD_COUNT;
    }

    public boolean isOXYGEN_SATURATION_DECREASED () {
        return OXYGEN_SATURATION_DECREASED;
    }

    public void setOXYGEN_SATURATION_DECREASED (boolean OXYGEN_SATURATION_DECREASED ) {
        this.OXYGEN_SATURATION_DECREASED  = OXYGEN_SATURATION_DECREASED;
    }


    @Override
    public String toString() {
        return "Symptom{" +
                "SYMPTOM_ID=" + SYMPTOM_ID +
                ", RESPIRATORY_SYSTEM_DISEASES=" + RESPIRATORY_SYSTEM_DISEASES +
                ", APPENDICITIS=" + APPENDICITIS +
                ", DYSPHAGIA=" + DYSPHAGIA +
                ", THROAT_TIGHTNESS=" + THROAT_TIGHTNESS +
                ", THROAT_IRRITATION=" + THROAT_IRRITATION +
                ", DYSPNOEA=" + DYSPNOEA +
                ", COUGH=" + COUGH +
                ", CHEST_DISCOMFORT=" + CHEST_DISCOMFORT +
                ", RESPIRATORY_DISTRESS=" + RESPIRATORY_DISTRESS +
                ", ANOEA=" + ANOEA +
                ", STRIDOR=" + STRIDOR +
                ", WHEEZING=" + WHEEZING +
                ", TACHYPNOE=" + TACHYPNOE +
                ", SHORTNESS_OF_BREATH=" + SHORTNESS_OF_BREATH +
                ", NAUSEA=" + NAUSEA +
                ", VOMITING=" + VOMITING +
                ", DIARRHOEA=" + DIARRHOEA +
                ", CHILLS=" + CHILLS +
                ", TREMOR=" + TREMOR +
                ", FATIGUE=" + FATIGUE +
                ", FEELING_ABNORMAL=" + FEELING_ABNORMAL +
                ", MYALGIA=" + MYALGIA +
                ", BODY_ACHE=" + BODY_ACHE +
                ", SWELLING=" + SWELLING +
                ", BLOOD_PRESSURE_INCREASED=" + BLOOD_PRESSURE_INCREASED +
                ", BLOOD_PRESSURE_DECREASED=" + BLOOD_PRESSURE_DECREASED +
                ", LOSS_OF_CONSCIOUSNESS=" + LOSS_OF_CONSCIOUSNESS +
                ", MUSCULOSKELETAL_DISORDER=" + MUSCULOSKELETAL_DISORDER +
                ", IMPAIRED_WORK_ABILITY=" + IMPAIRED_WORK_ABILITY +
                ", ARTHRITIS_BACTERIAL=" + ARTHRITIS_BACTERIAL +
                ", STROKE=" + STROKE +
                ", CARDIOVASCULAR_FAILURE=" + CARDIOVASCULAR_FAILURE +
                ", HEART_RATE_INCREASED=" + HEART_RATE_INCREASED +
                ", CORONARY_ARTERY_DISEASE=" + CORONARY_ARTERY_DISEASE +
                ", TACHYCARDIA=" + TACHYCARDIA +
                ", SUDDEN_CARDIAC_ARREST=" + SUDDEN_CARDIAC_ARREST +
                ", PALPITATIONS=" + PALPITATIONS +
                ", MYOCARDIAL_INFRACTION=" + MYOCARDIAL_INFRACTION +
                ", ANAPHYLACTIC_SHOCK=" + ANAPHYLACTIC_SHOCK +
                ", ANAPHYLACTIC_REACTION=" + ANAPHYLACTIC_REACTION +
                ", APHASIA=" + APHASIA +
                ", HEADACHE=" + HEADACHE +
                ", DIZZINESS=" + DIZZINESS +
                ", HYPERHIDROSIS=" + HYPERHIDROSIS +
                ", BLEPHAROSPASM=" + BLEPHAROSPASM +
                ", PARAESTHESIA=" + PARAESTHESIA +
                ", EPISTAXIS=" + EPISTAXIS +
                ", SARS_CoV_2_TEST_POSITIVE=" + SARS_CoV_2_TEST_POSITIVE +
                ", PYREXIA=" + PYREXIA +
                ", BODY_TEMPERATURE_INCREASED=" + BODY_TEMPERATURE_INCREASED +
                ", FEBRILE_CONVULSION=" + FEBRILE_CONVULSION +
                ", HOT_FLUSH=" + HOT_FLUSH +
                ", BODY_TEMPERATURE_DECREASED=" + BODY_TEMPERATURE_DECREASED +
                ", PARALYSIS=" + PARALYSIS +
                ", PALLOR=" + PALLOR +
                ", STILLBIRTH=" + STILLBIRTH +
                ", FOETAL_DEATH=" + FOETAL_DEATH +
                ", DEATH=" + DEATH +
                ", LYMPHADENOPATHY=" + LYMPHADENOPATHY +
                ", SEIZURE=" + SEIZURE +
                ", HERPES_ZOSTER=" + HERPES_ZOSTER +
                ", SLEEP_DISORDER=" + SLEEP_DISORDER +
                ", HIPERSOMNIA=" + HIPERSOMNIA +
                ", ANXIETY=" + ANXIETY +
                ", INFLUENZA=" + INFLUENZA +
                ", BLURRED_VISION=" + BLURRED_VISION +
                ", BLINDNESS=" + BLINDNESS +
                ", DYSPHONIA=" + DYSPHONIA +
                ", SPASM=" + SPASM  +
                ", HAEMORRHAGE=" + HAEMORRHAGE +
                ", HEARING_IMPAIRMENT=" + HEARING_IMPAIRMENT +
                ", DEAFNESS=" + DEAFNESS +
                ", SEPSIS=" + SEPSIS +
                ", VARICELLA=" + VARICELLA +
                ", PERICARDITIS=" + PERICARDITIS +
                ", AMYOTROPHY=" + AMYOTROPHY +
                ", SENSORY LOSS=" + SENSORY_LOSS +
                ", DECREASED APPETITE=" + DECREASED_APPETITE +
                ", CHANGE IN BLOOD COUNT=" + CHANGE_IN_BLOOD_COUNT +
                ", OXYGEN_SATURATION_DECREASED=" + OXYGEN_SATURATION_DECREASED +
                ", OTHER='" + OTHER + '\'' +
                '}';
    }
}

