package com.quickShift.controller;

import com.quickShift.model.EmployeeServiceImpl;

import static com.quickShift.controller.Controller.employeeService;

public final class DeleteController {

    private static volatile DeleteController deleteController = null;

    private DeleteController(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    }

    public static DeleteController getInstance()
    {
        if (deleteController == null)
        {
            synchronized(DeleteController.class)
            {
                if (deleteController == null)
                {
                    deleteController = new DeleteController();
                }
            }
        }
        return deleteController;
    }

    public void deleteEmployee(String username){
        employeeService.deleteEmployee(username);
    }
}


