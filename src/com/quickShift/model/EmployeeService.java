package com.quickShift.model;

import com.quickShift.view.ShiftPanel;
import java.util.List;

public interface EmployeeService {
    Employee employeeByLogin(String username, String password);
    Employee employeeById(int id);
    public boolean checkLoginValidity(String username, String password);
    boolean addEmployee(Employee e);
    boolean updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    boolean deleteEmployee(String username);
    List<Employee> employeeList();
    void saveShiftTableToDB(ShiftPanel sp[][]);
    public ShiftPanel[][] loadShiftTableToDB();

    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String emil);
    boolean isPhoneAvailable(String phone);
}
