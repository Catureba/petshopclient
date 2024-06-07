package com.catusoft.petshopclient.infrastructure.repository.product;

import com.catusoft.petshopclient.api.product.ProductDTO;
import com.catusoft.petshopclient.infrastructure.dao.product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConverter {

    public ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductDescription(productDTO.getProductDescription());
        productEntity.setProductPrice(productDTO.getProductPrice());
        productEntity.setStock(productDTO.getStock());
        return productEntity;
    }
    public ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setProductDescription(productEntity.getProductDescription());
        productDTO.setProductPrice(productEntity.getProductPrice());
        productDTO.setStock(productEntity.getStock());
        return productDTO;
    }
    public List<ProductDTO> toDTO(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::toDTO).toList();
    }
}
