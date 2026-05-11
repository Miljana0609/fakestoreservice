package se.jensen.miljana.fakestoreservice.service;

import org.junit.jupiter.api.Test;
import se.jensen.miljana.fakestoreservice.model.Product;
import se.jensen.miljana.fakestoreservice.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Test
    void getAllProducts() {

        // ARRANGE
        ProductRepository repository = mock(ProductRepository.class);

        Product product1 = new Product();
        product1.setTitle("test product 1");

        Product product2 = new Product();
        product2.setTitle("test product 2");


        List<Product> fakeProducts = List.of(product1, product2);

        when(repository.findAll()).thenReturn(fakeProducts);

        ProductService productService = new ProductService(repository);

        // ACT
        List<Product> result = productService.getAllProducts();


        // ASSERT

        assertEquals(2, result.size());
        assertEquals("test product 1", result.get(0).getTitle());
        assertEquals("test product 2", result.get(1).getTitle());


        verify(repository).findAll();

    }
}