package com.catusoft.petshopclient.api.order;

import com.catusoft.petshopclient.business.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petshopClient/v1/api/order")
@Slf4j
public class OrderRest {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrderDTO> getOrders() {
        log.info("[Controller] Buscando todos os pedidos");
        return orderService.findAll();
    }
    @GetMapping("/id/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }
    @PostMapping
    public void saveOrder(@RequestBody OrderDTO orderDTO) {
        log.info("[Controller] Salvando um novo pedido");
        orderService.save(orderDTO);
    }
    @DeleteMapping("/id/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
    }
}
