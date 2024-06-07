package com.catusoft.petshopclient.infrastructure.repository.product;

import com.catusoft.petshopclient.api.product.ProductDTO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductDAO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepository {
    @Autowired
    private ProductDAO productDAO;
    private final ProductConverter productConverter;

    @NewSpan("[product-repository] findAll")
    public List<ProductDTO> findAll() {
        log.info("[Repository] Buscando produtos");
        var productEntities = productDAO.findAll();
        if (Objects.isNull(productEntities)) return null;
        var productDTOs = productConverter.toDTO(productEntities);
        return productDTOs;
    }
    @NewSpan("[product-repository] findById")
    public ProductDTO findById(Long id) {
        var productEntity = productDAO.findById(id).orElse(null);
        if (Objects.isNull(productEntity)) return null;
        return productConverter.toDTO(productEntity);
    }
    @NewSpan("[product-repository] save")
    public void save(ProductDTO productDTO) {
        log.info("[Repository] Salvando um novo produto");
        ProductEntity productEntity = productConverter.toEntity(productDTO);
        productDAO.save(productEntity);
    }
    @NewSpan("[product-repository] delete")
    public void delete(Long id) {
        productDAO.deleteById(id);
    }

    @NewSpan("[product-repository] manageStock")
    public void manageStock(Long id, Integer quantity) {
        log.info("[Repository] Atualizando estoque");
        ProductEntity productEntity = productDAO.findById(id).orElse(null);

        if (Objects.isNull(productEntity)) return;

        productEntity.setStock(productEntity.getStock() + quantity);
        productDAO.save(productEntity);
    }
}
