package com.avilatek.ecommerceapi.service.product;

import com.avilatek.ecommerceapi.dto.ProductDto;
import com.avilatek.ecommerceapi.model.Product;
import com.avilatek.ecommerceapi.repository.ProductRepository;
import com.avilatek.ecommerceapi.request.AddProductRequest;
import com.avilatek.ecommerceapi.request.ProductUpdateRequest;
import com.avilatek.ecommerceapi.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

//    @Override
//    public Product addProduct(AddProductRequest request) {
//        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
//                .orElseGet(()->{
//                    Category newCategory = new Category(request.getCategory().getName());
//                    return categoryRepository.save(newCategory);
//                });
//        request.setCategory(category);
//        return productRepository.save(createProduct(request));
//    }

    private Product createProduct(AddProductRequest request){
        return new Product(
                request.getName(),
                request.getDescription(),
                request.getStock(),
                request.getPrice()
        );
    }

    @Override
    public Product addProduct(AddProductRequest request) {
        return productRepository.save(createProduct(request));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    @Override
    public Product updateProduct(Long id, ProductUpdateRequest product) {
        return null;
    }


//    @Override
//    public Product updateProduct(Long id, ProductUpdateRequest product) {
//        return productRepository.findById(id)
//                .map((existingProduct) -> updateExistingProduct(existingProduct, product))
//                .map(productRepository :: save)
//                .orElseThrow(() -> new RuntimeException("Product not found!"));
//    }

//    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request){
//        existingProduct.setName(request.getName());
//        existingProduct.setBrand(request.getBrand());
//        existingProduct.setDescription(request.getDescription());
//        existingProduct.setInventory(request.getInventory());
//        existingProduct.setPrice(request.getPrice());
//
//        Category category = categoryRepository.findByName(request.getCategory().getName());
//        existingProduct.setCategory(category);
//
//        return existingProduct;
//    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        () -> {throw new RuntimeException("Product not found!");});
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    @Override
//    public List<Product> getProductsByCategory(String category) {
//        return productRepository.findByCategoryName(category);
//    }
//
//    @Override
//    public List<Product> getProductsByBrand(String brand) {
//        return productRepository.findByBrand(brand);
//    }
//
//    @Override
//    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
//        return productRepository.findByCategoryNameAndBrand(category, brand);
//    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

//    @Override
//    public List<Product> getProductsByBrandAndName(String brand, String name) {
//        return productRepository.findByBrandAndName(brand, name);
//    }

//    @Override
//    public Long countProductsByBrandAndName(String brand, String name) {
//        return productRepository.countByBrandAndName(brand, name);
//    }

    @Override
    public List<ProductDto> getConvertedProductDtos(List<Product> products){
        return products.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public ProductDto convertToDto(Product product) {
        return null;
    }

//    @Override
//    public ProductDto convertToDto(Product product){
//        ProductDto productDto = modelMapper.map(product, ProductDto.class);
//        List<Image> images = imageRepository.findByProductId(product.getId());
//        List<ImageDto> imageDtos = images.stream()
//                .map(image -> modelMapper.map(image, ImageDto.class))
//                .toList();
//        productDto.setImages(imageDtos);
//        return productDto;
//    }
}