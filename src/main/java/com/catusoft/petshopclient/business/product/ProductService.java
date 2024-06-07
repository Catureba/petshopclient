package com.catusoft.petshopclient.business.product;

import com.catusoft.petshopclient.api.product.ManageStockDTO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import com.catusoft.petshopclient.infrastructure.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity findById(Long id) {
        return productRepository.findById(id);
    }
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
    public void manageStock(ManageStockDTO manageStockDTO) {
        Long id = manageStockDTO.getProductId();
        Integer quantity = manageStockDTO.getQuantity();
        productRepository.manageStock(id, quantity);
    }
}
