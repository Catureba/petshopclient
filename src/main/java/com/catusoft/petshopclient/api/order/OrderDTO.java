package com.catusoft.petshopclient.api.order;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class OrderDTO {
    private Integer quantity;
    private Long productId;
    private Date createdAt;
}
