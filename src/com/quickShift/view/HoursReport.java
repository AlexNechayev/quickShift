package com.quickShift.view;

import com.toedter.calendar.JDateChooser;

import com.quickShift.model.*;
import javax.swing.*;
import java.awt.*;
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
        this.setTitle("QuickShift : Hour report");
        this.setLocation(getWidth(),getHeight());
        this.setPreferredSize(new Dimension(800,300));
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        this.setVisible(true);

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

        //Calender:
        this.dateChoose.setDateFormatString("dd/MM/yyyy");
        this.jDatePanel.add(dateChoose);
        //Clock:
        this.HHTimeIn.setModel(new CyclingSpinnerListModel(returnTimeFormat(1)));
        this.MMTimeIn.setModel(new CyclingSpinnerListModel(returnTimeFormat(0)));
        this.HHTimeOut.setModel(new CyclingSpinnerListModel(returnTimeFormat(1)));
        this.MMTimeOut.setModel(new CyclingSpinnerListModel(returnTimeFormat(0)));

    }

    public String getEnterHour(){
        return enterHourTextField.getText();
    }

    public String getExitHour(){
        return exitHourTextField.getText();
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
