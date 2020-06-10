package com.quickShift.controller;

import com.quickShift.model.EmployeeImpl;
import com.quickShift.model.Model;

public final class LoginController
{
    private static volatile LoginController loginController = null;
    private Model model;
    private EmployeeService employeeService;

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    private LoginController() {
        this.employeeService = new EmployeeService();
    }

    public static LoginController getInstance() {
        synchronized (LoginController.class) {
            if (loginController == null) {
                loginController = new LoginController();
            }
        }

        return loginController;
    }

    public EmployeeImpl createEmployeeIfPossible(String i_UserName, String i_PassWord)
    {
        EmployeeImpl employee = null;

        if (EmployeeService.checkLoginValidity(i_UserName,i_PassWord))
        {
            employee = this.employeeService.loginEmployee(i_UserName,i_PassWord);
        }

        return employee;
    }
}