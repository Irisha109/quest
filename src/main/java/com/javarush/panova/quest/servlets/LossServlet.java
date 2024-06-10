package com.javarush.panova.quest.servlets;

import com.javarush.panova.quest.entities.NegativeAnswer;
import com.javarush.panova.quest.entities.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@WebServlet("/loss-servlet")
public class LossServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        Question currentQuestion = (Question) httpSession.getAttribute("currentQuestion");
        NegativeAnswer negativeAnswer = (NegativeAnswer) currentQuestion.getAnswers().get(1);
        String lossText = negativeAnswer.getLossText();

        httpSession.setAttribute("lossText", lossText);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/loss");
        requestDispatcher.forward(req, resp);


    }
}
