package com.example.testmakerdev;

import java.util.ArrayList;
import java.util.List;

public class Test  extends Activity{
    List<Question> questions;
    public Test() {
        questions = new ArrayList<>();
    }
    public void addQuestion (Question question) {
        if (question != null) {
            questions.add(question);
        }
    }
    public List<Question> getQuestions(){
        return questions;
    }
   //public Test(String filename){
    //    //Here should be constructor from file
   //}

}