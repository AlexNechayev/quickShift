package com.quickShift.model;

public interface Employee {
    EmployeeImpl loginEmployee(String username, String password);
    void addEmployee(EmployeeImpl e);
    void updateEmployee(EmployeeImpl e);
    void deleteEmployee(EmployeeImpl e);
    void deleteEmployee(String username);
}
