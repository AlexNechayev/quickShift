package com.quickShift.controller;

import com.quickShift.model.ContactInfo;
import com.quickShift.model.Employee;
import com.quickShift.model.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class RegisterControllerTest
{
    private RegisterController registerController;

    @Before
    public void setUpRegisterControllerTest()
    {
        this.registerController = RegisterController.getInstance();
        System.out.println("Set up method was called!");
    }

    @After
    public void tearDownRegisterControllerTest()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void testCheckEmail()
    {
        System.out.println("CheckEmail method was called!");

        //email = invalid email, we expect to fail the tests
        assertEquals(false, this.registerController.checkEmail(""));
        assertEquals(false, this.registerController.checkEmail("גכי65דכע45דכע54די54"));
        assertEquals(false, this.registerController.checkEmail("a@a.a"));

        //email = valid email, we expect to pass the tests
        assertEquals(true, this.registerController.checkEmail("avi@gmail.com"));
        assertEquals(true, this.registerController.checkEmail("yoni@walla.co.il"));
    }

    @Test
    public void testCheckPassword()
    {
        System.out.println("CheckPassword method was called!");

        //password = shorter than 6 characters, we expect to fail the tests
        assertEquals(false, this.registerController.checkPassword(""));
        assertEquals(false, this.registerController.checkPassword("שדג123"));
        assertEquals(false, this.registerController.checkPassword("as12"));

        //password = longer or equal to 6 characters, we expect to pass the tests
        assertEquals(true, this.registerController.checkPassword("a12312ssaas22"));
        assertEquals(true, this.registerController.checkPassword("a12124dfgdfs12"));

    }

    @Test
    public void testCheckPhoneNumber()
    {
        System.out.println("CheckPhoneNumber method was called!");

        //phone number = shorter or longer than 10 digits, we expect to fail the tests
        assertEquals(false, this.registerController.checkPhoneNumber(""));
        assertEquals(false, this.registerController.checkPhoneNumber("qweasdzxcw"));
        assertEquals(false, this.registerController.checkPhoneNumber("5s1fc6as5d41c6"));
        assertEquals(false, this.registerController.checkPhoneNumber("ד5ג6כ4ד5גע45כסע1"));

        //phone number = equal to 10 digits, we expect to pass the test
        assertEquals(true, this.registerController.checkPhoneNumber("0541568497"));
    }

    @Test
    public void testCheckIfFullNameHasOnlyEnglishLetters()
    {
        System.out.println("CheckIfFullNameHasOnlyEnglishLetters method was called!");

        //first name and last name = invalid names, we expect to fail the tests
        assertEquals(false, this.registerController.checkIfFullNameHasOnlyEnglishLetters("",""));
        assertEquals(false, this.registerController.checkIfFullNameHasOnlyEnglishLetters("4567453&^%$$%^","&*(^%^&3587954"));
        assertEquals(false, this.registerController.checkIfFullNameHasOnlyEnglishLetters("sdfg65sd4fg","6f54s65f"));
        assertEquals(false, this.registerController.checkIfFullNameHasOnlyEnglishLetters("כהן","אבי"));

        //first name and last name = invalid names, we expect to pass the test
        assertEquals(true, this.registerController.checkIfFullNameHasOnlyEnglishLetters("avi","cohen"));
    }

    @Test
    public void testCreateNewEmployee() throws SQLException {
        System.out.println("CreateNewEmployee method was called!");

        //TODO: write failing tests
        //registerController.createNewEmployee(new Employee(new Date(2020,12,12),"Morthy",9001,"Employee",new ContactInfo("Rick","Sanchez",54,"Male","IL","RS@gmail.com",new Date(1999,12,12),"0543211234"),new Login("us","pw"),false));
        //TODO: write passing tests
    }

    @Test
    public void testUpdateCurrentEmployee()
    {
        System.out.println("UpdateCurrentEmployee method was called!");

        //TODO: write failing tests

        //TODO: write passing tests
    }

    @Test
    public void testGetEmployeeList()
    {
        System.out.println("GetEmployeeList method was called!");

        //TODO: write failing tests

        //TODO: write passing tests
    }
}