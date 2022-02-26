package com.thesis.vaccines.controller;

public class SymptomOccurrence implements Comparable<SymptomOccurrence> {
    private String name;
    private double percent;

    public SymptomOccurrence() {
        percent = 0.0;
    }

    public SymptomOccurrence(String name, double percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public int compareTo(SymptomOccurrence o) {
        return Double.compare(this.getPercent(), o.getPercent());
    }
}
