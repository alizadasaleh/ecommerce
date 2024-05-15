package com.ailab.ecommerce.product;

import com.ailab.ecommerce.exception.EntityNotFoundException;
import com.ailab.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.elasticsearch.core.RefreshPolicy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductElasticRepository productElasticRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ProductElasticRepository productElasticRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productElasticRepository = productElasticRepository;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        Iterable<Product> products = productElasticRepository.findAll();
        return StreamSupport.stream(products.spliterator(), false)
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return productMapper.toResponseDto(productRepository.
                findById(id).orElseThrow(() -> new EntityNotFoundException("Product Not Found")));
    }

    @Override
    @Transactional
    public void updateProduct(Long productId, ProductRequestDto productRequestDto){
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        existingProduct.setName(productRequestDto.getName());
        existingProduct.setPrice(productRequestDto.getPrice());
        productRepository.update(existingProduct);
        productElasticRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void createProduct(ProductRequestDto productRequestDto) {
        Long product_id = productRepository.save(productMapper.toEntity(productRequestDto));
        productElasticRepository.save(productRepository.findById(product_id).orElseThrow());
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found to delete"));
        productRepository.delete(product);
        productElasticRepository.delete(product);
    }

    @Override
    public List<ProductResponseDto> searchProducts(String name) {
        Iterable<Product> products =  productElasticRepository.findByNameContaining(name);
        return StreamSupport.stream(products.spliterator(), false) // false for sequential stream
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> fuzzySearchProducts(String name) {
        Iterable<Product> products =  productElasticRepository.findByNameFuzzy(name);
        return StreamSupport.stream(products.spliterator(), false)
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
