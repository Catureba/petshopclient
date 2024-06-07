package com.catusoft.petshopclient.business.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infrastructure.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderDTO findById(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderDTO> findAll() {
        log.info("[Service] Buscando todos os pedidos");
        List<OrderDTO> orders = orderRepository.findAll();
        return orders;
    }

    public void save(OrderDTO orderDTO) {
        log.info("[Service] Salvando um novo pedido");
        orderRepository.save(orderDTO);
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

}
