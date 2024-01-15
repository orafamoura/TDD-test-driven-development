package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@SpringBootConfiguration
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> FindAll(){

        List<Product> products = productService.FindAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> FindById(@PathVariable Long id){

        Optional<Product> product = productService.FindById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }





}
