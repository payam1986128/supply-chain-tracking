package ir.greenweb.examples.supplychaintracking.business.service;

import ir.greenweb.examples.supplychaintracking.contract.business.ProductServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.ProductDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductsDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product.*;
import ir.greenweb.examples.supplychaintracking.business.exception.InvalidUUIDException;
import ir.greenweb.examples.supplychaintracking.business.exception.ProductNotFoundException;
import ir.greenweb.examples.supplychaintracking.business.mapper.ProductBusinessMapper;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements ProductServiceApi {

    private final ProductDaoApi productDao;
    private final ProductBusinessMapper productMapper;

    @Lock(LockModeType.OPTIMISTIC)
    @Override
    public ProductGetResponse getProduct(String id) {
        UUID productId = parseId(id);
        ProductDto product = findProduct(productId);
        return productMapper.toProductGetResponse(product);
    }

    @Override
    public ProductsGetResponse getProducts(ProductsGetRequest request) {
        ProductFilterDto filter = productMapper.toProductFilterDto(request);
        ProductsDto products = productDao.getProducts(filter);
        return productMapper.toProductsGetResponse(products);
    }

    @Override
    public ProductCreationResponse create(ProductCreationRequest request) {
        ProductDto product = productMapper.toProductDto(request);
        UUID id = productDao.addProduct(product);
        return new ProductCreationResponse(productMapper.toString(id));
    }

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Override
    public void update(String id, ProductEditionRequest request) {
        UUID productId = parseId(id);
        validateProductExistence(productId);
        ProductDto product = productMapper.toProductDto(request);
        productDao.editProduct(productId, product);
    }

    @Override
    public void delete(String id) {
        UUID productId = parseId(id);
        validateProductExistence(productId);
        productDao.deleteProduct(productId);
    }

    private UUID parseId(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new InvalidUUIDException();
        }
    }

    private ProductDto findProduct(UUID id) {
        Optional<ProductDto> optionalProduct = productDao.getProduct(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return optionalProduct.get();
    }

    private void validateProductExistence(UUID id) {
        findProduct(id);
    }
}
