package com.mylearning.productservice.productservice.controller;

import com.mylearning.productservice.productservice.dto.ProductDto;
import com.mylearning.productservice.productservice.mapper.ProductMapper;
import com.mylearning.productservice.productservice.model.Product;
import com.mylearning.productservice.productservice.repository.ProductRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepo repo;

    public ProductController(ProductRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductDto productDto) {
      Product product = ProductMapper.toProduct(productDto, new Product());
     return repo.save(product);
    }

    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public Product getProductById(@RequestParam("name") String name) {
        return  repo.findByName(name);
    }
}
