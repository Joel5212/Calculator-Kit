package group1.android.calculatorkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSimpleCalculator;
    Button btnGeometryCalculator;
    Button btnMatrixCalculator;
    Button btnConversionCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleCalculator = findViewById(R.id.btnSimpleCalculator);
        btnGeometryCalculator = findViewById(R.id.btnGeometryCalculator);
        btnMatrixCalculator = findViewById(R.id.btnMatrixCalculator);
        btnConversionCalculator = findViewById(R.id.btnConversionCalculator);

        btnSimpleCalculator.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SimpleCalculatorActivity.class);
            startActivity(i);
        });

        btnGeometryCalculator.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, GeometryCalculatorActivity.class);
            startActivity(i);
        });

        btnMatrixCalculator.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MatrixCalculatorActivity.class);
            startActivity(i);
        });

        btnConversionCalculator.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ConversionCalculatorActivity.class);
            startActivity(i);
        });
    }
}