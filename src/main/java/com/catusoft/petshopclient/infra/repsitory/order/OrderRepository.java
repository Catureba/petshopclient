package com.catusoft.petshopclient.infra.repsitory.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infra.dao.order.OrderDAO;
import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import com.catusoft.petshopclient.infra.dao.product.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private static final Logger log = LoggerFactory.getLogger(OrderRepository.class);
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ProductDAO productDAO;
    private final OrderConverter orderConverter;

    public List<OrderDTO> findAll() {
        var orders = orderDAO.findAll();
        if (Objects.isNull(orders)) {
            return null;
        }
        var ordersDTO = orderConverter.toDTO(orders);
        return ordersDTO;
    }

    public OrderDTO findById(Long id) {
        var orderDTO = orderConverter.toDTO(orderDAO.findById(id).orElse(null));
        return orderDTO;
    }

    public void save(OrderDTO orderDTO) {
        var product = productDAO.findById(orderDTO.getProductId()).orElse(null);
        if (Objects.isNull(product)) {
            log.error("Product not found");
            return;
        }
        var orderEntity = orderConverter.toEntity(orderDTO, product);
        if(product.getStock() < orderDTO.getQuantity()){
            log.error("Stock not enough");
            return;
        }

        orderEntity.setOrderPrice(product.getProductPrice() * orderDTO.getQuantity());
        product.setStock(product.getStock() - orderDTO.getQuantity());
        productDAO.save(product);
        orderDAO.save(orderEntity);
    }

    public void delete(Long id) {
        orderDAO.deleteById(id);
    }
}
