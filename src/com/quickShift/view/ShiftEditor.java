package com.quickShift.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Arrays;

public class ShiftEditor extends JFrame {
    String[] names = new String[]{null, "Alex", "Shartil", "Oron"};
    String[] hours = new String[]{null, "08:00", "16:00", "00:00"};

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

        JComboBox<String> nameComBox = new JComboBox<>(names);
        nameComBox.setSelectedIndex(Arrays.asList(names).indexOf(shift.getEmployeeNameTxt()));
        nameComBox.setPreferredSize(new Dimension(100, 20));
        nameComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setShiftStartTimeTxt(names[nameComBox.getSelectedIndex()]);
            }
        });

        JComboBox<String> shiftStartComBox = new JComboBox<>(hours);
        shiftStartComBox.setSelectedIndex(Arrays.asList(hours).indexOf(shift.getShiftStartTimeTxt()));
        shiftStartComBox.setPreferredSize(new Dimension(100, 20));
        shiftStartComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setShiftStartTimeTxt(hours[shiftStartComBox.getSelectedIndex()]);
            }
        });

        JComboBox<String> shiftEndComBox = new JComboBox<>(hours);
        shiftEndComBox.setSelectedIndex(Arrays.asList(hours).indexOf(shift.getShiftEndTimeTxt()));
        shiftEndComBox.setPreferredSize(new Dimension(100, 20));
        shiftEndComBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift.setShiftEndTimeTxt(hours[shiftEndComBox.getSelectedIndex()]);
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
}

