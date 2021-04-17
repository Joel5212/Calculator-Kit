package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.*;

public class SimpleCalculatorActivity extends AppCompatActivity {
    private Button btnDivide;
    private Button btnPower;
    private Button btnLeftPar;
    private Button btnRightPar;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn6;
    private Button btn5;
    private Button btn4;
    private Button btn3;
    private Button btn2;
    private Button btn1;
    private Button btn0;
    private Button btnNeg;
    private Button btnMultiply;
    private Button btnEquals;
    private Button btnDot;
    private ImageButton btnBackspace;
    private Button btnClear;
    private EditText etDisplay;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnSqrt;
    private int count = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        etDisplay = findViewById(R.id.etDisplay);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEquals = findViewById(R.id.btnEquals);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        btnLeftPar = findViewById(R.id.btnLeftPar);
        btnRightPar = findViewById(R.id.btnRightPar);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);
        btnNeg = findViewById(R.id.btnNeg);
        btnDot = findViewById(R.id.btnDot);
        btnBackspace = findViewById(R.id.btnBackspace);
        btnPower = findViewById(R.id.btnPower);
        etDisplay.setShowSoftInputOnFocus(false);
        btnLeftPar = findViewById(R.id.btnLeftPar);
        btnRightPar = findViewById(R.id.btnRightPar);
        btnSqrt = findViewById(R.id.btnSqrt);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText("");
            }
        });



        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int cursorPosition = etDisplay.getSelectionStart();
                    String currentString = etDisplay.getText().toString();
                    String leftString = currentString.substring(0, cursorPosition - 1);
                    String rightString = currentString.substring(cursorPosition);

                    etDisplay.setText(String.format("%s%s", leftString, rightString));
                    etDisplay.setSelection(cursorPosition - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userExp = etDisplay.getText().toString();
                if (correctUseOfNeg(userExp) && correctUseOfMinus(userExp))
                {
                    if (correctUseOfNegOp(userExp))
                    {
                        userExp = userExp.replaceAll("÷", "/");
                        userExp = userExp.replaceAll("×", "*");
                        userExp = userExp.replaceAll("—", "-");
                        userExp = userExp.replaceAll("√", "sqrt");
                        Expression exp = new Expression(userExp);
                        String result = String.valueOf(exp.calculate());
                        if (!result.equals("NaN"))
                        {
                            etDisplay.setText(result);
                            etDisplay.setSelection(result.length());
                        }
                        else
                        {
                            Toast.makeText(SimpleCalculatorActivity.this, "Syntax ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SimpleCalculatorActivity.this, "Syntax ERROR: Use () around negative values, —- or +- not allowed", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(SimpleCalculatorActivity.this, "Syntax ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentString = etDisplay.getText().toString();
                int cursorPosition = etDisplay.getSelectionStart();
                String leftString = currentString.substring(0, cursorPosition);
                String rightString = currentString.substring(cursorPosition);
                if (etDisplay.getText().toString().equals("Enter in a value..")) {
                    etDisplay.setText("-");
                    etDisplay.setSelection(cursorPosition + 1);

                } else {
                    etDisplay.setText(String.format("%s%s%s", leftString, "-", rightString));
                    etDisplay.setSelection(cursorPosition + 1);

                }
            }
        });

      btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String currentString = etDisplay.getText().toString();
                int cursorPosition = etDisplay.getSelectionStart();
                String leftString = currentString.substring(0, cursorPosition);
                String rightString = currentString.substring(cursorPosition);
                if (etDisplay.getText().toString().equals("Enter in a value..")) {
                    etDisplay.setText("√()");
                    etDisplay.setSelection(cursorPosition + 2);

                } else {
                    etDisplay.setText(String.format("%s%s%s", leftString, "√()", rightString));
                    etDisplay.setSelection(cursorPosition + 2);

                }


            }
      });


        etDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDisplay.getText().toString().equals("Enter in a value..")) {
                    etDisplay.setText("");
                }
            }
        });

        etDisplay.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (etDisplay.getText().toString().equals("Enter in a value..")) {
                        etDisplay.setText("");
                    }
                }
            }
        });


        View.OnClickListener numAndOpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                updateCalculation(b.getText().toString());
            }
        };
        btnDivide.setOnClickListener(numAndOpListener);
        btnLeftPar.setOnClickListener(numAndOpListener);
        btnRightPar.setOnClickListener(numAndOpListener);
        btn0.setOnClickListener(numAndOpListener);
        btn1.setOnClickListener(numAndOpListener);
        btn2.setOnClickListener(numAndOpListener);
        btn3.setOnClickListener(numAndOpListener);
        btn4.setOnClickListener(numAndOpListener);
        btn5.setOnClickListener(numAndOpListener);
        btn6.setOnClickListener(numAndOpListener);
        btn7.setOnClickListener(numAndOpListener);
        btn8.setOnClickListener(numAndOpListener);
        btn9.setOnClickListener(numAndOpListener);
        btnMultiply.setOnClickListener(numAndOpListener);
        btnDot.setOnClickListener(numAndOpListener);
        btnPower.setOnClickListener(numAndOpListener);
        btnRightPar.setOnClickListener(numAndOpListener);
        btnLeftPar.setOnClickListener(numAndOpListener);
        btnPlus.setOnClickListener(numAndOpListener);
        btnMinus.setOnClickListener(numAndOpListener);



    }

    private void updateCalculation(String addString) {
        String currentString = etDisplay.getText().toString();
        int cursorPosition = etDisplay.getSelectionStart();
        String leftString = currentString.substring(0, cursorPosition);
        String rightString = currentString.substring(cursorPosition);
        if (etDisplay.getText().toString().equals("Enter in a value..")) {
            etDisplay.setText(addString);
            etDisplay.setSelection(cursorPosition + 1);
        } else {
            etDisplay.setText(String.format("%s%s%s", leftString, addString, rightString));
            etDisplay.setSelection(cursorPosition + 1);
        }


    }

    public boolean correctUseOfNeg(String stringOfDisplay) //check to see if neg was used correctly
    {
        int i = 0;
        for (i = 0; i < stringOfDisplay.length(); i++) {
            if (stringOfDisplay.substring(i, i + 1).equals("-")) {
                if (i != 0) {
                    if (!(stringOfDisplay.substring(i - 1, i).equals("+") || stringOfDisplay.substring(i - 1, i).equals("—") || stringOfDisplay.substring(i - 1, i).equals("×") || stringOfDisplay.substring(i - 1, i).equals("÷") || stringOfDisplay.substring(i - 1, i).equals("^") || stringOfDisplay.substring(i - 1, i).equals("("))) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public boolean correctUseOfMinus(String stringOfDisplay) //check to see if neg was used correctly
    {
        int i = 0;
        for (i = 0; i < stringOfDisplay.length(); i++) {
            if (stringOfDisplay.substring(i, i + 1).equals("—"))
            {
                if (i != 0)
                {
                    if (stringOfDisplay.substring(i - 1, i).equals("+") || stringOfDisplay.substring(i - 1, i).equals("×") || stringOfDisplay.substring(i - 1, i).equals("÷") || stringOfDisplay.substring(i - 1, i).equals("^") || stringOfDisplay.substring(i - 1, i).equals("("))
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean correctUseOfNegOp(String stringOfDisplay) //check to see if neg was used correctly
    {
        int i = 0;
        for (i = 0; i < stringOfDisplay.length(); i++) {
            if (stringOfDisplay.substring(i, i + 1).equals("-"))
            {
                if (i != 0)
                {
                    if ((stringOfDisplay.substring(i - 1, i).equals("+") || stringOfDisplay.substring(i - 1, i).equals("—")))
                    {
                        return false;
                    }
                }
            }

        }
        return true;
    }










}