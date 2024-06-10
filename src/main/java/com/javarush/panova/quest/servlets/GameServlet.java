package com.javarush.panova.quest.servlets;

import com.javarush.panova.quest.entities.Game;
import com.javarush.panova.quest.entities.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet ("/game-servlet")
public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Game game = (Game) httpSession.getAttribute("game");

        httpSession.removeAttribute("currentQuestion");

        if(game.checkContinueGame()){
            Question currentQuestion = game.playGame();
            httpSession.setAttribute("currentQuestion", currentQuestion);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game");
            requestDispatcher.forward(req, resp);
        }
        else {
            httpSession.removeAttribute("game");
            httpSession.removeAttribute("questionList");
            httpSession.removeAttribute("currentQuestion");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/win");
            requestDispatcher.forward(req, resp);
        }

    }
}
