package com.example.testmakerdev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TextView questionTextView, testTitleTextView;
    private RadioGroup answersGroup;
    private Button checkAnswerButton, nextQuestionButton, exitTestButton;
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
        exitTestButton = findViewById(R.id.exitButton);

        //String filename = "filename";
        //currentTest= new Test(filename); Так должен инициализироваться тест в финальной форме - по названию
        //Здесь сделать прототип теста
        //

        Question quest1 = new Question();
        Question quest2 = new Question();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list1.add("ans1");
        list1.add("ans2");
        list1.add("ans3");
        list1.add("ans4");

        list2.add("ans5");
        list2.add("ans6");
        list2.add("ans7");
        list2.add("ans8");

        quest1.answers = list1;
        quest2.answers = list2;

        quest1.correctAnswer = 2;
        quest2.correctAnswer = 1;

        quest1.questionText = "Aboba?";
        quest2.questionText = "Ne Aboba?";

        currentTest = new Test();
        currentTest.name = "Prototype";
        currentTest.type = "Test";
        currentTest.addQuestion(quest1);
        currentTest.addQuestion(quest2);

        //конец прототипа


        allQuestions = currentTest.getQuestions();
        length = allQuestions.size();

        testTitleTextView.setText(currentTest.getName()); //заполняем название теста



        setQuestion();
        checkAnswerButton.setOnClickListener(v -> checkAnswer());
        nextQuestionButton.setOnClickListener(v -> nextQuestion());
        exitTestButton.setOnClickListener(v -> exitTest());

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
        currentQuestionIndex++;
        answersGroup.clearCheck();
        if(currentQuestionIndex < length) {
            setQuestion();

            checkAnswerButton.setEnabled(true);
            for (int i = 0; i < answersGroup.getChildCount(); i++) {
                answersGroup.getChildAt(i).setEnabled(true);
                //сбрасываем на дефолтный цвет
                answersGroup.getChildAt(i).setBackgroundColor(ContextCompat.getColor(this, R.color.backgroundColor));
            }
        }
        else {
            Toast toast = Toast.makeText(this, "Всего вопросов: " + currentQuestion + "\n Правильных ответов: " + counterCorrect, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    private void exitTest() {
        Intent intent = new Intent(TestActivity.this, TestListFragment.class);
        startActivity(intent);
    }
}