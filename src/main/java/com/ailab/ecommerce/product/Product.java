package com.ailab.ecommerce.product;

import com.ailab.ecommerce.order.Order;
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
@Document(indexName = "product_index")
public class Product implements Serializable {

    @CreatedDate
    @Field(type = FieldType.Date)
    private Date createdAt;


    @LastModifiedDate
    @Field(type = FieldType.Date)
    private Date updatedAt;


    @Field(type = FieldType.Long)
    private  Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Double)
    private Double price;

    private List<Order> orders;

}
