package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Product;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController<Product> {

    private final ProductRepository productRepository;

    public ProductController(BaseRepository<Product> baseRepository, ProductRepository productRepository) {
        super.baseRepository = baseRepository;
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<Product>> readByName(@PathVariable String name) {
        return new ResponseEntity<>(this.productRepository.findByName(name), HttpStatus.OK);
    }
}