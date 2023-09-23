package iuh.fit.week2.controllers;

import iuh.fit.week2.enums.EmployeeStatus;
import iuh.fit.week2.implement.*;
import iuh.fit.week2.models.*;
import iuh.fit.week2.repositories.Connection;
import iuh.fit.week2.repositories.EmployeeRepository;
import iuh.fit.week2.services.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    //    @Inject
//    private EmployeeService service;
//    @Inject
//    private CustomerService customerService;
//    @Inject
//    private OrderService orderService;
    private final EmployeeService eService = new EmployeeImplement();
    private final OrderService oService = new OrderImplement();
    private final CustomerService cService = new CustomerImplement();
    private final ProductImageService pService= new ProductImageImplement();

    public boolean createOrder() {
        Employee e = new Employee("emp1", "khai baby", LocalDate.of(2002, 5, 29), "khai@mail", "032423", "tan binh", EmployeeStatus.ACTIVE);
        eService.create(e);
        Customer c = new Customer("cust1", "khai not baby", "khai@mail", "0234143", "tan binh");
        cService.create(c);
        Order o = new Order("order1", LocalDateTime.now(), e, c);
        oService.create(o);
        return true;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductImage> l = pService.findAll();
        req.setAttribute("products",l);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
