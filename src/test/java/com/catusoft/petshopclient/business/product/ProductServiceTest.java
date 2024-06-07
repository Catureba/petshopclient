package com.catusoft.petshopclient.business.product;


import com.catusoft.petshopclient.api.product.ManageStockDTO;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import com.catusoft.petshopclient.infra.repository.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Long id = 1L;
        ProductEntity product = new ProductEntity();
        product.setId(id);
        when(productRepository.findById(id)).thenReturn(product);

        ProductEntity foundProduct = productService.findById(id);

        assertNotNull(foundProduct);
        assertEquals(id, foundProduct.getId());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void findAll() {
        ProductEntity product1 = new ProductEntity();
        ProductEntity product2 = new ProductEntity();
        List<ProductEntity> products = Arrays.asList(product1, product2);
        when(productRepository.findAll()).thenReturn(products);

        List<ProductEntity> foundProducts = productService.findAll();

        assertNotNull(foundProducts);
        assertEquals(2, foundProducts.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void save() {
        ProductEntity product = new ProductEntity();
        doNothing().when(productRepository).save(product);

        productService.save(product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    void delete() {
        Long id = 1L;
        doNothing().when(productRepository).delete(id);

        productService.delete(id);

        verify(productRepository, times(1)).delete(id);
    }

    @Test
    void manageStock() {
        Long id = 1L;
        Integer quantity = 1;
        ManageStockDTO manageStockDTO = new ManageStockDTO();
        manageStockDTO.setProductId(id);
        manageStockDTO.setQuantity(quantity);
       doNothing().when(productRepository).manageStock(manageStockDTO.getProductId(), manageStockDTO.getQuantity());
        productService.manageStock(manageStockDTO);

        verify(productRepository, times(1)).manageStock(id, quantity);
    }
}
