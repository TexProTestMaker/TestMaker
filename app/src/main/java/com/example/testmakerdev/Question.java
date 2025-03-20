package com.example.testmakerdev;
import java.util.List;
public class Question {
    String questionText;
    List<String> answers;
    int correctAnswer;
    public String getQuestionText() {
        return questionText;
    }
    public List<String> getAnswers() {
        return answers;
    }
    public int getCorrectAnswer(){
        return correctAnswer;
    }
}