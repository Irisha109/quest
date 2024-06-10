package com.javarush.panova.quest.entities;

import java.util.List;

public class Game {
    private static int countGames = 0;
    private final List<Question> questionList;
    private int step;



    public Game(List<Question> questions) {
        countGames++;
        this.questionList = questions;
        this.step = 0;

    }

    public static int getCountGames() {
        return countGames;
    }

    public boolean checkContinueGame() {
        return step < questionList.size() ;
    }

    public Question playGame(){
        Question question =  questionList.get(step);
             step++;
        return question;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}