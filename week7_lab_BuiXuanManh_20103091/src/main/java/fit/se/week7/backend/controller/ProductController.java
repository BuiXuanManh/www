package fit.se.week7.backend.controller;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.enums.ProductStatus;
import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.services.ProductPriceService;
import fit.se.week7.backend.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    @Autowired
    private ProductPriceService productPriceService;
    private int PAGE;
    private int SIZE;
    @GetMapping
    private String formProduct(Model model, @RequestParam(name = "userName", required = false) String userName){
        model.addAttribute("products",service.getProduct());
        model.addAttribute("n",userName);
        return "index";
    }

    @GetMapping("/sort")
    public String getAllBySort(Model model,@RequestParam(name = "userName", required = false) String userName, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, RedirectAttributes redirectAttributes){
        int currentPage= page.orElse(1);
        int currentSize=size.orElse(10);
        Page<ProductDto> p = service.findPage(currentPage - 1, currentSize, "name", "asc");
        model.addAttribute("pageProduct",p);
        model.addAttribute("n",userName);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }
        return "index";
    }
    @GetMapping("/insert")
    public String insertForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("statuses", ProductStatus.values());
        return "/shopping/insertPro";
    }
    @PostMapping("/insertNew")
    public String insert(@ModelAttribute("product") Product product){
        if(product!=null){
            service.save(product);
            return "redirect:/product/sort";
        }
        return "redirect:/product/insert";
    }


}
