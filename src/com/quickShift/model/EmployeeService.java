package com.quickShift.model;

import java.util.List;

public interface EmployeeService {
    Employee loginEmployee(String username, String password);
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    void deleteEmployee(String username);
    List<String> employeeList();

    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String emil);
    boolean isPhoneAvailable(String phone);

    /* TODO: 09/06/2020 add phone/email/username redundancy check */
}
