package com.javarush.panova.quest.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/restart")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String userName = (String) httpSession.getAttribute("userName");
        req.setAttribute("userName", userName);

        httpSession.invalidate();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/hello-servlet");
        requestDispatcher.forward(req, resp);


    }
}
