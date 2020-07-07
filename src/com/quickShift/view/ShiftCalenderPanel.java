package com.quickShift.view;

import com.quickShift.controller.RegisterController;
import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShiftCalenderPanel extends JPanel implements MouseListener {
    private ShiftPanel[][] shiftPanelMatrix = new ShiftPanel[3][5];

    public ShiftCalenderPanel() {
        super();

        //setMinimumSize(new Dimension(500, 500)); //Uncomment this if you want to set minimum size
        //setMaximumSize(new Dimension(500, 500));  //Uncomment this if you want to set maximum size
        setLayout(new GridLayout(4, 5, 0, 0));
        setBackground(new Color(210, 210, 180));


        JLabel sunday = new JLabel("Sunday"); sunday.setHorizontalAlignment(SwingConstants.CENTER); add(sunday);
        JLabel monday = new JLabel("Monday"); monday.setHorizontalAlignment(SwingConstants.CENTER); add(monday);
        JLabel tuesday = new JLabel("Tuesday"); tuesday.setHorizontalAlignment(SwingConstants.CENTER); add(tuesday);
        JLabel wednesday = new JLabel("Wednesday"); wednesday.setHorizontalAlignment(SwingConstants.CENTER); add(wednesday);
        JLabel thursday = new JLabel("Thursday"); thursday.setHorizontalAlignment(SwingConstants.CENTER); add(thursday);



        for (int i = 0; i < 3; i++) { //Shift type
            for (int j = 0; j < 5; j++) { //Day of week
                if (i == 0)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "09:00", "15:00");
                else if (i == 1)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "12:00", "18:00");
                else //if (i == 2)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "15:00", "21:00");

                shiftPanelMatrix[i][j].addMouseListener(this);
                add(shiftPanelMatrix[i][j]);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() instanceof ShiftPanel) {
            ShiftPanel shiftPanel = ((ShiftPanel)(e.getComponent()));

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ShiftEditor(shiftPanel);
                }
            });
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void arrangeShiftsRandomly() {
        RegisterController registerController = RegisterController.getInstance();
        List<Employee> employeeListForAssignment = registerController.getEmployeeList(); //Do we change the actual list?
        List<Employee> employeeListAssigned = new ArrayList<>();

        Random random = new Random();
        Employee employee;

        for (int i = 0; i < 3; i++) { //Shift type
            for (int j = 0; j < 5; j++) { //Day of week
                employee = employeeListForAssignment.get(random.nextInt(employeeListForAssignment.size() - 1));
                employeeListAssigned.add(employee);
                employeeListForAssignment.remove(employee);

                shiftPanelMatrix[i][j].setEmployeeNameTxt(employee.getContactInfo().getFullName());
                shiftPanelMatrix[i][j].invalidate();

                if (employeeListForAssignment.size() == 0) {
                    employeeListForAssignment.addAll(employeeListAssigned);
                    employeeListAssigned.clear();
                }
            }
        }
    }
}

