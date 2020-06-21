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



    public MenuFrame(Employee employee){
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
        this.setGratingMessage(employee.getContactInfo().getFirstName(), employee.getContactInfo().getLastName());

        if(employee.getMangerPosition()){
            this.addEmployeeBtn.setVisible(true);
            this.deleteEmployeeBtn.setVisible(true);
        }

        mainBar.removeAll();
        mainBar.repaint();
        mainBar.revalidate();

        mainBar.add(new ShiftCalenderPanel());
        mainBar.repaint();
        mainBar.revalidate();




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
                SwingUtilities.invokeLater(new Runnable() {
                    @Override

                    //TODO singleton ????

                    public void run() {
                        new RegisterFrame(employee);
                    }
                });
            }
        });
        reportHourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override

                    //TODO singleton ????

                    public void run() {
                        new HoursReport();
                    }
                });
            }
        });
    }

    public void setGratingMessage (String fistName,String lastName){
        this.gratingLbl.setText("Welcome Back "+fistName+" "+lastName);
    }
}

