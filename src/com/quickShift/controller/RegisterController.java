package com.quickShift.controller;

import java.util.regex.Pattern;

public final class RegisterController
{
    public static volatile  RegisterController registerController = null;
    // do we need to include a model member???

    private RegisterController() {}

    public static RegisterController getInstance() {
        if (registerController == null) {
            synchronized (DeleteController.class) {
                if (registerController == null) {
                    registerController = new RegisterController();
                }
            }
        }
        return registerController;
    }

    public boolean checkIfAllInformationWasEntered(String[] i_StringArray) {
        boolean checkResult = true;

        for (int i = 0; i < i_StringArray.length; i++) {
            if (i_StringArray[i].isEmpty()) {
                checkResult = false;
            }
        }

        return checkResult;
    }

    public boolean checkEmail(String i_EmailToCheck) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(i_EmailToCheck).matches();
    }

    public boolean checkPassword(String i_PasswordToCheck)
    {
        return i_PasswordToCheck.length() >=6;
    }

    public boolean checkPhoneNumber(String i_PhoneNumberToCheck)
    {
        return i_PhoneNumberToCheck.matches("[0-9]+") && i_PhoneNumberToCheck.length() == 10;
    }

    public void createNewEmployee(String[] i_DetailsStringArray)
    {
        //TODO: create model code that convert input String Array into sql data
    }
}