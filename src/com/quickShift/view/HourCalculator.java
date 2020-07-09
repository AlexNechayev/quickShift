package com.quickShift.view;

import com.quickShift.controller.LoginController;
import com.quickShift.controller.RegisterController;
import com.quickShift.model.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Objects;

public class HourCalculator extends JFrame implements ActionListener {

    private JComboBox<String> employeeCBox;
    private JPanel HCP;
    private JLabel shiftsLabel;
    private JLabel weeklyHours;
    private JLabel employeeNameLabel;

    private final RegisterController registerController = RegisterController.getInstance();
    private final LoginController loginController = LoginController.getInstance();
    private final Dimension dimension = new Dimension(350,210);
    private final List<Employee> employeeList = registerController.getEmployeeList();
    private Employee selectedEmployee = null;

    public HourCalculator(Employee e){
        this.setTitle("Hour Calculator");
        this.setLocation(getWidth(), getHeight());
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.add(HCP);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

        setEmployeeToCBox();
        calculateEmployeeWorkingHours(e.getContactInfo().getId());

        if(!(e.getMangerPosition())){
            employeeCBox.setVisible(false);
            employeeNameLabel.setText(e.getContactInfo().getFullName());
        }else{
            employeeCBox.addItemListener(event -> {
                if(event.getStateChange() == ItemEvent.SELECTED){
                    String title = Objects.requireNonNull(employeeCBox.getSelectedItem()).toString();
                    String[] data = title.split(":");
                    int id = Integer.parseInt(data[0]);
                    if(!(e.getLogin().getId() == id)){
                        selectedEmployee = loginController.pullEmployeeById(id);
                    }else{
                        selectedEmployee = new Employee(e);
                    }
                    calculateEmployeeWorkingHours(selectedEmployee.getContactInfo().getId());
                }
            });
        }

    }

    public void setEmployeeToCBox(){
        for(Employee employee:employeeList){
            String employeeTitleSelect = employee.getLogin().getId()+": "+employee.getContactInfo().getFullName();
            this.employeeCBox.addItem(employeeTitleSelect);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void calculateEmployeeWorkingHours(int id){

        ShiftPanel[][] sp = ShiftCalenderPanel.shiftPanelMatrix;

        int shiftCounter = 0;
        int totalHours = 0;
        int totalMinutes = 0;

        for(int i = 0; i< 3;i++){
            for(int j = 0; j< 5;j++){
                if(sp[i][j].getEmployee().getContactInfo().getId() == id){
                    shiftCounter++;

                    String[] startTime = sp[i][j].getShiftStartTimeTxt().split(":");
                    String[] endTime = sp[i][j].getShiftEndTimeTxt().split(":");

                    int hours = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]));
                    int minutes = (Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]));

                    if(minutes < 0){
                        minutes *= -1;
                        hours--;
                    }

                    totalHours+=hours;
                    totalMinutes+=minutes;

                }
            }
        }
        shiftsLabel.setText(String.valueOf(shiftCounter));
        weeklyHours.setText(String.format("%02d.%02d", totalHours, totalMinutes));
    }
}


