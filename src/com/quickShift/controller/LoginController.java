package com.quickShift.controller;

import com.quickShift.model.Employee;
import com.quickShift.model.EmployeeServiceImpl;
import com.quickShift.model.Model;

public final class LoginController
{
    private static volatile LoginController loginController = null;
    private Model model;
    private EmployeeServiceImpl employeeService;

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


    private LoginController() {
        this.employeeService = new EmployeeServiceImpl();
    }

    public static LoginController getInstance() {
        synchronized (LoginController.class) {
            if (loginController == null) {
                loginController = new LoginController();
            }
        }

        return loginController;
    }

    public Employee createEmployeeIfPossible(String username, String password)
    {
        Employee employee = null;

        if (EmployeeServiceImpl.checkLoginValidity(username,password))
        {
            employee = this.employeeService.employeeByLogin(username,password);
        }

        return employee;
    }
}
/*
public final class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
* */