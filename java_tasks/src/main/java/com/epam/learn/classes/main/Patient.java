package com.epam.learn.classes.main;

public class Patient extends Person {

    private long medicalCardNumber;
    private String diagnosis;

    public Patient(String surname, String name, long medicalCardNumber, String diagnosis) {
        super(surname, name);
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(String surname, String name, String address, String phone, long medicalCardNumber, String diagnosis) {
        super(surname, name, address, phone);
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(String surname, String name, String patronymic, String address, String phone, long medicalCardNumber, String diagnosis) {
        super(surname, name, patronymic, address, phone);
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public long getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(long medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return  super.toString() +
                String.format(" %-14d | %-18s |", medicalCardNumber, diagnosis);
    }
}
