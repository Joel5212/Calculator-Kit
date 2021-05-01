package group1.android.calculatorkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CircleAndLineIntersectionActivity extends AppCompatActivity {
    EditText etCLX;
    EditText etCLY;
    EditText etCLRadius;
    EditText etCLM;
    EditText etCLB;
    Button btnCL;
    TextView tvCLX1;
    TextView tvCLX2;
    TextView tvCLY1;
    TextView tvCLY2;
    SeekBar sbCL;
    TextView tvCLDecimals;
    TextView tvCLX;
    TextView tvCLY;
    boolean hasNotUsedSeekBar = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_and_line_intersection);
        etCLX = findViewById(R.id.etCLX);
        etCLY = findViewById(R.id.etCLY);
        etCLRadius = findViewById(R.id.etCLRadius);
        etCLM = findViewById(R.id.etCLM);
        etCLB = findViewById(R.id.etCLB);
        btnCL = findViewById(R.id.btnCL);
        tvCLX1 = findViewById(R.id.tvCLX1);
        tvCLX2 = findViewById(R.id.tvCLX2);
        tvCLY1 = findViewById(R.id.tvCLY1);
        tvCLY2 = findViewById(R.id.tvCLY2);
        sbCL = findViewById(R.id.sbCL);
        tvCLDecimals = findViewById(R.id.tvCLDecimals);
        tvCLX = findViewById(R.id.tvCLX);
        tvCLY = findViewById(R.id.tvCLY);

            sbCL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    tvCLDecimals.setText(String.valueOf(progress));

                    btnCL.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            try {
                                double CLXNum = Double.parseDouble(etCLX.getText().toString());
                                double CLMNum = Double.parseDouble(etCLM.getText().toString());
                                double CLYNum = Double.parseDouble(etCLY.getText().toString());
                                double CLBNum = Double.parseDouble(etCLB.getText().toString());
                                double CLRadiusNum = Double.parseDouble(etCLRadius.getText().toString());

                                if (progress == 0) {
                                    findIntersection(CLXNum, CLMNum, CLYNum, CLBNum, CLRadiusNum, null);
                                } else {
                                    findIntersection(CLXNum, CLMNum, CLYNum, CLBNum, CLRadiusNum, progress);
                                }
                            }
                            catch (Exception e)
                            {
                                Toast.makeText(getApplicationContext(), "Error: Check Inputs!", Toast.LENGTH_SHORT).show();
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

            if (hasNotUsedSeekBar == true) {
                btnCL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double CLXNum = Double.parseDouble(etCLX.getText().toString());
                            double CLMNum = Double.parseDouble(etCLM.getText().toString());
                            double CLYNum = Double.parseDouble(etCLY.getText().toString());
                            double CLBNum = Double.parseDouble(etCLB.getText().toString());
                            double CLRadiusNum = Double.parseDouble(etCLRadius.getText().toString());
                            findIntersection(CLXNum, CLMNum, CLYNum, CLBNum, CLRadiusNum, null);
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getApplicationContext(), "Error: Check Inputs!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }


    }














    public double quadraticCalculation(double A, double B, double C, String negativeOrPositive)
    {
        if(negativeOrPositive.equals("positive"))
        {
            return (-B + Math.sqrt(Math.pow(B,2) - 4*A*C))/(2*A);
        }
        else if(negativeOrPositive.equals("negative"))
        {
            return (-B - Math.sqrt(Math.pow(B,2) - 4*A*C))/(2*A);
        }
        return -1;

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

    public void findIntersection(double CLXNum, double CLMNum, double CLYNum, double CLBNum, double CLRadiusNum, Integer progress)
    {


        double CLB2;
        double CLC;
        double CLD;

        CLXNum *= -1;
        CLYNum *= -1;

        CLB2 = CLXNum + CLXNum;
        CLC = Math.pow(CLXNum, 2);
        CLD = CLBNum + CLYNum;


        double A = Math.pow(CLMNum, 2);
        double B = CLMNum * CLD + CLD * CLMNum;
        double C = CLD * CLD + CLC;

        A += 1;
        B = B + CLB2;
        C -= Math.pow(CLRadiusNum, 2);

        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;

        String x1String = null;
        String x2String = null;
        String y1String = null;
        String y2String = null;
        if(progress != null)
        {
            x1 = round(quadraticCalculation(A, B, C, "positive"), progress);
            y1 = round(CLMNum * x1 + CLBNum, progress);
            x2 = round(quadraticCalculation(A, B, C, "negative"), progress);
            y2 = round(CLMNum * x2 + CLBNum, progress);
        }
        else
        {
            x1 = Math.round(quadraticCalculation(A, B, C, "positive"));
            y1 = Math.round(CLMNum * x1 + CLBNum);
            x2 = Math.round(quadraticCalculation(A, B, C, "negative"));
            y2 = Math.round(CLMNum * x2 + CLBNum);

        }

        x1String = String.valueOf(x1);
        x2String = String.valueOf(y1);
        y1String = String.valueOf(x2);
        y2String = String.valueOf(y2);

        tvCLX1.setText(x1String);
        tvCLX2.setText(x2String);
        tvCLY1.setText(y1String);
        tvCLY2.setText(y2String);
        tvCLX.setText("X");
        tvCLY.setText("Y");

    }
}

