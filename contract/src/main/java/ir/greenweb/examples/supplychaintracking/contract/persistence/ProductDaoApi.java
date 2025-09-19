package ir.greenweb.examples.supplychaintracking.contract.persistence;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductsDto;

import java.util.Optional;
import java.util.UUID;

public interface ProductDaoApi {
    Optional<ProductDto> getProduct(UUID id);
    ProductsDto getProducts(ProductFilterDto filter);
    UUID addProduct(ProductDto product);
    void editProduct(UUID id, ProductDto product);
    void deleteProduct(UUID id);
    boolean isProductExist(UUID id);
}
