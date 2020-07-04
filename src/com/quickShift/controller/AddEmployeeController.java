package com.quickShift.controller;

import com.quickShift.model.EmployeeServiceImpl;

public final class AddEmployeeController {

    private Model model;
    private static volatile AddEmployeeController addEmployeeController = null;
    private EmployeeServiceImpl employeeService;

    private AddEmployeeController() {
        this.employeeService = new EmployeeServiceImpl();
    }

    public static AddEmployeeController getInstance() {
        synchronized (AddEmployeeController.class) {
            if (addEmployeeController == null) {
                addEmployeeController = new AddEmployeeController();
            }
        }
        return addEmployeeController;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
