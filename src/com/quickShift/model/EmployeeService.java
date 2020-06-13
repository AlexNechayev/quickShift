package com.quickShift.model;

import java.util.List;

public interface EmployeeService {
    Employee employeeByLogin(String username, String password);
    Employee employeeById(int id);
    public boolean checkLoginValidity(String username, String password);
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    void deleteEmployee(String username);
    List<Employee> employeeList();

    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String emil);
    boolean isPhoneAvailable(String phone);
}
