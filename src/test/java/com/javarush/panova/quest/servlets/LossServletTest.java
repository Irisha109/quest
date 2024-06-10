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

import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class LossServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpSession session;
    @Mock
    ServletContext servletContext;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    Game game;


    @Test
    public void doPostTest() throws IOException, ServletException {
        Mockito.doReturn("lossText").when(session).getAttribute("lossText");
        Mockito.doReturn(session).when(request).getSession();
        Mockito.when(servletContext.getRequestDispatcher(anyString())).thenReturn(dispatcher);


        assertEquals("lossText", session.getAttribute("lossText"));
        assertEquals(session, request.getSession());
        assertEquals(dispatcher, servletContext.getRequestDispatcher("/loss"));

    }
}
