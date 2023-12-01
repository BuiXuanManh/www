package fit.se.week7.backend.controller;

import fit.se.week7.backend.dto.CheckoutDto;
import fit.se.week7.backend.dto.CheckoutForm;
import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.dto.SignupDto;
import fit.se.week7.backend.models.Cart;
import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.pks.CartKey;
import fit.se.week7.backend.services.CartService;
import fit.se.week7.backend.services.ProductPriceService;
import fit.se.week7.backend.services.ProductService;
import fit.se.week7.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    private int PAGE;
    private int SIZE;
    @PostMapping(value = "/check", consumes = "application/x-www-form-urlencoded")
    public String check(@ModelAttribute("checkoutForm")CheckoutForm checkoutForm){
        List<CheckoutDto> products = checkoutForm.getProducts();
        return "redirect:/product/index";
    }

    @GetMapping("/checkout")
    public String checkoutForm(Model model,@RequestParam(name = "userName", required = false) String userName){
        SignupDto dto = new SignupDto();
        model.addAttribute("dto",dto);
        getCartItem(model,userName);
        return "checkout";
    }
    public void getCartItem(Model model,String userName){
        List<ProductDto> l = service.getProduct(userName);
        model.addAttribute("productsCart",l);
        model.addAttribute("n", userName);
        model.addAttribute("cartSize",l==null?0:l.size());
    }
    @GetMapping("/shop-details/{prod_id}")
    public String shopDetails( @PathVariable Long prod_id, Model model,@RequestParam(name = "userName", required = false) String userName){
        Optional<ProductDto> p = service.findByProdId(prod_id);

        if(p.isEmpty()){
            return "errorLogin";
        }
        getCartItem(model, userName);

        model.addAttribute("productDetail",p.get());
        return "shop-details";
    }

    @GetMapping("/cart")
    public String cartForm(Model model,@RequestParam(name = "userName", required = false) String userName){
        if(userName==null){
            model.addAttribute("isLogin","you not login");
        }
        else {
            getCartItem(model, userName);
            model.addAttribute("checkoutForm", new CheckoutForm());
        }
        return "shoping-cart";
    }
    @GetMapping("/cart/{user_id}/{prod_id}")
    public String cartInsert(@PathVariable("user_id") String userName, @PathVariable Long prod_id){
        Optional<User> u = userService.findByUserName(userName);
        Optional<Product> p = service.findById(prod_id);
        if(u.isEmpty()||p.isEmpty()){
            return "errorLogin";
        }
        CartKey key = new CartKey(p.get(),u.get());
        Cart c= new Cart(key);
        cartService.save(c);

        return "redirect:/product/index?userName="+userName;
    }
    @GetMapping
    private String formProduct(Model model, @RequestParam(name = "userName", required = false) String userName){
        model.addAttribute("products",service.getProduct(userName));
        model.addAttribute("n",userName);
        return "index";
    }

    @GetMapping("/index")
    public String getAllBySort(Model model,@RequestParam(name = "userName", required = false) String userName, @RequestParam(value = "page", required = false) Optional<Integer> page, @RequestParam(value = "size", required = false) Optional<Integer> size, RedirectAttributes redirectAttributes){
        int currentPage= page.orElse(1);
        int currentSize=size.orElse(10);
        Page<ProductDto> p = service.findPage(currentPage - 1, currentSize, "name", "asc");
        model.addAttribute("pageProduct",p);
        getCartItem(model, userName);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }
        return "index";
    }
}
