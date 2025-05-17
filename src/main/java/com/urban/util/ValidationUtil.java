package com.urban.util;

public class ValidationUtil {

    public static boolean isNameValid(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }

    public static boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isEmailValid(String email) {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean isPhoneValid(String number) {
    	return number != null && number.matches("^\\d{10}$");  
    	}

    public static boolean isPasswordStrong(String password) {
        return password != null && password.length() >= 6;
    }
}


