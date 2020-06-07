package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel mainFrame;
    private JPanel secLv;
    private JPanel rdLv;
    private JLabel main_Title;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginBtn;

    public LoginFrame(){

        this.setTitle("QuickShift : Login");
        this.setLocation(getWidth(),getHeight());
        this.setSize(660,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainFrame);
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

    public void addLoginListener(ActionListener listenForLogin){loginBtn.addActionListener(listenForLogin);}

    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
