package com.example.testmakerdev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answersGroup;
    private Button checkAnswerButton, nextQuestionButton;

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);  // Подключаем layout

        // Инициализация элементов
        questionTextView = findViewById(R.id.questionText);
        answersGroup = findViewById(R.id.answersGroup);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
    }
}