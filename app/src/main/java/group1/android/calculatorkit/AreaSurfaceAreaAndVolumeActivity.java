package group1.android.calculatorkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AreaSurfaceAreaAndVolumeActivity extends AppCompatActivity {


    Button btnSquare;
    Button btnRectangle;
    Button btnCircle;
    Button btnEllipse;
    Button btnTriangle;
    Button btnParallelogram;
    Button btnTrapezoid;
    Button btnRhombus;
    Button btnPentagon;
    Button btnHexagon;
    Button btnHeptagon;
    Button btnOctagon;
    Button btnNonagon;
    Button btnCube;
    Button btnSphere;
    Button btnRectangularPrism;
    Button btnSquarePrism;
    Button btnCylinder;
    Button btnCone;
    Button btnSquarePyramid;
    Button btnRectangularPyramid;
    Button btnArea;
    Button btnVolume;
    Button btnSA;
    Button btnCircumference;
    Button btnNext;
    TextView tvShape;
    TextView tvASAV;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_area_surface_area_and_volume);
        tvShape = findViewById(R.id.tvShape);
        btnSquare = findViewById(R.id.btnSquare);
        btnRectangle = findViewById(R.id.btnRectangle);
        btnCircle = findViewById(R.id.btnCircle);
        btnTriangle = findViewById(R.id.btnTriangle);
        btnParallelogram = findViewById(R.id.btnParallelogram);
        btnTrapezoid = findViewById(R.id.btnTrapezoid);
        btnSphere = findViewById(R.id.btnSphere);
        tvASAV = findViewById(R.id.tvASAV);
        btnArea = findViewById(R.id.btnArea);
        btnVolume = findViewById(R.id.btnVolume);
        btnSA = findViewById(R.id.btnSA);
        btnNext = findViewById(R.id.btnNext);
        btnCylinder = findViewById(R.id.btnCylinder);
        btnCone = findViewById(R.id.btnCone);
        btnCircumference = findViewById(R.id.btnCircumference);
        btnEllipse = findViewById(R.id.btnEllipse);
        btnRhombus = findViewById(R.id.btnRhombus);
        btnPentagon = findViewById(R.id.btnPentagon);
        btnHexagon = findViewById(R.id.btnHexagon);
        btnHeptagon = findViewById(R.id.btnHeptagon);
        btnOctagon = findViewById(R.id.btnOctagon);
        btnNonagon = findViewById(R.id.btnNonagon);
        btnCube = findViewById(R.id.btnCube);
        btnRectangularPrism = findViewById(R.id.btnRectangularPrism);
        btnSquarePrism = findViewById(R.id.btnSquarePrism);
        btnSquarePyramid = findViewById(R.id.btnSquarePyramid);
        btnRectangularPyramid = findViewById(R.id.btnRectangularPyramid);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                tvShape.setText(b.getText().toString());

            }
        };

        btnSquare.setOnClickListener(listener);
        btnRectangle.setOnClickListener(listener);
        btnCircle.setOnClickListener(listener);
        btnEllipse.setOnClickListener(listener);
        btnRhombus.setOnClickListener(listener);
        btnPentagon.setOnClickListener(listener);
        btnHexagon.setOnClickListener(listener);
        btnHeptagon.setOnClickListener(listener);
        btnOctagon.setOnClickListener(listener);
        btnNonagon.setOnClickListener(listener);
        btnCube.setOnClickListener(listener);
        btnTriangle.setOnClickListener(listener);
        btnParallelogram.setOnClickListener(listener);
        btnTrapezoid.setOnClickListener(listener);
        btnSphere.setOnClickListener(listener);
        btnCylinder.setOnClickListener(listener);
        btnCone.setOnClickListener(listener);
        btnSquarePyramid.setOnClickListener(listener);
        btnRectangularPyramid.setOnClickListener(listener);
        btnRectangularPrism.setOnClickListener(listener);
        btnSquarePrism.setOnClickListener(listener);


        View.OnClickListener listener2 = new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                tvASAV.setText(b.getText().toString());
            }
        };
        btnArea.setOnClickListener(listener2);
        btnVolume.setOnClickListener(listener2);
        btnSA.setOnClickListener(listener2);
        btnCircumference.setOnClickListener(listener2);
        String twoDimensionalShapes = "Square, Rectangle, Circle, Triangle, Parallelogram, Trapezoid, Ellipse, Rhombus, Pentagon, Hexagon, Heptagon, Octagon, Nonagon";
        String threeDimensionalShapes = "Rectangular Prism, Sphere, Cone, Cylinder, SqrPyramid, Triangular Pyramid, Rectangular Pyramid, SqrPrism, Cube";
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvShapeString = tvShape.getText().toString();
                String tvASAVString = tvASAV.getText().toString();
                if(tvShapeString.equals("Square Pyramid"))
                {
                    tvShapeString = "SqrPyramid";
                }
                else if(tvShapeString.equals("Square Prism"))
                {
                    tvShapeString = "SqrPrism";
                }
                if(twoDimensionalShapes.contains(tvShapeString) && (tvASAVString.equals("Surface Area") || tvASAVString.equals("Volume")) && (tvShapeString != null && tvASAVString != null))
                {
                    Toast.makeText(AreaSurfaceAreaAndVolumeActivity.this, "Surface Area or Volume cannot be found for this two-dimensional shape!", Toast.LENGTH_SHORT).show();
                }
                else if(threeDimensionalShapes.contains(tvShapeString) && (tvASAVString.equals("Area")) && (tvShapeString != null && tvASAVString != null))
                {
                    Toast.makeText(AreaSurfaceAreaAndVolumeActivity.this, "Area cannot be found for this three-dimensional shape!", Toast.LENGTH_SHORT).show();
                }
                else if(tvASAVString.equals("Circumference") &&(!tvShapeString.equals("Circle")))
                {
                    Toast.makeText(AreaSurfaceAreaAndVolumeActivity.this, "Circumference of this shape cannot be found!", Toast.LENGTH_SHORT).show();
                }
                else if((!tvShapeString.isEmpty()) && (!tvASAVString.isEmpty()))
                {
                    Intent intent = new Intent(AreaSurfaceAreaAndVolumeActivity.this, AreaSurfaceAreaAndVolumeMeasureActivity.class);
                    intent.putExtra("TV_SHAPE_STRING", tvShapeString);
                    intent.putExtra("TV_ASAV_STRING", tvASAVString);
                    startActivity(intent);
                }
                else if(tvShapeString.isEmpty() || tvASAVString.isEmpty())
                {
                    Toast.makeText(AreaSurfaceAreaAndVolumeActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
