package com.javarush.panova.quest.entities;

import java.util.Objects;

public class NegativeAnswer implements Answer{
    private final int questionID;
    private final String answerText;
    private final String lossText;

    public NegativeAnswer(int questionID, String answerText, String lossText) {
        this.questionID = questionID;
        this.answerText = answerText;
        this.lossText = lossText;
    }

    @Override
    public String getAnswerText() {
        return answerText;
    }

    public String getLossText() {
        return lossText;
    }

    @Override
    public int getQuestionID() {
        return questionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NegativeAnswer that = (NegativeAnswer) o;
        return questionID == that.questionID && Objects.equals(answerText, that.answerText) && Objects.equals(lossText, that.lossText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionID, answerText, lossText);
    }

    @Override
    public String toString() {
        return "NegativeAnswer{" +
                "questionID=" + questionID +
                ", answerText='" + answerText + '\'' +
                ", loss=" + lossText +
                '}';
    }
}
