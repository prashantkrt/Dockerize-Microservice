package com.mylearning.productservice.productservice.controller;

import com.mylearning.productservice.productservice.dto.Coupon;
import com.mylearning.productservice.productservice.dto.ProductDto;
import com.mylearning.productservice.productservice.mapper.ProductMapper;
import com.mylearning.productservice.productservice.model.Product;
import com.mylearning.productservice.productservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${coupon.service.url}")
    private String couponServiceUrl;

    public ProductController(ProductRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductDto productDto) {
        Coupon coupon = restTemplate.getForObject(couponServiceUrl + productDto.getCouponCode(),Coupon.class);
        Product product = ProductMapper.toProduct(productDto, new Product());
        product.setPrice(productDto.getPrice().subtract(coupon.getDiscount()));
        return repo.save(product);
    }

    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public Product getProductById(@RequestParam("name") String name) {
        return repo.findByName(name);
    }
}

//For Request Param
//http://localhost:8085/coupon/getCoupon?code=1234 // we have to make this uri

//String url = "http://localhost:8085/coupon/getCoupon";
//
// Constructing the URL with query parameters using UriComponentsBuilder
//String uri = UriComponentsBuilder.fromHttpUrl(url)
//        .queryParam("code",productDto.getCouponCode())
//        .toUriString();
//Coupon response = restTemplate.getForObject(uri, Coupon.class);