package group1.android.calculatorkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
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
    TextView tvCDecimals;
    TextView tvCircleX;
    TextView tvCircleY;
    Button btnCalculate;
    SeekBar sbC;



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
        sbC = findViewById(R.id.sbC);
        tvCDecimals = findViewById(R.id.tvCDecimals);
        tvCircleX = findViewById(R.id.tvCircleX);
        tvCircleY = findViewById(R.id.tvCircleY);


       sbC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               tvCDecimals.setText(String.valueOf(progress));

               btnCalculate.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       try {
                               //(x-a)^2 + (y-b)^2 = r0^2      (x-c)^2 + (y-d)^ = r1^2
                               Double a = Double.valueOf(etX1.getText().toString());
                               Double b = Double.valueOf(etY1.getText().toString());
                               Double r1 = Double.valueOf(etRadius1.getText().toString());
                               Double c = Double.valueOf(etX2.getText().toString());
                               Double d = Double.valueOf(etY2.getText().toString());
                               Double r2 = Double.valueOf(etRadius2.getText().toString());

                               Double x1 = intersection(a, b, c, d, r1, r2, true, true, progress);
                               Double y1 = intersection(a, b, c, d, r1, r2, false, false, progress);
                               Double x2 = intersection(a, b, c, d, r1, r2, true, false, progress);
                               Double y2 = intersection(a, b, c, d, r1, r2, false, true, progress);
                               set(x1, x2, y1, y2);
                       }
                       catch (Exception e)
                       {
                           Toast.makeText(CircleIntersectionActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
                       }
                   }


               });

           }






           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //(x-a)^2 + (y-b)^2 = r0^2      (x-c)^2 + (y-d)^ = r1^2
                    Double a = Double.valueOf(etX1.getText().toString());
                    Double b = Double.valueOf(etY1.getText().toString());
                    Double r1 = Double.valueOf(etRadius1.getText().toString());
                    Double c = Double.valueOf(etX2.getText().toString());
                    Double d = Double.valueOf(etY2.getText().toString());
                    Double r2 = Double.valueOf(etRadius2.getText().toString());

                    Double x1 = intersection(a, b, c, d, r1, r2, true, true, 0);
                    Double y1 = intersection(a, b, c, d, r1, r2, false, false, 0);
                    Double x2 = intersection(a, b, c, d, r1, r2, true, false, 0);
                    Double y2 = intersection(a, b, c, d, r1, r2, false, true, 0);
                    set(x1, x2, y1, y2);
                }
                catch (Exception e)
                {
                    Toast.makeText(CircleIntersectionActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }

        public double intersection(double a, double b, double c, double d, double r0, double r1, boolean forX, boolean addition, int progress) {
            Double intersection = null;
            //Distance between two circles centers
            Double D = Math.sqrt(Math.pow(c-a, 2) + Math.pow(d-b, 2));
            Double var1 = 0.25*Math.sqrt((D+r0+r1)*(D+r0-r1)*(D-r0+r1)*(-D+r0+r1));

            if (forX && addition)
            {
                intersection = round((a + c)/2 + (((c - a) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) + (2 * ((b - d) / Math.pow(D, 2))) * var1, progress);
                return intersection;
            }

            else if (forX && !addition)
            {
                intersection = round((a + c)/2 + (((c - a) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) - (2 * ((b - d) / Math.pow(D, 2))) * var1, progress);
                return intersection;
            }

            else if (!forX && addition)
            {
                intersection = round((b + d)/2 + (((d - b) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) + (2 * ((a - c) / Math.pow(D, 2))) * var1, progress);
                return intersection;
            }

            else if
            (!forX && !addition)
            {
                intersection = round((b + d)/2 + (((d - b) * (Math.pow(r0, 2) - Math.pow(r1, 2))) / (2*Math.pow(D, 2))) - (2 * ((a - c) / Math.pow(D, 2))) * var1, progress);
                return intersection;
            }
            return intersection;
        }

        public double round(double intersection, Integer progress)
        {
            double num = 1;
            for(int i = 0; i < progress; i++)
            {
            num*=10;
            }
            return Math.round(intersection*num)/num;
        }

        public void set(Double x1, Double x2, Double y1, Double y2)
        {
            String StringX1Intersection = String.valueOf(x1);
            String StringY1Intersection = String.valueOf(y1);
            String StringX2Intersection = String.valueOf(x2);
            String StringY2Intersection = String.valueOf(y2);

            if (StringX1Intersection.equals("NaN") && StringY1Intersection.equals("NaN") && StringX2Intersection.equals("NaN") && StringY2Intersection.equals("NaN")) {
                Toast.makeText(CircleIntersectionActivity.this, "Circles do not intersect!", Toast.LENGTH_SHORT).show();
            }
            else if (StringX1Intersection.equals(StringX2Intersection) && StringY1Intersection.equals(StringY2Intersection)) {
                tvXCircle.setText(StringX1Intersection);
                tvYCircle.setText(StringY1Intersection);
                tvCircleX.setText("X");
                tvCircleY.setText("Y");

            }
            else
            {
                tvXCircle.setText(StringX1Intersection);
                tvYCircle.setText(StringY1Intersection);
                tvX2Circle.setText(StringX2Intersection);
                tvY2Circle.setText(StringY2Intersection);
                tvCircleX.setText("X");
                tvCircleY.setText("Y");

            }
        }
}