package com.jenmann.controller;

import com.jenmann.entity.Encounter;
import com.jenmann.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A testing/utility type class that just lists all encounters in the database. Nothing to see here! ;)
 *
 * @author jcmann
 */
@WebServlet(urlPatterns = {"/encounters"})
public class EncounterList extends HttpServlet {

    /**
     * Handles a simple get request to this servlet and routes to a JSP that displays all encounters in a table
     *
     * @param req a general http request to this servlet
     * @param resp our response to send back
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao dao = new GenericDao<Encounter>(Encounter.class);
        List<Encounter> encounters = dao.getAll();
        req.setAttribute("encounters", encounters);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/encountersList.jsp");
        dispatcher.forward(req, resp);
    }
}
