package com.quickShift.controller;

import com.quickShift.view.*;
import com.quickShift.model.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Controller {

    private LoginFrame loginFrame;
    private Model model;
    static RegisterFrame registerFrame = new RegisterFrame();
    static MenuFrame menuFrame = new MenuFrame();
    static HoursReport hoursReport = new HoursReport();

    public Controller(LoginFrame loginFrame, Model model){
        this.loginFrame = loginFrame;
        this.model = model;


        class addAddEmployeeListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame = new RegisterFrame();
                registerFrame.setVisible(true);
                registerFrame.addAddEmployeeListener(new addEmployeeListener());
            }
        }

        class loginListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = loginFrame.getUsername();
                String password = loginFrame.getPassword();

                try {
                    Employee employee = new Employee(new Login(username,password));
                    if(employee.isManger()) employee = new Manger(employee);
                    if (employee.checkIfValid()){
                        menuFrame = new MenuFrame(employee);
                        menuFrame.setVisible(true);
                        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        menuFrame.reportHourBtnListener(new addReportHoursListener());
                        menuFrame.addAddEmployeeListener(new addAddEmployeeListener());
                        menuFrame.setGratingMessage(employee.getContactInfo().getFirstName(),employee.getContactInfo().getLastName());

                        loginFrame.setUserName("");
                        loginFrame.setPassword("");
                    }else{
                        loginFrame.showMessage("Incorrect username or password");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        this.loginFrame.addLoginListener(new loginListener());
    }

    static class addEmployeeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            //make a logical and syntax checks
            ////////////////////////////////////////////////////////////

            Login login = null;
            try {
                login = new Login(registerFrame.getUsername(),registerFrame.getPassword());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            assert login != null;
            ContactInfo contactInfo = new ContactInfo(registerFrame.getFName(),registerFrame.getLName(),login.getId(),registerFrame.getGender(),registerFrame.getAddressTxt(),registerFrame.getEmail(), registerFrame.getBDay(),registerFrame.getPhoneNumTxt());

            Date hireDate = registerFrame.getHireDate();
            String mangerName = registerFrame.getMangerNameTxt();
            String description = registerFrame.getDescriptionTxt();
            int departmentNumber = Integer.parseInt(registerFrame.getDepartmentNumber());
            boolean mangerPosition = registerFrame.getMangerPositionJRad();

            Employee employee = new Employee(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);
            employee.insertNewEmployee();
            registerFrame.closeForm();
        }
    }

    static class addReportHoursListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            hoursReport = new HoursReport();
            hoursReport.setVisible(true);
        }
    }
}

//package com.company.Controller;
//
//import com.company.Model.ContactInfo;
//import com.company.Model.Employee;
//import com.company.Model.com.company.Model;
//
//import javax.swing.*;
//import java.util.regex.Pattern;
//
//import static javax.swing.JOptionPane.showMessageDialog;

// The com.company.Controller coordinates interactions
// between the com.company.View and com.company.Model




//public class com.company.Controller {
//
//    private JFrame theView;
//    private com.company.Model theModel;
//
//    private ContactInfo m_ContactInfo;
//    private Employee m_Employee;
//
//    public com.company.Controller(JFrame theView, com.company.Model model) {
//        this.theView = theView;
//    }
//
//    public String addWorker(String... str) {
//        if (checkIfEnoughTextWasEntered(str)) {
//            if (str[1].matches("[0-9]+") && str[1].length() == 9) //checks ID
//            {
//                if (checkEmail(str[4])) {
//                    if (str[6].matches("[0-9]+")) {
//                        //m_ContactInfo = new ContactInfo(str[0], Integer.parseInt(str[1]), str[2], str[3], str[4]);
//                        m_Employee = new Employee(str[8], str[5], Integer.parseInt(str[6]), str[7], m_ContactInfo);
//                        /////////////////////// EXCEL //////////////////////////////////
//                        return "שמירה בוצע בהצלחה";
//                    } else
//                        return "הכנס מספר מחלקה";
//                } else {
//                    return "יש להזין כתובת דואל תקינה";
//                }
//            } else {
//                return "יש להזין מספר תעודת זהות באורך 9 ספרות";
//            }
//        } else {
//            return "יש למלא את כל הפרטים";
//        }
//    }
//
//    private boolean checkIfEnoughTextWasEntered(String[] str) {
//        for (int i = 0; i < str.length; i++) {
//            if (str[i].isEmpty())
//                return false;
//        }
//
//        return true;
//    }
//
//    //if (m_IDText.getText().matches("[0-9]+") && m_IDText.getText().length() == 9) //checks ID
//
//    public boolean checkEmail(String i_EmailToCheck) {
//        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//        Pattern pattern = Pattern.compile(regex);
//        boolean resultToReturn = pattern.matcher(i_EmailToCheck).matches();
//
//        return resultToReturn;
//    }
//}