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
    private EditText corAnsEditText; //ещё не реализовано в лэйауте, на данном ПК нужно ещё чинить билд, разберусь в СПБ

    private Button exitEditorButton, addQuestionButton, changeTitleButton;
    private Test currentTest;
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
    private void changeTitle() {
        String text = testTitleEditText.getText().toString();
        currentTest.name = "text";
        testTitleEditText.setText("");
    }

    private void addQuestionClick() {
        Question quest = new Question();
        String question = curQuestionEditText.getText().toString();
        String answer1 = answer1EditText.getText().toString();
        String answer2 = answer2EditText.getText().toString();
        String answer3 = answer3EditText.getText().toString();
        String answer4 = answer4EditText.getText().toString();
        String corAns = corAnsEditText.getText().toString();
        List<String> list = new ArrayList<String>();

        if (answer1.length() > 0) {
            list.add(answer1);
        }
        if (answer2.length() > 0) {
            list.add(answer2);
        }
        if (answer3.length() > 0) {
            list.add(answer3);
        }
        if (answer4.length() > 0) {
            list.add(answer4);
        }

        int number = -1;
        try {
             number = Integer.parseInt(corAns);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ошибка: введите число!", Toast.LENGTH_SHORT).show();
        }

        if ((list.size() == 4) && (number != -1) && (question.length() > 0)) {
            quest.answers = list;
            quest.correctAnswer = number;
            quest.questionText = question;
            currentTest.addQuestion(quest);
        }
    }
    private void exitEditor() {
        Intent intent = new Intent(TestActivity.this, TestListFragment.class);
        startActivity(intent);
    }
}