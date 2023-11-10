package iuh.fit.week5.controllers;

import iuh.fit.week5.entities.Address;
import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.enums.CandidateStatus;
import iuh.fit.week5.services.AddressService;
import iuh.fit.week5.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Qualifier("candidateImplement")
    @Autowired
    private CandidateService service;
    @Autowired
    private AddressService addressService;
    private int PAGE;
    private int SIZE;
    @GetMapping
    public String getAll(Model model){
        List<Candidate> l = service.findAll();
        model.addAttribute("candidates",l);
        return "candidates";
    }
    @GetMapping("/sort")
    public String Paging(Model model, @Param("page") Optional<Integer> page,@Param("size") Optional<Integer> size){
        int currentPage= page.orElse(1);
        int currentSize= size.orElse(10);
        Page<Candidate> p = service.findPage(currentPage - 1, currentSize, "id", "asc");
        model.addAttribute("candidatePage",p);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }

        return "candidatePaging";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        Candidate c= new Candidate();
        model.addAttribute("candidate",c);
        return "createCandidate";
    }
    @PostMapping("/create/new")
    public String createCandidate(@ModelAttribute("candidate") Candidate candidate){
        Address a= candidate.getAddress();
        addressService.save(a);
        service.save(candidate);
        return "redirect:/candidate/sort?size="+SIZE+"&page="+PAGE;
    }
    @GetMapping("/updateForm/{id}")
    public String formUpdate(Model model, @PathVariable("id") Long id){
        Optional<Candidate> c = service.find(id);
        Candidate b = null;
        if (c.isPresent()){
            b = c.get();
        }
        model.addAttribute("candidate",b);
        return "updateCandidate";
    }
    @PostMapping("/update/{id}")
    public String updateCandidate(@ModelAttribute("candidate") Candidate candidate, @PathVariable("id") Long id){
        Optional<Candidate> c = service.find(id);
        if (c.isPresent()){
            Candidate b = c.get();
            Address a= candidate.getAddress();
            addressService.save(a);
            b.setAddress(a);
            b.setDob(candidate.getDob());
            b.setEmail(candidate.getEmail());
            b.setPhone(candidate.getPhone());
            b.setFullName(candidate.getFullName());
            b.setCandidateStatus(CandidateStatus.ACTIVE);
            service.save(b);
        }
        return "redirect:/candidate/sort?size="+SIZE+"&page="+PAGE;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id ){
        service.delete(id);
        return "redirect:/candidate/sort?size="+SIZE+"&page="+PAGE;
    }

}
