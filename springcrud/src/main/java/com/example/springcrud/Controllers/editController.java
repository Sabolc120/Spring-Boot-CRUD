package com.example.springcrud.Controllers;

import com.example.springcrud.Models.Product;
import com.example.springcrud.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class editController {

    @Autowired
    private ProductRepo repo;

    @GetMapping("/szerkesztes/{id}")
    @ResponseBody
    public ModelAndView editProductPage(@PathVariable Long id){
        try{
             Product oneProduct = repo.findById(id).orElse(new Product());
             ModelAndView mv = new ModelAndView("szerkesztes.html");
             mv.addObject("data", oneProduct);
             return mv;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ModelAndView mv = new ModelAndView("szerkesztes.html");
            return mv;
        }
    }
    @GetMapping("/torles/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id){
        try{
            repo.deleteById(id);
            ModelAndView mv = new ModelAndView("torles");
            return mv;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ModelAndView mv = new ModelAndView("torles");
            return mv;
        }
    }
}
