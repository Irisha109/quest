package com.javarush.panova.quest.entities;

import com.javarush.panova.quest.model.Model;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class GameTest {
    Model model = Model.getInstance();
    Game game = new Game(model.getQuestionList());

    @Test
    public void playGame(){
        Question question = (Question) game.getQuestionList().get(0);

        assertEquals(question, game.playGame());
    }
    @Test
    public void getQuestionList() {
        assertEquals(model.getQuestionList(), game.getQuestionList());
    }

}
