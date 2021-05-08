package group1.android.calculatorkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CircleIntersectionActivity extends AppCompatActivity {

    EditText etX1;
    EditText etY1;
    EditText etRadius1;
    EditText etX2;
    EditText etY2;
    EditText etRadius2;
    TextView tvXCircle;
    TextView tvYCircle;
    TextView tvX2Circle;
    TextView tvY2Circle;
    TextView tvComma1;
    TextView tvComma2;
    Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_intersection);

        etX1 = findViewById(R.id.etX1);
        etY1 = findViewById(R.id.etY1);
        etRadius1 = findViewById(R.id.etRadius1);
        etX2 = findViewById(R.id.etX2);
        etY2 = findViewById(R.id.etY2);
        etRadius2 = findViewById(R.id.etRadius2);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvXCircle = findViewById(R.id.tvXCircle);
        tvYCircle  =findViewById(R.id.tvYCircle);
        tvX2Circle = findViewById(R.id.tvX2Circle);
        tvY2Circle  =findViewById(R.id.tvY2Circle);
        tvComma1 = findViewById(R.id.tvComma1);
        tvComma2 = findViewById(R.id.tvComma2);




        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String etX1String = etX1.getText().toString();
                    String etY1String = etY1.getText().toString();
                    String r0String = etRadius1.getText().toString();
                    String etX2String = etX2.getText().toString();
                    String etY2String = etY2.getText().toString();
                    String r1String = etRadius2.getText().toString();
                    if (!etX1String.isEmpty() && !etY1String.isEmpty() && !etX2String.isEmpty() && !etY2String.isEmpty() && !r0String.isEmpty() && !r1String.isEmpty()) {
                        //(x-a)^2 + (y-b)^2 = r0^2      (x-c)^2 + (y-d)^ = r1^2

                        Double a = Double.valueOf(etX1.getText().toString());
                        Double b = Double.valueOf(etY1.getText().toString());
                        Double r1 = Double.valueOf(etRadius1.getText().toString());
                        Double c = Double.valueOf(etX2.getText().toString());
                        Double d = Double.valueOf(etY2.getText().toString());
                        Double r2 = Double.valueOf(etRadius2.getText().toString());

                        Double x1 = intersection(a, b, c, d, r1, r2, true, true);
                        Double y1 = intersection(a, b, c, d, r1, r2, false, false);
                        Double x2 = intersection(a, b, c, d, r1, r2, true, false);
                        Double y2 = intersection(a, b, c, d, r1, r2, false, true);

                        String StringX1Intersection = String.format("%.2f", x1);
                        String StringY1Intersection = String.format("%.2f", y1);
                        String StringX2Intersection = String.format("%.2f", x2);
                        String StringY2Intersection = String.format("%.2f", y2);
                        if (StringX1Intersection.equals("NaN") && StringY1Intersection.equals("NaN") && StringX2Intersection.equals("NaN") && StringY2Intersection.equals("NaN")) {
                            Toast.makeText(CircleIntersectionActivity.this, "Circles do not intersect!", Toast.LENGTH_SHORT).show();
                        } else if (StringX1Intersection.equals(StringX2Intersection) && StringY1Intersection.equals(StringY2Intersection)) {
                            tvXCircle.setText(StringX1Intersection);
                            tvYCircle.setText(StringY1Intersection);
                            tvComma1.setText(",");
                        } else {
                            tvXCircle.setText(StringX1Intersection);
                            tvYCircle.setText(StringY1Intersection);
                            tvX2Circle.setText(StringX2Intersection);
                            tvY2Circle.setText(StringY2Intersection);
                            tvComma1.setText(",");
                            tvComma2.setText(",");
                        }


                    } else {
                        Toast.makeText(CircleIntersectionActivity.this, "Fill in all Fields!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(CircleIntersectionActivity.this, "SYNTAX Error", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

        public double intersection(double a, double b, double c, double d, double r0, double r1, boolean forX, boolean addition) {
            Double intersection = null;
            //Distance between two circles centers
            Double D = Math.sqrt(Math.pow(c-a, 2) + Math.pow(d-b, 2));
            Double var1 = 0.25*Math.sqrt((D+r0+r1)*(D+r0-r1)*(D-r0+r1)*(-D+r0+r1));

            if (forX && addition)
            {
                intersection = (a + c)/2 + (((c - a) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) + (2 * ((b - d) / Math.pow(D, 2))) * var1;
                return intersection;
            }

            else if (forX && !addition)
            {
                intersection = (a + c)/2 + (((c - a) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) - (2 * ((b - d) / Math.pow(D, 2))) * var1;
                return intersection;
            }

            else if (!forX && addition)
            {
                intersection = (b + d)/2 + (((d - b) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) + (2 * ((a - c) / Math.pow(D, 2))) * var1;
                return intersection;
            }

            else if
            (!forX && !addition) {
                intersection = (b + d)/2 + (((d - b) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) - (2 * ((a - c) / Math.pow(D, 2))) * var1;
                return intersection;
            }
            return intersection;
        }
}