package ir.greenweb.examples.supplychaintracking.presentation.rest;

import ir.greenweb.examples.supplychaintracking.contract.business.MovementServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.business.ProductServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceApi productService;
    private final MovementServiceApi movementService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductGetResponse getProduct(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductsGetResponse getProducts(@Valid ProductsGetRequest request) {
        return productService.getProducts(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreationResponse create(@Valid @RequestBody ProductCreationRequest request) {
        return productService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody ProductEditionRequest request) {
        productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        productService.delete(id);
    }

    @PostMapping("/{id}/movements")
    @ResponseStatus(HttpStatus.CREATED)
    public MovementCreationResponse logMovement(@PathVariable("id") String productId, @Valid @RequestBody MovementCreationRequest request) {
        return movementService.logMovement(productId, request);
    }

    @GetMapping("/{id}/movements")
    @ResponseStatus(HttpStatus.OK)
    public ProductMovementsGetResponse getMovements(@PathVariable("id") String productId, @Valid ProductMovementsGetRequest request) {
        return movementService.getMovements(productId, request);
    }
}
