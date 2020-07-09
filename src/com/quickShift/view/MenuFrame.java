package com.quickShift.view;

import com.quickShift.controller.DeleteController;
import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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
    private JButton mixShiftsRandomlyBtn;
    private JButton clearShiftsTableBtn;
    private JButton weeklyHourReportBtn;
    private ShiftCalenderPanel shiftCalenderPanel;
    private DeleteController deleteController = DeleteController.getInstance();


    public MenuFrame(Employee employee){
        this.setTitle("QuickShift");
        this.setLocation(getWidth(),getHeight());
        this.setPreferredSize(new Dimension(1000,600));
        this.add(mainMenu);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // centralize JFrame code
        this.pack();
        this.setLocationRelativeTo(null);

        this.setGratingMessage(employee.getContactInfo().getFullName());

        shiftCalenderPanel = ShiftCalenderPanel.getInstance(employee);

        if(employee.getMangerPosition()){
            this.addEmployeeBtn.setVisible(true);
            this.deleteEmployeeBtn.setVisible(true);
            this.mixShiftsRandomlyBtn.setVisible(true);
            this.clearShiftsTableBtn.setVisible(true);
        }

        mainBar.removeAll();
        mainBar.repaint();
        mainBar.revalidate();

        mainBar.add(shiftCalenderPanel);
        mainBar.repaint();
        mainBar.revalidate();

        //TODO: add the function shiftCalenderPanel.arrangeShiftsRandomly(); to the button listener
        // of JButton 'Arrange Shifts randomly'

        //TODO: add the code below to the button listener
        /*
        int result = JOptionPane.showConfirmDialog(null, "Make a swap request" , "Swap Request", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            TODO: Write your code here
        }
        */

        addEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
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
                String username = JOptionPane.showInputDialog(null,"Enter username that you want to delete");
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

                    public void run() {
                       new HoursReport();
                    }
                });
            }
        });
        weeklyHourReportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override

                    public void run() {
                        new HourCalculator(employee);
                    }
                });
            }
        });
        mixShiftsRandomlyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure you want to mix the shift table?","Arrange Shifts Randomly",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    shiftCalenderPanel.arrangeShiftsRandomly();
                }
            }
        });
        clearShiftsTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure you want to clear the shift table?","Clear Shift Table",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    shiftCalenderPanel.clearShiftTable();
                }
            }
        });
    }

    public void setGratingMessage (String fullName){
        this.gratingLbl.setText("Welcome Back "+fullName);
    }
}

