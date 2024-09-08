package com.mylearning.productservice.productservice.mapper;

import com.mylearning.productservice.productservice.dto.ProductDto;
import com.mylearning.productservice.productservice.model.Product;

//Utility class
public class ProductMapper {

    public static Product toProduct(ProductDto productDto, Product product) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public static ProductDto toProductDto(Product product, ProductDto productDto) {
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
