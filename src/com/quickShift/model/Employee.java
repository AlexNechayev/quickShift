package com.quickShift.model;

public interface Employee {
    void addEmployee(EmployeeImpl e);
    void updateEmployee(EmployeeImpl e);
    void deleteEmployee(EmployeeImpl e);
    EmployeeImpl loginEmployee(String username, String password);
}
