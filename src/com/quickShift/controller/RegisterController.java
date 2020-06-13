package com.quickShift.controller;

import com.quickShift.model.ContactInfo;
import com.quickShift.model.Employee;
import com.quickShift.model.EmployeeServiceImpl;
import com.quickShift.model.Login;

import java.sql.SQLException;
import java.util.regex.Pattern;

public final class RegisterController
{
    private static volatile  RegisterController registerController = null;
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    // do we need to include a model member???

    private RegisterController() {}

    public static RegisterController getInstance() {
        if (registerController == null) {
            synchronized (RegisterController.class) {
                if (registerController == null) {
                    registerController = new RegisterController();
                }
            }
        }
        return registerController;
    }


    public boolean checkEmail(String emailToCheck) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailToCheck).matches();
    }

    public boolean checkPassword(String passwordToCheck)
    {
        return passwordToCheck.length() >=6;
    }

    public boolean checkPhoneNumber(String phoneNumberToCheck)
    {
        return phoneNumberToCheck.matches("[0-9]+") && phoneNumberToCheck.length() == 10;
    }

    public void createNewEmployee(Employee employee) throws SQLException {
        employeeService.addEmployee(employee);
    }

    public void updateCurrentEmployee(Employee employee) throws SQLException{
        employeeService.updateEmployee(employee);
    }
}