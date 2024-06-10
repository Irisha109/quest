package com.javarush.panova.quest.entities;

import java.util.Objects;

public class PositiveAnswer implements Answer{
    private final int questionID;
    private final String answerText;


    public PositiveAnswer(int questionID, String answerText) {
        this.questionID = questionID;
        this.answerText = answerText;
    }

    @Override
    public String getAnswerText() {
        return answerText;
    }

    @Override
    public int getQuestionID() {
        return questionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveAnswer that = (PositiveAnswer) o;
        return questionID == that.questionID && Objects.equals(answerText, that.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionID, answerText);
    }

    @Override
    public String toString() {
        return "PositiveAnswer{" +
                "questionID=" + questionID +
                ", answerText='" + answerText + '\'' +
                '}';
    }
}