package com.thesis.vaccines.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @CsvBindByName (column = "VEARS_ID")
    private int NOTIFICATION_ID;
    @CsvBindByName (column = "RECVDATE")
    @CsvDate("MM/dd/yyyy")
    private Date RPT_DATE;
    @ManyToOne
    @JoinColumn(name="VEARS_ID", nullable = false)
    private Patient patient;
    @CsvBindByName (column = "STATE")
    private String CITY;
    @ManyToOne
    @JoinColumn(name="SYMPTOM_ID", nullable = false)
    private Symptom symptom;
    @CsvBindByName (column = "DIED")
    private char DIED;
    @CsvBindByName (column = "VAX_MANU" , required = false)
    private String TYPE_OF_VACCINE;

    public Notification(){};

    public Notification(Date RPT_DATE, Patient patient, String CITY, Symptom symptom, char DIED, String TYPE_OF_VACCINE) {
        this.RPT_DATE = RPT_DATE;
        this.patient = patient;
        this.CITY = CITY;
        this.symptom = symptom;
        this.DIED = DIED;
        this.TYPE_OF_VACCINE = TYPE_OF_VACCINE;
    }

    public Notification(int NOTIFICATION_ID, Date RPT_DATE, String CITY, char DIED, String TYPE_OF_VACCINE) {
        this.NOTIFICATION_ID = NOTIFICATION_ID;
        this.RPT_DATE = RPT_DATE;
        this.CITY = CITY;
        this.DIED = DIED;
        this.TYPE_OF_VACCINE = TYPE_OF_VACCINE;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "NOTIFICATION_ID=" + NOTIFICATION_ID +
                ", RPT_DATE=" + RPT_DATE +
                ", STATE='" + CITY + '\'' +
                ", DIED=" + DIED +
                ", TYPE_OF_VACCINE='" + TYPE_OF_VACCINE + '\'' +
                '}';
    }

    public int getNOTIFICATION_ID() {
        return NOTIFICATION_ID;
    }

    public void setNOTIFICATION_ID(int NOTIFICATION_ID) {
        this.NOTIFICATION_ID = NOTIFICATION_ID;
    }

    public Date getRPT_DATE() {
        return RPT_DATE;
    }

    public void setRPT_DATE(Date RPT_DATE) {
        this.RPT_DATE = RPT_DATE;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public char getDIED() {
        return DIED;
    }

    public void setDIED(char DIED) {
        this.DIED = DIED;
    }

    public String getTYPE_OF_VACCINE() {
        return TYPE_OF_VACCINE;
    }

    public void setTYPE_OF_VACCINE(String TYPE_OF_VACCINE) {
        this.TYPE_OF_VACCINE = TYPE_OF_VACCINE;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }
}

