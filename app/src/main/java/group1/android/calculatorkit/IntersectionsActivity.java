package group1.android.calculatorkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class IntersectionsActivity extends AppCompatActivity {
   TextView etSlope;
   TextView etSlope2;
   TextView etSlope3;
   TextView etb;
   TextView etb2;
   TextView etb3;
   TextView tvXInt;
   TextView tvYInt;
   Button btnIntersection;
   EditText etCheckBox;
   EditText etCheckBox2;
   EditText etCheckBox3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intersections);
        etSlope = findViewById(R.id.etSlope);
        etb = findViewById(R.id.etb);
        etSlope2 = findViewById(R.id.etSlope2);
        etb2 = findViewById(R.id.etb2);
        etSlope3 = findViewById(R.id.etSlope3);
        etb3 = findViewById(R.id.etb);
        tvXInt = findViewById(R.id.tvXInt);
        tvYInt = findViewById(R.id.tvYInt);
        btnIntersection = findViewById(R.id.btnIntersection);
        etCheckBox = findViewById(R.id.etCheckBox);
        etCheckBox2 = findViewById(R.id.etCheckBox2);
        etCheckBox3 = findViewById(R.id.etCheckBox3);





        btnIntersection.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                    String etCheckBoxX = etCheckBox.getText().toString();
                    String etCheckBoxX2 = etCheckBox2.getText().toString();
                    String etCheckBoxX3 = etCheckBox3.getText().toString();
                    try {
                        if(etCheckBoxX.equals("X") && etCheckBoxX2.equals("X") && etCheckBoxX3.equals("X"))
                        {
                            Double etSlopeNum = Double.parseDouble(etSlope.getText().toString());
                            Double etbNum = Double.parseDouble(etb.getText().toString());
                            Double etSlopeNum2 = Double.parseDouble(etSlope2.getText().toString());
                            Double etbNum2 = Double.parseDouble(etb2.getText().toString());
                            Double etSlopeNum3 = Double.parseDouble(etSlope3.getText().toString());
                            Double etbNum3 = Double.parseDouble(etb3.getText().toString());
                            findIntersection(etSlopeNum, etbNum, etSlopeNum2, etbNum2, etSlopeNum3, etbNum3);
                        }
                        else if (etCheckBoxX.equals("X") && etCheckBoxX2.equals("X")) {
                            Double etSlopeNum = Double.parseDouble(etSlope.getText().toString());
                            Double etbNum = Double.parseDouble(etb.getText().toString());
                            Double etSlopeNum2 = Double.parseDouble(etSlope2.getText().toString());
                            Double etbNum2 = Double.parseDouble(etb2.getText().toString());
                            findIntersection(etSlopeNum, etbNum, etSlopeNum2, etbNum2);
                        } else if (etCheckBoxX.equals("X") && etCheckBoxX3.equals("X")) {
                            Double etSlopeNum = Double.parseDouble(etSlope.getText().toString());
                            Double etbNum = Double.parseDouble(etb.getText().toString());
                            Double etSlopeNum3 = Double.parseDouble(etSlope3.getText().toString());
                            Double etbNum3 = Double.parseDouble(etb3.getText().toString());
                            findIntersection(etSlopeNum, etbNum, etSlopeNum3, etbNum3);
                        } else if (etCheckBoxX2.equals("X") && etCheckBoxX3.equals("X")) {
                            Double etSlopeNum2 = Double.parseDouble(etSlope2.getText().toString());
                            Double etbNum2 = Double.parseDouble(etb2.getText().toString());
                            Double etSlopeNum3 = Double.parseDouble(etSlope3.getText().toString());
                            Double etbNum3 = Double.parseDouble(etb3.getText().toString());
                            findIntersection(etSlopeNum2, etbNum2, etSlopeNum3, etbNum3);
                        }
                        else
                        {
                            Toast.makeText(IntersectionsActivity.this, "Select at least two lines!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(IntersectionsActivity.this, "Empty Values for selected or SYNTAX ERROR!", Toast.LENGTH_SHORT).show();
                    }
                }
        });




    }

    private void findIntersection(Double slopeValue, Double etbValue, Double slopeValue2, Double etbValue2) {
        String x;
        String y;
        double newSlopeValue = 0;
        double newetbValue = 0;
        if (!(slopeValue == 0 && slopeValue2 == 0) || (slopeValue != slopeValue2)) {
            if (!(etbValue == 0 && etbValue2 == 0)) {
                newSlopeValue = slopeValue - slopeValue2;
                newetbValue = etbValue2 - etbValue;
                double xNum = newetbValue / newSlopeValue;
                double yNum = slopeValue * xNum + etbValue;
                x = String.valueOf(xNum);
                y = String.valueOf(yNum);
                if(x == "-0.0")
                {
                    x = "0.0";
                }
                if(y == "-0.0")
                {
                    y = "-0.0";
                }
                tvXInt.setText(x);
                tvYInt.setText(y);
            }
            else {
                tvXInt.setText("0");
                tvYInt.setText("0");
            }
        }
        else
        {
            Toast.makeText(this, "Lines do not intersect", Toast.LENGTH_SHORT).show();
        }

    }

    private void findIntersection(Double slopeValue, Double etbValue, Double slopeValue2, Double etbValue2, Double slopeValue3, Double etbValue3)
    {
        String x;
        String y;
        double newSlopeValue = 0;
        double newetbValue = 0;
        if (!(slopeValue == 0 && slopeValue2 == 0 && slopeValue3 == 0) || (slopeValue != slopeValue2 && slopeValue2 != slopeValue3 )) {
            if (!(etbValue == 0 && etbValue2 == 0 && etbValue3 == 0))
            {
                newSlopeValue = slopeValue - slopeValue2;
                newetbValue = etbValue2 - etbValue;
                double xNum = newetbValue / newSlopeValue;
                double yNum2 = slopeValue3*xNum + etbValue3;
                double newetbValue2 = yNum2 - etbValue3;
                double xNum2 = newetbValue2/slopeValue3;
                x = String.valueOf(xNum2);
                y = String.valueOf(yNum2);
                if(x == "-0.0")
                {
                    x = "0.0";
                }
                if(y == "-0.0")
                {
                    y = "-0.0";
                }
                tvXInt.setText(x);
                tvYInt.setText(y);
            }
            else
            {
                tvXInt.setText("0");
                tvYInt.setText("0");
            }
        }
        else
        {
            Toast.makeText(this, "Lines do not intersect", Toast.LENGTH_SHORT).show();
        }
    }
}
