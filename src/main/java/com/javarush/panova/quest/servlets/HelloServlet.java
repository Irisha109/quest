package com.javarush.panova.quest.servlets;

import com.javarush.panova.quest.entities.Game;
import com.javarush.panova.quest.entities.Question;
import com.javarush.panova.quest.model.Model;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        if (name == null) {
            name = (String) request.getAttribute("userName");

        }

        HttpSession session = request.getSession(true);
        session.setAttribute("userName", name);

        Model model = Model.getInstance();
        List<Question> questionList = model.getQuestionList();
        Game game = new Game(questionList);
        Question currentQuestion = game.playGame();

        session.setAttribute("game", game);
        session.setAttribute("questionList", questionList);
        session.setAttribute("currentQuestion", currentQuestion);
        session.setAttribute("countGames", Game.getCountGames());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/game");
        requestDispatcher.forward(request, response);

    }


}