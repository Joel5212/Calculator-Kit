package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MatrixCalculatorActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText edRowA;
    private EditText edRowB;
    private EditText edColumnA;
    private EditText edColumnB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_calculator);

        btnNext = findViewById(R.id.btnNext);

    }
}
