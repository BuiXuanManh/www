package com.example.www_week6.controller;

import com.example.www_week6.implement.PostImple;
import com.example.www_week6.models.Post;
import com.example.www_week6.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/post")
public class PostControl {
    @Qualifier("postImple")
    @Autowired
    private PostService service;

//    @GetMapping
//    public String getAll(Model model){
//         model.addAttribute("list",service.getAll());
//         return "index";
//    }
    @GetMapping()
    public String getAllBySort(Model model, @RequestParam("page")Optional<Integer>page, @RequestParam("size") Optional<Integer> size){
       int currentPage = page.orElse(1);
       int currentSize = size.orElse(10);
        Page<Post> p = service.findPage(currentPage-1,currentSize,"id","asc");
        model.addAttribute("pagee",p);
        int totalPage = p.getTotalPages();
        if(totalPage>0){
            List<Integer> paNumber = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",paNumber);

        }
        return "index";
    }
}
