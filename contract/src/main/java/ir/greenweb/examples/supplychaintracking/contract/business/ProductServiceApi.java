package ir.greenweb.examples.supplychaintracking.contract.business;

import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product.*;

public interface ProductServiceApi {
    ProductGetResponse getProduct(String id);
    ProductsGetResponse getProducts(ProductsGetRequest request);
    ProductCreationResponse create(ProductCreationRequest request);
    void update(String id, ProductEditionRequest request);
    void delete(String id);
}
