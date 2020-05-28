package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class loginFrame extends JFrame {
    private JPanel mainFrame;
    private JPanel fstLv;
    private JPanel secLv;
    private JPanel rdLv;
    private JLabel main_Title;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton signUpBtn;
    private JButton loginBtn;

    public loginFrame(){

        add(mainFrame);
        this.setTitle("Test v1.0");
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getUserName(){
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

    public void addSignUpListener (ActionListener listenForSignUpBtn){signUpBtn.addActionListener(listenForSignUpBtn);}

    public void addLoginListener(ActionListener listenForLogin){loginBtn.addActionListener(listenForLogin);}

    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
    }
}