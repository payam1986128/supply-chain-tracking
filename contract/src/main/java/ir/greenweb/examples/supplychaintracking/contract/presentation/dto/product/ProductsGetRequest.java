package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductsGetRequest {
    private int page;
    private int pageSize;
    private String sort;
    private String sortDirection;
    private String type;
    private LocalDateTime manufacturingDateFrom;
    private LocalDateTime manufacturingDateTo;
    private String origin;
}
