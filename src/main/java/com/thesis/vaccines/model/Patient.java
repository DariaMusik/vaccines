package com.thesis.vaccines.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @CsvBindByName (column = "VEARS_ID")
    private int VEARS_ID;
    @CsvBindByName (column = "CAGE_YR")
    private int AGE_YRS;
    @CsvBindByName (column = "SEX")
    private  char SEX;

    public Patient(){};

    public Patient(int AGE_YRS, char SEX) {
        this.AGE_YRS = AGE_YRS;
        this.SEX = SEX;
    }

    public Patient(int VEARS_ID, int AGE_YRS, char SEX) {
        this.VEARS_ID = VEARS_ID;
        this.AGE_YRS = AGE_YRS;
        this.SEX = SEX;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "VEARS_ID=" + VEARS_ID +
                ", AGE_YRS=" + AGE_YRS +
                ", SEX=" + SEX +
                '}';
    }

    public int getVEARS_ID() {
        return VEARS_ID;
    }

    public void setVEARS_ID(int VEARS_ID) {
        this.VEARS_ID = VEARS_ID;
    }

    public int getAGE_YRS() {
        return AGE_YRS;
    }

    public void setAGE_YRS(int AGE_YRS) {
        this.AGE_YRS = AGE_YRS;
    }

    public char getSEX() {
        return SEX;
    }

    public void setSEX(char SEX) {
        this.SEX = SEX;
    }


}
