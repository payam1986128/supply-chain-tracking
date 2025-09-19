package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductFilterDto {
    private int page;
    private int pageSize;
    private String sort;
    private String sortDirection;
    private String type;
    private LocalDateTime manufacturingDateFrom;
    private LocalDateTime manufacturingDateTo;
    private String origin;
}
