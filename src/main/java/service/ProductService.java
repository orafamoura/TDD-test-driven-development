package service;

import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public List<Product> FindAll(){

        List<Product> products = new ArrayList<Product>();
        return products;
    }

    public Optional<Product> FindById(Long id){

        Optional<Product> product = Optional.of(new Product());
        return product;
    }

    public Product addProduct(Product product){

        return product;
    }
}
