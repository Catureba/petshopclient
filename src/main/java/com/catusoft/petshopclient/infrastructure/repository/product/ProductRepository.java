package com.catusoft.petshopclient.infrastructure.repository.product;

import com.catusoft.petshopclient.api.product.ProductDTO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductDAO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    @Autowired
    private ProductDAO productDAO;
    private ProductConverter productConverter;
    public List<ProductDTO> findAll() {
        var productEntities = productDAO.findAll();
        return productConverter.toDTO(productEntities);
    }

    public ProductDTO findById(Long id) {
        var productEntity = productDAO.findById(id).orElse(null);
        if (Objects.isNull(productEntity)) return null;
        return productConverter.toDTO(productEntity);
    }

    public void save(ProductDTO productDTO) {
        ProductEntity productEntity = productConverter.toEntity(productDTO);
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
