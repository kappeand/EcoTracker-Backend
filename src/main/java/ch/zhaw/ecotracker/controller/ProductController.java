package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Product;
import ch.zhaw.ecotracker.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(value = "product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(this.productRepository.save(product), HttpStatus.OK);
    }

    @GetMapping(value = "product/{id}")
    public ResponseEntity<Product> readById(@PathVariable Long id) {
        return this.productRepository.findById(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "product/all")
    public ResponseEntity<List<Product>> readAll() {
        return new ResponseEntity<>(this.productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "product/name/{name}")
    public ResponseEntity<List<Product>> readByName(@PathVariable String name) {
        return new ResponseEntity<>(this.productRepository.findByName(name), HttpStatus.OK);
    }

    @PutMapping(value = "product")
    public ResponseEntity<Product> update(@RequestBody Product newProduct) {
        if (this.productRepository.existsById(newProduct.getId())) {
            return new ResponseEntity<>(this.productRepository.save(newProduct), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "product")
    public ResponseEntity<Product> delete(@RequestParam("id") Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling