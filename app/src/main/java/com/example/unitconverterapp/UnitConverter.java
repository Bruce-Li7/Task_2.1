package com.example.unitconverterapp;

public class UnitConverter {
    // Conversion factors
    private static final double INCH_TO_CM = 2.54;
    private static final double FOOT_TO_CM = 30.48;
    private static final double YARD_TO_CM = 91.44;
    private static final double MILE_TO_KM = 1.60934;
    private static final double POUND_TO_KG = 0.453592;
    private static final double OUNCE_TO_G = 28.3495;
    private static final double TON_TO_KG = 907.185;

    public static double convert(String sourceUnit, String destinationUnit, double inputValue) {
        switch (sourceUnit) {
            case "Inch":
                if (destinationUnit.equals("cm")) {
                    return inputValue * INCH_TO_CM; // Convert to cm
                }
                break;
            case "Foot":
                if (destinationUnit.equals("cm")) {
                    return inputValue * FOOT_TO_CM; // Convert to cm
                }
                break;
            case "Yard":
                if (destinationUnit.equals("cm")) {
                    return inputValue * YARD_TO_CM; // Convert to cm
                }
                break;
            case "Mile":
                if (destinationUnit.equals("km")) {
                    return inputValue * MILE_TO_KM; // Convert to km
                }
                break;
            case "Pound":
                if (destinationUnit.equals("kg")) {
                    return inputValue * POUND_TO_KG; // Convert to kg
                }
                break;
            case "Ounce":
                if (destinationUnit.equals("g")) {
                    return inputValue * OUNCE_TO_G; // Convert to g
                }
                break;
            case "Ton":
                if (destinationUnit.equals("kg")) {
                    return inputValue * TON_TO_KG; // Convert to kg
                }
                break;
            case "Celsius":
                if (destinationUnit.equals("Fahrenheit")) {
                    return inputValue * 1.8 + 32;
                } else if (destinationUnit.equals("Kelvin")) {
                    return inputValue + 273.15;
                }
                break;
            case "Fahrenheit":
                if (destinationUnit.equals("Celsius")) {
                    return (inputValue - 32) / 1.8;
                } else if (destinationUnit.equals("Kelvin")) {
                    return (inputValue - 32) / 1.8 + 273.15;
                }
                break;
            case "Kelvin":
                if (destinationUnit.equals("Celsius")) {
                    return inputValue - 273.15;
                } else if (destinationUnit.equals("Fahrenheit")) {
                    return (inputValue - 273.15) * 1.8 + 32;
                }
                break;
        }

        // If no valid conversion was found, return the input value
        return inputValue;
    }
}


