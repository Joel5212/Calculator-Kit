package group1.android.calculatorkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntersectionActivity extends AppCompatActivity {

    Button btnLineIntersection;
    Button btnCircleIntersection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intersection);
        btnLineIntersection = findViewById(R.id.btnLineIntersection);
        btnCircleIntersection = findViewById(R.id.btnCircleIntersection);

        btnLineIntersection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntersectionActivity.this, LineIntersectionActivity.class);
                startActivity(i);
            }
        });

        btnCircleIntersection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntersectionActivity.this, CircleIntersectionActivity.class);
                startActivity(i);
            }
        });
    }
}