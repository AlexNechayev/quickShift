package com.quickShift.view;

import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame {
    private JButton reportHourBtn;
    private JPanel sideBar;
    private JPanel topBar;
    private JPanel mainBar;
    private JPanel mainMenu;
    private JButton addEmployeeBtn;
    private JLabel gratingLbl;
    private JButton deleteEmployeeBtn;
    private JButton updateInfoBtn;

    public MenuFrame() {
        this.setTitle("QuickShift");
        this.setLocation(getWidth(), getHeight());
        this.setPreferredSize(new Dimension(1000, 600));
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        this.add(mainMenu);
        setVisible(true); //Only for testing the ShiftCalenderPanel

        this.pack();
        this.setLocationRelativeTo(null);

        mainBar.removeAll();
        mainBar.repaint();
        mainBar.revalidate();

        mainBar.add(new ShiftCalenderPanel());
        mainBar.repaint();
        mainBar.revalidate();
    }

    public MenuFrame(Employee employee) {
        this.setTitle("QuickShift");
        this.setLocation(getWidth(),getHeight());
        this.setSize(1000,600);
        this.add(mainMenu);

        this.pack();
        this.setLocationRelativeTo(null);

        if(employee.getMangerPosition()) {
            this.addEmployeeBtn.setVisible(true);
            this.deleteEmployeeBtn.setVisible(true);
        }

        mainBar.removeAll();
        mainBar.repaint();
        mainBar.revalidate();

        mainBar.add(new ShiftCalenderPanel());
        mainBar.repaint();
        mainBar.revalidate();
    }

    public void setGratingMessage (String fistName,String lastName) {
        this.gratingLbl.setText("Welcome Back "+fistName+" "+lastName);
    }

    public void reportHourBtnListener(ActionListener listenForReportHourBtn) {
        reportHourBtn.addActionListener(listenForReportHourBtn);
    }

    public void addAddEmployeeListener(ActionListener listenForAddEmployeeBtn) {addEmployeeBtn.addActionListener(listenForAddEmployeeBtn);}
    public void addDeleteEmployeeListener (ActionListener listenForDeleteEmployee) {deleteEmployeeBtn.addActionListener(listenForDeleteEmployee);}
    public void addUpdateInfoListener (ActionListener listenForUpdateInfo) {updateInfoBtn.addActionListener(listenForUpdateInfo);}
}
