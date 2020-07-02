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
    public void setUpLoginControllerTest()
    {
        this.loginController = LoginController.getInstance();
        System.out.println("Set up method was called!");
    }

    @After
    public void tearDownLoginControllerTest()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void testPullEmployeeById()
    {
        System.out.println("CreateEmployeeById method was called!");

        //id = negative number, we expect to fail the test
        Employee testEmployee = this.loginController.pullEmployeeById(-5);
        assertEquals(null, testEmployee);

        //id = zero, we expect to fail the test
        testEmployee = this.loginController.pullEmployeeById(0);
        assertEquals(null, testEmployee);

        //id = actual employee ID, we expect to pass the test
        String testEmployeeUserName = this.loginController.pullEmployeeById(12).getLogin().getUsername();
        assertEquals("a", testEmployeeUserName);
    }

    @Test
    public void testCreateEmployeeIfPossible() {
        System.out.println("checkCreateEmployeeIfPossible method was called!");

        //username = false employee username, password = false employee password, we expect to fail the test
        Employee testEmployee = this.loginController.createEmployeeIfPossible("abc", "123");
        assertEquals(null, testEmployee);

        //username = empty string (""), password = empty string (""), we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("", "");
        assertEquals(null, testEmployee);

        //username = employee username in hebrew, password = employee password in hebrew, we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("הדכעאי", "קכדעגעיגכי");
        assertEquals(null, testEmployee);

        //username = gibberish, password = gibberish, we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("!@#%@cvdfgsfדכגכעגכע", "HFFJ$%#$דגגASAS");
        assertEquals(null, testEmployee);

        //username = actual employee username, password = actual employee password, we expect to pass the test
        int testEmployeeID = this.loginController.createEmployeeIfPossible("a", "123").getLogin().getId();
        assertEquals(12, testEmployeeID);
    }
}