package com.quickShift.controller;

import com.quickShift.model.Employee;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerTest
{
    private static LoginController loginController;

    @BeforeClass
    public static void setUpLoginControllerTest()
    {
        loginController = LoginController.getInstance();
        System.out.println("Set up method was called!");
    }

    @AfterClass
    public static void tearDownLoginControllerTest()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void testPullEmployeeById()
    {
        System.out.println("CreateEmployeeById method was called!");

        //id = negative number, we expect to fail the test
        Employee testEmployee = this.loginController.pullEmployeeById(-5);
        assertNull(testEmployee);

        //id = zero, we expect to fail the test
        testEmployee = this.loginController.pullEmployeeById(0);
        assertNull(testEmployee);

        //id = actual employee ID, we expect to pass the test
        String testEmployeeUserName = this.loginController.pullEmployeeById(12).getLogin().getUsername();
        assertNotNull(testEmployeeUserName);
    }

    @Test
    public void testCreateEmployeeIfPossible()
    {
        System.out.println("checkCreateEmployeeIfPossible method was called!");

        //username = false employee username, password = false employee password, we expect to fail the test
        Employee testEmployee = this.loginController.createEmployeeIfPossible("abc", "123");
        assertNull(testEmployee);

        //username = empty string (""), password = empty string (""), we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("", "");
        assertNull(testEmployee);

        //username = employee username in hebrew, password = employee password in hebrew, we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("הדכעאי", "קכדעגעיגכי");
        assertNull(testEmployee);

        //username = gibberish, password = gibberish, we expect to fail the test
        testEmployee = this.loginController.createEmployeeIfPossible("!@#%@cvdfgsfדכגכעגכע", "HFFJ$%#$דגגASAS");
        assertNull(testEmployee);

        //username = actual employee username, password = actual employee password, we expect to pass the test
        int testEmployeeID = this.loginController.createEmployeeIfPossible("a", "123").getLogin().getId();
        assertNotNull(testEmployeeID);
    }
}