package com.quickShift.model;

import java.util.Date;

public class EmployeeImpl {
    private Login login;
    private Date hireDate;
    private String mangerName;
    private int departmentNumber;
    private String description;
    private ContactInfo contactInfo;
    private Boolean mangerPosition;

    public EmployeeImpl(Date hireDate, String mangerName, int departmentNumber, String description, ContactInfo contactInfo, Login login, boolean mangerPosition)
    {
        this.login = login;
        this.hireDate = hireDate;
        this.mangerName = mangerName;
        this.departmentNumber = departmentNumber;
        this.description = description;
        this.contactInfo = contactInfo;
        this.mangerPosition = mangerPosition;
    }

    ////////////////////////////////////////////     Getters and Setters     ///////////////////////////////////////////
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Login getLogin(){return login;}
    public void setLogin(Login login){this.login = login;}

    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getMangerName() {
        return mangerName;
    }
    public void setMangerName(String mangerName) {
        this.mangerName = mangerName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }
    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMangerPosition() {
        return mangerPosition;
    }
    public void setMangerPosition(Boolean mangerPosition) {
        this.mangerPosition = mangerPosition;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Employee{" +
                "hireDate=" + hireDate +
                ", mangerName='" + mangerName + '\'' +
                ", departmentNumber=" + departmentNumber +
                ", description='" + description + '\'' +
                ", contact Info=" + contactInfo.toString() +
                '}';
    }
}