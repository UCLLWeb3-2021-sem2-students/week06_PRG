package be.ucll.week06_PRG.ui.controller;

import be.ucll.week06_PRG.domain.db.*;
import be.ucll.week06_PRG.domain.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Register extends PersonOverview {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();
        List<String> errors = new ArrayList<>();
        setLastName(request, errors, person);
        setFirstName(request, errors, person);
        setUserid(request, errors, person);
        setEmail(request, errors, person);
        setPassword(request, errors, person);
        if (errors.size() == 0) {
            try {
                PersonDbInMemory persons = this.getPersons();
                persons.add(person);
                response.sendRedirect("Controller?command=PersonOverview");
                return "";
            } catch (DbException e) {
                errors.add(e.getMessage());
            }
        }
        if (errors.size() != 0) {
            request.setAttribute("errors", errors);
        }
        return "signUp.jsp";

    }

    private void setPassword(HttpServletRequest request, List<String> errors, Person person) {
        try {
            person.setPassword(request.getParameter("password"));
            request.setAttribute("oldPassword", request.getParameter("password"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setEmail(HttpServletRequest request, List<String> errors, Person person) {
        try {
            person.setEmail(request.getParameter("email"));
            request.setAttribute("oldEmail", request.getParameter("email"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setUserid(HttpServletRequest request, List<String> errors, Person person) {
        try {
            person.setUserid(request.getParameter("userid"));
            request.setAttribute("oldUserid", request.getParameter("userid"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(HttpServletRequest request, List<String> errors, Person person) {
        try {
            person.setFirstName(request.getParameter("firstName"));
            request.setAttribute("oldFirstName", request.getParameter("firstName"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setLastName(HttpServletRequest request, List<String> errors, Person person) {
        try {
            person.setLastName(request.getParameter("lastName"));
            request.setAttribute("oldLastName", request.getParameter("lastName"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }


}
