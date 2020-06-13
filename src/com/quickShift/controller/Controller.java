package com.quickShift.controller;

import com.quickShift.view.*;
import com.quickShift.model.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class Controller {

    private LoginFrame loginFrame;

    private Model model;
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static Employee currentEmployee;
    static Employee selectedEmployee;

    public Controller(LoginFrame loginFrame, Model model){
        this.loginFrame = loginFrame;
        this.model = model;



//    static class updateEmployeeListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(selectedEmployee == null) selectedEmployee = currentEmployee;
//            Login login = new Login();
//            login.setUsername(registerFrame.getUsername());
//            login.setPassword(registerFrame.getPassword());
//            login.setId(selectedEmployee.getLogin().getId());
//            ContactInfo contactInfo = new ContactInfo(registerFrame.getFName(),registerFrame.getLName(),login.getId(),registerFrame.getGender(),registerFrame.getAddressTxt(),registerFrame.getEmail(), registerFrame.getBDay(),registerFrame.getPhoneNumTxt());
//
//            Date hireDate = registerFrame.getHireDate();
//            String mangerName = registerFrame.getMangerNameTxt();
//            String description = registerFrame.getDescriptionTxt();
//            int departmentNumber = Integer.parseInt(registerFrame.getDepartmentNumber());
//            boolean mangerPosition = registerFrame.getMangerPositionJRad();
//
//            selectedEmployee = new Employee(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);
//
//            employeeService.updateEmployee(selectedEmployee);
//
//            selectedEmployee = null;
//            registerFrame.closeForm();
//        }
//    }
//
//    public static class deleteEmployeeListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {

//        }
//    }
//
//    public static class addReportHoursListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            hoursReport = new HoursReport();
//            hoursReport.setVisible(true);
//        }
//    }
//
//    public static class updateInfoListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            registerFrame = new RegisterFrame(currentEmployee);

//            registerFrame.setEmployeeToCBox(employeeService.employeeList());

//            registerFrame.addAddEmployeeListener(new updateEmployeeListener());
//            registerFrame.addItemChangeListener(new addItemChangedListener());
//            registerFrame.setVisible(true);
//        }
//    }
//
//    static class addItemChangedListener implements ItemListener{
//
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            if(e.getStateChange() == ItemEvent.SELECTED){
//                if(!(Objects.equals(registerFrame.getEmployeeCBox().getSelectedItem(), ""))){
//                    String fName = registerFrame.getEmployeeCBox().getSelectedItem().toString();
//                    selectedEmployee = employeeService.employeeByFirstName(fName);
//                    registerFrame.setValue(selectedEmployee);
//                }
//            }
//        }
    }
}

//package com.company.Controller;
//
//import com.company.Model.ContactInfo;
//import com.company.Model.EmployeeService;
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
//    private EmployeeService m_Employee;
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
//                        m_Employee = new EmployeeService(str[8], str[5], Integer.parseInt(str[6]), str[7], m_ContactInfo);
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