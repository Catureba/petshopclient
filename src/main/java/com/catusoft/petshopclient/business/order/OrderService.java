package com.catusoft.petshopclient.business.order;

import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import com.catusoft.petshopclient.infra.repsitory.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity findById(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public void save(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

}
