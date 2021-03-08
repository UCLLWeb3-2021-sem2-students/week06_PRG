package be.ucll.week06_PRG.ui.controller;


import be.ucll.week06_PRG.domain.db.PersonDbInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private PersonDbInMemory persons = new PersonDbInMemory();
    private ControllerFactory factory = new ControllerFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestHandler handler = factory.getHandler(request, response, persons);
        String destination = handler.handleRequest(request, response);
        if (!response.isCommitted()) {
            request.getRequestDispatcher(destination).forward(request, response);
        }
    }


}
