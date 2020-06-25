package com.quickShift.controller;

import com.quickShift.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerTest
{
    private LoginController loginController;

    @Before
    public void setUpCreateEmployeeIfPossible()
    {
        this.loginController = LoginController.getInstance();
        System.out.println("Set up method was called!");
    }

    @After
    public void tearDownCreateEmployeeIfPossible()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void checkCreateEmployeeById()
    {
        System.out.println("CreateEmployeeById method was called!");
        //דוגמה קטנה להרצת בדיקה
        Employee testEmployee = this.loginController.createEmployeeById(0);
        assertEquals(null, testEmployee);
        /////////////////////////////////////////////////////////
        //TODO check createEmployeeById method with the next values:
        //TODO id = actual employee ID, we expect to pass the test
        //TODO id = negative number, we expect to fail the test
        //TODO id = zero, we expect to fail the test
    }

    @Test
    public void checkCreateEmployeeIfPossible()
    {
        System.out.println("checkCreateEmployeeIfPossible method was called!");
        //דוגמה קטנה להרצת בדיקה
        Employee testEmployee = this.loginController.createEmployeeIfPossible("abc","123");
        assertEquals(null, testEmployee);
        /////////////////////////////////////////////////////////
        //TODO check createEmployeeById method with the next values:
        //TODO username = actual employee username, password = actual employee password, we expect to pass the test
        //TODO username = empty string (""), password = empty string (""), we expect to fail the test
        //TODO username = false employee username, password = false employee password, we expect to fail the test
        //TODO username = employee username in hebrew, password = employee password in hebrew, we expect to fail the test
        //TODO username = gibberish (!@#%@cvdfgsfדכגכעגכע), password = gibberish (HFFJ$%#$דגגASAS), we expect to fail the test
    }
}