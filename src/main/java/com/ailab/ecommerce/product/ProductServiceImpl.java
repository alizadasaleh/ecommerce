package com.ailab.ecommerce.product;

import com.ailab.ecommerce.exceptions.ProductAlreadyExists;
import com.ailab.ecommerce.exceptions.ProductNotFound;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> Products = productRepository.findAll();
        return Products.stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(long id) {
        return productMapper.toResponseDto(productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product Not Found")));
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto){
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFound("Product not found"));

        existingProduct.setName(productRequestDto.getName());
        existingProduct.setPrice(productRequestDto.getPrice());

        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.toResponseDto(updatedProduct);
    }

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        var existingProduct = productRepository.findByName(productRequestDto.getName());
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExists("Product with this name already exists");
        }
        return productMapper.toResponseDto(productRepository.save(productMapper.toEntity(productRequestDto)));
    }



    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
