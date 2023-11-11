package iuh.fit.week2.controllers;

import iuh.fit.week2.implement.EmployeeImplement;
import iuh.fit.week2.model.EmployeeModel;
import iuh.fit.week2.model.ProductModel;
import iuh.fit.week2.models.Employee;
import iuh.fit.week2.models.Product;
import iuh.fit.week2.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    private EmployeeModel employeeModel=new EmployeeModel();
    private ProductModel productModel= new ProductModel();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object action= req.getParameter("action");
        if(action!=null){
            if(action.equals("getAllProduct")){
                List<Product> l = productModel.getAll();
                req.setAttribute("listPro",l);

            }
        }
    }


}
