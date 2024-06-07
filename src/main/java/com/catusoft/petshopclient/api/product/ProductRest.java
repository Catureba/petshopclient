package com.catusoft.petshopclient.api.product;

import com.catusoft.petshopclient.business.product.ProductService;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petshopClient/v1/api/product")
@Slf4j
public class ProductRest {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> getProducts() {
        log.info("[Controller] Buscando todos os produtos");
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("")
    public void saveProduct(ProductDTO productDTO) {
        productService.save(productDTO);
    }

    @DeleteMapping("/id/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @PostMapping("/manageStock")
    public void manageStock(@RequestBody ManageStockDTO manageStockDTO) {
        log.info("[Controller] Atualizando estoque");
        productService.manageStock(manageStockDTO);
    }
}