package com.catusoft.petshopclient.infra.repsitory.order;

import com.catusoft.petshopclient.infra.dao.order.OrderDAO;
import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private OrderDAO orderDAO;

    public List<OrderEntity> findAll() {
        return orderDAO.findAll();
    }

    public OrderEntity findById(Long id) {
        return orderDAO.findById(id).orElse(null);
    }

    public void save(OrderEntity orderEntity) {
        orderDAO.save(orderEntity);
    }

    public void delete(Long id) {
        orderDAO.deleteById(id);
    }
}
