package com.avilatek.ecommerceapi.service.product;

import com.avilatek.ecommerceapi.dto.ProductDto;
import com.avilatek.ecommerceapi.model.Product;
import com.avilatek.ecommerceapi.request.AddProductRequest;
import com.avilatek.ecommerceapi.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    Product updateProduct(Long id, ProductUpdateRequest product);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
    List<ProductDto> getConvertedProductDtos(List<Product> products);
    ProductDto convertToDto(Product product);
}