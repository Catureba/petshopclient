package com.catusoft.petshopclient.infra.repository.product;

import com.catusoft.petshopclient.infra.dao.product.ProductDAO;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    @Autowired
    private ProductDAO productDAO;

    public List<ProductEntity> findAll() {
        return productDAO.findAll();
    }

    public ProductEntity findById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    public void save(ProductEntity productEntity) {
        productDAO.save(productEntity);
    }

    public void delete(Long id) {
        productDAO.deleteById(id);
    }

    public void manageStock(Long id, Integer quantity) {
        ProductEntity productEntity = productDAO.findById(id).orElse(null);

        if (Objects.isNull(productEntity)) return;

        productEntity.setStock(productEntity.getStock() + quantity);
        productDAO.save(productEntity);
    }
}
