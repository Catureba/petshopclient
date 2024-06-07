package com.catusoft.petshopclient.infrastructure.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
}
