package com.quickShift.view;

import com.quickShift.model.EmployeeImpl;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class RegisterFrame extends JFrame {
    private JPanel registrationFrame;
    private JPanel departInfoJPan;
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JTextField fNameTxt;
    private JTextField lNameTxt;
    private JTextField mangerNameTxt;
    private JTextField descriptionTxt;
    private JTextField addressTxt;
    private JTextField phoneNumTxt;
    private JTextField emailTxt;
    private JPanel hireDateJPanel;
    private JPanel birthdayJPanel;
    private JComboBox<String> genderCBox;
    private JComboBox<Integer> departmentNumCBox;

    private JRadioButton departEnableJRad;

    private JRadioButton mangerPositionJRad;
    private JButton addEmployeeBtn;
    private JLabel mainTitle;
    private JComboBox<String> employeeCBox;
    private JPanel employeeSelectJPanel;

    private String[] gender = {"","Male","Female"};
    private Integer[] departmentNum = {null,9001,9002,9003};


    Calendar cld = Calendar.getInstance();
    JDateChooser dateChooseHireD = new JDateChooser(cld.getTime());
    JDateChooser dateChooseBDay = new JDateChooser(cld.getTime());

    public RegisterFrame() {
        this.setTitle("Add employee");
        this.setLocation(getWidth(),getHeight());
        this.setSize(660,560);
        this.add(registrationFrame);

        this.dateChooseHireD.setDateFormatString("dd/MM/yyyy");
        this.dateChooseBDay.setDateFormatString("dd/MM/yyyy");

        this.birthdayJPanel.add(dateChooseHireD);
        this.hireDateJPanel.add(dateChooseBDay);

        this.genderCBox.addItem(gender[0]);
        this.genderCBox.addItem(gender[1]);
        this.genderCBox.addItem(gender[2]);

        this.departmentNumCBox.addItem(departmentNum[0]);
        this.departmentNumCBox.addItem(departmentNum[1]);
        this.departmentNumCBox.addItem(departmentNum[2]);
        this.departmentNumCBox.addItem(departmentNum[3]);

        departEnableJRad.addActionListener(e -> {
            if(departEnableJRad.isSelected()) departInfoJPan.setVisible(true);
            else departInfoJPan.setVisible(false);
        });
    }

    public RegisterFrame(EmployeeImpl e){
        this.setTitle("Update Info");
        this.setLocation(getWidth(),getHeight());
        this.setSize(660,560);
        this.add(registrationFrame);
        this.addEmployeeBtn.setText("Update");
        this.mainTitle.setText("Update Employee");

        this.genderCBox.addItem(gender[0]);
        this.genderCBox.addItem(gender[1]);
        this.genderCBox.addItem(gender[2]);

        this.departmentNumCBox.addItem(departmentNum[0]);
        this.departmentNumCBox.addItem(departmentNum[1]);
        this.departmentNumCBox.addItem(departmentNum[2]);
        this.departmentNumCBox.addItem(departmentNum[3]);

        this.usernameTxt.setText(e.getLogin().getUsername());
        this.usernameTxt.setEnabled(false);
        this.passwordTxt.setText(e.getLogin().getPassword());
        this.fNameTxt.setText(e.getContactInfo().getFirstName());
        this.fNameTxt.setEnabled(false);
        this.lNameTxt.setText(e.getContactInfo().getLastName());
        this.lNameTxt.setEnabled(false);
        this.genderCBox.setSelectedIndex(getGenderIndexByValue(e.getContactInfo().getGender()));
        this.genderCBox.setEnabled(false);
        this.phoneNumTxt.setText(e.getContactInfo().getPhoneNumber());
        this.emailTxt.setText(e.getContactInfo().getEmail());
        this.addressTxt.setText(e.getContactInfo().getAddress());

        this.dateChooseBDay.setDate(e.getContactInfo().getBirthDayDate());
        this.dateChooseBDay.setDateFormatString("dd/MM/yyyy");
        this.birthdayJPanel.add(dateChooseBDay);
        this.birthdayJPanel.setEnabled(false);
        this.dateChooseHireD.setDate(e.getHireDate());
        this.dateChooseHireD.setDateFormatString("dd/MM/yyyy");
        this.hireDateJPanel.add(dateChooseHireD);
        this.hireDateJPanel.setEnabled(false);

        this.departmentNumCBox.setSelectedIndex(getDepartmentNumberIndexByValue(e.getDepartmentNumber()));
        this.mangerNameTxt.setText(e.getMangerName());
        this.descriptionTxt.setText(e.getDescription());
        this.mangerPositionJRad.setEnabled(e.getMangerPosition());
        this.departEnableJRad.setVisible(false);

        if(e.getMangerPosition()){
            this.usernameTxt.setEnabled(true);
            this.fNameTxt.setEnabled(true);
            this.lNameTxt.setEnabled(true);
            this.genderCBox.setEnabled(true);
            this.birthdayJPanel.setEnabled(true);
            this.hireDateJPanel.setEnabled(true);
            this.departInfoJPan.setEnabled(true);
            this.departInfoJPan.setVisible(true);
            this.mangerPositionJRad.setSelected(true);
            this.employeeSelectJPanel.setVisible(true);
        }

    }

    public String getFName(){
        return this.fNameTxt.getText();
    }

    public String getLName(){
        return this.lNameTxt.getText();
    }

    public String getUsername(){
        return this.usernameTxt.getText();
    }

    public String getPassword(){
        return String.valueOf(this.passwordTxt.getPassword());
    }

    public Date getHireDate(){
        return this.dateChooseHireD.getDate();
    }

    public Date getBDay(){
        return this.dateChooseBDay.getDate();
    }

    public String getEmail(){
        return this.emailTxt.getText();
    }

    public String getGender(){
        return Objects.requireNonNull(this.genderCBox.getSelectedItem()).toString();
    }

    public int getGenderIndexByValue(String value){
        for(int i=0;i<gender.length;i++){
            if (gender[i].equals(value)) return i;
        }
        return 0;
    }

    public String getDepartmentNumber(){
        return Objects.requireNonNull(this.departmentNumCBox.getSelectedItem()).toString();
    }

    public int getDepartmentNumberIndexByValue(int value){
        for(int i=1;i<departmentNum.length;i++){
            if (departmentNum[i]==value) return i;
        }
        return 0;
    }

    public String getMangerNameTxt() {
        return mangerNameTxt.getText();
    }

    public String getDescriptionTxt() {
        return descriptionTxt.getText();
    }

    public String getAddressTxt() {
        return addressTxt.getText();
    }

    public String getPhoneNumTxt() {
        return phoneNumTxt.getText();
    }

    public boolean getMangerPositionJRad() {
        return mangerPositionJRad.isSelected();
    }

    public void setEmployeeCBox(JComboBox<String> employeeCBox){
        int i=0;
        while(employeeCBox.getItemAt(i) != null){
            this.employeeCBox.addItem(employeeCBox.getItemAt(i++));
        }
    }

    public JComboBox<String> getEmployeeCBox() {
        return employeeCBox;
    }

    public void closeForm(){
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }

    public void addAddEmployeeListener(ActionListener listenForAddEmployeeBtn){
        addEmployeeBtn.addActionListener(listenForAddEmployeeBtn);}
}
