package com.example.testmakerdev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TextView questionTextView, testTitleTextView;
    private RadioGroup answersGroup;
    private Button checkAnswerButton, nextQuestionButton;
    private int currentQuestionIndex = 0;
    private int counterCorrect = 0;
    private Test currentTest;
    private List<Question> allQuestions;
    private Question currentQuestion;
    private int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionTextView = findViewById(R.id.questionText); //соединяем кнопки
        answersGroup = findViewById(R.id.answersGroup);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        testTitleTextView = findViewById(R.id.testTitle);

        //String filename = "filename";
        //currentTest= new Test(filename); Так должен инициализироваться тест в финальной форме - по названию
        //Здесь сделать прототип теста
        allQuestions = currentTest.getQuestions();
        length = allQuestions.size();

        testTitleTextView.setText(currentTest.getName()); //заполняем название теста

        setQuestion();

        checkAnswerButton.setOnClickListener(v -> checkAnswer());
        nextQuestionButton.setOnClickListener(v -> nextQuestion());
    }
    private void setQuestion() {
        currentQuestion = allQuestions.get(currentQuestionIndex); //берём текущий вопрос из списка всех вопросов
        questionTextView.setText(currentQuestion.getQuestionText()); //заполняем вопрос
        for (int i = 0; i < answersGroup.getChildCount(); i++) { //заполняем кнопки текстом из вопроса
            RadioButton radioButton = (RadioButton) answersGroup.getChildAt(i);
            if (i < currentQuestion.getAnswers().size()) { //проверяем, что для этих кнопок есть варианты ответа
                radioButton.setText(currentQuestion.getAnswers().get(i));
                radioButton.setVisibility(View.VISIBLE);
            } else {
                radioButton.setVisibility(View.GONE);
            }
        }
    }
    private void checkAnswer() {
        int selectedAnswerId = answersGroup.getCheckedRadioButtonId();

        if (selectedAnswerId == -1) { //всплывающее окно, если нет ответа
            Toast toast = Toast.makeText(this, "Выберите ответ!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (selectedAnswerId ==  currentQuestion.getCorrectAnswer()) { //!!Можно тоже сделать всплывающие окна, что ответ правильный/неправильный
            counterCorrect++;
        }

        checkAnswerButton.setEnabled(false);
        for (int i = 0; i < answersGroup.getChildCount(); i++) {
            answersGroup.getChildAt(i).setEnabled(false);
            //окрашиваем правильные и неправильные ответы после ответа
            if (i == currentQuestion.getCorrectAnswer()) {
                answersGroup.getChildAt(i).setBackgroundColor(ContextCompat.getColor(this, R.color.correct_answer));
            }
            else {
                answersGroup.getChildAt(i).setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect_answer));
            }
        }
    }

    private void nextQuestion() {

    }
    private void exitTest() {

    }
}