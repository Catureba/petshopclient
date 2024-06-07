package com.catusoft.petshopclient.infrastructure.repository.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infrastructure.dao.order.OrderEntity;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class OrderConverter {

    public OrderEntity toEntity(OrderDTO orderDTO, ProductEntity productEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setOrderPrice(productEntity.getProductPrice() * orderDTO.getQuantity());
        orderEntity.setCreatedAt(new Date());
        orderEntity.setProduct(productEntity);
        return orderEntity;
    }

    public OrderDTO toDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setQuantity(orderEntity.getQuantity());
        orderDTO.setCreatedAt(orderEntity.getCreatedAt());
        orderDTO.setProductId(orderEntity.getProduct().getId());
        return orderDTO;
    }
    public List<OrderDTO> toDTO(List<OrderEntity> orderEntities) {
        if(orderEntities.isEmpty()) return List.of();
        return orderEntities.stream().map(this::toDTO).toList();
    }

}
