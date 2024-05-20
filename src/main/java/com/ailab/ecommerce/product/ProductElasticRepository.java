package com.ailab.ecommerce.product;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepository  extends ElasticsearchRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    @Query("{\"fuzzy\": {\"name\": {\"value\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Product> findByNameFuzzy(String name);

    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Product> findByNameWithFuzziness(String name);

}
