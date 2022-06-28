package com.example.springcrud.Controllers;

import com.example.springcrud.Models.Product;
import com.example.springcrud.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ResponseBody
@Controller
public class uploadController {
    @Autowired
    private ProductRepo repo;

    @GetMapping("/")
    public ModelAndView getUploads(){
        ModelAndView mv = new ModelAndView("index.html");
        List<Product> products = repo.findAll();
        mv.addObject("data",products);
        System.out.println(products);
        return mv;
    }
    @GetMapping("/index")
    public ModelAndView getUploadsI(){
        ModelAndView mv = new ModelAndView("index.html");
        List<Product> products = repo.findAll();
        mv.addObject("data",products);
        System.out.println(products);
        return mv;
    }
    @PostMapping("/uploadSuccess")
    public ModelAndView postFeltoltes(Product product){
       String name = product.getProductName();
       String productDescription = product.getProductDescription();
       int price = product.getPrice();
       try{
           Product newProduct = new Product(name, productDescription, price);
           repo.save(newProduct);
           System.out.println("Sikeres feltöltés.");
           ModelAndView mv = new ModelAndView("uploadSuccess.html");
           return mv;
       }
       catch(Exception exception){
           System.out.println("Valamiféle hiba történt.");
           System.out.println(exception.getMessage());
           ModelAndView mv = new ModelAndView("index.html");
           return mv;
        }
    }
}
