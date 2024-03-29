package com.quickShift.controller;

import com.quickShift.model.Employee;
import com.quickShift.model.EmployeeServiceImpl;
import com.quickShift.view.ShiftPanel;

public final class LoginController
{
    private static volatile LoginController loginController = null;
    private EmployeeServiceImpl employeeService;


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

    public Employee pullEmployeeById(int id){
        Employee employee = null;
        employee = this.employeeService.employeeById(id);
        return employee;
    }

    public Employee pullEmployeeByLogin(String username, String password){
        Employee employee = null;
        employee = this.employeeService.employeeByLogin(username,password);
        return employee;
    }

    public Employee createEmployeeIfPossible(String username, String password)
    {
        Employee employee = null;

        //TODO לשאול את שרון האם יש צורך בבדיקה
        //תשובה: הבדיקה נחוצה משום שבה אנו בודקים האם שם משתמש וסיסמא נמצאים במסד הנתונים
        //אם כן, נוכל ליצור אובייקט עובד בבטחון
        //אחרת, יוחזר ערך NULL כי לא קיים עובד עם שם משתמש וסיסמא שהוכנסו
        if (employeeService.checkLoginValidity(username,password))
        {
            employee = this.employeeService.employeeByLogin(username,password);
        }

        return employee;
    }

    public void saveShiftsTableDB(ShiftPanel[][] sp){
        this.employeeService.saveShiftTableToDB(sp);
    }

    public ShiftPanel[][] loadShiftsTableDB(){
        return this.employeeService.loadShiftTableToDB();
    }
}