package se.jensen.miljana.fakestoreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.jensen.miljana.fakestoreservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

