package com.quickShift.view;

import com.quickShift.controller.LoginController;
import com.quickShift.model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel mainFrame;
    private JPanel secLv;
    private JPanel rdLv;
    private JLabel main_Title;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginBtn;
    private LoginController loginController = LoginController.getInstance();

    public LoginFrame(){
        this.setTitle("QuickShift : Login");
        this.setLocation(getWidth(),getHeight());
        this.setSize(660,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainFrame);

        // centralize jframe code
        this.pack();
        this.setLocationRelativeTo(null);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Employee employee = loginController.createEmployeeIfPossible(getUsername(), getPassword());
                if (employee != null)
                {
                    setVisible(false);
                    setUserName("");
                    setPassword("");
                    dispose();

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override

                        //TODO singleton ????

                        public void run() {
                            new MenuFrame(employee);
                        }
                    });
                }
                else
                {
                    showMessage("Incorrect username or password");
                }
            }
        });
    }



    public String getUsername(){
        return this.usernameTextField.getText();
    }

    public String getPassword(){
        return String.valueOf(this.passwordTextField.getPassword());
    }

    public void setUserName(String userName){
        this.usernameTextField.setText(userName);
    }

    public void setPassword(String password){
        this.passwordTextField.setText(password);
    }

    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
    }
}