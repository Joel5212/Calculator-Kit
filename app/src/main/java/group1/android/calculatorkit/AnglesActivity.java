package group1.android.calculatorkit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnglesActivity extends AppCompatActivity {

    Button btnAnglesTriangle;
    Button btnAnglesQuadrilateral;
    Button btnAnglesPentagon;
    Button btnAnglesHexagon;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angles);

        btnAnglesTriangle = findViewById(R.id.btnAngleTriangle);
        btnAnglesQuadrilateral = findViewById(R.id.btnAngleQuadrilateral);
        btnAnglesPentagon = findViewById(R.id.btnAnglePentagon);
        btnAnglesHexagon = findViewById(R.id.btnAngleHexagon);

        btnAnglesTriangle.setOnClickListener(v -> {
            Intent i = new Intent(AnglesActivity.this, AnglesTriangleActivity.class);
            startActivity(i);
        });

        btnAnglesQuadrilateral.setOnClickListener(v -> {
            Intent i = new Intent(AnglesActivity.this, AnglesQuadrilateralActivity.class);
            startActivity(i);
        });

        btnAnglesPentagon.setOnClickListener(v -> {
            Intent i = new Intent(AnglesActivity.this, AnglesPentagonActivity.class);
            startActivity(i);
        });

        btnAnglesHexagon.setOnClickListener(v -> {
            Intent i = new Intent(AnglesActivity.this, AnglesHexagonActivity.class);
            startActivity(i);
        });
    }
}
