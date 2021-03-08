package be.ucll.week06_PRG.ui.controller;

import be.ucll.week06_PRG.domain.db.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class ControllerFactory {
    public RequestHandler getHandler(HttpServletRequest request, HttpServletResponse response, PersonDbInMemory persons) {
        String command = request.getParameter("command");
        if (command == null)
            command = "Home";
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("be.ucll.week06_PRG.ui.controller." + command);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setPersons(persons);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("The requested page could not be found");
        }
        return handler;
    }
}
