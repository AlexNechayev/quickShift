package com.quickShift.view;

import com.quickShift.controller.LoginController;
import com.quickShift.controller.RegisterController;
import com.quickShift.model.ContactInfo;
import com.quickShift.model.Employee;
import com.quickShift.model.Login;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class RegisterFrame extends JFrame implements ActionListener{

    private RegisterController registerController = RegisterController.getInstance();
    private LoginController loginController = LoginController.getInstance();


    private Dimension dimension = new Dimension(660,560);

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
    private List<Employee> employeeList = registerController.getEmployeeList();
    private Employee selectedEmployee = null;

    Calendar cld = Calendar.getInstance();
    JDateChooser dateChooseHireD = new JDateChooser(cld.getTime());
    JDateChooser dateChooseBDay = new JDateChooser(cld.getTime());

    @Override
    public void actionPerformed(ActionEvent e) {
        Login login = null;
        String username = getUsername();
        String password = getPassword();
        String fName = getFName();
        String lName = getLName();
        Date bDay = getBDay();
        String gender = getGender();
        String address = getAddressTxt();
        String phoneNum = getPhoneNumTxt();
        String email = getEmail();
        int departmentNumber = getDepartmentNumber().equals("")?0:Integer.parseInt(getDepartmentNumber());
        Date hireDate = getHireDate();
        String mangerName = getMangerNameTxt();
        String description = getDescriptionTxt();
        boolean mangerPosition = getMangerPositionJRad();

        if (!getUsername().isEmpty())
        {
            if (registerController.checkPassword(getPassword()))
            {
                if (registerController.checkIfFullNameHasOnlyEnglishLetters(getFName(),getLName()))
                {
                    if (!getBDay().toString().isEmpty())
                    {
                        if(!getGender().isEmpty())
                        {
                            if (!getAddressTxt().isEmpty())
                            {
                                if (registerController.checkPhoneNumber(getPhoneNumTxt()))
                                {
                                    if (registerController.checkEmail(getEmail()))
                                    {
                                        try {
                                            int id;
                                            login = new Login(username,password);
                                            ContactInfo contactInfo = new ContactInfo(fName,lName,login.getId(),gender,address,email,bDay,phoneNum);
                                            Employee employee = new Employee(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);

                                            if(addEmployeeBtn.getName().equals("update")){
                                                id = selectedEmployee.getLogin().getId();
                                                employee.getContactInfo().setId(id);
                                                employee.getLogin().setId(id);
                                                selectedEmployee = employee;
                                                registerController.updateCurrentEmployee(selectedEmployee);
                                                JOptionPane.showMessageDialog(null, "The employee details were successfully updated", "successful operation", JOptionPane.INFORMATION_MESSAGE);
                                            }else if(addEmployeeBtn.getName().equals("addEmployee")){
                                                registerController.createNewEmployee(employee);
                                                JOptionPane.showMessageDialog(null, "The new employee was successfully added", "successful operation", JOptionPane.INFORMATION_MESSAGE);
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Something went wrong", "error operation", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            this.closeForm();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Please enter a valid email", "Invalid Email", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Please enter an address", "Invalid Address", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please choose a valid gender", "Invalid Gender", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please choose a valid birthday", "Invalid Birthday", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a full name with english letters", "Invalid Full Name", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please enter a password with a least 6 characters", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter a Username", "Invalid Username", JOptionPane.ERROR_MESSAGE);
        }
    }

    public RegisterFrame() {  // Create new Employee
        this.setTitle("Add employee");
        this.addEmployeeBtn.setName("addEmployee");
        this.setLocation(getWidth(), getHeight());
        this.setPreferredSize(dimension);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        this.setVisible(true);
        this.add(registrationFrame);

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

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
            if (departEnableJRad.isSelected()) departInfoJPan.setVisible(true);
            else departInfoJPan.setVisible(false);
        });

        addEmployeeBtn.addActionListener(this);
    }

    public RegisterFrame(Employee e){ //Update Employee info
        this.setTitle("Update Info");
        this.setLocation(getWidth(),getHeight());
        this.setPreferredSize(dimension);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        this.add(registrationFrame);
        this.addEmployeeBtn.setText("Update");
        this.addEmployeeBtn.setName("update");
        this.mainTitle.setText("Update Employee");
        this.setVisible(true);
        selectedEmployee = new Employee(e);

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

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
            setEmployeeToCBox();
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

            employeeCBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent event) {
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String title = Objects.requireNonNull(employeeCBox.getSelectedItem()).toString();
                        if(title.equals("")){
                            selectedEmployee = new Employee(e);
                        }else{
                            String[] data = title.split(":");
                            int id = Integer.parseInt(data[0]);
                            if(!(e.getLogin().getId() == id)){
                                selectedEmployee = loginController.createEmployeeById(id);
                            }else{
                                selectedEmployee = new Employee(e);
                            }
                        }
                        setValue(selectedEmployee);
                    }
//                    if(e.getStateChange() == ItemEvent.SELECTED){
//                    if(!((employeeCBox.getSelectedItem().equals("")){
//                    String fName = employeeCBox.getSelectedItem().toString();
////                    Employee employee = employeeService.employeeByFirstName(fName);
////                    setValue();
                }
            });


        }
        addEmployeeBtn.addActionListener(this);
    }

    public void setValue(Employee e){
        this.usernameTxt.setText(e.getLogin().getUsername());
        this.passwordTxt.setText(e.getLogin().getPassword());
        this.fNameTxt.setText(e.getContactInfo().getFirstName());
        this.lNameTxt.setText(e.getContactInfo().getLastName());
        this.genderCBox.setSelectedIndex(getGenderIndexByValue(e.getContactInfo().getGender()));
        this.phoneNumTxt.setText(e.getContactInfo().getPhoneNumber());
        this.emailTxt.setText(e.getContactInfo().getEmail());
        this.addressTxt.setText(e.getContactInfo().getAddress());

        this.dateChooseBDay.setDate(e.getContactInfo().getBirthDayDate());
        this.dateChooseBDay.setDateFormatString("dd/MM/yyyy");
        this.birthdayJPanel.add(dateChooseBDay);
        this.dateChooseHireD.setDate(e.getHireDate());
        this.dateChooseHireD.setDateFormatString("dd/MM/yyyy");
        this.hireDateJPanel.add(dateChooseHireD);

        this.departmentNumCBox.setSelectedIndex(getDepartmentNumberIndexByValue(e.getDepartmentNumber()));
        this.mangerNameTxt.setText(e.getMangerName());
        this.descriptionTxt.setText(e.getDescription());
        this.mangerPositionJRad.setSelected(e.getMangerPosition());

//        if(e.getMangerPosition()){
//            this.usernameTxt.setEnabled(true);
//            this.fNameTxt.setEnabled(true);
//            this.lNameTxt.setEnabled(true);
//            this.genderCBox.setEnabled(true);
//            this.birthdayJPanel.setEnabled(true);
//            this.hireDateJPanel.setEnabled(true);
//            this.departInfoJPan.setEnabled(true);
//            this.departInfoJPan.setVisible(true);
//            this.mangerPositionJRad.setSelected(true);
//            this.employeeSelectJPanel.setVisible(true);
//        }
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
        String s = emailTxt.getText();
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
        String valueToReturn;

        if (this.departmentNumCBox.getSelectedItem() == null)
        {
            valueToReturn = "";
        }
        else
        {
            valueToReturn = Objects.requireNonNull(this.departmentNumCBox.getSelectedItem()).toString();
        }
        return valueToReturn;
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



    public void setEmployeeToCBox(){
        this.employeeCBox.addItem("");
        for(Employee employee:employeeList){
            String employeeTitleSelect = employee.getLogin().getId()+": "+employee.getContactInfo().getFirstName()+" "+employee.getContactInfo().getLastName();
            this.employeeCBox.addItem(employeeTitleSelect);
        }
    }
    public JComboBox<String> getEmployeeCBox() {
        return employeeCBox;
    }

    public void closeForm(){
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }

    public void addItemChangeListener(ItemListener listenForItemChange){
        employeeCBox.addItemListener(listenForItemChange);
    }


}
