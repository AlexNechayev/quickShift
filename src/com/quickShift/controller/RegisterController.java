package com.quickShift.controller;

import com.quickShift.model.ContactInfo;
import com.quickShift.model.Employee;
import com.quickShift.model.EmployeeServiceImpl;
import com.quickShift.model.Login;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public final class RegisterController
{
    private static volatile  RegisterController registerController = null;
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

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
        boolean resultToReturn = passwordToCheck.length() >= 6;

        //password can be made of letters and numbers only
        if (resultToReturn)
        {
            resultToReturn = passwordToCheck.matches("^[a-zA-Z0-9]+$");
        }

        return resultToReturn;
    }

    public boolean checkPhoneNumber(String phoneNumberToCheck)
    {
        return phoneNumberToCheck.matches("[0-9]+") && phoneNumberToCheck.length() == 10;
    }

    public boolean checkIfFullNameHasOnlyEnglishLetters(String firstNameToCheck,String lastNameToCheck)
    {
        return firstNameToCheck.matches("[a-zA-Z]+") && lastNameToCheck.matches("[a-zA-Z]+");
    }

    public boolean createNewEmployee(Employee employee) throws SQLException {
       return employeeService.addEmployee(employee);
    }

    public boolean updateCurrentEmployee(Employee employee) throws SQLException{
        return employeeService.updateEmployee(employee);
    }

    public List<Employee> getEmployeeList(){
        return employeeService.employeeList();
    }
}