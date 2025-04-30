package com.example.testmakerdev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class LectureEditorActivity extends AppCompatActivity {
    private EditText editTextInput;
    private Button buttonSubmit;
    private Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lecture_editor);

        editTextInput = findViewById(R.id.editTextInput);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonExit = findViewById(R.id.buttonExit);

        buttonSubmit.setOnClickListener(v -> {
            String inputText = editTextInput.getText().toString();
            editTextInput.setText("");
        });

        buttonExit.setOnClickListener(v -> {
            Intent intent = new Intent(LectureEditorActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}