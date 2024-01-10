package controller;

import model.Product;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@SpringBootConfiguration
public class ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> FindAll(){

        List<Product> products = new ArrayList<Product>();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> FindById(@PathVariable Long id){

        Optional<Product> product = Optional.of(new Product());
        return new ResponseEntity<>(product, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(product, HttpStatus.OK);
    }





}
