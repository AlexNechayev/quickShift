package com.quickShift.view;

import javax.swing.*;
import java.awt.*;

public class ShiftsTable extends JFrame {
    public ShiftsTable() throws HeadlessException {
        super("Shift Table");

        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridBagLayout());
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShiftCalenderPanel shiftCalenderPanel = new ShiftCalenderPanel();

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.gridy = 1;
        add(shiftCalenderPanel, gc);
    }
}

