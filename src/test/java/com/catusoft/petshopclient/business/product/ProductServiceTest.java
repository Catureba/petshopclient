package com.catusoft.petshopclient.business.product;


import com.catusoft.petshopclient.api.product.ManageStockDTO;
import com.catusoft.petshopclient.infra.dao.product.ProductEntity;
import com.catusoft.petshopclient.infra.repsitory.product.ProductRepositry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepositry productRepositry;

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
        when(productRepositry.findById(id)).thenReturn(product);

        ProductEntity foundProduct = productService.findById(id);

        assertNotNull(foundProduct);
        assertEquals(id, foundProduct.getId());
        verify(productRepositry, times(1)).findById(id);
    }

    @Test
    void findAll() {
        ProductEntity product1 = new ProductEntity();
        ProductEntity product2 = new ProductEntity();
        List<ProductEntity> products = Arrays.asList(product1, product2);
        when(productRepositry.findAll()).thenReturn(products);

        List<ProductEntity> foundProducts = productService.findAll();

        assertNotNull(foundProducts);
        assertEquals(2, foundProducts.size());
        verify(productRepositry, times(1)).findAll();
    }

    @Test
    void save() {
        ProductEntity product = new ProductEntity();
        doNothing().when(productRepositry).save(product);

        productService.save(product);

        verify(productRepositry, times(1)).save(product);
    }

    @Test
    void delete() {
        Long id = 1L;
        doNothing().when(productRepositry).delete(id);

        productService.delete(id);

        verify(productRepositry, times(1)).delete(id);
    }

    @Test
    void manageStock() {
        Long id = 1L;
        Integer quantity = 1;
        ManageStockDTO manageStockDTO = new ManageStockDTO();
        manageStockDTO.setProductId(id);
        manageStockDTO.setQuantity(quantity);
       doNothing().when(productRepositry).manageStock(manageStockDTO.getProductId(), manageStockDTO.getQuantity());
        productService.manageStock(manageStockDTO);

        verify(productRepositry, times(1)).manageStock(id, quantity);
    }
}
