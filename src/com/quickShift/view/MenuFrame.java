package com.quickShift.view;


import com.quickShift.controller.Controller;
import com.quickShift.controller.DeleteController;
import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{
    private JButton reportHourBtn;
    private JPanel sideBar;
    private JPanel topBar;
    private JPanel mainBar;
    private JPanel mainMenu;
    private JButton addEmployeeBtn;
    private JLabel gratingLbl;
    private JButton deleteEmployeeBtn;
    private JButton updateInfoBtn;
    private JPanel shiftTable;

    private DeleteController deleteController = DeleteController.getInstance();



    public MenuFrame(Employee employeeImpl){
        this.setTitle("QuickShift");
        this.setLocation(getWidth(),getHeight());
        this.setPreferredSize(new Dimension(1000,600));
        this.add(mainMenu);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

        //this.reportHourBtnListener(new Controller.addReportHoursListener());
        //menuFrame.addAddEmployeeListener(new addAddEmployeeListener());
        //this.addDeleteEmployeeListener(new Controller.deleteEmployeeListener());
        //this.addUpdateInfoListener(new Controller.updateInfoListener());
        this.setGratingMessage(employeeImpl.getContactInfo().getFirstName(), employeeImpl.getContactInfo().getLastName());

        if(employeeImpl.getMangerPosition()){
            this.addEmployeeBtn.setVisible(true);
            this.deleteEmployeeBtn.setVisible(true);
        }


        /*
        if (currentEmployee != null){
            menuFrame = new MenuFrame(currentEmployee);
            menuFrame.setVisible(true);
            menuFrame.setGratingMessage(currentEmployee.getContactInfo().getFirstName(), currentEmployee.getContactInfo().getLastName());


            /*listener
            menuFrame.reportHourBtnListener(new Controller.addReportHoursListener());
            menuFrame.addAddEmployeeListener(new addAddEmployeeListener());
            menuFrame.addDeleteEmployeeListener(new Controller.deleteEmployeeListener());
            menuFrame.addUpdateInfoListener(new Controller.updateInfoListener());
            */


//        shiftTable = new TestGrid();
//
//        mainBar.removeAll();
//        mainBar.repaint();
//        mainBar.revalidate();
//
//        mainBar.add(shiftTable);
//        mainBar.repaint();
//        mainBar.revalidate();

        addEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override

                    //TODO singleton ????

                    public void run() {
                        new RegisterFrame();
                    }
                });

            }
        });
        deleteEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteController.getInstance();
                String username = JOptionPane.showInputDialog("Enter username that you want to delete");
                deleteController.deleteEmployee(username);
            }
        });
        updateInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reportHourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setGratingMessage (String fistName,String lastName){
        this.gratingLbl.setText("Welcome Back "+fistName+" "+lastName);
    }

    public void reportHourBtnListener(ActionListener listenForReportHourBtn){
        reportHourBtn.addActionListener(listenForReportHourBtn);}

    public void addAddEmployeeListener(ActionListener listenForAddEmployeeBtn){addEmployeeBtn.addActionListener(listenForAddEmployeeBtn);}
    public void addDeleteEmployeeListener (ActionListener listenForDeleteEmployee){deleteEmployeeBtn.addActionListener(listenForDeleteEmployee);}
    public void addUpdateInfoListener (ActionListener listenForUpdateInfo){updateInfoBtn.addActionListener(listenForUpdateInfo);}
}

