package be.ucll.week06_PRG.ui.controller;

import be.ucll.week06_PRG.domain.db.PersonDbInMemory;
import be.ucll.week06_PRG.domain.model.Activity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class RequestHandler {
    private PersonDbInMemory persons;

    public PersonDbInMemory getPersons() {
        return persons;
    }

    public void setPersons(PersonDbInMemory persons) {
        this.persons = persons;
    }

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
