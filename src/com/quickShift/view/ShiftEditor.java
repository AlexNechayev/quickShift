package com.quickShift.view;

import com.quickShift.controller.RegisterController;
import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ShiftEditor extends JFrame {

    private RegisterController registerController = RegisterController.getInstance();
    private List<Employee> employeeList = registerController.getEmployeeList();

    String[] startHours = new String[]{"", "09:00", "12:00", "15:00", "18:00"};
    String[] endHours = new String[]{"", "12:00", "15:00", "18:00", "21:00"};

    public ShiftEditor(ShiftPanel shift) throws HeadlessException {
        super("Shift Editor");
        setLocation(getWidth(), getHeight());
        setMinimumSize(new Dimension(200, 100));
        setPreferredSize(new Dimension(200, 200));
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/quickShift/view/images/icon.png"));
        setIconImage(icon.getImage());
        setLayout(new GridBagLayout());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        String[] employees = employeeToString();
        JComboBox<String> nameComBox = new JComboBox<String>(employees);
        nameComBox.setSelectedIndex(Arrays.asList(employees).indexOf(shift.getEmployeeNameTxt()));
        nameComBox.setPreferredSize(new Dimension(100, 20));
        nameComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setEmployeeNameTxt(employees[nameComBox.getSelectedIndex()]);
            }
        });

        JComboBox<String> shiftStartComBox = new JComboBox<>(startHours);
        shiftStartComBox.setSelectedIndex(Arrays.asList(startHours).indexOf(shift.getShiftStartTimeTxt()));
        shiftStartComBox.setPreferredSize(new Dimension(100, 20));
        shiftStartComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setShiftStartTimeTxt("Start: " + startHours[shiftStartComBox.getSelectedIndex()]);
            }
        });

        JComboBox<String> shiftEndComBox = new JComboBox<>(endHours);
        shiftEndComBox.setSelectedIndex(Arrays.asList(endHours).indexOf(shift.getShiftEndTimeTxt()));
        shiftEndComBox.setPreferredSize(new Dimension(100, 20));
        shiftEndComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setShiftEndTimeTxt("End: " + endHours[shiftEndComBox.getSelectedIndex()]);
            }
        });

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Name:"), gc);

        gc.gridy = 1;
        add(new JLabel("Start:"), gc);

        gc.gridy = 2;
        add(new JLabel("End:"), gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(nameComBox, gc);

        gc.gridy = 1;
        add(shiftStartComBox, gc);

        gc.gridy = 2;
        add(shiftEndComBox, gc);
    }

    public String[] employeeToString() {
        String firstName = null, lastName = null;
        String[] employeeStringList = new String[employeeList.size()];

        for (int i = 0; i < employeeList.size(); i++)
        {
            firstName = employeeList.get(i).getContactInfo().getFirstName();
            lastName = employeeList.get(i).getContactInfo().getLastName();
            employeeStringList[i] = firstName +" "+ lastName;
        }

        return employeeStringList;
    }
}