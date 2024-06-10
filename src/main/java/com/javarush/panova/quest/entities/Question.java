package com.javarush.panova.quest.entities;

import java.util.List;
import java.util.Objects;

public class Question{
    private final int id;
    private final String questionText;
    private List<Answer> answers;

    public Question(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public Question(int id, String questionText, List<Answer> answers) {
        this.id = id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }
    public String getQuestionText() {
        return questionText;
    }


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id && Objects.equals(questionText, question.questionText) && Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", answers=" + answers +
                '}';
    }
}