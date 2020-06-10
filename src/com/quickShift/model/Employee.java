package com.quickShift.model;

import javax.swing.*;

public interface Employee {
    EmployeeImpl loginEmployee(String username, String password);
    void addEmployee(EmployeeImpl e);
    void updateEmployee(EmployeeImpl e);
    void deleteEmployee(EmployeeImpl e);
    void deleteEmployee(String username);

    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String emil);
    boolean isPhoneAvailable(String phone);

    /* TODO: 09/06/2020 add phone/email/username redundancy check */
}
