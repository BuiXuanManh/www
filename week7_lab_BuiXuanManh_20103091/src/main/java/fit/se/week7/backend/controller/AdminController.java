package fit.se.week7.backend.controller;

import fit.se.week7.backend.dto.*;
import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import fit.se.week7.backend.services.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveChanges(
            @RequestParam(name = "userName", required = false) String userName,
            @RequestBody ListDto userCheckedDtos, HttpServletRequest request) {
        for (UserCheckedDto dto : userCheckedDtos.getList()) {
            String uid = dto.getUserName();
            Optional<User> u = userService.findByUserName(uid);
            if (u.isEmpty()) return "errorLogin";
            List<CheckedDto> roles = dto.getRoles();
            for (CheckedDto c : roles) {
                Optional<Role> r = roleService.findByRoleName(RoleName.valueOf(c.getRoleName()));
                if (c.isCheck()) {
                    UserRolePK pk = new UserRolePK(u.get(), r.get());
                    Optional<UserRole> ur = userRoleService.findById(pk);
                    if (ur.isEmpty()) {
                        UserRole uu = new UserRole(pk, UserRoleStatus.ACTIVE);
                        userRoleService.save(uu);
                    } else {
                        UserRole uu = ur.get();
                        uu.setStatus(UserRoleStatus.ACTIVE);
                        userRoleService.save(uu);
                    }
                } else {
                    UserRolePK pk = new UserRolePK(u.get(), r.get());
                    Optional<UserRole> ur = userRoleService.findById(pk);
                    if (ur.isPresent()) {
                        UserRole uu = ur.get();
                        uu.setStatus(UserRoleStatus.DELETE);
                        userRoleService.save(uu);
                    }
                }
            }
        }
//        request.getRequestDispatcher("/admin?userName=" + userName + "&select=acc");
        return "redirect:/admin?userName=" + userName + "&select=acc";
    }

    @GetMapping
    public String adminForm(Model model, @RequestParam(name = "userName", required = false) String userName, @RequestParam(name = "select", required = false) String select) {
        getCartItem(model, userName, select);
        return "admin";
    }

    public void AccHandle(Model model) {
        List<User> list = userService.getAll();
        List<UserDto> listDto = new ArrayList<>();
        List<Role> listRoles = roleService.getAll();
        for (User u : list) {
            List<Role> listR = roleService.findByUserName(u.getUserName());
//            for (Role missingRole : missingRoles) {
//                if (missingRole != null) {
//                    if (missingRole.getRoleName() == RoleName.USER) {
//                        model.addAttribute("userRole", false);
//                    } else if (missingRole.getRoleName() == RoleName.ADMIN) {
//                        model.addAttribute("adminRole", false);
//                    }
//                }
//            }
//            for (Role r : listR) {
//                if (r != null) {
//                    if (r.getRoleName() == RoleName.USER) {
//                        model.addAttribute("userRole", true);
//                    } else if(r.getRoleName()==RoleName.ADMIN) model.addAttribute("adminRole", true);
//                } else {
//                    model.addAttribute("userRole", false);
//                    model.addAttribute("adminRole", false);
//                }
//            }
//            List<UserRole> ur = userRoleService.findByUserName(u.getUserName());
//            u.setUserRoles(ur);
//            System.out.println(u);
            ;
            UserDto dto = new UserDto(u, listR);
            listDto.add(dto);
        }
        model.addAttribute("listRole", listRoles);
        model.addAttribute("users", listDto);
    }

    public void getCartItem(Model model, String userName, String select) {
        List<ProductDto> l = service.getProduct(userName);
        model.addAttribute("productsCart", l);
        if (userName != null) {
            model.addAttribute("n", userName);
            Optional<User> u = userService.findByUserName(userName);
            if (u.isPresent()) {
                model.addAttribute("admin", true);
            }
        }
        if (select != null) {
            switch (select) {
                case "acc":
                    AccHandle(model);
                    break;
                case "emp":
                    model.addAttribute("employees", employeeService.getAll());
                    break;
                case "cus":
                    model.addAttribute("customers", customerService.getAll());
                    break;
                case "date":

                    break;
                case "Semp":
                    break;
                default:
                    AccHandle(model);
                    break;
            }
        } else AccHandle(model);
        model.addAttribute("cartSize", l == null ? 0 : l.size());
    }
}
