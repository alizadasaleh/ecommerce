package com.ailab.ecommerce.repository;

import com.ailab.ecommerce.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepository{
    List<Product>findAllById(List<Long> ids);
    List<Product> findAll();

    Long save(Product product);
    void update(Product product);
    void delete(Product product);

    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);


}
