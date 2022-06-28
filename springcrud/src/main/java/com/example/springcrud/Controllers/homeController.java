package com.example.springcrud.Controllers;

import com.example.springcrud.Models.Product;
import com.example.springcrud.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class homeController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/feltoltes")
    public String getFeltolt(){
        return "feltoltes";
    }
}
