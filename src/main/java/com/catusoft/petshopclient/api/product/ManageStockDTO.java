package com.catusoft.petshopclient.api.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ManageStockDTO {

    private Long productId;
    private Integer quantity;
}
