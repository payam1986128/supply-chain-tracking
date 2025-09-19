package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsGetResponse {
    private List<ProductAbstractDto> products;
    private int total;
}
