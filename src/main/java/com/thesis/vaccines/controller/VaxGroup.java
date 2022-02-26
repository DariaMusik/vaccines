package com.thesis.vaccines.controller;

import java.util.HashMap;
import java.util.Map;

public class VaxGroup {
    private String type;
    private Map<String, Integer> symptomCounter = new HashMap<String, Integer>();
    private String commonSymptom;

    public VaxGroup() {
        symptomCounter.put("RESPIRATORY_SYSTEM_DISEASES",0);
        symptomCounter.put("APPENDICITIS",0);
        symptomCounter.put("DYSPHAGIA,SWALLOWING_DISORDERS",0);
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
        symptomCounter.put("SARS_CoV_2_TEXT_POSITIVE",0);
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
        symptomCounter.put("DECREASED APPETITE",0);
        symptomCounter.put("CHANGE_IN_BLOOD_COUNT",0);
        symptomCounter.put("OXYGEN_SATURATION_DECREASED",0);
    }

    public VaxGroup(String type, String commonSymptom){
        this.type = type;
        this.commonSymptom = commonSymptom;
    }

    public VaxGroup(String type) {
        this.type = type;
        symptomCounter.put("RESPIRATORY_SYSTEM_DISEASES",0);
        symptomCounter.put("APPENDICITIS",0);
        symptomCounter.put("DYSPHAGIA,SWALLOWING_DISORDERS",0);
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
        symptomCounter.put("SARS_CoV_2_TEXT_POSITIVE",0);
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
        symptomCounter.put("DECREASED APPETITE",0);
        symptomCounter.put("CHANGE_IN_BLOOD_COUNT",0);
        symptomCounter.put("OXYGEN_SATURATION_DECREASED",0);
    }

    public void mostCommonSymptom() {
        String theMostCommonSymptom = "lack";
        int value = 0;
        for (Map.Entry<String, Integer> map: this.symptomCounter.entrySet()) {
            if (map.getValue() > value){
                theMostCommonSymptom = map.getKey();
                value = map.getValue();
            }
        }
        this.commonSymptom = theMostCommonSymptom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Integer> getSymptomCounter() {
        return symptomCounter;
    }

    public void setSymptomCounter(Map<String, Integer> symptomCounter) {
        this.symptomCounter = symptomCounter;
    }

    public String getCommonSymptom() {
        return commonSymptom;
    }

    public void setCommonSymptom(String commonSymptom) {
        this.commonSymptom = commonSymptom;
    }
}
