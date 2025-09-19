package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductsDto {
    private List<ProductDto> products;
    private long total;
}
