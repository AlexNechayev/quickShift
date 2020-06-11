package com.quickShift.controller;

import com.quickShift.model.Employee;
import com.quickShift.model.EmployeeServiceImpl;
import com.quickShift.model.Model;

public final class LoginController
{
    private static volatile LoginController m_LoginController  = null;
    private Model m_Model;
    private EmployeeServiceImpl m_EmployeeService;

    public Model GetM_Model()
    {
        return m_Model;
    }
    public void SetM_Model(Model m_Model)
    {
        this.m_Model = m_Model;
    }

    private LoginController()
    {
        this.m_EmployeeService = new EmployeeServiceImpl();
    }

    public static LoginController GetInstance()
    {
        if (m_LoginController == null)
        {
            synchronized(LoginController.class)
            {
                if (m_LoginController == null)
                {
                    m_LoginController = new LoginController();
                }
            }
        }

        return m_LoginController;
    }

    public Employee CreateEmployeeIfPossible(String i_UserName, String i_PassWord)
    {
        Employee employee = null;

        if (EmployeeServiceImpl.CheckLoginValidity(i_UserName,i_PassWord))
        {
            employee = this.m_EmployeeService.employeeByLogin(i_UserName,i_PassWord);
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