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