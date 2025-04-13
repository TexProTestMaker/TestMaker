package com.example.testmakerdev;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class LectureActivity extends AppCompatActivity {
    private TextView lectureNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        lectureNameTextView = findViewById(R.id.lectureName);

    }

}
