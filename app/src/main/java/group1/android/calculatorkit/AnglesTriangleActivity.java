package group1.android.calculatorkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnglesTriangleActivity extends AppCompatActivity {

    EditText etAngle1;
    EditText etAngle2;
    Button btnFindMissingAngle;
    TextView tvMissingAngle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angles_triangle);

        etAngle1 = findViewById(R.id.etAngle1);
        etAngle2 = findViewById(R.id.etAngle2);
        btnFindMissingAngle = findViewById(R.id.btnFindMissingAngle);
        tvMissingAngle = findViewById(R.id.tvMissingAngle);

        etAngle1.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        etAngle2.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        btnFindMissingAngle.setOnClickListener(v -> {
            
            String angle1 = etAngle1.getText().toString();
            String angle2 = etAngle2.getText().toString();

            tvMissingAngle.setText("");

            /*
            Input validation that checks of empty input
             */
            if (!angle1.matches("") && angle2.matches("")) {
                /*
                Angle 1 has an input, but not Angle 2
                 */
                int intAngle1 = Integer.parseInt(angle1);

                if (intAngle1 > 178) {
                    Toast.makeText(this, "Invalid input: Angle 1 should not be greater than 178 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (intAngle1 == 0) {
                    Toast.makeText(this, "Invalid input: Angle 1 should not be 0 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int missingAnglesRange = 179 - intAngle1;

                /*
                If the missing angle range is 1, both angles are 1.
                 */
                if (missingAnglesRange == 1) {
                    String missingAngles = "Both missing angles are 1 degree.";
                    tvMissingAngle.setText(missingAngles);
                    return;
                }

                String missingAngles = "The two angles can be between 1 - " + missingAnglesRange;
                tvMissingAngle.setText(missingAngles);

            } else if (!angle2.matches("") && angle1.matches("")) {
                /*
                Angle 2 has an input, but not Angle 1
                 */
                int intAngle2 = Integer.parseInt(angle2);

                if (intAngle2 > 178) {
                    Toast.makeText(this, "Invalid input: Angle 2 should not be greater than 178 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (intAngle2 == 0) {
                    Toast.makeText(this, "Invalid input: Angle 2 should not be 0 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int missingAnglesRange = 179 - intAngle2;

                /*
                If the missing angle range is 1, both angles are 1.
                 */
                if (missingAnglesRange == 1) {
                    String missingAngles = "Both missing angles are 1 degree.";
                    tvMissingAngle.setText(missingAngles);
                    return;
                }

                String missingAngles = "The two angles can be between 1 - " + missingAnglesRange;
                tvMissingAngle.setText(missingAngles);

            } else if (angle2.matches("") && angle1.matches("")) {
                /*
                Both Angles 1 and 2 do not have inputs.
                 */
                Toast.makeText(this, "Invalid input: Need values for Angle 1 and Angle 2.", Toast.LENGTH_SHORT).show();
            } else {
                int intAngle1 = Integer.parseInt(angle1);
                int intAngle2 = Integer.parseInt(angle2);
                int sumOfBothAngles = (intAngle1 + intAngle2);

                /*
                Checks if angles are greater than 180.
                 */
                if (sumOfBothAngles >= 180) {
                    Toast.makeText(this, "Invalid input: Sum of angles should not be greater than or equal to 180.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int angle3 = 180 - sumOfBothAngles;

                /*
                Input validation if angles are greater than 178.
                Send a toast message to user indicating which angle is too large.
                NOTE: The text input should not allow for negative values
                so there is no need to check for negative values.
                 */
                if (intAngle1 > 178) {
                    Toast.makeText(this, "Invalid input: Angle 1 should not be greater than 178 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (intAngle2 > 178) {
                    Toast.makeText(this, "Invalid input: Angle 2 should not be greater than 178 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                }

                /*
                Input validation to check if user input a 0 degrees angle.
                 */
                if (intAngle1 == 0) {
                    Toast.makeText(this, "Invalid input: Angle 1 should not be 0 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (intAngle2 == 0) {
                    Toast.makeText(this, "Invalid input: Angle 2 should not be 0 degrees.", Toast.LENGTH_SHORT).show();
                    return;
                }

                tvMissingAngle.setText(Integer.toString(angle3));
            }
        });
    }

    /*
    Class is needed to change password input text that shows bullets as text
    to not show bullets
     */
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
}
