package com.catusoft.petshopclient.business.product;

import com.catusoft.petshopclient.api.product.ManageStockDTO;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import com.catusoft.petshopclient.infra.repsitory.product.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepositry productRepositry;

    public ProductEntity findById(Long id) {
        return productRepositry.findById(id);
    }
    public List<ProductEntity> findAll() {
        return productRepositry.findAll();
    }
    public void save(ProductEntity productEntity) {
        productRepositry.save(productEntity);
    }

    public void delete(Long id) {
        productRepositry.delete(id);
    }
    public void manageStock(ManageStockDTO manageStockDTO) {
        Long id = manageStockDTO.getProductId();
        Integer quantity = manageStockDTO.getQuantity();
        productRepositry.manageStock(id, quantity);
    }
}
