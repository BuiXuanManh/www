package iuh.fit.week5.controllers;

import iuh.fit.week5.entities.Job;
import iuh.fit.week5.entities.User;
import iuh.fit.week5.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    @Qualifier("jobImplement")
    @Autowired
    private JobService service;
    @GetMapping()
    public String formJob(Model model){
        List<Job> l= service.getAll();
        User u= new User();
        model.addAttribute("jobs",l);
        return "index";
    }
}
