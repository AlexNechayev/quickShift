package com.quickShift.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShiftCalenderPanel extends JPanel implements MouseListener {
    ShiftPanel morning1 = new ShiftPanel("Alex", "08:00", "16:00");
    ShiftPanel morning2 = new ShiftPanel("Alex", "08:00", "16:00");
    ShiftPanel morning3 = new ShiftPanel("Alex", "08:00", "16:00");
    ShiftPanel morning4 = new ShiftPanel("Alex", "08:00", "16:00");
    ShiftPanel morning5 = new ShiftPanel("Alex", "08:00", "16:00");

    ShiftPanel afternoon1 = new ShiftPanel("Shartil", "16:00", "00:00");
    ShiftPanel afternoon2 = new ShiftPanel("Shartil", "16:00", "00:00");
    ShiftPanel afternoon3 = new ShiftPanel("Shartil", "16:00", "00:00");
    ShiftPanel afternoon4 = new ShiftPanel("Shartil", "16:00", "00:00");
    ShiftPanel afternoon5 = new ShiftPanel("Shartil", "16:00", "00:00");

    ShiftPanel night1 = new ShiftPanel("Oron", "00:00", "08:00");
    ShiftPanel night2 = new ShiftPanel("Oron", "00:00", "08:00");
    ShiftPanel night3 = new ShiftPanel("Oron", "00:00", "08:00");
    ShiftPanel night4 = new ShiftPanel("Oron", "00:00", "08:00");
    ShiftPanel night5 = new ShiftPanel("Oron", "00:00", "08:00");

    public ShiftCalenderPanel() {
        super();

        setMinimumSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(4, 5, 0, 0));
        //setBackground(Color.GRAY);


        JLabel sunday = new JLabel("Sunday"); sunday.setHorizontalAlignment(SwingConstants.CENTER); add(sunday);
        JLabel monday = new JLabel("Monday"); monday.setHorizontalAlignment(SwingConstants.CENTER); add(monday);
        JLabel tuesday = new JLabel("Tuesday"); tuesday.setHorizontalAlignment(SwingConstants.CENTER); add(tuesday);
        JLabel wednesday = new JLabel("Wednesday"); wednesday.setHorizontalAlignment(SwingConstants.CENTER); add(wednesday);
        JLabel thursday = new JLabel("Thursday"); thursday.setHorizontalAlignment(SwingConstants.CENTER); add(thursday);


        morning1.setName("Morning1"); morning1.addMouseListener(this);
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
        add(night5);
    }

    /*public void setMorning1Name(String name) {
        morning1.setEmployeeNameTxt(name);
    }

    public void setMorning1StartTime(String startTime) {
        morning1.setShiftStartTimeTxt(startTime);
    }

    public void setMorning1EndTime(String endTime) {
        morning1.setShiftEndTimeTxt(endTime);
    }

    public void setMorning2Name(String name) {
        morning2.setEmployeeNameTxt(name);
    }

    public void setMorning2StartTime(String startTime) {
        morning2.setShiftStartTimeTxt(startTime);
    }

    public void setMorning2EndTime(String endTime) {
        morning2.setShiftEndTimeTxt(endTime);
    }

    public void setMorning3Name(String name) {
        morning3.setEmployeeNameTxt(name);
    }

    public void setMorning3StartTime(String startTime) {
        morning3.setShiftStartTimeTxt(startTime);
    }

    public void setMorning3EndTime(String endTime) {
        morning3.setShiftEndTimeTxt(endTime);
    }

    public void setMorning4Name(String name) {
        morning4.setEmployeeNameTxt(name);
    }

    public void setMorning4StartTime(String startTime) {
        morning4.setShiftStartTimeTxt(startTime);
    }

    public void setMorning4EndTime(String endTime) {
        morning4.setShiftEndTimeTxt(endTime);
    }

    public void setMorning5Name(String name) {
        morning5.setEmployeeNameTxt(name);
    }

    public void setMorning5StartTime(String startTime) {
        morning5.setShiftStartTimeTxt(startTime);
    }

    public void setMorning5EndTime(String endTime) {
        morning5.setShiftEndTimeTxt(endTime);
    }


    public void setAfternoon1Name(String name) {
        afternoon1.setEmployeeNameTxt(name);
    }

    public void setAfternoon1StartTime(String startTime) {
        afternoon1.setShiftStartTimeTxt(startTime);
    }

    public void setAfternoon1EndTime(String endTime) {
        afternoon1.setShiftEndTimeTxt(endTime);
    }

    public void setAfternoon2Name(String name) {
        afternoon2.setEmployeeNameTxt(name);
    }

    public void setAfternoon2StartTime(String startTime) {
        afternoon2.setShiftStartTimeTxt(startTime);
    }

    public void setAfternoon2EndTime(String endTime) {
        afternoon2.setShiftEndTimeTxt(endTime);
    }

    public void setAfternoon3Name(String name) {
        afternoon3.setEmployeeNameTxt(name);
    }

    public void setAfternoon3StartTime(String startTime) {
        afternoon3.setShiftStartTimeTxt(startTime);
    }

    public void setAfternoon3EndTime(String endTime) {
        afternoon3.setShiftEndTimeTxt(endTime);
    }

    public void setAfternoon4Name(String name) {
        afternoon1.setEmployeeNameTxt(name);
    }

    public void setAfternoon4StartTime(String startTime) {
        afternoon4.setShiftStartTimeTxt(startTime);
    }

    public void setAfternoon4EndTime(String endTime) {
        afternoon4.setShiftEndTimeTxt(endTime);
    }

    public void setAfternoon5Name(String name) {
        afternoon5.setEmployeeNameTxt(name);
    }

    public void setAfternoon5StartTime(String startTime) {
        afternoon5.setShiftStartTimeTxt(startTime);
    }

    public void setAfternoon5EndTime(String endTime) {
        afternoon5.setShiftEndTimeTxt(endTime);
    }

    public void setNight1Name(String name) {
        night1.setEmployeeNameTxt(name);
    }

    public void setNight1StartTime(String startTime) {
        night1.setShiftStartTimeTxt(startTime);
    }

    public void setNight1EndTime(String endTime) {
        night1.setShiftEndTimeTxt(endTime);
    }

    public void setNight2Name(String name) {
        night2.setEmployeeNameTxt(name);
    }

    public void setNight2StartTime(String startTime) {
        night2.setShiftStartTimeTxt(startTime);
    }

    public void setNight2EndTime(String endTime) {
        night2.setShiftEndTimeTxt(endTime);
    }

    public void setNight3Name(String name) {
        night3.setEmployeeNameTxt(name);
    }

    public void setNight3StartTime(String startTime) {
        night3.setShiftStartTimeTxt(startTime);
    }

    public void setNight3EndTime(String endTime) {
        night3.setShiftEndTimeTxt(endTime);
    }

    public void setNight4Name(String name) {
        night4.setEmployeeNameTxt(name);
    }

    public void setNight4StartTime(String startTime) {
        night4.setShiftStartTimeTxt(startTime);
    }

    public void setNight4EndTime(String endTime) {
        night4.setShiftEndTimeTxt(endTime);
    }

    public void setNight5Name(String name) {
        night5.setEmployeeNameTxt(name);
    }

    public void setNight5StartTime(String startTime) {
        night5.setShiftStartTimeTxt(startTime);
    }

    public void setNight5EndTime(String endTime) {
        night5.setShiftEndTimeTxt(endTime);
    }*/

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

