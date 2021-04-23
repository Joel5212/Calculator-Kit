package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LineIntersectionActivity extends AppCompatActivity {
   private TextView etSlope;
   private TextView etSlope2;
   private TextView etSlope3;
   private TextView etb;
   private TextView etb2;
   private TextView etb3;
   private TextView tvXInt;
   private TextView tvYInt;
   private Button btnIntersection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_intersection);
        etSlope = findViewById(R.id.etSlope);
        etb = findViewById(R.id.etb);
        etSlope2 = findViewById(R.id.etSlope2);
        etb2 = findViewById(R.id.etb2);
        etSlope3 = findViewById(R.id.etSlope3);
        etb3 = findViewById(R.id.etb3);
        tvXInt = findViewById(R.id.tvXInt);
        tvYInt = findViewById(R.id.tvYInt);
        btnIntersection = findViewById(R.id.btnIntersection);



        btnIntersection.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View v) {
                    String etSlopeString = etSlope.getText().toString();
                    String etbString = etb.getText().toString();
                    String etSlopeString2 = etSlope2.getText().toString();
                    String etbString2 = etb2.getText().toString();
                    String etSlopeString3 = etSlope3.getText().toString();
                    String etbString3 = etb3.getText().toString();
                    Double etSlopeNum;
                    Double etbNum;
                    Double etSlopeNum2;
                    Double etbNum2;
                    Double etSlopeNum3;
                    Double etbNum3;

                    try {

                        if (((etSlopeString.isEmpty() == false || etbString.isEmpty() == false) && (etSlopeString2.isEmpty() == false || etbString2.isEmpty() == false)) && (etSlopeString3.isEmpty() == true && etbString3.isEmpty() == true))
                        {
                            if(etSlopeString.isEmpty())
                            {
                                etSlopeNum = 0.0;
                            }
                            else
                            {
                                etSlopeNum = Double.parseDouble(etSlopeString);
                            }

                            if(etbString.isEmpty())
                            {
                                etbNum = 0.0;
                            }
                            else
                            {
                                etbNum = Double.parseDouble(etbString);
                            }

                            if(etSlopeString2.isEmpty())
                            {
                                etSlopeNum2 = 0.0;
                            }
                            else
                            {
                                etSlopeNum2 = Double.parseDouble(etSlopeString2);
                            }

                            if(etbString2.isEmpty())
                            {
                                etbNum2 = 0.0;
                            }
                            else
                            {
                                etbNum2 =  Double.parseDouble(etbString2);
                            }
                            findIntersection(etSlopeNum, etbNum, etSlopeNum2, etbNum2);
                        }
                        else if (((etSlopeString.isEmpty() == false || etbString.isEmpty() == false) && (etSlopeString3.isEmpty() == false || etbString3.isEmpty() == false)) && (etSlopeString2.isEmpty() == true && etbString2.isEmpty() == true))
                        {
                            if(etSlopeString.isEmpty())
                            {
                                etSlopeNum = 0.0;
                            }
                            else
                            {
                                etSlopeNum = Double.parseDouble(etSlopeString);
                            }

                            if(etbString.isEmpty())
                            {
                                etbNum = 0.0;
                            }
                            else
                            {
                                etbNum = Double.parseDouble(etbString);
                            }

                            if(etSlopeString3.isEmpty())
                            {
                                etSlopeNum3 = 0.0;
                            }
                            else
                            {
                                etSlopeNum3 = Double.parseDouble(etSlopeString3);
                            }

                            if(etbString3.isEmpty())
                            {
                                etbNum3 = 0.0;
                            }
                            else
                            {
                                etbNum3 =  Double.parseDouble(etbString3);
                            }
                            findIntersection(etSlopeNum, etbNum, etSlopeNum3, etbNum3);
                        }
                        else if (((etSlopeString2.isEmpty() == false || etbString2.isEmpty() == false) && (etSlopeString3.isEmpty() == false || etbString3.isEmpty() == false)) && (etSlopeString.isEmpty() == true && etbString.isEmpty() == true))
                        {
                            if(etSlopeString2.isEmpty())
                            {
                                etSlopeNum2 = 0.0;
                            }
                            else
                            {
                                etSlopeNum2 = Double.parseDouble(etSlopeString2);
                            }

                            if(etbString2.isEmpty())
                            {
                                etbNum2 = 0.0;
                            }
                            else
                            {
                                etbNum2 = Double.parseDouble(etbString2);
                            }

                            if(etSlopeString3.isEmpty())
                            {
                                etSlopeNum3 = 0.0;
                            }
                            else
                            {
                                etSlopeNum3 = Double.parseDouble(etSlopeString3);
                            }

                            if(etbString3.isEmpty())
                            {
                                etbNum3 = 0.0;
                            }
                            else
                            {
                                etbNum3 =  Double.parseDouble(etbString3);
                            }
                            findIntersection(etSlopeNum2, etbNum2, etSlopeNum3, etbNum3);
                        }
                        else if ((etSlopeString.isEmpty() == false || etbString.isEmpty() == false) && (etSlopeString2.isEmpty() == false || etbString2.isEmpty() == false) && (etSlopeString3.isEmpty() == false || etbString3.isEmpty() == false))
                        {
                            if(etSlopeString.isEmpty())
                            {
                                etSlopeNum = 0.0;
                            }
                            else
                            {
                                etSlopeNum = Double.parseDouble(etSlopeString);
                            }

                            if(etbString.isEmpty())
                            {
                                etbNum = 0.0;
                            }
                            else
                            {
                                etbNum = Double.parseDouble(etbString);
                            }

                            if(etSlopeString2.isEmpty())
                            {
                                etSlopeNum2 = 0.0;
                            }
                            else
                            {
                                etSlopeNum2 = Double.parseDouble(etSlopeString2);
                            }

                            if(etbString2.isEmpty())
                            {
                                etbNum2 = 0.0;
                            }
                            else
                            {
                                etbNum2 =  Double.parseDouble(etbString2);
                            }

                            if(etSlopeString3.isEmpty())
                            {
                                etSlopeNum3 = 0.0;
                            }
                            else
                            {
                                etSlopeNum3 = Double.parseDouble(etSlopeString3);
                            }

                            if(etbString3.isEmpty())
                            {
                                etbNum3 = 0.0;
                            }
                            else
                            {
                                etbNum3 =  Double.parseDouble(etbString3);
                            }


                            findIntersection(etSlopeNum, etbNum, etSlopeNum2, etbNum2, etSlopeNum3, etbNum3);
                        } else {
                            Toast.makeText(LineIntersectionActivity.this, "Select at least two lines!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(LineIntersectionActivity.this, "er" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }





    private void findIntersection(Double slopeValue, Double etbValue, Double slopeValue2, Double etbValue2) {
        String x;
        String y;
        double newSlopeValue = 0;
        double newetbValue = 0;

            newSlopeValue = slopeValue - slopeValue2;
            newetbValue = etbValue2 - etbValue;
            double xNum = newetbValue / newSlopeValue;
            double yNum = slopeValue * xNum + etbValue;
            x = String.valueOf(xNum);
            y = String.valueOf(yNum);
            if (x.equals("-0.0")) {
                x = "0.0";
            }
            if (y.equals("-0.0")) {
                y = "0.0";
            }
            if((x.equals("Infinity") && y.equals("Infinity")) || (x.equals("-Infinity") && y.equals("-Infinity")) || (x.equals("NaN") && y.equals("NaN")))
            {
                x = "";
                y = "";

                tvXInt.setText(x);
                tvYInt.setText(y);
                Toast.makeText(this, "Lines do not intersect", Toast.LENGTH_SHORT).show();
            }
            {
            tvXInt.setText(x);
            tvYInt.setText(y);
            }


    }

    private void findIntersection(Double slopeValue, Double etbValue, Double slopeValue2, Double etbValue2, Double slopeValue3, Double etbValue3)
    {
        String x;
        String y;
        double newSlopeValue = 0;
        double newetbValue = 0;
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
            y = "0.0";
        }
        if((x.equals("Infinity") && y.equals("Infinity")) || (x.equals("-Infinity") && y.equals("-Infinity")) || (x.equals("NaN") && y.equals("NaN")))
        {
            x = "";
            y = "";

            tvXInt.setText(x);
            tvYInt.setText(y);
            Toast.makeText(this, "Lines do not intersect", Toast.LENGTH_SHORT).show();
        }
        else
        {
            tvXInt.setText(x);
            tvYInt.setText(y);
        }

    }
}
