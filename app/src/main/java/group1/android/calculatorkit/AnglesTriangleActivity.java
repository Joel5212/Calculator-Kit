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

            // Check each angle to see if they are between 1 - 178
            boolean angle1IsValid = isAngleValid(angle1, "1");
            boolean angle2IsValid = isAngleValid(angle2, "2");

            // If all are valid, compute missing angles
            if (angle1IsValid && angle2IsValid) {

                // Changes the angle from String to int
                // Also, if angle is an empty string, treat it as 0
                int intAngle1 = getAngle(angle1);
                int intAngle2 = getAngle(angle2);

                // Sum all angles
                int sumOfAngles = intAngle1 + intAngle2;

                // Check if sum is valid
                // If the sum of angles are above 359,
                // do not compute since no quadrilateral
                // can be above 360 degrees and a missing
                // degree must be at least 1.
                if (!isSumValid(sumOfAngles)) {
                    return;
                }

                // Find the missing angle(s) by subtracting by the sum by 360.
                int angle3OrMissingAngles = 180 - sumOfAngles;

                // If one of the empty strings were converted to 0,
                // Then there are more than one missing angle to find.
                if (intAngle1 == 0 || intAngle2 == 0) {

                    // If the missing angle range is 1, all angles are 1.
                    if (angle3OrMissingAngles == 1) {
                        String missingAngles = "All missing angles are 1 degree.";
                        tvMissingAngle.setText(missingAngles);
                        return;
                    }

                    // Set answer by setting the text as the following.
                    String missingAngles = "The missing angles can be between 1 - " + angle3OrMissingAngles;
                    tvMissingAngle.setText(missingAngles);
                    return;
                }

                // If there is only one missing angle, set the text as just a number.
                tvMissingAngle.setText(Integer.toString(angle3OrMissingAngles));
            }
        });
    }

    /**
     * Returns false if angle is 0 or greater than 178.
     * If not, the angle is valid or an empty string, return true.
     * @param angle       String of the angle
     * @param angleNumber String of the angle's number
     * @return boolean    Whether or not the angle is valid
     */
    private boolean isAngleValid(String angle, String angleNumber) {

        if (angle.matches("")) return true;

        int intAngle = Integer.parseInt(angle);

        if (intAngle > 178) {
            Toast.makeText(this, "Invalid input: Angle " + angleNumber + " should not be greater than 178 degrees.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intAngle == 0) {
            Toast.makeText(this, "Invalid input: Angle " + angleNumber + " should not be 0 degrees.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Returns 0 if string is empty.
     * If not, returns input string as integer
     * @param angle1 The input angle as string
     * @return int   The input angle or 0
     */
    private int getAngle(String angle1) {

        if (angle1.matches("")) return 0;

        return Integer.parseInt(angle1);
    }

    /**
     * Returns a boolean if the sum if greater than 360.
     * @param sumOfAngles Integer of the sum of angles
     * @return boolean    Whether or not sum is valid.
     */
    private boolean isSumValid(int sumOfAngles) {
        if (sumOfAngles > 179) {
            Toast.makeText(this, "Invalid input: Sum of angles should not be greater than or equal to 180.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    /**
     * Class is needed to change password input text that shows bullets as text
     * to not show bullets
     */
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
}
