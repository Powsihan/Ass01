package com.example.ass01;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    EditText marksInput;
    Button calculateButton;
    TextView gradeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marksInput = findViewById(R.id.marksInput);
        calculateButton = findViewById(R.id.calculateButton);
        gradeOutput = findViewById(R.id.gradeOutput);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        String marksText = marksInput.getText().toString().trim();
        if (marksText.isEmpty()) {
            gradeOutput.setTextColor(Color.RED);
            gradeOutput.setText("Please fill in the marks field.");
            return;
        }
        int marks = Integer.parseInt(marksText);

        String grade = calculateGradeForSystem(marks);
        gradeOutput.setText("");
        marksInput.setText("");

        if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D")) {
            gradeOutput.setGravity(Gravity.CENTER);
            gradeOutput.append("\nCongratulations!\n\n");
            gradeOutput.append("You got " + grade + " grade. Pass!");

        } else if (grade.equals("E")) {
            gradeOutput.setGravity(Gravity.CENTER);
            gradeOutput.append("\nBetter luck next time!\n\n");
            gradeOutput.append("You got " + grade + " grade.");
        }
        if (grade.equals("E")) {
            gradeOutput.setTextColor(Color.RED);
        } else {
            gradeOutput.setTextColor(Color.GREEN);
        }
    }

    private String calculateGradeForSystem(int marks) {
        if (marks >= 75) {
            return "A";
        } else if (marks >= 65) {
            return "B";
        } else if (marks >= 55) {
            return "C";
        } else if (marks >= 35) {
            return "D";
        } else {
            return "E";
        }
    }
}
