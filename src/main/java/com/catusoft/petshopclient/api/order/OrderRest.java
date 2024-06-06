package com.catusoft.petshopclient.api.order;

import com.catusoft.petshopclient.business.order.OrderService;
import com.catusoft.petshopclient.infra.dao.order.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petshopClient/v1/api/order")
public class OrderRest {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrderEntity> getOrders() {
        return orderService.findAll();
    }
    @GetMapping("/id/{id}")
    public OrderEntity getOrderById(Long id) {
        return orderService.findById(id);
    }
    @PostMapping("")
    public void saveOrder(OrderEntity orderEntity) {
        orderService.save(orderEntity);
    }
    @DeleteMapping
    public void deleteOrder(Long id) {
        orderService.delete(id);
    }
}
