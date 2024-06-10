package com.javarush.panova.quest.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    Question question = new Question(1, "question text");
    Answer positiveAnswer = new PositiveAnswer(1, "You can do it");
    Answer negativeAnswer = new NegativeAnswer(1, "What's it?", "You lose");
    List<Answer> answerList = new ArrayList<>();


    public void  createQuestion(){
        answerList.add(positiveAnswer);
        answerList.add(negativeAnswer);
        question.setAnswers(answerList);
    }

    @Test
    public void getId() {
        assertEquals(1, question.getId());
    }
    @Test
    public void getQuestionText() {
        assertEquals("question text", question.getQuestionText());
    }

    @Test
    public void getAnswers() {
        createQuestion();
        assertEquals(answerList, question.getAnswers());
    }




}
