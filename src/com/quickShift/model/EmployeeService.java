package com.quickShift.model;

import java.util.List;

public interface EmployeeService {
    Employee employeeByLogin(String username, String password);
    Employee employeeByFirstName(String fName);
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    void deleteEmployee(String username);
    List<String> employeeList();

    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String emil);
    boolean isPhoneAvailable(String phone);
}
