package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner sourceUnitSpinner;
    private Spinner destinationUnitSpinner;
    private EditText inputValue;
    private Button convertButton;
    private TextView convertedValue;
    private TextView outputlabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceUnitSpinner = findViewById(R.id.spinner);
        destinationUnitSpinner = findViewById(R.id.spinner2);
        inputValue = findViewById(R.id.editTextNumber);
        convertButton = findViewById(R.id.button);
        convertedValue = findViewById(R.id.textView2);
        outputlabel= findViewById(R.id.textView3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unit_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.converted_unit, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationUnitSpinner.setAdapter(adapter1);

        // Add event listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputlabel.setText("");
                String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
                String destinationUnit = destinationUnitSpinner.getSelectedItem().toString();
                double input = Double.parseDouble(inputValue.getText().toString());

                try {
                    double result = UnitConverter.convert(sourceUnit, destinationUnit, input);
                    convertedValue.setText(Double.toString(result));
                    outputlabel.setText(destinationUnit);
                } catch (IllegalArgumentException e) {

                    convertedValue.setText("Error: " + e.getMessage());
                }

            }
        });
    }

    public static class UnitConverter {

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
                        return inputValue * INCH_TO_CM;
                    }
                    break;
                case "Foot":
                    if (destinationUnit.equals("cm")) {
                        return inputValue * FOOT_TO_CM;
                    }
                    break;
                case "Yard":
                    if (destinationUnit.equals("cm")) {
                        return inputValue * YARD_TO_CM;
                    }
                    break;
                case "Mile":
                    if (destinationUnit.equals("km")) {
                        return inputValue * MILE_TO_KM;
                    }
                    break;
                case "Pound":
                    if (destinationUnit.equals("kg")) {
                        return inputValue * POUND_TO_KG;
                    }
                    break;
                case "Ounce":
                    if (destinationUnit.equals("g")) {
                        return inputValue * OUNCE_TO_G;
                    }
                    break;
                case "Ton":
                    if (destinationUnit.equals("kg")) {
                        return inputValue * TON_TO_KG;
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

            // If no valid conversion was found to throw an expection.
            throw new IllegalArgumentException("Invalid Conversion! Please change the Unit.");
        }
    }
}



