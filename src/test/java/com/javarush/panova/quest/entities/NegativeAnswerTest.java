package com.javarush.panova.quest.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeAnswerTest {
    NegativeAnswer negativeAnswer = new NegativeAnswer(1, "What's it?", "You lose");

    @Test
    public void getAnswerText() {
        assertEquals("What's it?", negativeAnswer.getAnswerText());
    }
    @Test
    public void getLossText() {
        assertEquals("You lose", negativeAnswer.getLossText());
    }

    @Test
    public void getQuestionID() {
        assertEquals(1, negativeAnswer.getQuestionID());
    }

}
