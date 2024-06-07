package com.catusoft.petshopclient.infrastructure.dao.order;

import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "order_table")
@Setter
@Getter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float orderPrice;

    private Integer quantity;

    private String orderDate;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
