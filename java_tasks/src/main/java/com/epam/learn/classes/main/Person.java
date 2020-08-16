package com.epam.learn.classes.main;

public class Person {

    private static int idGenerator;
    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;

    public Person(String surname, String name) {
        this.id = idGenerator++;
        this.surname = surname;
        this.name = name;
    }

    public Person(String surname, String name, String address, String phone) {
        this(surname, name);
        this.address = address;
        this.phone = phone;
    }

    public Person(String surname, String name, String patronymic, String address, String phone) {
        this(surname, name, address, phone);
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format( "| %-2d | %-8s | %-8s | %-22s | %-8s |", id, surname, name, address, phone);
    }

}

