//package iuh.fit.week2.controllers;
//
//import iuh.fit.week2.enums.EmployeeStatus;
//import iuh.fit.week2.models.*;
//import iuh.fit.week2.services.*;
//import jakarta.inject.Inject;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@WebServlet(urlPatterns = {"/ControlServlet"})
//public class ControlServlet extends HttpServlet {
//    @Inject
//    private EmployeeService service;
//    @Inject
//    private CustomerService customerService;
//    @Inject
//    private OrderService orderService;
//    @Inject
//    private ProductImageService productImageService;
//
//    public boolean createOrder() {
//        Employee e = new Employee("khai baby", LocalDate.of(2002, 5, 29), "khai@mail", "032423", "tan binh", EmployeeStatus.ACTIVE);
//        service.create(e);
//        Customer c = new Customer("khai not baby", "khai@mail", "0234143", "tan binh");
//        customerService.create(c);
//        Order o = new Order(LocalDateTime.now(), e, c);
//        orderService.create(o);
//        return true;
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//
//            String action = req.getServletPath();
//            switch (action) {
//                case "/new":
//                    Long id = Long.valueOf(req.getParameter("id"));
//                    String name = req.getParameter("fullName");
//                    String dob = req.getParameter("dob");
//                    String email = req.getParameter("email");
//                    String phone = req.getParameter("phone");
//                    String address = req.getParameter("address");
//                    int status = Integer.parseInt(req.getParameter("status"));
//                    break;
////                case "/insert":
////                    insertUser(request, response);
////                    break;
////                case "/delete":
////                    deleteUser(request, response);
////                    break;
////                case "/edit":
////                    showEditForm(request, response);
////                    break;
////                case "/update":
////                    updateUser(request, response);
////                    break;
////                default:
////                    listUser(request, response);
////                    break;
//            }
//        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//
//
//}
