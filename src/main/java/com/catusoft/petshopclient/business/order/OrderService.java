package com.catusoft.petshopclient.business.order;

import com.catusoft.petshopclient.api.order.OrderDTO;
import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import com.catusoft.petshopclient.infra.repsitory.order.OrderConverter;
import com.catusoft.petshopclient.infra.repsitory.order.OrderRepository;
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
        var orders = orderRepository.findAll();
        if (Objects.isNull(orders) || orders.isEmpty()) {
            log.error(orders.toString());
            return null;
        }
        return orderRepository.findAll();
    }

    public void save(OrderDTO orderDTO) {
        try {
            orderRepository.save(orderDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

}
