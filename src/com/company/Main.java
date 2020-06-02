package com.company;

import Controller.*;
import Model.*;
import View.*;

public class Main {

    public static void main(String[] args) {
        LoginFrame mainView = new LoginFrame();
        Model model = new Model();
        Controller controller = new Controller(mainView,model);
        mainView.setVisible(true);

        //TestGrid tg = new TestGrid();

    }
}