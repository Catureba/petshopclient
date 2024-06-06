package com.catusoft.petshopclient.api.order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {
    private Integer quantity;

    private Long productId;
}
