package ir.greenweb.examples.supplychaintracking.persistence.dao;

import ir.greenweb.examples.supplychaintracking.contract.persistence.ProductDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductsDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Product;
import ir.greenweb.examples.supplychaintracking.persistence.mapper.ProductPersistenceMapper;
import ir.greenweb.examples.supplychaintracking.persistence.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

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
        Page<Product> productsPage = productRepository.filter(filter.getType(), filter.getManufacturingDateFrom(),
                filter.getManufacturingDateTo(), filter.getOrigin(), pageRequest);
        return ProductsDto.builder()
                .products(productMapper.toProductsDto(productsPage.getContent()))
                .total(productsPage.getSize())
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
