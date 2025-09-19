package ir.greenweb.examples.supplychaintracking.persistence.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDto> toProductsDto(List<Product> products);
    ProductDto toProductDto(Product product);
    Product toProduct(ProductDto productDto);
}
