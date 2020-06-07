package View;

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

    public String getDepartmentNumber(){
        return Objects.requireNonNull(this.departmentNumCBox.getSelectedItem()).toString();
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

    public void closeForm(){
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }



    public void addAddEmployeeListener(ActionListener listenForAddEmployeeBtn){
        addEmployeeBtn.addActionListener(listenForAddEmployeeBtn);}
}
