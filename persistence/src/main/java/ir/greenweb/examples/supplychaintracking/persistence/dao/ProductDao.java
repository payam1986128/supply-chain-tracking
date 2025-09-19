package ir.greenweb.examples.supplychaintracking.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.greenweb.examples.supplychaintracking.contract.persistence.ProductDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductsDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Product;
import ir.greenweb.examples.supplychaintracking.persistence.entity.QProduct;
import ir.greenweb.examples.supplychaintracking.persistence.mapper.ProductPersistenceMapper;
import ir.greenweb.examples.supplychaintracking.persistence.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProductDao implements ProductDaoApi {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productMapper;


    @Override
    public Optional<ProductDto> getProduct(UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(productMapper::toProductDto);
    }

    @Override
    public ProductsDto getProducts(ProductFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QProduct.product.manufacturingDate.before(LocalDateTime.now());
        if (filter.getType() != null) {
            predicate = predicate.and(QProduct.product.type.eq(filter.getType()));
        }
        if (filter.getOrigin() != null) {
            predicate = predicate.and(QProduct.product.origin.eq(filter.getOrigin()));
        }
        if (filter.getManufacturingDateFrom() != null) {
            predicate = predicate.and(QProduct.product.manufacturingDate.after(filter.getManufacturingDateFrom()));
        }
        if (filter.getManufacturingDateTo() != null) {
            predicate = predicate.and(QProduct.product.manufacturingDate.before(filter.getManufacturingDateTo()));
        }
        Page<Product> productsPage = productRepository.findAll(predicate, pageRequest);
        return ProductsDto.builder()
                .products(productMapper.toProductsDto(productsPage.getContent()))
                .total(productsPage.getTotalElements())
                .build();
    }

    @Override
    public UUID addProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public void editProduct(UUID id, ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean isProductExist(UUID id) {
        return productRepository.existsById(id);
    }
}
