package controller;

import controller.command.Command;
import controller.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

            processRequest(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

            processRequest(httpServletRequest, httpServletResponse);

    }

    private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("Srvlet");
        CommandFactory commandFactory = CommandFactory.commandFactory();
        Command command = commandFactory.getCommand(httpServletRequest);
        String page = command.execute(httpServletRequest);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);

        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
