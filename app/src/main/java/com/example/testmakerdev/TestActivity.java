package com.example.test1;

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

        // Устанавливаем вопрос
        setQuestion();

        // Обработчик кнопки "Проверить ответ"
        checkAnswerButton.setOnClickListener(v -> checkAnswer());

        // Обработчик кнопки "Следующий вопрос"
        nextQuestionButton.setOnClickListener(v -> nextQuestion());
    }

    private void setQuestion() {
        // Здесь ты будешь устанавливать вопросы и ответы
        questionTextView.setText("Вопрос №" + (currentQuestionIndex + 1));
    }

    private void checkAnswer() {
        // Здесь будет логика для проверки правильности ответа
        int selectedAnswerId = answersGroup.getCheckedRadioButtonId();
        RadioButton selectedAnswer = findViewById(selectedAnswerId);

        if (selectedAnswer != null) {
            // Проверка правильности ответа
            boolean isCorrect = selectedAnswer.getText().toString().equals("Правильный ответ");
            if (isCorrect) {
                // Ответ правильный
            } else {
                // Ответ неправильный
            }
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        setQuestion();
        answersGroup.clearCheck();  // Очистить выбор ответов
    }
}
