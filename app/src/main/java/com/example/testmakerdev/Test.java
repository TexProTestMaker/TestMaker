package com.example.testmakerdev;

import java.util.List;

public class Test  extends Activity{
    List<Question> questions;
    public void addQuestion (Question question) {
        questions.add(question);
    }
    public List<Question> getQuestions(){
        return questions;
    }
   public Test(String filename){
        //Here should be constructor from file
   }

}