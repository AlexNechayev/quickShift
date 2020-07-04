package com.quickShift.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteControllerTest
{
    private static DeleteController deleteController;

    @BeforeClass
    public static void setUpDeleteControllerTest()
    {
        deleteController = deleteController.getInstance();
        System.out.println("Set up method was called!");
    }

    @AfterClass
    public static void tearDownRegisterControllerTest()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void testDeleteEmployee()
    {
        System.out.println("DeleteEmployee method was called!");

        String userName = null;

        //user name = invalid user name, we expect to fail the test
        userName = "";
        assertFalse(this.deleteController.deleteEmployee(userName));

        userName = "אבי_כהן";
        assertFalse(this.deleteController.deleteEmployee(userName));

        userName = "sd564fs6d4f5";
        assertFalse(this.deleteController.deleteEmployee(userName));

        //user name = valid user name, we expect to fail the test
        userName = "a";//valid user name
        assertTrue(this.deleteController.deleteEmployee(userName));
    }
}