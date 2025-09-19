package ir.greenweb.examples.supplychaintracking.business.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductsDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductMapper {
    ProductGetResponse toProductGetResponse(ProductDto product);
    ProductFilterDto toProductFilterDto(ProductsGetRequest productsGetRequest);
    ProductsGetResponse toProductsGetResponse(ProductsDto products);
    ProductAbstractDto toProductAbstractDto(ProductDto product);
    List<ProductAbstractDto> toProductAbstractsDto(List<ProductDto> productsDto);
    ProductDto toProductDto(ProductCreationRequest productCreationRequest);
    ProductDto toProductDto(ProductEditionRequest productEditionRequest);

    default String toString(UUID source) {
        return source.toString();
    }

    default UUID toUUID(String source) {
        return UUID.fromString(source);
    }
}
