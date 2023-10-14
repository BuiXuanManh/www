package iuh.fit.week5.controllers;

import iuh.fit.week5.entities.Address;
import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.entities.User;
import iuh.fit.week5.services.AddressService;
import iuh.fit.week5.services.CandidateService;
import iuh.fit.week5.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Qualifier("userImplement")
    @Autowired
    private UserService service;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private AddressService addressService;
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping("/signup")
    public String formSignUp(Model model){
        User u= new User();
        Candidate c= new Candidate();
        model.addAttribute("user", u);
        model.addAttribute("candidate",c);
        return "signup";
    }
    @PostMapping("/signup/new")
    public String signUp(@ModelAttribute("user") User user, @ModelAttribute("candidate") Candidate candidate){
        Optional<User> s = service.findByUserName(user.getUserName());
        try {
            if(!s.isPresent()){
                Address a= candidate.getAddress();
                addressService.save(a);
                candidateService.save(candidate);
                service.save(user);
                return "redirect:/user/login";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "error";
    }
    @GetMapping("/login")
    public String formLogin(Model model){
        User u= new User();
        model.addAttribute("user",u);
        return "login";
    }
    @PostMapping("/login/valid")
    public String Login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        Optional<User> s = service.findByUserName(user.getUserName());
        try {
            if(s.isPresent()){
                User user1 = s.get();
                if(user1.getPassWord().equalsIgnoreCase(user.getPassWord()))
                    redirectAttributes.addFlashAttribute("user",user);
                    return "redirect:/job";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "error";
    }
}
