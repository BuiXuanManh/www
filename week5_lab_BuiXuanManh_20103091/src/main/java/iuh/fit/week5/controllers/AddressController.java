package iuh.fit.week5.controllers;

import com.neovisionaries.i18n.CountryCode;
import iuh.fit.week5.entities.Address;
import iuh.fit.week5.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    private int PAGE;
    private int SIZE;

    @GetMapping
    public String getAll(Model model){
        List<Address> l = addressService.getAll();
        model.addAttribute("addresses",l);
        return "address";
    }
    @GetMapping("/new")
    public String formAddress(Model model){
        Address a= new Address();
        model.addAttribute("address",a);
        return "newAddress";
    }

    @PostMapping("/newAddress")
    public String saveAddress(@ModelAttribute("address") Address address) {

//            address.setCountryCode(CountryCode.getByCode("840")); // Ví dụ: Mỹ
//
//        String c = addressService.getCountryCode(address.getId());
//        CountryCode cc = CountryCode.getByCode(c);
//        address.setCountryCode(cc);address.setCountryCode(CountryCode.getByCode("840")); // Ví dụ: Mỹ
//
        addressService.save(address);
            return "redirect:/address";
    }
    @GetMapping("/update/{id}")
    public String formUpdateAddress(Model model,@PathVariable Long id){
        Optional<Address> a= addressService.find(id);
        Address b = null;
        if(a.isPresent())
            b=a.get();
        model.addAttribute("address",b);
        return "updateAddress";
    }

    @PostMapping("/updateAddress/{id}")
    public String updateAddress(@ModelAttribute("address") Address address,@PathVariable Long id) {
        Optional<Address> a= addressService.find(id);
        Address b = null;
        if(a.isPresent())
            b=a.get();
        b.setCity(address.getCity());
        b.setCountryCode(address.getCountryCode());
        b.setZipcode(address.getZipcode());
        b.setStreet(address.getStreet());
        b.setNumber(address.getNumber());
        addressService.save(b);
        if(SIZE==0||PAGE==0){
            return "redirect:/address";
        }
        return "redirect:/address/sort?page="+PAGE+"&size="+SIZE;
    }
//    @GetMapping("/delete/{id}")
//    public String deleteAddress(@PathVariable Long id){
//        addressService.delete(id);
//        if(SIZE==0||PAGE==0){
//            return "redirect:/address";
//        }
//        return "redirect:/address/sort?page="+PAGE+"&size="+SIZE;
//    }

    @GetMapping("/sort")
    public String getAllBySort(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, RedirectAttributes redirectAttributes){
        int currentPage= page.orElse(1);
        int currentSize=size.orElse(10);
        Page<Address> p = addressService.findPage(currentPage - 1, currentSize, "id", "asc");
        model.addAttribute("pageAddress",p);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }


        return "addressPaging";
    }

}
