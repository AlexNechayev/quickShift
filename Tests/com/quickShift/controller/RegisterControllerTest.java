package com.quickShift.controller;

import com.quickShift.model.ContactInfo;
import com.quickShift.model.Employee;
import com.quickShift.model.Login;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class RegisterControllerTest
{
    private static RegisterController registerController;
    private static LoginController loginController;

    @BeforeClass
    public static void setUpRegisterControllerTest()
    {
        registerController = RegisterController.getInstance();
        loginController = LoginController.getInstance();
        System.out.println("Set up method was called!");
    }

    @AfterClass
    public static void tearDownRegisterControllerTest()
    {
        System.out.println("Tear down method was called!");
    }

    @Test
    public void testCheckEmail()
    {
        System.out.println("CheckEmail method was called!");

        //email = invalid email, we expect to fail the tests
        assertFalse(this.registerController.checkEmail(""));
        assertFalse(this.registerController.checkEmail("גכי65דכע45דכע54די54"));
        assertFalse(this.registerController.checkEmail("a@a.a"));

        //email = valid email, we expect to pass the tests
        assertTrue(this.registerController.checkEmail("avi@gmail.com"));
        assertTrue(this.registerController.checkEmail("yoni@walla.co.il"));
    }

    @Test
    public void testCheckPassword()
    {
        System.out.println("CheckPassword method was called!");

        //password = shorter than 6 characters, we expect to fail the tests
        assertFalse(this.registerController.checkPassword(""));
        assertFalse(this.registerController.checkPassword("שדג123"));
        assertFalse(this.registerController.checkPassword("as12"));

        //password = longer or equal to 6 characters, we expect to pass the tests
        assertTrue(this.registerController.checkPassword("a12312ssaas22"));
        assertTrue(this.registerController.checkPassword("a12124dfgdfs12"));
    }

    @Test
    public void testCheckPhoneNumber()
    {
        System.out.println("CheckPhoneNumber method was called!");

        //phone number = shorter or longer than 10 digits, we expect to fail the tests
        assertFalse(this.registerController.checkPhoneNumber(""));
        assertFalse(this.registerController.checkPhoneNumber("qweasdzxcw"));
        assertFalse(this.registerController.checkPhoneNumber("5s1fc6as5d41c6"));
        assertFalse(this.registerController.checkPhoneNumber("ד5ג6כ4ד5גע45כסע1"));

        //phone number = equal to 10 digits, we expect to pass the test
        assertTrue(this.registerController.checkPhoneNumber("0541568497"));
    }

    @Test
    public void testCheckIfFullNameHasOnlyEnglishLetters()
    {
        System.out.println("CheckIfFullNameHasOnlyEnglishLetters method was called!");

        //first name and last name = invalid names, we expect to fail the tests
        assertFalse(this.registerController.checkIfFullNameHasOnlyEnglishLetters("",""));
        assertFalse(this.registerController.checkIfFullNameHasOnlyEnglishLetters("4567453&^%$$%^","&*(^%^&3587954"));
        assertFalse(this.registerController.checkIfFullNameHasOnlyEnglishLetters("sdfg65sd4fg","6f54s65f"));
        assertFalse(this.registerController.checkIfFullNameHasOnlyEnglishLetters("כהן","אבי"));

        //first name and last name = invalid names, we expect to pass the test
        assertTrue(this.registerController.checkIfFullNameHasOnlyEnglishLetters("avi","cohen"));
    }

    @Test
    public void testCreateNewEmployee() throws SQLException
    {
        System.out.println("CreateNewEmployee method was called!");

        //we'll add a new employee, we expect to pass the test
        LocalDate testDate = LocalDate.of(2020,12,12);
        Login testLogin = new Login("us","pw");
        ContactInfo testContactInfo = new ContactInfo("Rick","Sanchez","Male","IL","RS@gmail.com",LocalDate.of(1999,12,12),"0543211234");
        Employee testEmployee = new Employee(testDate,"Morty",9001,"Employee",testContactInfo,testLogin,false);

        assertTrue(this.registerController.createNewEmployee(testEmployee));
    }

    @Test
    public void testUpdateCurrentEmployee() throws SQLException
    {
        System.out.println("UpdateCurrentEmployee method was called!");

        Employee employeeTest = null;

        //user name and password are false employee credentials, we expect to fail the test
        employeeTest = loginController.pullEmployeeByLogin("","");
        assertNull(employeeTest);
        employeeTest = loginController.pullEmployeeByLogin("fmdbz3455bgj3bv","45e6getseg");
        assertNull(employeeTest);
        employeeTest = loginController.pullEmployeeByLogin("אבי_כהן","אבי1234");
        assertNull(employeeTest);

        //user name and password are real employee credentials, we expect to pass the test
        employeeTest = loginController.pullEmployeeByLogin("us","pw");
        employeeTest.setMangerName("Alex"); //Input Updated manger name
        assertTrue(this.registerController.updateCurrentEmployee(employeeTest));
    }

    @Test
    public void testGetEmployeeList()
    {
        System.out.println("GetEmployeeList method was called!");

        // we'll get real employee data list, we expect to pass the test
        List<Employee> employeeList = registerController.getEmployeeList();
        assertNotNull(employeeList);
    }
}