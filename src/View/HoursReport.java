package View;

import com.toedter.calendar.JDateChooser;

import Model.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class HoursReport extends JFrame {

    private JTextField enterHourTextField;
    private JTextField exitHourTextField;
    private JTextField commentTextField;
    private JPanel mainForm;
    private JButton reportBtn;
    private JButton resetBtn;
    private JPanel TitlePanel;
    private JPanel jDatePanel;
    private JSpinner HHTimeIn;
    private JSpinner MMTimeIn;
    private JSpinner HHTimeOut;
    private JSpinner MMTimeOut;

    Calendar cld = Calendar.getInstance();
    JDateChooser dateChoose = new JDateChooser(cld.getTime());


    public HoursReport(){

        add(mainForm);
        this.setTitle("Name Form Window");

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,300);

        //Calender:
        this.dateChoose.setDateFormatString("dd/MM/yyyy");
        this.jDatePanel.add(dateChoose);
        //Clock:
        this.HHTimeIn.setModel(new CyclingSpinnerListModel(returnTimeFormat(1)));
        this.MMTimeIn.setModel(new CyclingSpinnerListModel(returnTimeFormat(0)));
        this.HHTimeOut.setModel(new CyclingSpinnerListModel(returnTimeFormat(1)));
        this.MMTimeOut.setModel(new CyclingSpinnerListModel(returnTimeFormat(0)));

    }

    public String getFirstName(){
        return enterHourTextField.getText();
    }

    public String getLastName(){
        return exitHourTextField.getText();
    }

    public String getFullName() {
        return this.getFirstName()+" "+this.getLastName();
    }

    public void setFNameTextField(String fNameTextField) {
        this.enterHourTextField.setText(fNameTextField);
    }

    public void setLNameTextField(String lNameTextField) {
        this.exitHourTextField.setText(lNameTextField);
    }

    public void setCommentTextField(String fullName) {
        commentTextField.setText(fullName);
    }

    public void addGenerateListener(ActionListener listenForGenerateBtn){
        reportBtn.addActionListener(listenForGenerateBtn);
    }

    public void addRestListener(ActionListener listenForRestBtn){
        resetBtn.addActionListener(listenForRestBtn);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }

    public String[] returnTimeFormat(int oneHH_zeroMM){
        String[] HH = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        String[] MM = {"00","05","10","15","20","25","30","35","40","45","50","55"};
        return (oneHH_zeroMM) == 1 ? HH:MM;
    }

}
