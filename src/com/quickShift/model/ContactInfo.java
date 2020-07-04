package com.quickShift.model;

import java.util.Date;

public class ContactInfo
{
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private Date birthDayDate;

    public ContactInfo() { }

    public ContactInfo(String firstName, String lastName, int id, String gender, String address, String email, Date birthDayDate, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.birthDayDate = birthDayDate;
        this.phoneNumber = phoneNumber;
    }

    public ContactInfo(String firstName, String lastName, String gender, String address, String email, Date birthDayDate, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.birthDayDate = birthDayDate;
        this.phoneNumber = phoneNumber;
    }

    ////////////////////////////////////////////     Getters and Setters     ///////////////////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(Date birthDayDate) {
        this.birthDayDate = birthDayDate;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "ContactInfo{" +
                "first name='" + firstName + '\'' +
                "last name='" + lastName + '\'' +
                ", ID=" + id +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + email + '\'' +
                '}';
    }
}