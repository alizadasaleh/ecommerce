package com.ailab.ecommerce.common;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntityAudit implements Serializable {

    private Date createdAt;

    private Date updatedAt;
}