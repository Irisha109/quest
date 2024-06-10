package com.javarush.panova.quest.model;

import com.javarush.panova.quest.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private static final List<Question> questionList;
    static {
        questionList = new ArrayList<>();

        Question question1 = new Question(1, "Ты потерял память. Принять вызов НЛО?");
        Answer positiveAnswer1 = new PositiveAnswer(1, "Принять вызов");
        Answer negativeAnswer1 = new NegativeAnswer(1, "Отклонить вызов",
                "Ты отклонил вызов");
        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(positiveAnswer1);
        answerList1.add(negativeAnswer1);
        question1.setAnswers(answerList1);


        Question question2 = new Question(2, "Ты принял вызов. Поднимаешься на мостик к капитану?");
        Answer positiveAnswer2 = new PositiveAnswer(2, "Подняться на мостик");
        Answer negativeAnswer2 = new NegativeAnswer(2, "Отказаться подниматься на мостик",
                "Ты не пошел на переговоры");
        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(positiveAnswer2);
        answerList2.add(negativeAnswer2);
        question2.setAnswers(answerList2);

        Question question3 = new Question(3, "Ты поднялся на мостик. Ты кто?");
        Answer positiveAnswer3 = new PositiveAnswer(3, "Рассказать правду о себе");
        Answer negativeAnswer3 = new NegativeAnswer(3, "Солгать о себе",
                "Твою ложь разоблачили");
        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(positiveAnswer3);
        answerList3.add(negativeAnswer3);
        question3.setAnswers(answerList3);

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
    }

    private Model() {

    }

    public static Model getInstance() {
        return instance;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}




    /*

Текст победы: Тебя вернули домой

----------------------------------------------
Вопрос1:Ты потерял память. Принять вызов НЛО?
Положительный ответ1: Принять вызов
Отрицательный ответ1: Отклонить вызов
Текст поражения1: Ты отклонил вызов

Вопрос2:Ты принял вызов. Поднимаешься на мостик к капитану?
Положительный ответ2: Подняться на мостик
Отрицательный ответ2: Отказаться подниматься на мостик
Текст поражения2: Ты не пошел на переговоры


Вопрос3:Ты поднялся на мостик. Ты кто?
Положительный ответ3: Рассказать правду о себе
Отрицательный ответ3: Солгать о себе
Текст поражения3: Твою ложь разоблачили


*/