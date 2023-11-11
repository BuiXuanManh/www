package com.example.week.controllers;

import com.example.week.enums.AccountStatus;
import com.example.week.enums.GrantStatus;
import com.example.week.enums.RoleStatus;
import com.example.week.implement.AccountImplement;
import com.example.week.implement.GrantAccessImpl;
import com.example.week.implement.LogImplement;
import com.example.week.implement.RoleImplement;
import com.example.week.models.*;
import com.example.week.repositories.AccountRepository;
import com.example.week.services.AccountService;
import com.example.week.services.GrantAccessService;
import com.example.week.services.LogService;
import com.example.week.services.RoleService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {

    //    @Inject
//    private AccountService accountService;
//    @Inject
//    private RoleService roleService;
//    @Inject
//    private GrantAccessService gService;
//    @Inject
//    private LogService logService;
    private AccountService accountService = new AccountImplement();
    private RoleService roleService = new RoleImplement();
    private GrantAccessService gService = new GrantAccessImpl();
    private LogService logService = new LogImplement();
    private Logger logger = LoggerFactory.getLogger(ControlServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object action = req.getParameter("action");
        if (action != null) {
            if ("update".equals(action)) {
                String id = req.getParameter("id");
                Optional<Account> acc = accountService.findById(id);
                if (acc.isEmpty()) {
                    resp.sendRedirect("error.jsp");
                } else {
                    req.setAttribute("acc", acc.get());
                    req.getRequestDispatcher("update.jsp").forward(req, resp);
                }

            } else if ("delete".equals(action)) {
                String id = req.getParameter("id");
                Optional<Account> acc = accountService.findById(id);
                if (acc.isEmpty()) {
                    resp.sendRedirect("error.jsp");
                } else {
                    accountService.delete(acc.get());
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                }
            } else if ("viewLog".equals(action)) {
                String id = req.getParameter("id");
                List<Log> list = logService.find(id);
                req.setAttribute("listLog", list);
                req.getRequestDispatcher("writeLog.jsp").forward(req, resp);

            } else if ("grant".equals(action)) {
                String id = req.getParameter("id");
                Optional<Account> a = accountService.findById(id);
                if (a.isEmpty()) {
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                } else {
                    List<Role> rl = roleService.findByAccId(a.get().getAccount_id());
                    req.setAttribute("acc", a.get());
                    req.setAttribute("listRole", rl);
                    req.getRequestDispatcher("grant.jsp").forward(req, resp);
                }

            } else if ("deleteGrant".equals(action)) {
                String id = req.getParameter("id");
                String role = req.getParameter("role");
                Optional<Account> a = accountService.findById(id);
                Optional<GrantAccess> g = gService.findByAR(id, role);
                if (a.isEmpty() || g.isEmpty()) {
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                } else {
                    gService.grantCancel(g.get());
                    List<Role> rl = roleService.findByAccId(a.get().getAccount_id());
                    req.setAttribute("acc", a.get());
                    req.setAttribute("listRole", rl);
                    req.getRequestDispatcher("grant.jsp").forward(req, resp);
                }

            } else if ("logout".equals(action)) {
                String id = req.getParameter("id");
                Optional<Account> a = accountService.findById(id);
                if (a.isEmpty()) {
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                } else {
                    Log g = new Log(a.get(), null, LocalDateTime.now(), "logout");
                    logService.createLog(g);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object action = req.getParameter("action");
        String u = "";
        if (action != null) {
            if ("addAcc".equals(action)) {
                String newUsername = req.getParameter("newUsername");
                String newPassword = req.getParameter("newPassword");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String fullName = req.getParameter("fullName");
                Account a = new Account(newUsername, fullName, newPassword, email, phone, AccountStatus.ACTIVE);
                Role r = roleService.findByRoleName("USER");
                GrantAccess g= new GrantAccess(a,r,"user access",GrantStatus.ENABLED);
                accountService.create(a);
                gService.grantAccess(g);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else if ("deleteAccount".equals(action)) {
                String updateUsername = req.getParameter("deleteUsername");
                Optional<Account> a = accountService.findById(updateUsername);
                if (!a.isPresent()) {
                    resp.sendRedirect("error.jsp");
                } else
                    accountService.delete(a.get());
            } else if ("login".equals(action)) {
                u = req.getParameter("username");
                String p = req.getParameter("password");
                Optional<Account> a = accountService.findById(u);
                req.setAttribute("username", u);
                if (a.isEmpty() || !a.get().getPassword().equalsIgnoreCase(p)) {
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                } else {
                    List<Role> rl = roleService.findByAccId(a.get().getAccount_id());
                    int amin = 0;
                    for (Role r : rl) {
                        if (r.getRole_name().equals("ADMIN"))
                            amin = amin + 1;
                    }
                    if (amin == 0) {
                        Log l = new Log(a.get(), LocalDateTime.now(), null, "login");
                        logService.createLog(l);
                        req.setAttribute("acc", a.get());
                        req.setAttribute("listRole", rl);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
                        dispatcher.forward(req, resp);
                    } else if (amin == 1) {
                        List<Account> ali = accountService.findByNotAdmin("ADMIN");
                        req.setAttribute("listAcc", ali);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("dashboard.jsp");
                        dispatcher.forward(req, resp);
                    }
                }
            } else if ("update".equals((action))) {
                String password = req.getParameter("password");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String fullname = req.getParameter("fullName");
                String id = req.getParameter("id");
                Optional<Account> a1 = accountService.findById(id);
                if (a1.isEmpty()) {
                    resp.sendRedirect("error.jsp");
                } else {
                    Account a = a1.get();
                    a.setAccount_id(id);
                    a.setPassword(password);
                    a.setEmail(email);
                    a.setPhone(phone);
                    a.setFull_name(fullname);
                    a.setStatus(AccountStatus.ACTIVE);
                    accountService.update(a);
                    resp.sendRedirect("dashboard.jsp");
                }
            } else if ("grantP".equals(action)) {
                u = req.getParameter("id");
                Optional<Account> a = accountService.findById(u);
                if (a.isEmpty()) {
                    resp.sendRedirect("error.jsp");
                } else {
                    req.setAttribute("acc", a.get());
                    String select = req.getParameter("select");
                    List<Role> list = new ArrayList<>();
                    if (select.equals("ADMIN")) {
                        Role r = roleService.findByRoleName("ADMIN");
                        Role r2 = roleService.findByRoleName("USER");
                        list.add(r);
                        list.add(r2);
                        logger.info("r2: " + r2);
                        System.out.println("r2 " + r2);
                        GrantAccess grantAccess = new GrantAccess(a.get(), r, "access admin", GrantStatus.ENABLED);
                        GrantAccess grantAccess2 = new GrantAccess(a.get(), r2, "access user", GrantStatus.ENABLED);
                        Optional<GrantAccess> g = gService.findByAR(a.get().getAccount_id(), "ADMIN");
                        Optional<GrantAccess> g2 = gService.findByAR(a.get().getAccount_id(), "USER");
                        req.setAttribute("listRole", list);
                        if (g.isPresent()) {
                            GrantAccess gg = g.get();
                            gg.setGrantStatus(GrantStatus.ENABLED);
                            gService.grantAccess(gg);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        } else if (g2.isPresent()) {
                            GrantAccess gg = g2.get();
                            gg.setGrantStatus(GrantStatus.ENABLED);
                            gService.grantAccess(gg);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        } else if (g2.isEmpty()) {
                            gService.grantAccess(grantAccess);
                            gService.grantAccess(grantAccess2);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        }
                    } else if (select.equals("USER")) {
                        Role r2 = roleService.findByRoleName("USER");
                        list.add(r2);
                        req.setAttribute("listRole", list);
                        GrantAccess grantAccess2 = new GrantAccess(a.get(), r2, "access admin", GrantStatus.ENABLED);
                        logger.info("grant 22: " + grantAccess2);
                        Optional<GrantAccess> g2 = gService.findByAR(a.get().getAccount_id(), "USER");
                        Optional<GrantAccess> g = gService.findByAR(a.get().getAccount_id(), "ADMIN");

                        if (g.isPresent()) {
                            GrantAccess ag1 = g.get();
                            ag1.setGrantStatus(GrantStatus.DISABLED);
                            gService.grantCancel(ag1);
                            logger.info("Grant 1: " + ag1);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        } else if (g2.isPresent()) {
                            logger.info("Grant 0:");
                            GrantAccess gg = g2.get();
                            gg.setGrantStatus(GrantStatus.ENABLED);
                            gService.grantAccess(gg);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        } else {
                            logger.info("Grant 2: " + grantAccess2);
                            gService.grantAccess(grantAccess2);
                            req.getRequestDispatcher("grant.jsp").forward(req, resp);
                        }
                    }
                }

            } else if ("logLoginLogout".equals(action)) {
                u = req.getParameter("username");
                Optional<Account> a = accountService.findById(u);
                if (!a.isPresent()) {
                    resp.sendRedirect("error.jsp");
                } else {
                    List<Log> l = logService.find(u);
                    req.setAttribute("Log", l);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("writeLog.jsp");
                    dispatcher.forward(req, resp);
                }
            } else {
                resp.sendRedirect("error.jsp");
            }
        }
    }
}
