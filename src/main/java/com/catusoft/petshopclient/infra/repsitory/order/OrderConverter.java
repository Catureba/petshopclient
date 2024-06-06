package com.catusoft.petshopclient.infra.repository.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderConverter {

    public OrderEntity toEntity(OrderDTO orderDTO, ProductEntity productEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setProduct(productEntity);
        return orderEntity;
    }

    public OrderDTO toDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setQuantity(orderEntity.getQuantity());
        orderDTO.setProductId(orderEntity.getProduct().getId());
        return orderDTO;
    }
    public List<OrderDTO> toDTO(List<OrderEntity> orderEntities) {
        return orderEntities.stream().map(this::toDTO).toList();
    }

}
