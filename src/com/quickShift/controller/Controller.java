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
    static EmployeeService employeeService = new EmployeeService();
    static EmployeeImpl employee;

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

                employee = employeeService.loginEmployee(username,password);
                if (employee != null){
                    menuFrame = new MenuFrame(employee);
                    menuFrame.setVisible(true);
                    menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    menuFrame.reportHourBtnListener(new addReportHoursListener());
                    menuFrame.addAddEmployeeListener(new addAddEmployeeListener());
                    menuFrame.addDeleteEmployeeListener(new deleteEmployeeListener());
                    menuFrame.addUpdateInfoListener(new updateInfoListener());
                    menuFrame.setGratingMessage(employee.getContactInfo().getFirstName(), employee.getContactInfo().getLastName());

                    loginFrame.setUserName("");
                    loginFrame.setPassword("");
                }else{
                    loginFrame.showMessage("Incorrect username or password");
                }
            }
        }
        this.loginFrame.addLoginListener(new loginListener());
    }

    static class addEmployeeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            //TODO: make a logical and syntax checks//

            String username = registerFrame.getUsername();
            String password = registerFrame.getPassword();


            String firstName = registerFrame.getFName();
            String lastName = registerFrame.getLName();
            String gender = registerFrame.getGender();
            String address = registerFrame.getAddressTxt();
            String email = registerFrame.getEmail();
            Date birthday = registerFrame.getBDay();
            String phone = registerFrame.getPhoneNumTxt();

            //employeeService.isUsernameAvailable(username);
            //employeeService.isEmailAvailable(email);
            //employeeService.isPhoneAvailable(phone);


            //TODO: DP - Factory Method//
            Date hireDate = registerFrame.getHireDate();
            String mangerName = registerFrame.getMangerNameTxt();
            String description = registerFrame.getDescriptionTxt();
            int departmentNumber = Integer.parseInt(registerFrame.getDepartmentNumber());
            boolean mangerPosition = registerFrame.getMangerPositionJRad();


            Login login = null;
            try {
                login = new Login(username,password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            assert login != null;

            ContactInfo contactInfo = new ContactInfo(firstName,lastName,login.getId(),gender,address,email,birthday,phone);
            EmployeeImpl employee = new EmployeeImpl(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);

            employeeService.addEmployee(employee);
            registerFrame.closeForm();
        }
    }

    static class updateEmployeeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            Login login = new Login();
            login.setUsername(registerFrame.getUsername());
            login.setPassword(registerFrame.getPassword());
            login.setId(employee.getLogin().getId());
            ContactInfo contactInfo = new ContactInfo(registerFrame.getFName(),registerFrame.getLName(),login.getId(),registerFrame.getGender(),registerFrame.getAddressTxt(),registerFrame.getEmail(), registerFrame.getBDay(),registerFrame.getPhoneNumTxt());

            Date hireDate = registerFrame.getHireDate();
            String mangerName = registerFrame.getMangerNameTxt();
            String description = registerFrame.getDescriptionTxt();
            int departmentNumber = Integer.parseInt(registerFrame.getDepartmentNumber());
            boolean mangerPosition = registerFrame.getMangerPositionJRad();

            employee = new EmployeeImpl(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);

            employeeService.updateEmployee(employee);
            registerFrame.closeForm();
        }
    }

    static class deleteEmployeeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = JOptionPane.showInputDialog("Enter username that you want to delete");
            employeeService.deleteEmployee(username);
        }
    }

    static class addReportHoursListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            hoursReport = new HoursReport();
            hoursReport.setVisible(true);
        }
    }

    static class updateInfoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            registerFrame = new RegisterFrame(employee);
            registerFrame.setEmployeeCBox(employeeService.employeeList());
            registerFrame.setVisible(true);
            registerFrame.addAddEmployeeListener(new updateEmployeeListener());
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