package com.quickShift.view;

import javax.swing.*;
import java.awt.*;

public class ShiftsTable extends JPanel {
    public ShiftsTable() throws HeadlessException {
        super();

        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridBagLayout());
        setVisible(true);

        ShiftCalenderPanel shiftCalenderPanel = new ShiftCalenderPanel();

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.gridy = 1;
        add(shiftCalenderPanel, gc);
    }
}

