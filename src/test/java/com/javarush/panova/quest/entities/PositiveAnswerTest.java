package com.javarush.panova.quest.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveAnswerTest {
    PositiveAnswer positiveAnswer = new PositiveAnswer(1, "You can do it");

    @Test
    public void getAnswerText() {
        assertEquals("You can do it", positiveAnswer.getAnswerText());
    }


    @Test
    public void getQuestionID() {
        assertEquals(1, positiveAnswer.getQuestionID());
    }



}
