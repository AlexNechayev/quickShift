package com.quickShift.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
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
}

