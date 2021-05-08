package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.*;

import java.text.DecimalFormat;


public class ConversionCalculatorActivity extends AppCompatActivity {

    private EditText etInch;
    private EditText etCm;
    private EditText etFahrenheit;
    private EditText etCelsius;
    private EditText etMiles;
    private EditText etKm;

    private Button inchEqualsCm;
    private Button cmEqualsInch;
    private Button fahrenheitEqualsCelsius;
    private Button celsiusEqualsFahrenheit;
    private Button milesEqualsKm;
    private Button kmEqualsMiles;

    private TextView tvCm;
    private TextView tvInch;
    private TextView tvCelsius;
    private TextView tvFahrenheit;
    private TextView tvKm;
    private TextView tvMiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_calculator);
        etInch = findViewById(R.id.etInch);
        etCm = findViewById(R.id.etCm);
        etFahrenheit = findViewById(R.id.etFahrenheit);
        etCelsius = findViewById(R.id.etCelsius);
        etMiles = findViewById(R.id.etMiles);
        etKm = findViewById(R.id.etKm);

        inchEqualsCm = findViewById(R.id.inchEqualsCm);
        cmEqualsInch = findViewById(R.id.cmEqualsInch);
        fahrenheitEqualsCelsius = findViewById(R.id.fahrenheitEqualsCelsius);
        celsiusEqualsFahrenheit = findViewById(R.id.celsiusEqualsFahrenheit);
        milesEqualsKm = findViewById(R.id.milesEqualsKm);
        kmEqualsMiles = findViewById(R.id.kmEqualsMiles);

        tvCm = findViewById(R.id.tvCm);
        tvInch = findViewById(R.id.tvInch);
        tvCelsius = findViewById(R.id.tvCelsius);
        tvFahrenheit = findViewById(R.id.tvFahrenheit);
        tvKm = findViewById(R.id.tvKm);
        tvMiles = findViewById(R.id.tvMiles);

        inchEqualsCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convert from inch to cm
                
                convertFromInchToCm();
            }
        });

        cmEqualsInch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromCmToInch();
            }
        });

        fahrenheitEqualsCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromFahrenheitToCelsius();
            }
        });

        celsiusEqualsFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromCelsiusToFahrenheit();
            }
        });

        milesEqualsKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromMilesToKm();
            }
        });

        kmEqualsMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromKmToMiles();
            }
        });






    }

    private void convertFromKmToMiles() {

        String kmValueEntered = etKm.getText().toString();

        double inputKm = Double.parseDouble(kmValueEntered);

        double displayMiles = inputKm/1.60934;

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        tvMiles.setText("" + numberFormat.format(displayMiles) + " miles");

    }

    private void convertFromMilesToKm() {

        String milesValueEntered = etMiles.getText().toString();

        double inputMiles = Double.parseDouble(milesValueEntered);

        double displayKm = inputMiles * 1.60934 ;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        tvKm.setText("" + numberFormat.format(displayKm) + " km");


    }

    private void convertFromCelsiusToFahrenheit() {

        String celsiusValueEntered = etCelsius.getText().toString();

        double inputCelsius = Double.parseDouble(celsiusValueEntered);

        double displayFahrenheit = (inputCelsius + 1.8) + 32 ;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        tvFahrenheit.setText("" + numberFormat.format(displayFahrenheit) + " °F");



    }

    private void convertFromFahrenheitToCelsius() {

        String fahrenheitValueEntered = etFahrenheit.getText().toString();

        double inputFahrenheit = Double.parseDouble(fahrenheitValueEntered);

        double displayCelsius = (inputFahrenheit - 32) * 0.5556;
        DecimalFormat numberFormat = new DecimalFormat("#.00");


        tvCelsius.setText("" + numberFormat.format(displayCelsius) + " °C");



    }

    private void convertFromCmToInch() {

        String cmValueEntered = etCm.getText().toString();

        double inputCm = Double.parseDouble(cmValueEntered);

        double displayInch = inputCm / 2.54;

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        tvInch.setText("" + numberFormat.format(displayInch) + " inches");

    }

    private void convertFromInchToCm() {
        //converts from inches in edit tet  to Cm
        //display in centimeter textview

        String inchValueEntered = etInch.getText().toString();

        //converting string to number
        double inputInch = Double.parseDouble(inchValueEntered);

        // converting inch to cm

        double displayCm = inputInch * 2.54;

        //displaying value

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        tvCm.setText("" + numberFormat.format(displayCm) + " cm");




    }
}
