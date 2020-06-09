package com.quickShift.model;

import java.util.Date;

public class Manger extends EmployeeImpl {

    //private ArrayList<Employee> employeeList;
    public Manger(EmployeeImpl e){
        super(e.getHireDate(),e.getMangerName(),e.getDepartmentNumber(),e.getDescription(),e.getContactInfo(),e.getLogin(),e.getMangerPosition());
    }

    public Manger(Date hireDate, String mangerName, int departmentNumber, String description, ContactInfo contactInfo, Login login, boolean mangerPosition) {
        super(hireDate, mangerName, departmentNumber, description, contactInfo, login, mangerPosition);
    }

//    public ArrayList<Employee> getEmployeeList() {
//        return employeeList;
//    }

}
