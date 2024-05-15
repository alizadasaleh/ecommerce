package com.ailab.ecommerce.product;

import com.ailab.ecommerce.common.BaseEntity;
import com.ailab.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Document(indexName = "product_index")
public class Product implements Serializable {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @Field(type = FieldType.Date)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Field(type = FieldType.Date)
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(type = FieldType.Long)
    private  Long id;

    @Column(length = 255, nullable = true)
    @Field(type = FieldType.Text)
    private String name;

    @Column(nullable = false)
    @Field(type = FieldType.Double)
    private Double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Order> orders;

}
