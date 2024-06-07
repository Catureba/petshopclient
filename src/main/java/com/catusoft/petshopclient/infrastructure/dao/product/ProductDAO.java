package com.catusoft.petshopclient.infrastructure.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductEntity, Long> {
}
