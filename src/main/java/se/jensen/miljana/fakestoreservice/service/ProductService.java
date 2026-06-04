package se.jensen.miljana.fakestoreservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.jensen.miljana.fakestoreservice.model.Product;
import se.jensen.miljana.fakestoreservice.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final RestTemplate restTemplate;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
    }


    public List<Product> fetchAndSaveProducts() {
        String url = "http://fakestoreservice-env.eba-pmbni5kh.eu-north-1.elasticbeanstalk.com/";

        Product[] response = restTemplate.getForObject(
                url,
                Product[].class
        );
        List<Product> products = Arrays.asList(response);

        repository.saveAll(products);
        return repository.findAll();
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
