package com.javarush.panova.quest.servlets;

import com.javarush.panova.quest.entities.Game;
import com.javarush.panova.quest.entities.Question;
import com.javarush.panova.quest.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HelloServletTest {
    @Mock
    HttpServletRequest requestTest;
    @Mock
    HttpSession httpSession;
    @Mock
    ServletContext servletContext;
    @Mock
    RequestDispatcher dispatcher;

    Model model = Model.getInstance();
    List<Question> questionList = model.getQuestionList();
    Game game = new Game(questionList);
    Question currentQuestion = game.playGame();

    @Test
    public void doPostTest() throws IOException, ServletException {

        Mockito.doReturn("Tom").when(requestTest).getAttribute("userName");
        Mockito.doReturn("Tom").when(httpSession).getAttribute("userName");

        Mockito.doReturn(game).when(httpSession).getAttribute("game");
        Mockito.doReturn(questionList).when(httpSession).getAttribute("questionList");
        Mockito.doReturn(currentQuestion).when(httpSession).getAttribute("currentQuestion");
        Mockito.doReturn(Game.getCountGames()).when(httpSession).getAttribute("countGames");

        assertEquals("Tom", requestTest.getAttribute("userName"));
        assertEquals("Tom", httpSession.getAttribute("userName"));
        assertEquals(game, httpSession.getAttribute("game"));
        assertEquals(questionList, httpSession.getAttribute("questionList"));
        assertEquals(currentQuestion, httpSession.getAttribute("currentQuestion"));
        assertEquals(Game.getCountGames(), httpSession.getAttribute("countGames"));

        Mockito.doReturn(httpSession).when(requestTest).getSession();
        Mockito.when(servletContext.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        assertEquals(httpSession, requestTest.getSession());
        assertEquals(dispatcher, servletContext.getRequestDispatcher("/game"));

    }


}
