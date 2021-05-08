package group1.android.calculatorkit;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AreaSurfaceAreaAndVolumeMeasureActivity extends AppCompatActivity {
    TextView tvMeasure1;
    TextView tvMeasure2;
    TextView tvMeasure3;

    EditText etMeasure1;
    EditText etMeasure2;
    EditText etMeasure3;

    Button btnCalculate;
    TextView tvResultMeasure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_surface_area_and_volume_measure);
        String tvShapeString = getIntent().getStringExtra("TV_SHAPE_STRING");
        String tvASAVString = getIntent().getStringExtra("TV_ASAV_STRING");

        tvMeasure1 = findViewById(R.id.tvMeasure1);
        tvMeasure2 = findViewById(R.id.tvMeasure2);
        tvMeasure3 = findViewById(R.id.tvMeasure3);

        etMeasure1 = findViewById(R.id.etMeasure1);
        etMeasure2 = findViewById(R.id.etMeasure2);
        etMeasure3 = findViewById(R.id.etMeasure3);

        btnCalculate = findViewById(R.id.btnCalculate);
        tvResultMeasure = findViewById(R.id.tvResultMeasure);

        switch(tvShapeString)
        {
            case "Square":
                    tvMeasure1.setText("Enter Side:");
                    etMeasure2.setKeyListener(null);
                    etMeasure3.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;


            case "Rectangle":
                    tvMeasure1.setText("Enter Length:");
                    tvMeasure2.setText("Enter Width");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;


            case "Circle":
                    tvMeasure1.setText("Enter Radius:");
                    etMeasure2.setKeyListener(null);
                    etMeasure3.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            case "Ellipse":
                    tvMeasure1.setText("Enter Radius#1:");
                    tvMeasure2.setText("Enter Radius#2:");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;


            case "Triangle":
                    tvMeasure1.setText("Enter Base:");
                    tvMeasure2.setText("Enter Height:");
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setKeyListener(null);
                    break;

            case "Parallelogram":
                    tvMeasure1.setText("Enter Base:");
                    tvMeasure2.setText("Enter Height:");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;



            case "Trapezoid":
                    tvMeasure1.setText("Enter a (Top Base): ");
                    tvMeasure2.setText("Enter b (Bottom Base): ");
                    tvMeasure3.setText("Enter Height: ");
                    break;



            case "Sphere":

                    tvMeasure1.setText("Enter Radius:");
                    etMeasure2.setKeyListener(null);
                    etMeasure3.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            case "Cube":
                tvMeasure1.setText("Enter Edge:");
                    etMeasure2.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            case "Rectangular Prism":
                    tvMeasure1.setText("Enter Width:");
                    tvMeasure2.setText("Enter Height:");
                    tvMeasure3.setText("Enter Length");
                    break;

            case "Cone":
                    tvMeasure1.setText("Enter Radius: ");
                    tvMeasure2.setText("Enter Height: ");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;


            case "Cylinder":
                    tvMeasure1.setText("Enter Radius: ");
                    tvMeasure2.setText("Enter Height: ");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            case "Rhombus":
            {
                    tvMeasure1.setText("Enter Diagonal#1");
                    tvMeasure2.setText("Enter Diagonal#2");
                    etMeasure3.setKeyListener(null);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;
            }

            case "Pentagon":
            {
                    tvMeasure1.setText("Side:");
                    etMeasure2.setKeyListener(null);
                    etMeasure3.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            }
            case "Hexagon":
                    tvMeasure1.setText("Side:");
                    etMeasure2.setKeyListener(null);
                    etMeasure3.setKeyListener(null);
                    etMeasure2.setBackgroundResource(android.R.color.transparent);
                    etMeasure3.setBackgroundResource(android.R.color.transparent);
                    break;

            case "Heptagon":
                tvMeasure1.setText("Side:");
                etMeasure2.setKeyListener(null);
                etMeasure3.setKeyListener(null);
                etMeasure2.setBackgroundResource(android.R.color.transparent);
                etMeasure3.setBackgroundResource(android.R.color.transparent);
                break;
            case "Octagon":
                tvMeasure1.setText("Side:");
                etMeasure2.setKeyListener(null);
                etMeasure3.setKeyListener(null);
                etMeasure2.setBackgroundResource(android.R.color.transparent);
                etMeasure3.setBackgroundResource(android.R.color.transparent);
                break;

            case "Nonagon":
                tvMeasure1.setText("Side:");
                etMeasure2.setKeyListener(null);
                etMeasure3.setKeyListener(null);
                etMeasure2.setBackgroundResource(android.R.color.transparent);
                etMeasure3.setBackgroundResource(android.R.color.transparent);
                break;

            case "SqrPyramid":
                tvMeasure1.setText("Enter Base Edge:");
                tvMeasure2.setText("Enter Height:");
                etMeasure3.setKeyListener(null);
                etMeasure3.setBackgroundResource(android.R.color.transparent);
                break;


            case "Rectangular Pyramid":
                tvMeasure1.setText("Base Width:");
                tvMeasure2.setText("Pyramid Height:");
                tvMeasure3.setText("Base Length:");
                break;

            case "SqrPrism":
                tvMeasure1.setText("Enter Base Edge:");
                tvMeasure2.setText("Enter Height:");
                etMeasure3.setKeyListener(null);
                etMeasure3.setBackgroundResource(android.R.color.transparent);
                break;




        }

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            Double area;
            Double volume;
            Double surfaceArea;
            Double circumference;
            Double length;
            Double width;
            Double height;
            Double radius;
            Double radius2;
            Double base;
            Double diagonal1;
            Double diagonal2;
            @Override
            public void onClick(View v) {

                try {
                    switch (tvShapeString) {
                        case "Square":
                            length = Double.parseDouble(etMeasure1.getText().toString());
                            area = length * length;
                            break;
                        case "Rectangle":

                            length = Double.parseDouble(etMeasure1.getText().toString());
                            width = Double.parseDouble(etMeasure2.getText().toString());
                            area = length * width;
                            break;

                        case "Circle":
                            if (tvASAVString.equals("Circumference")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                circumference = 2 * Math.PI * radius;
                                break;
                            } else {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                area = Math.PI * (radius * radius);
                                break;
                            }

                        case "Ellipse":
                            radius = Double.parseDouble(etMeasure1.getText().toString());
                            radius2 = Double.parseDouble(etMeasure2.getText().toString());
                            area = Math.PI * radius * radius2;
                            break;


                        case "Triangle":
                            height = Double.parseDouble(etMeasure2.getText().toString());
                            base = Double.parseDouble(etMeasure1.getText().toString());
                            area = (base * height) / 2;
                            break;

                        case "Parallelogram":
                            base = Double.parseDouble(etMeasure1.getText().toString());
                            height = Double.parseDouble(etMeasure2.getText().toString());
                            area = base * height;
                            break;


                        case "Trapezoid":
                            Double base1 = Double.parseDouble(etMeasure1.getText().toString());
                            Double base2 = Double.parseDouble(etMeasure2.getText().toString());
                            height = Double.parseDouble(etMeasure3.getText().toString());
                            area = ((base1 + base2) * height) / 2;
                            break;

                        case "Rhombus":
                            diagonal1 = Double.parseDouble(etMeasure1.getText().toString());
                            diagonal2 = Double.parseDouble(etMeasure2.getText().toString());
                            area = (diagonal1 * diagonal2) / 2;
                            break;


                        case "Pentagon":
                            area = Math.sqrt(5 * (5 + (2 * Math.sqrt(5)))) * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2) / 4;
                            break;
                        case "Hexagon":
                            area = (3 * Math.sqrt(3) * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2)) / 2;
                            break;
                        case "Heptagon":
                            double tangent = 1 / Math.tan((Math.toRadians(180) / 7));
                            area = (7 * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2) * (tangent)) / 4;
                            break;
                        case "Octagon":
                            area = 2 * (1 + Math.sqrt(2)) * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2);
                            break;
                        case "Nonagon":
                            area = (9 * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2) * (1 / Math.tan(Math.toRadians(180 / 9)))) / 4;
                            break;
                        case "Sphere": {
                            if (tvASAVString.equals("Volume")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                volume = (4 / 3) * Math.PI * (Math.pow(radius, 3));
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                surfaceArea = 4 * Math.pow(radius, 2);
                                break;
                            }

                        }
                        case "Cube": {

                            if (tvASAVString.equals("Volume")) {
                                volume = Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 3);
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                surfaceArea = 6 * Math.pow(Double.parseDouble(etMeasure1.getText().toString()), 2);
                                break;
                            }

                        }

                        case "Rectangular Prism":
                            if (tvASAVString.equals("Volume")) {
                                width = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                length = Double.parseDouble(etMeasure3.getText().toString());
                                volume = width * height * length;
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                width = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                length = Double.parseDouble(etMeasure3.getText().toString());
                                surfaceArea = 2 * ((width * length) + (height * length) + (height * width));
                                break;
                            }


                        case "Cone":
                            if (tvASAVString.equals("Volume")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                volume = (Math.PI) * (Math.pow(radius, 2)) * (height / 3);
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                surfaceArea = Math.PI * radius * (radius + (Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2))));
                                break;
                            }


                        case "Cylinder": {
                            if (tvASAVString.equals("Volume")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                volume = (Math.PI) * (Math.pow(radius, 2)) * (height);
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                radius = Double.parseDouble(etMeasure1.getText().toString());
                                height = Double.parseDouble(etMeasure2.getText().toString());
                                surfaceArea = 2 * (Math.PI) * radius * height + 2 * Math.PI * Math.pow(radius, 2);
                                break;
                            }
                        }

                        case "SqrPyramid":
                            length = Double.parseDouble(etMeasure1.getText().toString());
                            height = Double.parseDouble(etMeasure2.getText().toString());
                            if (tvASAVString.equals("Volume")) {
                                volume = Math.pow(length, 2) * (height / 3);
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                surfaceArea = Math.pow(length, 2) + (2 * length * Math.sqrt(((Math.pow(length, 2)) / 4) + Math.pow(height, 2)));
                                break;
                            }
                        case "Rectangular Pyramid":
                            width = Double.parseDouble(etMeasure1.getText().toString());
                            height = Double.parseDouble(etMeasure2.getText().toString());
                            length = Double.parseDouble(etMeasure3.getText().toString());
                            if (tvASAVString.equals("Volume")) {
                                volume = (length * width * height) / 3;
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                surfaceArea = length * width + length * Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2)) + width * Math.sqrt(Math.pow(length / 2, 2) + Math.pow(height, 2));
                                break;
                            }

                        case "SqrPrism":
                            length = Double.parseDouble(etMeasure1.getText().toString());
                            height = Double.parseDouble(etMeasure2.getText().toString());
                            if (tvASAVString.equals("Volume")) {
                                volume = Math.pow(length, 2) * height;
                                break;
                            } else if (tvASAVString.equals("Surface Area")) {
                                surfaceArea = 2 * Math.pow(length, 2) + 4 * length * height;
                                break;
                            }
                    }

                    if (tvASAVString.equals("Area")) {
                        tvResultMeasure.setText(area.toString());
                    } else if (tvASAVString.equals("Volume")) {
                        tvResultMeasure.setText(volume.toString());
                    } else if (tvASAVString.equals("Surface Area")) {
                        tvResultMeasure.setText(surfaceArea.toString());
                    } else if (tvASAVString.equals("Circumference")) {
                        tvResultMeasure.setText(circumference.toString());
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error: Fill in all fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}


