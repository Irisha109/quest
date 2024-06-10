package com.javarush.panova.quest.servlets;

import com.javarush.panova.quest.entities.Game;
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
public class GameServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpSession session;
    @Mock
    ServletContext servletContext;
    @Mock
    RequestDispatcher dispatcher;

   @Mock
    Game game ;


    @Test
    public void doPostTest() throws IOException, ServletException {
        game.playGame();
        game.checkContinueGame();

        Mockito.doReturn(session).when(request).getSession();
        Mockito.when(servletContext.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        Mockito.verify(game).playGame();
        Mockito.verify(game).checkContinueGame();

        assertEquals(session, request.getSession());
        assertEquals(dispatcher, servletContext.getRequestDispatcher("/game"));


    }
}
