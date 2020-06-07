package com.quickShift.view;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel{

    private JLabel shiftName;
    private JLabel employeeName;
    private JLabel startHour;
    private JLabel endHour;
    private JPanel J4Grid;
    public JButton setButton;

    public Test() {

    }

    Test(String name, String HE, String EX){
        add(J4Grid);
        this.employeeName.setText(name);
        this.startHour.setText(HE);
        this.endHour.setText(EX);
        this.setPreferredSize(new Dimension(70,70));

    }


}
