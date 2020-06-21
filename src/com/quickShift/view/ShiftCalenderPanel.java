package com.quickShift.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShiftCalenderPanel extends JPanel implements MouseListener {
    /*private ShiftPanel morning1 = new ShiftPanel("", "09:00", "15:00");
    private ShiftPanel morning2 = new ShiftPanel("", "09:00", "15:00");
    private ShiftPanel morning3 = new ShiftPanel("", "09:00", "15:00");
    private ShiftPanel morning4 = new ShiftPanel("", "09:00", "15:00");
    private ShiftPanel morning5 = new ShiftPanel("", "09:00", "15:00");

    private ShiftPanel afternoon1 = new ShiftPanel("", "12:00", "18:00");
    private ShiftPanel afternoon2 = new ShiftPanel("", "12:00", "18:00");
    private ShiftPanel afternoon3 = new ShiftPanel("", "12:00", "18:00");
    private ShiftPanel afternoon4 = new ShiftPanel("", "12:00", "18:00");
    private ShiftPanel afternoon5 = new ShiftPanel("", "12:00", "18:00");

    private ShiftPanel night1 = new ShiftPanel("", "15:00", "21:00");
    private ShiftPanel night2 = new ShiftPanel("", "15:00", "21:00");
    private ShiftPanel night3 = new ShiftPanel("", "15:00", "21:00");
    private ShiftPanel night4 = new ShiftPanel("", "15:00", "21:00");
    private ShiftPanel night5 = new ShiftPanel("", "15:00", "21:00");*/

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


        /*morning1.setName("Morning1"); morning1.addMouseListener(this);
        morning2.setName("Morning2"); morning2.addMouseListener(this);
        morning3.setName("Morning3"); morning3.addMouseListener(this);
        morning4.setName("Morning4"); morning4.addMouseListener(this);
        morning5.setName("Morning5"); morning5.addMouseListener(this);

        afternoon1.setName("Afternoon1"); afternoon1.addMouseListener(this);
        afternoon2.setName("Afternoon2"); afternoon2.addMouseListener(this);
        afternoon3.setName("Afternoon3"); afternoon3.addMouseListener(this);
        afternoon4.setName("Afternoon4"); afternoon4.addMouseListener(this);
        afternoon5.setName("Afternoon5"); afternoon5.addMouseListener(this);

        night1.setName("Night1"); night1.addMouseListener(this);
        night2.setName("Night2"); night2.addMouseListener(this);
        night3.setName("Night3"); night3.addMouseListener(this);
        night4.setName("Night4"); night4.addMouseListener(this);
        night5.setName("Night5"); night5.addMouseListener(this);


        //Morning Shifts:
        add(morning1);
        add(morning2);
        add(morning3);
        add(morning4);
        add(morning5);

        //Afternoon Shifts:
        add(afternoon1);
        add(afternoon2);
        add(afternoon3);
        add(afternoon4);
        add(afternoon5);

        //Night Shifts:
        add(night1);
        add(night2);
        add(night3);
        add(night4);
        add(night5);*/
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

    private ShiftPanel[][] initializeMatrix() {
        ShiftPanel[][] shiftPanelMatrix = new ShiftPanel[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "09:00", "15:00");
                else if (i == 1)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "12:00", "18:00");
                else //if (i == 2)
                    shiftPanelMatrix[i][j] = new ShiftPanel("", "15:00", "21:00");
            }
        }

        return shiftPanelMatrix;
    }
}

