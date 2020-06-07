package com.quickShift.model;

import java.util.Date;

public class Manger extends Employee {

    //private ArrayList<Employee> employeeList;
    public Manger(Employee e){
        super(e.getHireDate(),e.getMangerName(),e.getDepartmentNumber(),e.getDescription(),e.getContactInfo(),e.getLogin(),e.isManger());
    }

    public Manger(Date hireDate, String mangerName, int departmentNumber, String description, ContactInfo contactInfo, Login login, boolean mangerPosition) {
        super(hireDate, mangerName, departmentNumber, description, contactInfo, login, mangerPosition);
    }

//    public ArrayList<Employee> getEmployeeList() {
//        return employeeList;
//    }

}
