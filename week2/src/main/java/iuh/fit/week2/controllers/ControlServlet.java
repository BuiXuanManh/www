package iuh.fit.week2.controllers;

import iuh.fit.week2.repositories.Connection;
import iuh.fit.week2.repositories.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    private Logger logger;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeRepository re= new EmployeeRepository();
        re.findAll();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
