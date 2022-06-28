package com.example.springcrud.Repositories;

import com.example.springcrud.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
