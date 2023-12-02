package fit.se.week7.backend.controller;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @GetMapping
    public String adminForm(Model model,@RequestParam(name = "userName", required = false) String userName){
        getCartItem(model,userName);
        return "admin";
    }
    public void getCartItem(Model model,String userName){
        List<ProductDto> l = service.getProduct(userName);
        model.addAttribute("productsCart",l);
        if(userName!=null){
            model.addAttribute("n", userName);
            Optional<User> u = userService.findByUserName(userName);
            if(u.isPresent()){
                model.addAttribute("admin",true);
            }
        }

        model.addAttribute("cartSize",l==null?0:l.size());
    }
}
