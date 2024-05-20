package com.ailab.ecommerce.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseEntity<T> implements Serializable {


    private T id;


}
