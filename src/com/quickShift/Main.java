package com.quickShift;

import com.quickShift.controller.*;
import com.quickShift.model.*;
import com.quickShift.view.*;

public class Main {

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        Model model = new Model();
        Controller controller = new Controller(loginFrame,model);
        loginFrame.setVisible(true);

        //TestGrid tg = new TestGrid();

    }
}