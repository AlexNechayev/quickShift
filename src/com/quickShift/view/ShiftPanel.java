package com.quickShift.view;

import javax.swing.*;
import java.awt.*;

public class ShiftPanel extends JPanel {
    private JLabel employeeName;
    private JLabel shiftStartTime;
    private JLabel shiftEndTime;

    public ShiftPanel(String name, String startTime, String endTime) {
        super();

        setLayout(new GridLayout(3, 1));
        setPreferredSize(new Dimension(80, 50));
        setBackground(new Color(255, 249, 212));
        setBorder(BorderFactory.createLineBorder(Color.black, 1));

        employeeName = new JLabel();
        employeeName.setText(name);
        employeeName.setHorizontalAlignment(SwingConstants.CENTER);

        shiftStartTime = new JLabel();
        shiftStartTime.setText("Start: " + startTime);
        shiftStartTime.setHorizontalAlignment(SwingConstants.CENTER);

        shiftEndTime = new JLabel();
        shiftEndTime.setText("End: " + endTime);
        shiftEndTime.setHorizontalAlignment(SwingConstants.CENTER);


        add(employeeName);
        add(shiftStartTime);
        add(shiftEndTime);
    }


    public String getEmployeeNameTxt() {
        return employeeName.getText();
    }

    public void setEmployeeNameTxt(String txt) {
        this.employeeName.setText(txt);
    }

    public String getShiftStartTimeTxt() {
        String[] txt = shiftStartTime.getText().split(" ");
        return txt[1];
    }

    public void setShiftStartTimeTxt(String txt) {
        this.shiftStartTime.setText(txt);
    }

    public String getShiftEndTimeTxt() {
        String[] txt = shiftEndTime.getText().split(" ");
        return txt[1];
    }

    public void setShiftEndTimeTxt(String txt) {
        this.shiftEndTime.setText(txt);
    }
}

