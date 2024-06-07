package com.catusoft.petshopclient.infrastructure.repository.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infrastructure.dao.order.OrderDAO;
import com.catusoft.petshopclient.infrastructure.dao.order.OrderEntity;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductDAO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
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

    @NewSpan("[order-repository] findAll")
    public List<OrderDTO> findAll() {
        log.info("[Repository] Buscando pedidos");
        List<OrderEntity> orders = orderDAO.findAll();
        if (Objects.isNull(orders)) {
            return null;
        }
        var ordersDTO = orderConverter.toDTO(orders);
        return ordersDTO;
    }

    @NewSpan("[order-repository] findById")
    public OrderDTO findById(Long id) {
        OrderDTO orderDTO = orderConverter.toDTO(orderDAO.findById(id).orElse(null));
        return orderDTO;
    }

    @NewSpan("[order-repository] save")
    public void save(OrderDTO orderDTO) {
        log.info("[Repository] Salvando novo pedido");
        ProductEntity product = productDAO.findById(orderDTO.getProductId()).orElse(null);
        if (Objects.isNull(product)) {
            log.error("Product not found");
            return;
        }
        OrderEntity orderEntity = orderConverter.toEntity(orderDTO, product);
        if(product.getStock() < orderDTO.getQuantity()){
            log.error("Stock not enough");
            return;
        }

        product.setStock(product.getStock() - orderDTO.getQuantity());
        productDAO.save(product);
        orderDAO.save(orderEntity);
    }

    @NewSpan("[order-repository] delete")
    public void delete(Long id) {
        orderDAO.deleteById(id);
    }
}
