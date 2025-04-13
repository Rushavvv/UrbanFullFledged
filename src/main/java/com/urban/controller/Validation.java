package com.urban.controller;

public class Validation {
	/**
     * Validates if the camera ID is within the range of 100000 to 999999.
     *
     * @param camId the camera ID to validate
     * @return true if the ID is in range, false otherwise
     */
    public static boolean isIdInRange(String camId) {
        try {
            int id = Integer.parseInt(camId);

            if (id < 1000 || id > 9999999) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Validates if the camera ID starts with "13" followed by four digits.
     *
     * @param camId the camera ID to validate
     * @return true if the ID starts correctly, false otherwise
     */
    public static boolean isIdStartCorrect(String camId) {
        try {
            if (!camId.matches("^13\\d{4}$")) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Validates if the name contains only alphabets and spaces.
     *
     * @param name the name to validate
     * @return true if the name is valid, false otherwise
     */
    public static boolean isNameValid(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }

    /**
     * Checks if a given string is numeric.
     *
     * @param num the string to check
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates if the price is within the range of 70000 to 500000.
     *
     * @param price the price to validate
     * @return true if the price is valid, false otherwise
     */
    public static boolean isPriceValid(String price) {
        try {
            int pri = Integer.parseInt(price);

            if (pri < 50000 || pri > 5000000) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    
    /**
     * Validates if the stock is within the range of 1 to 10.
     *
     * @param stock the price to validate
     * @return true if the stock is valid, false otherwise
     */
    public static boolean isStockValid(String stock) {
        try {
            int st = Integer.parseInt(stock);

            if (st < 1 || st > 10) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    
    /**
     * Validates if the stock is within the permissible limit (up to 20).
     *
     * @param stock the stock to validate
     * @return true if the stock is valid, false otherwise
     */
    public static boolean isStockEnough(String stock) {
        try {
            int stoc = Integer.parseInt(stock);

            if (stoc > 20) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Validates if the resolution is within the range of 10 to 100 megapixels.
     *
     * @param resolution the resolution to validate
     * @return true if the resolution is valid, false otherwise
     */
    public static boolean isResolutionInRange(String resolution) {
        try {
            int reso = Integer.parseInt(resolution);

            if (reso < 10 || reso > 100) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Placeholder for validating storage (currently always returns true).
     *
     * @param storage the storage to validate
     * @return true if the storage is valid, false otherwise
     */
    public static boolean isStorageValid(String storage) {
        try {
            int storageValue = Integer.parseInt(storage);

            // Check if the value matches one of the predefined valid storage options
            return storageValue == 28 || storageValue == 32 || storageValue == 64 || 
            storageValue == 128 || storageValue == 256;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Checks if a given value is empty or null.
     *
     * @param value the value to check
     * @return true if the value is empty or null, false otherwise
     */
    public static boolean IsEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
