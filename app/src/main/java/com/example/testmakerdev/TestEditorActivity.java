package com.example.testmakerdev;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TestEditorActivity extends AppCompatActivity {

   private EditText testTitleEditText, curQuestionEditText, answer1EditText, answer2EditText, answer3EditText, answer4EditText;

   private Button exitEditorButton, addQuestionButton, changeTitleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_editor);


        testTitleEditText = findViewById(R.id.testTitleEditText);
        curQuestionEditText = findViewById(R.id.curQuestionEditText);
        answer1EditText = findViewById(R.id.answer1EditText);
        answer2EditText = findViewById(R.id.answer2EditText);
        answer3EditText = findViewById(R.id.answer3EditText);
        answer4EditText = findViewById(R.id.answer4EditText);


    }
    private exitEditor() {
        Intent intent = new Intent(TestActivity.this, TestListFragment.class);
        startActivity(intent);
    }

}