package com.thesis.vaccines;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.thesis.vaccines.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {

    public static Date formatDate(Date inputDate) throws ParseException {
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(inputDate);
        Date date = sm.parse(strDate);
        return date;
    }

    public static List<Notification> parsNotificationData(String dataFileName, String vaxFileName) throws IOException, CsvException {
        List<Notification> notifications = new CsvToBeanBuilder(new FileReader(dataFileName))
                .withType(Notification.class)
                .build()
                .parse();

        try (BufferedReader br = new BufferedReader(new FileReader(vaxFileName))) {
            br.readLine();
            for (Notification notification : notifications) {
                String line = br.readLine();
                String[] split = line.split(",");
                notification.setTYPE_OF_VACCINE(split[2]);

                if (notification.getDIED() != 'Y')
                    notification.setDIED('N');

                try {
                    notification.setRPT_DATE(formatDate(notification.getRPT_DATE()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return notifications;
    }

    public static List<Patient> parsPatientData(String fileName) throws IOException, CsvException{
        List<Patient> patients = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Patient.class)
                .build()
                .parse();
        return patients;
    }

    public static List<Symptom> parsSymptomData(String fileName) throws IOException{
        List<Symptom> symptoms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            while (br.readLine() != null){
                Symptom symptom = new Symptom();
                String line = br.readLine().toLowerCase();
                System.out.println("line: " + line);
                String[] split = line.split(",");
                for (int i = 1; i < split.length; i+=2) {
                    if(split[i].matches("(.*)allergic alveolitis(.*)") || split[i].matches("(.*)beryllium(.*)") || split[i].matches("(.*)central sleep apnea(.*)") || split[i].matches("(.*)interstitial lung disease related to bronchiolitis(.*)") || split[i].matches("(.*)exfoliating interstitial pneumonia(.*)") || split[i].matches("(.*)pulmonary eosinophils(.*)") || split[i].matches("(.*)papular bronchiolitis(.*)") || split[i].matches("(.*)tuberculosis(.*)") || split[i].matches("(.*)influenza pneumonia(.*)") || split[i].matches("(.*)idiopathic pulmonary fibrosis(.*)") || split[i].matches("(.*)lung infiltration(.*)") || split[i].matches("(.*)lung consolidation(.*)") || split[i].matches("(.*)cryptogenic organizing pneumonia(.*)") || split[i].matches("(.*)whooping cough(.*)") || split[i].matches("(.*)sputum culture(.*)") || split[i].matches("(.*)lymphangioleiomimatosis(.*)") || split[i].matches("(.*)lymphocyte interstitial pneumonia(.*)") || split[i].matches("(.*)non-specific interstitial pneumonia(.*)") || split[i].matches("(.*)obstructive sleep apnea(.*)") || split[i].matches("(.*)pneumothorax(.*)") || split[i].matches("(.*)scute respiratory failure(.*)") || split[i].matches("(.*)acute interstitial pneumonia(.*)") || split[i].matches("(.*)acute bronchiolitis(.*)") || split[i].matches("(.*)pulmonary form of Langerhans cell histiocytosis(.*)") || split[i].matches("(.*)pneumococcal pneumonia(.*)") || split[i].matches("(.*)alveolar proteinosis(.*)") || split[i].matches("(.*)lung congestion(.*)") || split[i].matches("(.*)chronic respiratory failure(.*)") || split[i].matches("(.*)diffuse bronchiolitis(.*)") || split[i].matches("(.*)spontaneous pleural-interstitial fibroelastosis(.*)") || split[i].matches("(.*)sarcoidosis(.*)") || split[i].matches("(.*)bronchitis(.*)")  || split[i].matches("(.*)inflammation of the respiratory bronchioles(.*)") || split[i].matches("(.*)pneumonia(.*)") || split[i].matches("(.*)obstructive bronchiolitis(.*)") || split[i].matches("(.*)hypoventilation and hypoxemia syndromes during sleep(.*)") || split[i].matches("(.*)cloudy lungs(.*)") || split[i].matches("(.*)interstitial pneumonia(.*)")){
                        symptom.setRESPIRATORY_SYSTEM_DISEASES(true);
                    }
                    if(split[i].matches("(.*)appendic(.*)")){
                        symptom.setAPPENDICITIS(true);
                    }
                    if(split[i].matches("(.*)dysphagia(.*)") || split[i].matches("(.*)swallowing disorder(.*)")){
                        symptom.setDYSPHAGIA(true);
                    }
                    if(split[i].matches("(.*)throat tightness(.*)")) {
                        symptom.setTHROAT_TIGHTNESS(true);
                    }
                    if(split[i].matches("(.*)throat irritation(.*)")) {
                        symptom.setTHROAT_IRRITATION(true);
                    }
                    if(split[i].matches("(.*)dysponea(.*)")){
                        symptom.setDYSPNOEA(true);
                    }
                    if(split[i].matches("(.*)cough(.*)")){
                        symptom.setCOUGH(true);
                    }
                    if(split[i].matches("(.*)Chest discomfort(.*)")){
                        symptom.setCHEST_DISCOMFORT(true);
                    }
                    if(split[i].matches("(.*)respiratory distress(.*)")) {
                        symptom.setRESPIRATORY_DISTRESS(true);
                    }
                    if(split[i].matches("(.*)anoea(.*)")) {
                        symptom.setANOEA(true);
                    }
                    if(split[i].matches("(.*)stridor(.*)")) {
                        symptom.setSTRIDOR(true);
                    }
                    if(split[i].matches("(.*)wheezing(.*)"))  {
                        symptom.setWHEEZING(true);
                    }
                    if(split[i].matches("(.*)tachypnoe(.*)") || split[i].matches("(.*)respiratory rate increased(.*)"))  {
                        symptom.setTACHYPNOE(true);
                    }
                    if(split[i].matches("(.*)shortness of breath(.*)"))  {
                        symptom.setSHORTNESS_OF_BREATH(true);
                    }
                    if(split[i].matches("(.*)nausea(.*)") || split[i].matches("(.*)sickness(.*)") || split[i].matches("(.*)retch(.*)") || split[i].matches("(.*)heave(.*)") || split[i].matches("(.*)qualm(.*)") || split[i].matches("(.*)queasiness(.*)"))  {
                        symptom.setNAUSEA(true);
                    }
                    if(split[i].matches("(.*)vomiting(.*)")) {
                        symptom.setVOMITING(true);
                    }
                    if(split[i].matches("(.*)diarrhoea(.*)")) {
                        symptom.setDIARRHOEA(true);
                    }
                    if(split[i].matches("(.*)chills(.*)")) {
                        symptom.setCHILLS(true);
                    }
                    if(split[i].matches("(.*)tremor(.*)")|| split[i].matches("(.*)twitching(.*)")) {
                        symptom.setCHILLS(true);
                    }
                    if(split[i].matches("(.*)fatigue(.*)") || split[i].matches("(.*)malaise(.*)") || split[i].matches("(.*)asthenia(.*)")) {
                        symptom.setFATIGUE(true);
                    }
                    if(split[i].matches("(.*)feeling abnormal(.*)")){
                        symptom.setFEELING_ABNORMAL(true);
                    }
                    if (split[i].matches("(.*)myalgia(.*)") || split[i].matches("(.*)musculoskeletal(.*)")) {
                        symptom.setMYALGIA(true);
                    }
                    if (split[i].matches("(.*)pain(.*)") || split[i].matches("(.*)arthralgia(.*)") || split[i].matches("(.*)radiculitis brachial(.*)")) {
                        symptom.setBODY_ACHE(true);
                    }
                    if(split[i].matches("(.*)swelling(.*)") || split[i].matches("(.*)peripheral swelling(.*)") || split[i].matches("(.*)pharyngeal swelling(.*)") || split[i].matches("(.*)swelling face(.*)") || split[i].matches("(.*)lip swelling(.*)")) {
                        symptom.setSWELLING(true);
                    }
                    if(split[i].matches("(.*)blood pressure increased(.*)") || split[i].matches("(.*)blood pressure diastolic increased(.*)") || split[i].matches("(.*)blood pressure systolic increased(.*)")) {
                        symptom.setBLOOD_PRESSURE_INCREASED(true);
                    }
                    if(split[i].matches("(.*)Blood pressure decreased(.*)")) {
                        symptom.setBLOOD_PRESSURE_DECREASED(true);
                    }
                    if(split[i].matches("(.*)loss of consciousness(.*)") || split[i].matches("(.*)syncope(.*)")) {
                        symptom.setLOSS_OF_CONSCIOUSNESS(true);
                    }
                    if(split[i].matches("(.*)musculoskeletal disorder(.*)") || split[i].matches("(.*)mobility decreased(.*)") || split[i].matches("(.*)gait disturbance(.*)") || split[i].matches("(.*)balance disorder(.*)") || split[i].matches("(.*)musculoskeletal(.*)") || split[i].matches("(.*)ataxia(.*)") || split[i].matches("(.*)impaired work ability(.*)") || split[i].matches("(.*)arthritis bacterial(.*)") || split[i].matches("(.*)joint range of motion decreased(.*)") || split[i].matches("(.*)complex regional pain syndrome(.*)") || split[i].matches("(.*)muscular weakness(.*)")) {
                        symptom.setMUSCULOSKELETAL_DISORDER(true);
                    }
                    if(split[i].matches("(.*)impaired work ability(.*)")) {
                        symptom.setIMPAIRED_WORK_ABILITY(true);
                    }
                    if(split[i].matches("(.*)arthritis bacterial(.*)")) {
                        symptom.setARTHRITIS_BACTERIAL(true);
                    }
                    if(split[i].matches("(.*)stroke(.*)") || split[i].matches("(.*)cerebrovascular accident(.*)")) {
                        symptom.setSTROKE(true);
                    }
                    if(split[i].matches("(.*)cardiovascular failure(.*)")) {
                        symptom.setCARDIOVASCULAR_FAILURE(true);
                    }
                    if(split[i].matches("(.*)heart rate increased(.*)")) {
                        symptom.setHEART_RATE_INCREASED(true);
                    }
                    if(split[i].matches("(.*)coronary artery disease(.*)")) {
                        symptom.setCORONARY_ARTERY_DISEASE(true);
                    }
                    if(split[i].matches("(.*)tachycardia(.*)")) {
                        symptom.setTACHYCARDIA(true);
                    }
                    if(split[i].matches("(.*)sudden cardiac arrest(.*)")  || split[i].matches("(.*)cardiac arrest(.*)")) {
                        symptom.setSUDDEN_CARDIAC_ARREST(true);
                    }
                    if(split[i].matches("(.*)palpitations(.*)")) {
                        symptom.setPALPITATIONS(true);
                    }
                    if(split[i].matches("(.*)myocardial infarction(.*)")) {
                        symptom.setMYOCARDIAL_INFRACTION(true);
                    }
                    if(split[i].matches("(.*)anaphylactic shock(.*)")) {
                        symptom.setANAPHYLACTIC_SHOCK(true);
                    }
                    if(split[i].matches("(.*)erythema(.*)") || split[i].matches("(.*)pruritus(.*)") || split[i].matches("(.*)urticaria(.*)") || split[i].matches("(.*)rush macular(.*)") || split[i].matches("(.*)rash(.*)") || split[i].matches("(.*)itching(.*)") || split[i].matches("(.*)redness(.*)")) {
                        symptom.setANAPHYLACTIC_REACTION(true);
                    }
                    if(split[i].matches("(.*)aphasia(.*)") || split[i].matches("(.*)speech disorder(.*)")) {
                        symptom.setAPHASIA(true);
                    }
                    if(split[i].matches("(.*)headache(.*)") || split[i].matches("(.*)migraine(.*)")) {
                        symptom.setHEADACHE(true);
                    }
                    if(split[i].matches("(.*)dizziness(.*)")) {
                        symptom.setDIZZINESS(true);
                    }
                    if(split[i].matches("(.*)hyperhidrosis(.*)")) {
                        symptom.setHYPERHIDROSIS(true);
                    }
                    if(split[i].matches("(.*)blepharospasm(.*)")) {
                        symptom.setBLEPHAROSPASM(true);
                    }
                    if(split[i].matches("(.*)paraesthesia(.*)")) {
                        symptom.setPARAESTHESIA(true);
                    }
                    if(split[i].matches("(.*)epistaxis(.*)")) {
                        symptom.setEPISTAXIS(true);
                    }
                    if(split[i].matches("(.*)sars-cov-2 test positive(.*)")) {
                        symptom.setSARS_CoV_2_TEST_POSITIVE(true);
                    }
                    if(split[i].matches("(.*)pyrexia(.*)") || split[i].matches("(.*)fever(.*)")) {
                        symptom.setPYREXIA(true);
                    }
                    if(split[i].matches("(.*)body temperature increased(.*)")) {
                        symptom.setBODY_TEMPERATURE_INCREASED(true);
                    }
                    if(split[i].matches("(.*)febrile convulsion(.*)")) {
                        symptom.setFEBRILE_CONVULSION(true);
                    }
                    if(split[i].matches("(.*)hot flush(.*)")) {
                        symptom.setHOT_FLUSH(true);
                    }
                    if(split[i].matches("(.*)body temperature decreased(.*)")) {
                        symptom.setBODY_TEMPERATURE_DECREASED(true);
                    }
                    if(split[i].matches("(.*)paralysis(.*)") || split[i].matches("(.*)facial paralysis(.*)")) {
                        symptom.setPARALYSIS(true);
                    }
                    if(split[i].matches("(.*)pallor(.*)") || split[i].matches("(.*)paleness(.*)") || split[i].matches("(.*)wanness(.*)")) {
                        symptom.setPALLOR(true);
                    }
                    if(split[i].matches("(.*)stillbirth(.)") || split[i].matches("(.*)foetal death(.*)")) {
                        symptom.setSTILLBIRTH(true);
                    }
                    if(split[i].matches("(.*)foetal death(.)")) {
                        symptom.setFOETAL_DEATH(true);
                    }
                    if(split[i].matches("(.*)death(.)")) {
                        symptom.setDEATH(true);
                    }
                    if(split[i].matches("(.*)lymphadenopathy(.)")) {
                        symptom.setLYMPHADENOPATHY(true);
                    }
                    if(split[i].matches("(.*)seizure(.)")) {
                        symptom.setSEIZURE(true);
                    }
                    if(split[i].matches("(.*)herpes_zoster(.)")) {
                        symptom.setHERPES_ZOSTER(true);
                    }
                    if(split[i].matches("(.*)sleep disorder(.)")) {
                        symptom.setSLEEP_DISORDER(true);
                    }
                    if(split[i].matches("(.*)hipersomnia(.)")) {
                        symptom.setHIPERSOMNIA(true);
                    }
                    if(split[i].matches("(.*)anxiety(.)")) {
                        symptom.setANXIETY(true);
                    }
                    if(split[i].matches("(.*)influenza(.)")) {
                        symptom.setINFLUENZA(true);
                    }
                    if(split[i].matches("(.*)blurred_vision(.)") || split[i].matches("(.*)eyelid function disorder(.*)") || split[i].matches("(.*)tunnel vision(.*)")) {
                        symptom.setBLURRED_VISION(true);
                    }
                    if(split[i].matches("(.*)blindness(.)")) {
                        symptom.setBLINDNESS(true);
                    }
                    if(split[i].matches("(.*)dysphonia(.)")) {
                        symptom.setDYSPHONIA(true);
                    }
                    if(split[i].matches("(.*)spasm(.)")) {
                        symptom.setSPASM(true);
                    }
                    if(split[i].matches("(.*)haemorrhage(.)") || split[i].matches("(.*)eye haemorrhage(.*)")) {
                        symptom.setHAEMORRHAGE(true);
                    }
                    if(split[i].matches("(.*)hearing impairment(.)") || split[i].matches("(.*)deafness unilateral(.*)") || split[i].matches("(.*)deafness(.*)") || split[i].matches("(.*)tonnitus(.*)") || split[i].matches("(.*)hypoacusis(.*)")) {
                        symptom.setHEARING_IMPAIRMENT(true);
                    }
                    if(split[i].matches("(.*)deafness(.)")) {
                        symptom.setDEAFNESS(true);
                    }
                    if(split[i].matches("(.*)sepsis(.)")) {
                        symptom.setSEPSIS(true);
                    }
                    if(split[i].matches("(.*)varicella(.)")) {
                        symptom.setVARICELLA(true);
                    }
                    if(split[i].matches("(.*)pericarditis(.)")) {
                        symptom.setPERICARDITIS(true);
                    }
                    if(split[i].matches("(.*)amyotrophy(.)")) {
                        symptom.setAMYOTROPHY(true);
                    }
                    if(split[i].matches("(.*)sensory loss(.)")) {
                        symptom.setSENSORY_LOSS(true);
                    }
                    if(split[i].matches("(.*)decreased appetite(.)")) {
                        symptom.setDECREASED_APPETITE(true);
                    }
                    if(split[i].matches("(.*)anion gap decreased(.)") || split[i].matches("(.*)basophil percentage decreased(.*)") || split[i].matches("(.*)blood potassium decreased(.*)") || split[i].matches("(.*)carbon dioxide decreased(.*)") || split[i].matches("(.*)eosinophil count decreased(.*)") || split[i].matches("(.*)immature granulocyte count increased(.*)") || split[i].matches("(.*)lymphocyte count decreased(.*)") || split[i].matches("(.*)monocyte percentage decreased(.*)") || split[i].matches("(.*)neurophil percentage increased(.*)") || split[i].matches("(.*)red cell distribution width increased(.*)") || split[i].matches("(.*)band neutrophil percentage increased(.*)") || split[i].matches("(.*)white blood cell count increased(.*)") || split[i].matches("(.*)blood lactic acid(.*)") || split[i].matches("(.*)blood lactate dehydrogenase increased(.*)") || split[i].matches("(.*)serum ferritin increased(.*)")) {
                        symptom.setCHANGE_IN_BLOOD_COUNT(true);
                    }
                    if(split[i].matches("(.*)oxygen saturation decreased(.)")) {
                        symptom.setOXYGEN_SATURATION_DECREASED(true);
                    }
                }
                symptoms.add(symptom);
            }
        }
        return symptoms;
    }

    public static Symptom parsSymptomDataFromWeb(String dataFromForm){
        Symptom symptom = new Symptom();
        String line = dataFromForm.toLowerCase();
        if(line.matches("(.*)allergic alveolitis(.*)") || line.matches("(.*)beryllium(.*)") || line.matches("(.*)central sleep apnea(.*)") || line.matches("(.*)interstitial lung disease related to bronchiolitis(.*)") || line.matches("(.*)exfoliating interstitial pneumonia(.*)") || line.matches("(.*)pulmonary eosinophils(.*)") || line.matches("(.*)papular bronchiolitis(.*)") || line.matches("(.*)tuberculosis(.*)") || line.matches("(.*)influenza pneumonia(.*)") || line.matches("(.*)idiopathic pulmonary fibrosis(.*)") || line.matches("(.*)lung infiltration(.*)") || line.matches("(.*)lung consolidation(.*)") || line.matches("(.*)cryptogenic organizing pneumonia(.*)") || line.matches("(.*)whooping cough(.*)") || line.matches("(.*)sputum culture(.*)") || line.matches("(.*)lymphangioleiomimatosis(.*)") || line.matches("(.*)lymphocyte interstitial pneumonia(.*)") || line.matches("(.*)non-specific interstitial pneumonia(.*)") || line.matches("(.*)obstructive sleep apnea(.*)") || line.matches("(.*)pneumothorax(.*)") || line.matches("(.*)scute respiratory failure(.*)") || line.matches("(.*)acute interstitial pneumonia(.*)") || line.matches("(.*)acute bronchiolitis(.*)") || line.matches("(.*)pulmonary form of Langerhans cell histiocytosis(.*)") || line.matches("(.*)pneumococcal pneumonia(.*)") || line.matches("(.*)alveolar proteinosis(.*)") || line.matches("(.*)lung congestion(.*)") || line.matches("(.*)chronic respiratory failure(.*)") || line.matches("(.*)diffuse bronchiolitis(.*)") || line.matches("(.*)spontaneous pleural-interstitial fibroelastosis(.*)") || line.matches("(.*)sarcoidosis(.*)") || line.matches("(.*)bronchitis(.*)")  || line.matches("(.*)inflammation of the respiratory bronchioles(.*)") || line.matches("(.*)pneumonia(.*)") || line.matches("(.*)obstructive bronchiolitis(.*)") || line.matches("(.*)hypoventilation and hypoxemia syndromes during sleep(.*)") || line.matches("(.*)cloudy lungs(.*)") || line.matches("(.*)interstitial pneumonia(.*)")){
            symptom.setRESPIRATORY_SYSTEM_DISEASES(true);
        }
        if(line.matches("(.*)appendic(.*)")){
            symptom.setAPPENDICITIS(true);
        }
        if(line.matches("(.*)dysphagia(.*)") || line.matches("(.*)swallowing disorder(.*)")){
            symptom.setDYSPHAGIA(true);
        }
        if(line.matches("(.*)throat tightness(.*)")) {
            symptom.setTHROAT_TIGHTNESS(true);
        }
        if(line.matches("(.*)throat irritation(.*)")) {
            symptom.setTHROAT_IRRITATION(true);
        }
        if(line.matches("(.*)dysponea(.*)")){
            symptom.setDYSPNOEA(true);
        }
        if(line.matches("(.*)cough(.*)")){
            symptom.setCOUGH(true);
        }
        if(line.matches("(.*)Chest discomfort(.*)")){
            symptom.setCHEST_DISCOMFORT(true);
        }
        if(line.matches("(.*)respiratory distress(.*)")) {
            symptom.setRESPIRATORY_DISTRESS(true);
        }
        if(line.matches("(.*)anoea(.*)")) {
            symptom.setANOEA(true);
        }
        if(line.matches("(.*)stridor(.*)")) {
            symptom.setSTRIDOR(true);
        }
        if(line.matches("(.*)wheezing(.*)"))  {
            symptom.setWHEEZING(true);
        }
        if(line.matches("(.*)tachypnoe(.*)") || line.matches("(.*)respiratory rate increased(.*)"))  {
            symptom.setTACHYPNOE(true);
        }
        if(line.matches("(.*)shortness of breath(.*)"))  {
            symptom.setSHORTNESS_OF_BREATH(true);
        }
        if(line.matches("(.*)nausea(.*)") || line.matches("(.*)sickness(.*)") || line.matches("(.*)retch(.*)") || line.matches("(.*)heave(.*)") || line.matches("(.*)qualm(.*)") || line.matches("(.*)queasiness(.*)"))  {
            symptom.setNAUSEA(true);
        }
        if(line.matches("(.*)vomiting(.*)")) {
            symptom.setVOMITING(true);
        }
        if(line.matches("(.*)diarrhoea(.*)")) {
            symptom.setDIARRHOEA(true);
        }
        if(line.matches("(.*)chills(.*)")) {
            symptom.setCHILLS(true);
        }
        if(line.matches("(.*)tremor(.*)")|| line.matches("(.*)twitching(.*)")) {
            symptom.setCHILLS(true);
        }
        if(line.matches("(.*)fatigue(.*)") || line.matches("(.*)malaise(.*)") || line.matches("(.*)asthenia(.*)")) {
            symptom.setFATIGUE(true);
        }
        if(line.matches("(.*)feeling abnormal(.*)")){
            symptom.setFEELING_ABNORMAL(true);
        }
        if (line.matches("(.*)myalgia(.*)") || line.matches("(.*)musculoskeletal(.*)")) {
            symptom.setMYALGIA(true);
        }
        if (line.matches("(.*)pain(.*)") || line.matches("(.*)arthralgia(.*)") || line.matches("(.*)radiculitis brachial(.*)")) {
            symptom.setBODY_ACHE(true);
        }
        if(line.matches("(.*)swelling(.*)") || line.matches("(.*)peripheral swelling(.*)") || line.matches("(.*)pharyngeal swelling(.*)") || line.matches("(.*)swelling face(.*)") || line.matches("(.*)lip swelling(.*)")) {
            symptom.setSWELLING(true);
        }
        if(line.matches("(.*)blood pressure increased(.*)") || line.matches("(.*)blood pressure diastolic increased(.*)") || line.matches("(.*)blood pressure systolic increased(.*)")) {
            symptom.setBLOOD_PRESSURE_INCREASED(true);
        }
        if(line.matches("(.*)Blood pressure decreased(.*)")) {
            symptom.setBLOOD_PRESSURE_DECREASED(true);
        }
        if(line.matches("(.*)loss of consciousness(.*)") || line.matches("(.*)syncope(.*)")) {
            symptom.setLOSS_OF_CONSCIOUSNESS(true);
        }
        if(line.matches("(.*)musculoskeletal disorder(.*)") || line.matches("(.*)mobility decreased(.*)") || line.matches("(.*)gait disturbance(.*)") || line.matches("(.*)balance disorder(.*)") || line.matches("(.*)musculoskeletal(.*)") || line.matches("(.*)ataxia(.*)") || line.matches("(.*)impaired work ability(.*)") || line.matches("(.*)arthritis bacterial(.*)") || line.matches("(.*)joint range of motion decreased(.*)") || line.matches("(.*)complex regional pain syndrome(.*)") || line.matches("(.*)muscular weakness(.*)")) {
            symptom.setMUSCULOSKELETAL_DISORDER(true);
        }
        if(line.matches("(.*)impaired work ability(.*)")) {
            symptom.setIMPAIRED_WORK_ABILITY(true);
        }
        if(line.matches("(.*)arthritis bacterial(.*)")) {
            symptom.setARTHRITIS_BACTERIAL(true);
        }
        if(line.matches("(.*)stroke(.*)") || line.matches("(.*)cerebrovascular accident(.*)")) {
            symptom.setSTROKE(true);
        }
        if(line.matches("(.*)cardiovascular failure(.*)")) {
            symptom.setCARDIOVASCULAR_FAILURE(true);
        }
        if(line.matches("(.*)heart rate increased(.*)")) {
            symptom.setHEART_RATE_INCREASED(true);
        }
        if(line.matches("(.*)coronary artery disease(.*)")) {
            symptom.setCORONARY_ARTERY_DISEASE(true);
        }
        if(line.matches("(.*)tachycardia(.*)")) {
            symptom.setTACHYCARDIA(true);
        }
        if(line.matches("(.*)sudden cardiac arrest(.*)")  || line.matches("(.*)cardiac arrest(.*)")) {
            symptom.setSUDDEN_CARDIAC_ARREST(true);
        }
        if(line.matches("(.*)palpitations(.*)")) {
            symptom.setPALPITATIONS(true);
        }
        if(line.matches("(.*)myocardial infarction(.*)")) {
            symptom.setMYOCARDIAL_INFRACTION(true);
        }
        if(line.matches("(.*)anaphylactic shock(.*)")) {
            symptom.setANAPHYLACTIC_SHOCK(true);
        }
        if(line.matches("(.*)erythema(.*)") || line.matches("(.*)pruritus(.*)") || line.matches("(.*)urticaria(.*)") || line.matches("(.*)rush macular(.*)") || line.matches("(.*)rash(.*)") || line.matches("(.*)itching(.*)") || line.matches("(.*)redness(.*)")) {
            symptom.setANAPHYLACTIC_REACTION(true);
        }
        if(line.matches("(.*)aphasia(.*)") || line.matches("(.*)speech disorder(.*)")) {
            symptom.setAPHASIA(true);
        }
        if(line.matches("(.*)headache(.*)") || line.matches("(.*)migraine(.*)")) {
            symptom.setHEADACHE(true);
        }
        if(line.matches("(.*)dizziness(.*)")) {
            symptom.setDIZZINESS(true);
        }
        if(line.matches("(.*)hyperhidrosis(.*)")) {
            symptom.setHYPERHIDROSIS(true);
        }
        if(line.matches("(.*)blepharospasm(.*)")) {
            symptom.setBLEPHAROSPASM(true);
        }
        if(line.matches("(.*)paraesthesia(.*)")) {
            symptom.setPARAESTHESIA(true);
        }
        if(line.matches("(.*)epistaxis(.*)")) {
            symptom.setEPISTAXIS(true);
        }
        if(line.matches("(.*)sars-cov-2 test positive(.*)")) {
            symptom.setSARS_CoV_2_TEST_POSITIVE(true);
        }
        if(line.matches("(.*)pyrexia(.*)") || line.matches("(.*)fever(.*)")) {
            symptom.setPYREXIA(true);
        }
        if(line.matches("(.*)body temperature increased(.*)")) {
            symptom.setBODY_TEMPERATURE_INCREASED(true);
        }
        if(line.matches("(.*)febrile convulsion(.*)")) {
            symptom.setFEBRILE_CONVULSION(true);
        }
        if(line.matches("(.*)hot flush(.*)")) {
            symptom.setHOT_FLUSH(true);
        }
        if(line.matches("(.*)body temperature decreased(.*)")) {
            symptom.setBODY_TEMPERATURE_DECREASED(true);
        }
        if(line.matches("(.*)paralysis(.*)") || line.matches("(.*)facial paralysis(.*)")) {
            symptom.setPARALYSIS(true);
        }
        if(line.matches("(.*)pallor(.*)") || line.matches("(.*)paleness(.*)") || line.matches("(.*)wanness(.*)")) {
            symptom.setPALLOR(true);
        }
        if(line.matches("(.*)stillbirth(.)") || line.matches("(.*)foetal death(.*)")) {
            symptom.setSTILLBIRTH(true);
        }
        if(line.matches("(.*)foetal death(.)")) {
            symptom.setFOETAL_DEATH(true);
        }
        if(line.matches("(.*)death(.)")) {
            symptom.setDEATH(true);
        }
        if(line.matches("(.*)lymphadenopathy(.)")) {
            symptom.setLYMPHADENOPATHY(true);
        }
        if(line.matches("(.*)seizure(.)")) {
            symptom.setSEIZURE(true);
        }
        if(line.matches("(.*)herpes_zoster(.)")) {
            symptom.setHERPES_ZOSTER(true);
        }
        if(line.matches("(.*)sleep disorder(.)")) {
            symptom.setSLEEP_DISORDER(true);
        }
        if(line.matches("(.*)hipersomnia(.)")) {
            symptom.setHIPERSOMNIA(true);
        }
        if(line.matches("(.*)anxiety(.)")) {
            symptom.setANXIETY(true);
        }
        if(line.matches("(.*)influenza(.)")) {
            symptom.setINFLUENZA(true);
        }
        if(line.matches("(.*)blurred_vision(.)") || line.matches("(.*)eyelid function disorder(.*)") || line.matches("(.*)tunnel vision(.*)")) {
            symptom.setBLURRED_VISION(true);
        }
        if(line.matches("(.*)blindness(.)")) {
            symptom.setBLINDNESS(true);
        }
        if(line.matches("(.*)dysphonia(.)")) {
            symptom.setDYSPHONIA(true);
        }
        if(line.matches("(.*)spasm(.)")) {
            symptom.setSPASM(true);
        }
        if(line.matches("(.*)haemorrhage(.)") || line.matches("(.*)eye haemorrhage(.*)")) {
            symptom.setHAEMORRHAGE(true);
        }
        if(line.matches("(.*)hearing impairment(.)") || line.matches("(.*)deafness unilateral(.*)") || line.matches("(.*)deafness(.*)") || line.matches("(.*)tonnitus(.*)") || line.matches("(.*)hypoacusis(.*)")) {
            symptom.setHEARING_IMPAIRMENT(true);
        }
        if(line.matches("(.*)deafness(.)")) {
            symptom.setDEAFNESS(true);
        }
        if(line.matches("(.*)sepsis(.)")) {
            symptom.setSEPSIS(true);
        }
        if(line.matches("(.*)varicella(.)")) {
            symptom.setVARICELLA(true);
        }
        if(line.matches("(.*)pericarditis(.)")) {
            symptom.setPERICARDITIS(true);
        }
        if(line.matches("(.*)amyotrophy(.)")) {
            symptom.setAMYOTROPHY(true);
        }
        if(line.matches("(.*)sensory loss(.)")) {
            symptom.setSENSORY_LOSS(true);
        }
        if(line.matches("(.*)decreased appetite(.)")) {
            symptom.setDECREASED_APPETITE(true);
        }
        if(line.matches("(.*)anion gap decreased(.)") || line.matches("(.*)basophil percentage decreased(.*)") || line.matches("(.*)blood potassium decreased(.*)") || line.matches("(.*)carbon dioxide decreased(.*)") || line.matches("(.*)eosinophil count decreased(.*)") || line.matches("(.*)immature granulocyte count increased(.*)") || line.matches("(.*)lymphocyte count decreased(.*)") || line.matches("(.*)monocyte percentage decreased(.*)") || line.matches("(.*)neurophil percentage increased(.*)") || line.matches("(.*)red cell distribution width increased(.*)") || line.matches("(.*)band neutrophil percentage increased(.*)") || line.matches("(.*)white blood cell count increased(.*)") || line.matches("(.*)blood lactic acid(.*)") || line.matches("(.*)blood lactate dehydrogenase increased(.*)") || line.matches("(.*)serum ferritin increased(.*)")) {
            symptom.setCHANGE_IN_BLOOD_COUNT(true);
        }
        if(line.matches("(.*)oxygen saturation decreased(.)")) {
            symptom.setOXYGEN_SATURATION_DECREASED(true);
        }
        return symptom;
    }


    public static Symptom parsSymptomDataFromWebPL(String dataFromForm){
        Symptom symptom = new Symptom();
        String line = dataFromForm.toLowerCase();
        if(line.matches("(.*)alergiczne zapalenie pęcherzyków płucnych(.*)") || line.matches("(.*)beryloza(.*)") || line.matches("(.*)centralny bezdech senny(.*)") || line.matches("(.*)choroba śródmiąższowa płuc związana z zapaleniem oskrzelików(.*)") || line.matches("(.*)złuszczające się śródmiąższowe zapalenie płuc(.*)") || line.matches("(.*)eozynofile płucne(.*)") || line.matches("(.*)grudkowe zapalenie oskrzelików(.*)") || line.matches("(.*)gruźlica(.*)") || line.matches("(.*)grypowe zapalenie płuc(.*)") || line.matches("(.*)idiopatyczne włóknienie płuc(.*)") || line.matches("(.*)infiltracja płuc(.*)") || line.matches("(.*)konsolidacja płuc(.*)") || line.matches("(.*)kryptogenne organizujące się zapalenie płuc(.*)") || line.matches("(.*)krztusiec(.*)") || line.matches("(.*)kultura plwociny(.*)") || line.matches("(.*)limfangioleiomimatoza(.*)") || line.matches("(.*)limfocytów śródmiąższowe zapalenie płuc(.*)") || line.matches("(.*)niespecyficzne śródmiąższowe zapalenie płuc(.*)") || line.matches("(.*)obturacyjny bezdech senny(.*)") || line.matches("(.*)odma opłucnowa(.*)") || line.matches("(.*)ostra niewydolność oddechowa(.*)") || line.matches("(.*)ostre śródmiąższowe zapalenie płuc(.*)") || line.matches("(.*)ostre zapalenie oskrzelików(.*)") || line.matches("(.*)płucna postać histiocytozy z komórek Langerhansa(.*)") || line.matches("(.*)pneumokokowe zapalenie płuc(.*)") || line.matches("(.*)proteinoza pęcherzyków płucnych(.*)") || line.matches("(.*)przekrwienie płuc(.*)") || line.matches("(.*)przewlekła niewydolność oddechowa(.*)") || line.matches("(.*)rozlane zapalenie oskrzelików(.*)") || line.matches("(.*)samoistna fibroelastoza opłucnowo-śródmiąższowa(.*)") || line.matches("(.*)sarkoidoza(.*)") || line.matches("(.*)śródmiąszowe zapalenie płuc(.*)")  || line.matches("(.*)zapalenie oskrzeli(.*)") || line.matches("(.*)zapalenie oskrzelików oddechowych(.*)") || line.matches("(.*)zapalenie płuc(.*)") || line.matches("(.*)zarostowe zapalenie oskrzelików(.*)") || line.matches("(.*)zespoły hipowentylacji i hipoksemii w czasie snu(.*)") || line.matches("(.*)zmętnienie płuc(.*)")){
            symptom.setRESPIRATORY_SYSTEM_DISEASES(true);
        }
        if(line.matches("(.*)zapalenie wyrostka robaczkowego(.*)") || line.matches("(.*)wycięcie ślepej kiszki(.*)")){
            symptom.setAPPENDICITIS(true);
        }
        if(line.matches("(.*)dysfagia(.*)") || line.matches("(.*)zaburzenia połykania(.*)")){
            symptom.setDYSPHAGIA(true);
        }
        if(line.matches("(.*)ucisk w gardle(.*)")) {
            symptom.setTHROAT_TIGHTNESS(true);
        }
        if(line.matches("(.*)podrażnienie gardła(.*)")) {
            symptom.setTHROAT_IRRITATION(true);
        }
        if(line.matches("(.*)duszność(.*)")){
            symptom.setDYSPNOEA(true);
        }
        if(line.matches("(.*)kaszel(.*)")){
            symptom.setCOUGH(true);
        }
        if(line.matches("(.*)dyskomfort w klatce(.*)")){
            symptom.setCHEST_DISCOMFORT(true);
        }
        if(line.matches("(.*)niewydolność oddechowa(.*)")) {
            symptom.setRESPIRATORY_DISTRESS(true);
        }
        if(line.matches("(.*)bezdech (.*)")) {
            symptom.setANOEA(true);
        }
        if(line.matches("(.*)świst wdechowy(.*)")) {
            symptom.setSTRIDOR(true);
        }
        if(line.matches("(.*)świst wydechowy(.*)"))  {
            symptom.setWHEEZING(true);
        }
        if(line.matches("(.*)zwiększona częstość oddechów(.*)")) {
            symptom.setTACHYPNOE(true);
        }
        if(line.matches("(.*)krótki oddech(.*)"))  {
            symptom.setSHORTNESS_OF_BREATH(true);
        }
        if(line.matches("(.*)nudności(.*)") || line.matches("(.*)mdłości(.*)")) {
            symptom.setNAUSEA(true);
        }
        if(line.matches("(.*)wymioty(.*)")) {
            symptom.setVOMITING(true);
        }
        if(line.matches("(.*)biegunka(.*)")) {
            symptom.setDIARRHOEA(true);
        }
        if(line.matches("(.*)dreszcze(.*)")) {
            symptom.setCHILLS(true);
        }
        if(line.matches("(.*)drżenie(.*)")) {
            symptom.setCHILLS(true);
        }
        if(line.matches("(.*)zmęczenie(.*)") || line.matches("(.*)złe samopoczucie(.*)") || line.matches("(.*)niemoc(.*)")) {
            symptom.setFATIGUE(true);
        }
        if(line.matches("(.*)nienormalne uczucie(.*)")){
            symptom.setFEELING_ABNORMAL(true);
        }
        if (line.matches("(.*)mialgia(.*)") || line.matches("(.*)ból mięśniowy(.*)")) {
            symptom.setMYALGIA(true);
        }
        if (line.matches("(.*)ból(.*)") || line.matches("(.*)rwa kulszowa(.*)")) {
            symptom.setBODY_ACHE(true);
        }
        if(line.matches("(.*)obrzęk(.*)")) {
            symptom.setSWELLING(true);
        }
        if(line.matches("(.*)wzrost ciśnienia krwi(.*)") || line.matches("(.*)zwiększone rozkurczowe ciśnienie krwi(.*)") || line.matches("(.*)wzrost skurczowego ciśnienia krwi(.*)")) {
            symptom.setBLOOD_PRESSURE_INCREASED(true);
        }
        if(line.matches("(.*)spadek ciśnienia krwi(.*)")) {
            symptom.setBLOOD_PRESSURE_DECREASED(true);
        }
        if(line.matches("(.*)utrata przytomności(.*)")) {
            symptom.setLOSS_OF_CONSCIOUSNESS(true);
        }
        if(line.matches("(.*)zaburzenia mięśniowo-szkieletowe(.*)") || line.matches("(.*)zmniejszona mobilność(.*)") || line.matches("(.*)zaburzenia chodu(.*)") || line.matches("(.*)zaburzenia równowagi(.*)") || line.matches("(.*)niezborność ruchów,(.*)") || line.matches("(.*)zaburzenia koordynacji ruchowej(.*)")) {
            symptom.setMUSCULOSKELETAL_DISORDER(true);
        }
        if(line.matches("(.*)niezdolność do pracy(.*)")) {
            symptom.setIMPAIRED_WORK_ABILITY(true);
        }
        if(line.matches("(.*)bakteryjne zapalenie stawów(.*)")) {
            symptom.setARTHRITIS_BACTERIAL(true);
        }
        if(line.matches("(.*)udar(.*)") || line.matches("(.*)udar naczyniowo-mózgowy(.*)")) {
            symptom.setSTROKE(true);
        }
        if(line.matches("(.*)niewydolność krążenia(.*)")) {
            symptom.setCARDIOVASCULAR_FAILURE(true);
        }
        if(line.matches("(.*)zwiększone tętno(.*)")) {
            symptom.setHEART_RATE_INCREASED(true);
        }
        if(line.matches("(.*)choroba wieńcowa(.*)")) {
            symptom.setCORONARY_ARTERY_DISEASE(true);
        }
        if(line.matches("(.*)tachykardia(.*)") || line.matches("(.*)częstoskurcz(.*)")) {
            symptom.setTACHYCARDIA(true);
        }
        if(line.matches("(.*)nagłe zatrzymanie krążenia(.*)")) {
            symptom.setSUDDEN_CARDIAC_ARREST(true);
        }
        if(line.matches("(.*)kołatanie serca(.*)") || line.matches("(.*)palpitacja(.*)")) {
            symptom.setPALPITATIONS(true);
        }
        if(line.matches("(.*)zawał mięśnia sercowego(.*)")) {
            symptom.setMYOCARDIAL_INFRACTION(true);
        }
        if(line.matches("(.*)wstrząs anafilaktyczny(.*)")) {
            symptom.setANAPHYLACTIC_SHOCK(true);
        }
        if(line.matches("(.*)reakcja anafilaktyczna(.*)") || line.matches("(.*)rumień(.*)") || line.matches("(.*)świąd(.*)") || line.matches("(.*)pokrzywka(.*)") || line.matches("(.*)wysypka plamkowa(.*)") || line.matches("(.*)swędzenie(.*)") || line.matches("(.*)zaczerwienienie(.*)")) {
            symptom.setANAPHYLACTIC_REACTION(true);
        }
        if(line.matches("(.*)utrata zdolności mowy(.*)") || line.matches("(.*)zaburzenia mowy(.*)")) {
            symptom.setAPHASIA(true);
        }
        if(line.matches("(.*)ból głowy(.*)") || line.matches("(.*)migrena(.*)")) {
            symptom.setHEADACHE(true);
        }
        if(line.matches("(.*)zawroty głowy(.*)")) {
            symptom.setDIZZINESS(true);
        }
        if(line.matches("(.*)nadmierna potliwość(.*)")) {
            symptom.setHYPERHIDROSIS(true);
        }
        if(line.matches("(.*)kurcz powiek(.*)")) {
            symptom.setBLEPHAROSPASM(true);
        }
        if(line.matches("(.*)parestezia(.*)") || line.matches("(.*)czucie opaczne(.*)")) {
            symptom.setPARAESTHESIA(true);
        }
        if(line.matches("(.*)krwawienie z nosa(.*)")) {
            symptom.setEPISTAXIS(true);
        }
        if(line.matches("(.*)pozytywny test na CoV-2(.*)")) {
            symptom.setSARS_CoV_2_TEST_POSITIVE(true);
        }
        if(line.matches("(.*)gorączka(.*)")) {
            symptom.setPYREXIA(true);
        }
        if(line.matches("(.*)zwiększenie temperatury ciała(.*)")) {
            symptom.setBODY_TEMPERATURE_INCREASED(true);
        }
        if(line.matches("(.*)drgawki gorączkowe(.*)")) {
            symptom.setFEBRILE_CONVULSION(true);
        }
        if(line.matches("(.*)uderzenie gorąca gorączkowe(.*)")) {
            symptom.setHOT_FLUSH(true);
        }
        if(line.matches("(.*)spadek temperatury ciała(.*)")) {
            symptom.setBODY_TEMPERATURE_DECREASED(true);
        }
        if(line.matches("(.*)paraliż(.*)")) {
            symptom.setPARALYSIS(true);
        }
        if(line.matches("(.*)bladość(.*)")) {
            symptom.setPALLOR(true);
        }
        if(line.matches("(.*)poronienie(.)")) {
            symptom.setSTILLBIRTH(true);
        }
        if(line.matches("(.*)śmierć płodu(.)")) {
            symptom.setFOETAL_DEATH(true);
        }
        if(line.matches("(.*)śmierć(.)")) {
            symptom.setDEATH(true);
        }
        if(line.matches("(.*)powiększenie węzłów chłonnych(.)")) {
            symptom.setLYMPHADENOPATHY(true);
        }
        if(line.matches("(.*)napad(.)")) {
            symptom.setSEIZURE(true);
        }
        if(line.matches("(.*)półpasiec(.)")) {
            symptom.setHERPES_ZOSTER(true);
        }
        if(line.matches("(.*)zaburzenia snu(.)")) {
            symptom.setSLEEP_DISORDER(true);
        }
        if(line.matches("(.*)nadmierna senność(.)")) {
            symptom.setHIPERSOMNIA(true);
        }
        if(line.matches("(.*)lęk(.)")) {
            symptom.setANXIETY(true);
        }
        if(line.matches("(.*)grypa(.)")) {
            symptom.setINFLUENZA(true);
        }
        if(line.matches("(.*)zaburzenia widzenia(.)") || line.matches("(.*)widzenie tunelowe(.*)") || line.matches("(.*)zaburzenia funkcji powiek(.*)")) {
            symptom.setBLURRED_VISION(true);
        }
        if(line.matches("(.*)ślepota(.)")) {
            symptom.setBLINDNESS(true);
        }
        if(line.matches("(.*)dysfonia(.)")  || line.matches("(.*)zaburzenia głosu(.*)")) {
            symptom.setDYSPHONIA(true);
        }
        if(line.matches("(.*)skurcze(.)")) {
            symptom.setSPASM(true);
        }
        if(line.matches("(.*)krwotok(.)") || line.matches("(.*)krwotok do oka(.*)")) {
            symptom.setHAEMORRHAGE(true);
        }
        if(line.matches("(.*)zaburzenia słuchu(.)") || line.matches("(.*)szum w uszach(.*)") || line.matches("(.*)niedosłuch(.*)")){
            symptom.setHEARING_IMPAIRMENT(true);
        }
        if(line.matches("(.*)głuchota(.)")) {
            symptom.setDEAFNESS(true);
        }
        if(line.matches("(.*)posocznica(.)")) {
            symptom.setSEPSIS(true);
        }
        if(line.matches("(.*)ospa wietrzna(.)")) {
            symptom.setVARICELLA(true);
        }
        if(line.matches("(.*)zapalenie osierdzia(.)")) {
            symptom.setPERICARDITIS(true);
        }
        if(line.matches("(.*)amiotrofia(.)")) {
            symptom.setAMYOTROPHY(true);
        }
        if(line.matches("(.*)utrata zmysłów(.)")) {
            symptom.setSENSORY_LOSS(true);
        }
        if(line.matches("(.*)spadek apetytu(.)")) {
            symptom.setDECREASED_APPETITE(true);
        }
        if(line.matches("(.*)spadek luki anionowej(.)") || line.matches("(.*)procentowy spadek bazofili(.*)") || line.matches("(.*)spadek potasu(.*)") || line.matches("(.*)spadek liczby eozynofili(.*)") || line.matches("(.*)procentowy spadek eozynofili(.*)") || line.matches("(.*)zwiększona liczba niedojrzałych granulocytów(.*)") || line.matches("(.*)spadek liczby limfocytów(.*)") || line.matches("(.*) spadek liczby monocytów(.*)") || line.matches("(.*)procentowy wzrost neurofili(.*)") || line.matches("(.*)zwiększona szerokość dystrybucji krwinek czerwonych(.*)") || line.matches("(.*)spadek dwutlenku węgla(.*)")) {
            symptom.setCHANGE_IN_BLOOD_COUNT(true);
        }
        if(line.matches("(.*)spadek saturacji(.)")) {
            symptom.setOXYGEN_SATURATION_DECREASED(true);
        }
        return symptom;
    }
}
