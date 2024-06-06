package com.catusoft.petshopclient.api.product;

import com.catusoft.petshopclient.business.product.ProductService;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petshopClient/v1/api/product")
public class ProductRest {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductEntity> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    public ProductEntity getProductById(Long id) {
        return productService.findById(id);
    }

    @PostMapping("")
    public void saveProduct(ProductEntity productEntity) {
        productService.save(productEntity);
    }

    @DeleteMapping
    public void deleteProduct(Long id) {
        productService.delete(id);
    }

    @PostMapping("/manageStock")
    public void manageStock(Long id, Integer quantity) {
        productService.manageStock(id, quantity);
    }
}