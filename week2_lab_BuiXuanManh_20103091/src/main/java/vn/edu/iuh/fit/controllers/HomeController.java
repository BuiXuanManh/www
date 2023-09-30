package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.implement.ProductImplement;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private static String HOME_PAGE="index.jsp";
    private ProductService productService;
    public HomeController() {
        productService = new ProductImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findTop5ProductNew(12);

//        List<ProductDTOAllProperty> bestProc = statisticalService.topProcBestSales(4, ProductDTOAllProperty.class);
        req.setAttribute("products",products);
        req.setAttribute("bestProc",products);
        req.getRequestDispatcher(HOME_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
