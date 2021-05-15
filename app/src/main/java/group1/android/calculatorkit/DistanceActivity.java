package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DistanceActivity extends AppCompatActivity {

    EditText etDistanceX;
    EditText etDistanceY;
    EditText etDistanceX2;
    EditText etDistanceY2;
    Button btnCalculateDistance;
    TextView tvDistance;
    TextView tvDDecimals;
    SeekBar sbD;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        etDistanceX = findViewById(R.id.etDistanceX);
        etDistanceY = findViewById(R.id.etDistanceY);
        etDistanceX2 = findViewById(R.id.etDistanceX2);
        etDistanceY2 = findViewById(R.id.etDistanceY2);
        tvDistance = findViewById(R.id.tvDistance);
        btnCalculateDistance = findViewById(R.id.btnCalculateDistance);
        sbD = findViewById(R.id.sbD);
        tvDDecimals = findViewById(R.id.tvDDecimals);


        sbD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvDDecimals.setText(String.valueOf(progress));

                btnCalculateDistance.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Double X = Double.parseDouble(etDistanceX.getText().toString());
                            Double Y = Double.parseDouble(etDistanceY.getText().toString());
                            Double X2 = Double.parseDouble(etDistanceX2.getText().toString());
                            Double Y2 = Double.parseDouble(etDistanceY2.getText().toString());
                            Double distance = Math.sqrt(Math.pow(X2 - X, 2) + Math.pow(Y2 - Y, 2));
                            distance = round(distance, progress);
                            tvDistance.setText(String.valueOf(distance));
                        } catch (Exception e) {
                            Toast.makeText(DistanceActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
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

        btnCalculateDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double X = Double.parseDouble(etDistanceX.getText().toString());
                    double Y = Double.parseDouble(etDistanceY.getText().toString());
                    double X2 = Double.parseDouble(etDistanceX2.getText().toString());
                    double Y2 = Double.parseDouble(etDistanceY2.getText().toString());
                    double distance = Math.round(Math.sqrt(Math.pow(X2 - X, 2) + Math.pow(Y2 - Y, 2)));
                    double roundedDistance = round(distance, 0);
                    tvDistance.setText(String.valueOf(roundedDistance));
                } catch (Exception e) {
                    Toast.makeText(DistanceActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
    public double round(double distance, Integer progress)
    {
        double num = 1;
        for(int i = 0; i < progress; i++)
        {
            num*=10;
        }
        return Math.round(distance*num)/num;
    }

}
