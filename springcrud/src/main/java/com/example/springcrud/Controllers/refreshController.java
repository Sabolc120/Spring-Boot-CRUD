package com.example.springcrud.Controllers;

import com.example.springcrud.Models.Product;
import com.example.springcrud.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@ResponseBody
@Controller
public class refreshController {
    @Autowired
    private ProductRepo repo;

    @GetMapping("/frissit/{id}")
    public ModelAndView getRefresh(@PathVariable Long id){
        try{
            Product oneProduct = repo.findById(id).orElse(new Product());
            ModelAndView mv = new ModelAndView("frissit.html");
            mv.addObject("data", oneProduct);
            return mv;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            ModelAndView mv = new ModelAndView("frissit.html");
            return mv;
        }
    }
    @PostMapping("/frissit")
    public ModelAndView postRefresh(Product product){
        try{
            Long id = product.getId();
            String productName = product.getProductName();
            String productDescription = product.getProductDescription();
            int productPrice = product.getPrice();
            repo.deleteById(id);
            Product editedProduct = new Product(id, productName, productDescription, productPrice);
            repo.save(editedProduct);
            ModelAndView mv = new ModelAndView("szerkesztes.html");
            mv.addObject("data",  editedProduct);
            return mv;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            ModelAndView mv = new ModelAndView("szerkesztes.html");
            return mv;
        }
    }

}
