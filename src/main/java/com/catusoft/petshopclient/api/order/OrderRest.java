package com.catusoft.petshopclient.api.order;

import com.catusoft.petshopclient.business.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petshopClient/v1/api/order")
public class OrderRest {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrderDTO> getOrders() {
        return orderService.findAll();
    }
    @GetMapping("/id/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }
    @PostMapping("")
    public void saveOrder(@RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO);
    }
    @DeleteMapping
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
    }
}
